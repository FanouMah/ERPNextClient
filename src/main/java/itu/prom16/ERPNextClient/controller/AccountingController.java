package itu.prom16.ERPNextClient.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import itu.prom16.ERPNextClient.DTO.PaymentEntryDTO;
import itu.prom16.ERPNextClient.DTO.PurchaseInvoiceDTO;
import itu.prom16.ERPNextClient.DTO.ReferenceDTO;
import itu.prom16.ERPNextClient.DTO.SalesInvoiceDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.service.CompanyService;
import itu.prom16.ERPNextClient.service.ModeOfPaymentService;
import itu.prom16.ERPNextClient.service.PaymentEntryService;
import itu.prom16.ERPNextClient.service.PurchaseInvoiceService;
import itu.prom16.ERPNextClient.service.SalesInvoiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author Fanou
 */
@Controller
public class AccountingController {
    
    @Autowired
    private PurchaseInvoiceService purchaseInvoiceService;

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @Autowired
    private PaymentEntryService paymentEntryService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ModeOfPaymentService modeOfPaymentService;

    @GetMapping("/accounting/purchase-invoices")
    public String showPurchaseInvoices(
            @CookieValue(value = "sid", required = false) String sid,
            Model model) {

        if (sid != null && !sid.isEmpty()) {
            try {
                List<PurchaseInvoiceDTO> purchaseInvoices = purchaseInvoiceService.getPurchaseInvoices(sid);
                model.addAttribute("purchaseInvoices", purchaseInvoices);
                model.addAttribute("modeOfPayments", modeOfPaymentService.getModeOfPaymentsEnable(sid));
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "purchase-invoices";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/accounting/sales-invoices")
    public String showSalesInvoices(
            @CookieValue(value = "sid", required = false) String sid,
            Model model) {

        if (sid != null && !sid.isEmpty()) {
            try {
                List<SalesInvoiceDTO> salesInvoices = salesInvoiceService.getSalesInvoices(sid);
                model.addAttribute("salesInvoices", salesInvoices);
                model.addAttribute("modeOfPayments", modeOfPaymentService.getModeOfPaymentsEnable(sid));
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "sales-invoices";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/accounting/purchase-invoice/pay")
    public String createPaymentEntryForPurchaseInvoice(
            @CookieValue(value = "sid", required = false) String sid,
            @RequestParam String invoiceId,
            @RequestParam String postingDate,
            @RequestParam double amount,
            @RequestParam String paymentMethod,
            @RequestParam String referenceNo,
            @RequestParam String referenceDate,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (sid == null || sid.isEmpty()) {
            return "redirect:/";
        }

        if (paymentMethod.isEmpty() && referenceNo.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide at least one of the payment method or reference number.");
            return "redirect:/accounting/purchase-invoices";
            
        }

        if (paymentMethod.isEmpty()) {
            paymentMethod = null;
        }

        if (referenceNo.isEmpty()) {
            referenceNo = null;
        }

        try {
            PurchaseInvoiceDTO purchaseInvoice = purchaseInvoiceService.getPurchaseInvoiceDTOById(sid, invoiceId);

            PaymentEntryDTO paymentEntry = new PaymentEntryDTO();
            ReferenceDTO reference = new ReferenceDTO();

            paymentEntry.setNamingSeries(purchaseInvoice.getNamingSeries());
            paymentEntry.setPostingDate(LocalDate.parse(postingDate));
            paymentEntry.setPaymentType("Pay");
            paymentEntry.setCompany(purchaseInvoice.getCompany());
            paymentEntry.setModeOfPayment(paymentMethod);
            paymentEntry.setPartyType("Supplier");
            paymentEntry.setParty(purchaseInvoice.getSupplier());
            paymentEntry.setPaidTo(purchaseInvoice.getCreditTo());
            paymentEntry.setPaidToAccountCurrency(purchaseInvoice.getCurrency());
            if (paymentMethod == null) {
                paymentEntry.setPaidFrom(companyService.getDefaultAccount(sid, purchaseInvoice.getCompany()));
            } else {
                paymentEntry.setPaidFrom(companyService.getDefaultAccountByModePaymentName(sid, purchaseInvoice.getCompany(), paymentMethod));
            }
            paymentEntry.setPaidFromAccountCurrency(purchaseInvoice.getCurrency());
            paymentEntry.setPaidAmount(amount);
            paymentEntry.setReceivedAmount(amount);
            paymentEntry.setReferenceNo(referenceNo);
            paymentEntry.setReferenceDate(LocalDate.parse(referenceDate));

            reference.setReferenceDoctype("Purchase Invoice");
            reference.setReferenceName(invoiceId);
            reference.setParentfield("references");
            reference.setParenttype("Payment Entry");
            reference.setTotalAmount(purchaseInvoice.getGrandTotal());
            reference.setOutstandingAmount(purchaseInvoice.getOutstandingAmount());
            reference.setAllocatedAmount(amount);

            List<ReferenceDTO> references = new ArrayList<>();
            references.add(reference);
            paymentEntry.setReferences(references);

            PaymentEntryDTO createdPaymentEntry = paymentEntryService.createPaymentEntry(sid, paymentEntry);
            paymentEntryService.submitPaymentEntry(sid, createdPaymentEntry.getName());
            
            redirectAttributes.addFlashAttribute("success", "The payment N° "+createdPaymentEntry.getName()+" has been successfully created and validated.");
            
            return "redirect:/accounting/purchase-invoices";
        } catch (CSRFTokenException ex) {
            return "redirect:/logout";
        } catch (RuntimeException e) {
            model.addAttribute("code", "500");
            model.addAttribute("error", e.getMessage());
            return "error-500";
        }
    }

    @PostMapping("/accounting/sales-invoice/pay")
    public String createPaymentEntryForSaleInvoice(
            @CookieValue(value = "sid", required = false) String sid,
            @RequestParam String invoiceId,
            @RequestParam String postingDate,
            @RequestParam double amount,
            @RequestParam String paymentMethod,
            @RequestParam String referenceNo,
            @RequestParam String referenceDate,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (sid == null || sid.isEmpty()) {
            return "redirect:/";
        }

        if (paymentMethod.isEmpty() && referenceNo.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide at least one of the payment method or reference number.");
            return "redirect:/accounting/sales-invoices";
            
        }

        if (paymentMethod.isEmpty()) {
            paymentMethod = null;
        }

        if (referenceNo.isEmpty()) {
            referenceNo = null;
        }

        try {

            SalesInvoiceDTO salesInvoice = salesInvoiceService.getSalesInvoiceDTOById(sid, invoiceId);

            PaymentEntryDTO paymentEntry = new PaymentEntryDTO();
            ReferenceDTO reference = new ReferenceDTO();

            paymentEntry.setNamingSeries(salesInvoice.getNamingSeries());
            paymentEntry.setPostingDate(LocalDate.parse(postingDate));
            paymentEntry.setPaymentType("Receive");
            paymentEntry.setCompany(salesInvoice.getCompany());
            paymentEntry.setModeOfPayment(paymentMethod);
            paymentEntry.setPartyType("Customer");
            paymentEntry.setParty(salesInvoice.getCustomer());
            paymentEntry.setPaidFrom(salesInvoice.getDebitTo());
            paymentEntry.setPaidFromAccountCurrency(salesInvoice.getCurrency());
            if (paymentMethod == null) {
                paymentEntry.setPaidTo(companyService.getDefaultAccount(sid, salesInvoice.getCompany()));
            } else {
                paymentEntry.setPaidTo(companyService.getDefaultAccountByModePaymentName(sid, salesInvoice.getCompany(), paymentMethod));
            }
            paymentEntry.setPaidToAccountCurrency(salesInvoice.getCurrency());
            paymentEntry.setPaidAmount(amount);
            paymentEntry.setReceivedAmount(amount);
            paymentEntry.setReferenceNo(referenceNo);
            paymentEntry.setReferenceDate(LocalDate.parse(referenceDate));

            reference.setReferenceDoctype("Sales Invoice");
            reference.setReferenceName(invoiceId);
            reference.setParentfield("references");
            reference.setParenttype("Payment Entry");
            reference.setTotalAmount(salesInvoice.getGrandTotal());
            reference.setOutstandingAmount(salesInvoice.getOutstandingAmount());
            reference.setAllocatedAmount(amount);

            List<ReferenceDTO> references = new ArrayList<>();
            references.add(reference);
            paymentEntry.setReferences(references);

            PaymentEntryDTO createdPaymentEntry = paymentEntryService.createPaymentEntry(sid, paymentEntry);
            paymentEntryService.submitPaymentEntry(sid, createdPaymentEntry.getName());
            
            redirectAttributes.addFlashAttribute("success", "The payment N° "+createdPaymentEntry.getName()+" has been successfully created and validated.");
            
            return "redirect:/accounting/sales-invoices";
        } catch (CSRFTokenException ex) {
            return "redirect:/logout";
        } catch (RuntimeException e) {
            model.addAttribute("code", "500");
            model.addAttribute("error", e.getMessage());
            return "error-500";
        }
    }
}
