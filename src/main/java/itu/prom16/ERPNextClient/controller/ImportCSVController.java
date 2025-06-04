package itu.prom16.ERPNextClient.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.ui.Model;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.service.ImportCSVService;

/**
 *
 * @author Fanou
 */
@Controller
public class ImportCSVController {

    @Autowired
    private ImportCSVService importCSVService;

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
            Map<String, Object> stats = importCSVService.importCSV(file1.getInputStream(), file2.getInputStream(), file3.getInputStream());

            if ("error".equals(stats.get("status"))) {
                redirectAttributes.addFlashAttribute("importStats", stats);
                redirectAttributes.addFlashAttribute("error", stats.get("error"));
            } else {
                redirectAttributes.addFlashAttribute("importStats", stats);
                redirectAttributes.addFlashAttribute("success", "Import completed successfully.");
            }

        } catch (CSRFTokenException ex) {
            return "redirect:/logout";
        } catch (Exception e) {
            model.addAttribute("code", "500");
            model.addAttribute("error", e.getMessage());
            return "error-500";
        }

        return "redirect:/import-csv-hr";
    }
}
