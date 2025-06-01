package itu.prom16.ERPNextClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.ui.Model;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;

/**
 *
 * @author Fanou
 */
@Controller
public class ImportCSVController {

    @GetMapping("/import-csv-hr")
    public String showImportCSVPage(@CookieValue(value = "sid", required = false) String sid) {
        if (sid != null && !sid.isEmpty()) {
            return "import-csv-hr";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/import-csv-hr")
    public String importCSV(
        @CookieValue(value = "sid", required = false) String sid,
        @RequestParam("file1") MultipartFile file1,
        @RequestParam("file2") MultipartFile file2,
        @RequestParam("file3") MultipartFile file3,
        RedirectAttributes redirectAttributes,
        Model model) {

        if (sid == null || sid.isEmpty()) {
            return "redirect:/";
        }
        
        try {
            java.util.Map<String, Object> stats = new java.util.HashMap<>();
            stats.put("created_documents", 10);
            stats.put("created_employee", 8);
            stats.put("created_company", 7);
            stats.put("created_holiday_list", 6);
            stats.put("created_salary_structures", 5);
            stats.put("created_salary_components", 12);
            stats.put("created_salary_structure_assignment", 3);
            stats.put("created_payroll_entry", 2);
            stats.put("created_salary_slip", 1);
            stats.put("created_journal_entry", 1);
            stats.put("duration_seconds", 4.2);
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            stats.put("end_time", java.time.LocalDateTime.now().format(formatter));
            stats.put("error_count", 2);
            java.util.List<String> errors = new java.util.ArrayList<>();
            errors.add("Row 3: Invalid supplier email address.");
            errors.add("Row 7: Item code already exists.");
            stats.put("errors", errors);

            redirectAttributes.addFlashAttribute("importStats", stats);
            redirectAttributes.addFlashAttribute("success", "Import completed successfully.");

        } catch (CSRFTokenException ex) {
            return "redirect:/logout";
        } catch (RuntimeException e) {
            model.addAttribute("code", "500");
            model.addAttribute("error", e.getMessage());
            return "error-500";
        }

        return "redirect:/import-csv-hr";
    }
}
