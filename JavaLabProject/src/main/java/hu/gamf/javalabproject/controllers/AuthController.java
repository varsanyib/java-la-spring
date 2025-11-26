package hu.gamf.javalabproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String errorParam, Model model) {
        if (errorParam != null) {
            model.addAttribute("error", errorParam);
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        boolean ok = false;

        if (!ok) {
            model.addAttribute("error", "Hibás felhasználónév vagy jelszó.");
            return "auth/login";
        }

        return "redirect:/index";
    }

    @GetMapping("/register")
    public String showRegisterPage(@RequestParam(value = "error", required = false) String errorParam, Model model) {
        if (errorParam != null) {
            model.addAttribute("error", errorParam);
        }
        return "auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username, @RequestParam String fullname, @RequestParam String password, Model model) {
        boolean ok = false;

        if (!ok) {
            model.addAttribute("error", "A felhasználónév már foglalt.");
            return "auth/register";
        }

        return "redirect:/auth/login";
    }
}
