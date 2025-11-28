package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.User;
import hu.gamf.javalabproject.repositories.UserInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired private UserInterfaceRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String errorParam, Model model) {
        if (errorParam != null) {
            model.addAttribute("error", errorParam);
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        String hash = bCryptPasswordEncoder.encode(password);

        Iterable<User> users = userRepo.findAll();

        User loggedUser = null;

        for (User user : users) {
            if (user.getUsername().equals(username) && bCryptPasswordEncoder.matches(password, user.getPassword())) {
                loggedUser = user;
                boolean isAdmin = user.isAdmin();
                break;
            }
        }

        if (loggedUser == null) {
            model.addAttribute("error", "Hibás felhasználónév vagy jelszó.");
            return "auth/login";
        }

        return "redirect:/";
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
