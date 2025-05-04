package itu.prom16.ERPNextClient.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import itu.prom16.ERPNextClient.DTO.PaymentEntryDTO;
import itu.prom16.ERPNextClient.DTO.PurchaseInvoiceDTO;
import itu.prom16.ERPNextClient.DTO.ReferenceDTO;
import itu.prom16.ERPNextClient.DTO.SalesInvoiceDTO;
import itu.prom16.ERPNextClient.service.CompanyService;
import itu.prom16.ERPNextClient.service.PaymentEntryService;
import itu.prom16.ERPNextClient.service.PurchaseInvoiceService;
import itu.prom16.ERPNextClient.service.SalesInvoiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/accounting")
    public String showAccounting(@CookieValue(value = "sid", required = false) String sid) {
        if (sid != null && !sid.isEmpty()) {
            return "accounting";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/accounting/purchase-invoices")
    public String showPurchaseInvoices(
            @CookieValue(value = "sid", required = false) String sid,
            Model model) {

        if (sid != null && !sid.isEmpty()) {
            try {
                List<PurchaseInvoiceDTO> purchaseInvoices = purchaseInvoiceService.getPurchaseInvoices(sid);
                model.addAttribute("purchaseInvoices", purchaseInvoices);
            } catch (RuntimeException e) {
                model.addAttribute("error", e.getMessage());
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
            } catch (RuntimeException e) {
                model.addAttribute("error", e.getMessage());
            }
            return "sales-invoices";
        } else {
            return "redirect:/";
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
            Model model) {

        if (sid == null || sid.isEmpty()) {
            return "redirect:/";
        }

        try {

            SalesInvoiceDTO salesInvoice = salesInvoiceService.gSalesInvoiceDTOById(sid, invoiceId);

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

            model.addAttribute("paymentEntry", createdPaymentEntry);
            return "payment-entry-success";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "payment-entry-failure";
        }
    }

    @GetMapping("/company/{companyName}/mode-of-payment/{modePaymentName}/default-account")
    public String getCompanyDefaultAccount(
        @CookieValue(value = "sid", required = false) String sid,
        @PathVariable("companyName") String companyName,
        @PathVariable("modePaymentName") String modePaymentName,
        Model model) {

        if (sid == null || sid.isEmpty()) {
            return "redirect:/";
        }

        try {
            String accounts = companyService.getDefaultAccountByModePaymentName(sid, companyName, modePaymentName);

        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "company-default-accounts";
    }
    
}
