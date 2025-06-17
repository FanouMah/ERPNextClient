package itu.prom16.ERPNextClient.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import itu.prom16.ERPNextClient.DTO.PurchaseOrderDTO;
import itu.prom16.ERPNextClient.DTO.SupplierDTO;
import itu.prom16.ERPNextClient.DTO.SupplierQuotationDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.service.PurchaseOrderService;
import itu.prom16.ERPNextClient.service.SupplierQuotationService;
import itu.prom16.ERPNextClient.service.SupplierService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author Fanou
 */
@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierQuotationService supplierQuotationservice;

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    
    @GetMapping("/suppliers")
    public String showSuppliers(@CookieValue(value = "sid", required = false) String sid, Model model) {
        if (sid != null) {
            try {
                List<SupplierDTO> suppliers = supplierService.getSuppliers(sid);
                model.addAttribute("suppliers", suppliers);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "suppliers";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/supplier/{supplierName}/quotations")
    public String showSupplierQuotations(
            @PathVariable("supplierName") String supplierName,
            @CookieValue(value = "sid", required = false) String sid,
            Model model) {

        if (sid != null && !sid.isEmpty()) {
            try {
                List<SupplierQuotationDTO> supplierQuotations = supplierQuotationservice.getSupplierQuotationsBySupplier(sid, supplierName);
                model.addAttribute("supplierQuotations", supplierQuotations);
                model.addAttribute("supplierName", supplierName);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "supplier-quotations";
        } else {
            return "redirect:/";
        }
    }
    
    @PostMapping("/SupplierQuotation/update")
    public String updateSupplierQuotation(
        @CookieValue(value = "sid", required = false) String sid,
        @RequestParam("itemName") List<String> itemName,
        @RequestParam("supplierName") String supplierName,
        @RequestParam("supplierQuotationName") String supplierQuotationName,
        @RequestParam("qty") List<Double> qty,
        @RequestParam("rate") List<Double> rate,
        RedirectAttributes redirectAttributes,
        Model model) {

        if (sid == null || sid.isEmpty()) {
        return "redirect:/";
        }

        try {
            for (int i = 0; i < itemName.size(); i++) {
                supplierQuotationservice.updateSupplierQuotationItem(sid, itemName.get(i), qty.get(i), rate.get(i));
            }
            SupplierQuotationDTO sq = supplierQuotationservice.submitSupplierQuotation(sid, supplierQuotationName);
            purchaseOrderService.createPurchaseOrder(sid, sq);

            redirectAttributes.addFlashAttribute("success", "Supplier Quotation updated and submitted successfully.");
        } catch (CSRFTokenException ex) {
            return "redirect:/logout";
        } catch (RuntimeException e) {
            model.addAttribute("code", "500");
            model.addAttribute("error", e.getMessage());
            return "error-500";
        }
        supplierName = URLEncoder.encode(supplierName, StandardCharsets.UTF_8).replace("+", "%20");
        return "redirect:/supplier/"+supplierName+"/quotations";
    }

    @GetMapping("/supplier/{supplierName}/purchase-orders")
    public String showSupplierPurchaseOrders(
            @PathVariable("supplierName") String supplierName,
            @CookieValue(value = "sid", required = false) String sid,
            Model model) {

        if (sid != null && !sid.isEmpty()) {
            try {
                List<PurchaseOrderDTO> purchaseOrders = purchaseOrderService.getPurchaseOrdersBySupplier(sid, supplierName);
                model.addAttribute("purchaseOrders", purchaseOrders);
                model.addAttribute("supplierName", supplierName);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "purchase-orders";
        } else {
            return "redirect:/";
        }
    }
    
}
