package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.User;
import hu.gamf.javalabproject.repositories.UserInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired UserInterfaceRepo userRepo;

    @GetMapping
    public String getAdminPage(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "admin";
    }
}
