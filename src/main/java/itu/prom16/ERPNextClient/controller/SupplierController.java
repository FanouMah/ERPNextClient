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
                List<SupplierQuotationDTO> supplierQuotations = supplierQuotationservice.getRequestForQuotationsBySupplier(sid, supplierName);
                model.addAttribute("supplierQuotations", supplierQuotations);
                model.addAttribute("supplierName", supplierName);
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
    
    @PostMapping("/SupplierQuotationItem/update")
    public String updateSupplierQuotationItem(
        @CookieValue(value = "sid", required = false) String sid,
        @CookieValue(value = "system_user", required = false) String system_user,
        @RequestParam("itemName") String itemName,
        @RequestParam("supplierName") String supplierName,
        @RequestParam("qty") double qty,
        @RequestParam("rate") double rate,
        RedirectAttributes redirectAttributes,
        Model model) {

        if (sid == null || sid.isEmpty()) {
        return "redirect:/";
        }

        try {
            supplierQuotationservice.updateSupplierQuotationItem(sid, system_user , itemName, qty, rate);
            redirectAttributes.addFlashAttribute("success", "Item updated successfully.");
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
