package itu.prom16.ERPNextClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import itu.prom16.ERPNextClient.DTO.EmployeeDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.service.EmployeeService;

/**
 *
 * @author Fanou
 */
@Controller
public class EmployeeController {
 
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String showEmployees(@CookieValue(value = "sid", required = false) String sid, Model model) {
        if (sid != null) {
            try {
                List<EmployeeDTO> employees = employeeService.getEmployees(sid);
                model.addAttribute("employees", employees);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "employees";
        } else {
            return "redirect:/";
        }
    }
}
