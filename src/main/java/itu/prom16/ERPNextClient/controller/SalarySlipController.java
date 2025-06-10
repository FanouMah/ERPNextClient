package itu.prom16.ERPNextClient.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.model.SalarySlipsMonth;
import itu.prom16.ERPNextClient.service.PDFGeneratorService;
import itu.prom16.ERPNextClient.service.SalarySlipService;

/**
 *
 * @author Fanou
 */
@Controller
public class SalarySlipController {
    @Autowired
    private SalarySlipService salarySlipService;

    @Autowired
    private PDFGeneratorService pdfGeneratorService;
    
    @GetMapping(value = "/salary-slip/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPayslipPDF(
            @CookieValue(value = "sid", required = false) String sid,
            @RequestParam("name") String salarySlipName) {    
            try {
                SalarySlipDTO salarySlip = salarySlipService.getSalarySlip(sid, salarySlipName);

                byte[] pdf = pdfGeneratorService.generateSalarySlipPDF(salarySlip);

                System.out.println(pdf);
                if (pdf == null) {
                    return ResponseEntity.notFound().build();
                }

                String safeFilename = salarySlip.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".pdf";

                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=\"" + safeFilename + "\"")
                        .body(pdf);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        }

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
                double sommeRoundedTotal = 0;
                double sommeEarnings = 0;
                double sommeDeductions = 0;
                double sommeNetPay = 0;
                for (SalarySlipDTO ss : salarySlips) {
                    sommeRoundedTotal += ss.getRoundedTotal();
                    sommeEarnings += ss.getGrossPay();
                    sommeDeductions += ss.getTotalDeduction();
                    sommeNetPay += ss.getNetPay();
                }
                model.addAttribute("salarySlips", salarySlips);
                model.addAttribute("sommeRoundedTotal", sommeRoundedTotal);
                model.addAttribute("sommeNetPay", sommeNetPay);
                model.addAttribute("sommeEarnings", sommeEarnings);
                model.addAttribute("sommeDeductions", sommeDeductions);
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

    
    @GetMapping("/salary-slips/dashboard")
    public String showSalarySlipsDashboard(
        @CookieValue(value = "sid", required = false) String sid,
        Model model,
        @RequestParam(value = "filter-year", required = false) String filterYear
    ) {
        if (sid != null) {
            try {
                List<SalarySlipDTO> salarySlips = salarySlipService.getSalarySlipsByYear(sid, filterYear);
    
                if (filterYear == null || filterYear.trim().isEmpty()) {
                    filterYear = java.time.Year.now().toString();
                } 
    
                model.addAttribute("filterYear", filterYear);
    
                // Groupement des salaires par "yyyy-MM"
                Map<String, List<SalarySlipDTO>> grouped = salarySlips.stream()
                    .collect(Collectors.groupingBy(ss -> ss.getPostingDate().format(DateTimeFormatter.ofPattern("yyyy-MM"))));
    
                List<SalarySlipsMonth> salarySlipsMonths = new ArrayList<>();
    
                // Boucle sur les 12 mois de l’année sélectionnée
                for (int month = 1; month <= 12; month++) {
                    String key = String.format("%s-%02d", filterYear, month);
                    List<SalarySlipDTO> slips = grouped.getOrDefault(key, new ArrayList<>());
    
                    BigDecimal totalEarnings = slips.stream()
                        .map(ss -> BigDecimal.valueOf(ss.getGrossPay()))
                        .filter(Objects::nonNull)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
                    BigDecimal totalDeductions = slips.stream()
                        .map(ss -> BigDecimal.valueOf(ss.getTotalDeduction()))
                        .filter(Objects::nonNull)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
                    BigDecimal totalNetPay = slips.stream()
                        .map(ss -> BigDecimal.valueOf(ss.getNetPay()))
                        .filter(Objects::nonNull)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
                    salarySlipsMonths.add(new SalarySlipsMonth(key, totalEarnings, totalDeductions, totalNetPay, slips));
                }
    
                model.addAttribute("salarySlipsMonths", salarySlipsMonths);
    
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "salary-slips-dashboard";
        } else {
            return "redirect:/";
        }
    }    
}
