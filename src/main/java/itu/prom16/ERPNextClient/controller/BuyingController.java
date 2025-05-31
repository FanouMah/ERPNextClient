package itu.prom16.ERPNextClient.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Controller
public class BuyingController {
    @GetMapping("/buying/request-for-quotation")
    public String showLoginPage(@CookieValue(value = "sid", required = false) String sid, Model model) {
        if (sid != null) {
            try {

            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "new-supplier-quotation";
        } else {
            return "redirect:/";
        }
    }
}
