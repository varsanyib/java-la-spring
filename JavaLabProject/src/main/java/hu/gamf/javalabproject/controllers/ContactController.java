package hu.gamf.javalabproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping
    public String showContactForm(@RequestParam(value = "success", required = false) Boolean success, Model model) {
        if (success != null && success) {
            model.addAttribute("success", true);
        }
        return "contact";
    }

    @PostMapping
    public String handleContactForm(@RequestParam(required = false) Long userId, @RequestParam String name, @RequestParam String subject, @RequestParam String message, RedirectAttributes redirectAttributes) {
        System.out.println(name);
        System.out.println(message);
        System.out.println(subject);
        redirectAttributes.addAttribute("success", true);
        return "redirect:/contact";
    }
}
