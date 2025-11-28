package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.User;
import hu.gamf.javalabproject.repositories.UserInterfaceRepo;
import hu.gamf.javalabproject.services.AuthUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired private UserInterfaceRepo userRepo;
    @Autowired private AuthUserService authUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String errorParam, @RequestParam(value="logout", required = false) String logoutParam, @RequestParam(value="registered", required = false) String registeredParam, Model model) {
        if (errorParam != null) {
            model.addAttribute("error", errorParam);
        }
        if (logoutParam != null) {
            model.addAttribute("logout", logoutParam);
        }
        if (registeredParam != null) {
            model.addAttribute("registered", registeredParam);
        }
        return "auth/login";
    }

    /*
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
            model.addAttribute("error", "Hibás felhasználónév vagy jelszó!");
            return "auth/login";
        }

        return "redirect:/";
    }
    */

    @GetMapping("/register")
    public String showRegisterPage(@RequestParam(value = "error", required = false) String errorParam, Model model) {
        if (errorParam != null) {
            model.addAttribute("error", errorParam);
        }
        return "auth/register";
    }
    @PostMapping("/register")
    public String handleRegister(@RequestParam String username, @RequestParam String fullname, @RequestParam String password, Model model) {
        try {
            authUserService.registerUser(username, fullname, password);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("username", username);
            model.addAttribute("fullname", fullname);
            return "auth/register";
        }

        // sikeres regisztráció után login oldalra irányítás
        return "redirect:/auth/login?registered";
    }

}
