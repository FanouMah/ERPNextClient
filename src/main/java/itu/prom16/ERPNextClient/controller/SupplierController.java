package itu.prom16.ERPNextClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import itu.prom16.ERPNextClient.DTO.SupplierDTO;
import itu.prom16.ERPNextClient.DTO.SupplierQuotationDTO;
import itu.prom16.ERPNextClient.service.SupplierQuotationService;
import itu.prom16.ERPNextClient.service.SupplierService;

/**
 *
 * @author Fanou
 */
@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    
    @GetMapping("/suppliers")
    public String showSuppliers(@CookieValue(value = "sid", required = false) String sid, Model model) {
        if (sid != null) {
            try {
                List<SupplierDTO> suppliers = supplierService.getSuppliers(sid);
                model.addAttribute("suppliers", suppliers);
            } catch (RuntimeException e) {
                model.addAttribute("error", e.getMessage());
            } 
            return "suppliers";
        } else {
            return "redirect:/";
        }
    }

    
    @Autowired
    private SupplierQuotationService service;

    @GetMapping("/supplier/{supplierName}/quotations")
    public String showSupplierQuotations(
            @PathVariable("supplierName") String supplierName,
            @CookieValue(value = "sid", required = false) String sid,
            Model model) {

        if (sid != null && !sid.isEmpty()) {
            try {
                List<SupplierQuotationDTO> supplierQuotations = service.getRequestForQuotationsBySupplier(sid, supplierName);
                model.addAttribute("supplierQuotations", supplierQuotations);
                model.addAttribute("supplierName", supplierName);
            } catch (RuntimeException e) {
                model.addAttribute("error", e.getMessage());
            }
            return "supplier-quotations";
        } else {
            return "redirect:/";
        }
    }
}
