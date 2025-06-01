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
            // Static mock data for import stats
            java.util.Map<String, Object> stats = new java.util.HashMap<>();
            stats.put("created_documents", 10);
            stats.put("created_suppliers", 8);
            stats.put("created_material_requests", 7);
            stats.put("created_rfqs", 6);
            stats.put("created_supplier_quotations", 5);
            stats.put("created_items", 12);
            stats.put("created_item_groups", 3);
            stats.put("created_warehouse", 2);
            stats.put("created_country", 1);
            stats.put("duration_seconds", 4.2);
            stats.put("end_time", java.time.LocalDateTime.now().toString());
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

        return "import-csv-hr";
    }
}
