package itu.prom16.ERPNextClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.service.SalarySlipService;

/**
 *
 * @author Fanou
 */
@Controller
public class SalarySlipController {
    @Autowired
    private SalarySlipService salarySlipService;
    
    @GetMapping("/salary-slips")
    public String showSalarySlips(
        @CookieValue(value = "sid", required = false) String sid,
        Model model,
        @RequestParam(value = "filter-month", required = false) String filterMonth
    ) {
        if (sid != null) {
            try {
                List<SalarySlipDTO> salarySlips;
                if (filterMonth != null && !filterMonth.isEmpty()) {
                    salarySlips = salarySlipService.getSalarySlipsByMonth(sid, filterMonth);
                    model.addAttribute("filterMonth", filterMonth);
                } else {
                    salarySlips = salarySlipService.getSalarySlips(sid);
                }
                double total = 0;
                for (SalarySlipDTO ss : salarySlips) {
                    total += ss.getRoundedTotal();
                }
                model.addAttribute("salarySlips", salarySlips);
                model.addAttribute("sommeRoundedTotal", total);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "salary-slips";
        } else {
            return "redirect:/";
        }
    }
}
