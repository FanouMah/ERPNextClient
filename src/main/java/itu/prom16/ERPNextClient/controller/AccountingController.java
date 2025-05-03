package itu.prom16.ERPNextClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import itu.prom16.ERPNextClient.DTO.PurchaseInvoiceDTO;
import itu.prom16.ERPNextClient.DTO.SalesInvoiceDTO;
import itu.prom16.ERPNextClient.service.PurchaseInvoiceService;
import itu.prom16.ERPNextClient.service.SalesInvoiceService;

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
}
