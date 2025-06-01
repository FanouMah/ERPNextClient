package itu.prom16.ERPNextClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

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
}
