package itu.prom16.ERPNextClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itu.prom16.ERPNextClient.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Fanou
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService service;

    @GetMapping("/")
    public String showLoginPage(@CookieValue(value = "sid", required = false) String sid) {
        if (sid != null && service.isLoggedIn(sid)) {
            return "home";
        } else {
            return "index";
        }
    }


    @PostMapping("/login")
    public String login(@RequestParam String usr, @RequestParam String pwd, HttpServletResponse servletResponse, Model model) {
        try {
            List<String> cookies = service.login(usr, pwd);
            if (cookies != null) {
                for (String cookie : cookies) {
                    servletResponse.addHeader("Set-Cookie", cookie);
                }
                return "redirect:/";
            }

        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/";
    }
    

    @GetMapping("/logout")
    public String logout(HttpServletResponse servletResponse, Model model) {
        try {
            List<String> cookies = service.logout();
            if (cookies != null) {
                for (String cookie : cookies) {
                    servletResponse.addHeader("Set-Cookie", cookie);
                }
                return "redirect:/";
            }

        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/";
    }
}
