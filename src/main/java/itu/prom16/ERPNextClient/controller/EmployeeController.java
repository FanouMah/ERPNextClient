package itu.prom16.ERPNextClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import itu.prom16.ERPNextClient.DTO.EmployeeDTO;
import itu.prom16.ERPNextClient.DTO.LangueDTO;
import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.service.EmployeeService;
import itu.prom16.ERPNextClient.service.LangueService;
import itu.prom16.ERPNextClient.service.SalarySlipService;

/**
 *
 * @author Fanou
 */
@Controller
public class EmployeeController {
 
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalarySlipService salarySlipService;

    @Autowired
    private LangueService langueService;

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

    @GetMapping("/employee/{employeeName}")
    public String ficheEmployee(
        @PathVariable("employeeName") String employeeName,
        @CookieValue(value = "sid", required = false) String sid,
        Model model) {
        if (sid != null) {
            try {
                List<String> printFormats = salarySlipService.getSalarySlipPrintFormat(sid);
                List<LangueDTO> langues = langueService.getLanguesEnabled(sid);
                List<SalarySlipDTO> salarySlips = salarySlipService.getSalarySlipsByEmployee(sid, employeeName);
                EmployeeDTO emp = employeeService.getEmployeeByName(sid, employeeName);
                
                model.addAttribute("employee", emp);
                model.addAttribute("salarySlips", salarySlips);
                model.addAttribute("printFormats", printFormats);
                model.addAttribute("langues", langues);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "fiche-employee";
        } else {
            return "redirect:/";
        }
    }
}
