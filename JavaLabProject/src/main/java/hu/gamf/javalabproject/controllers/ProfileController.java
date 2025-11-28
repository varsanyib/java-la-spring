package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.repositories.UserInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired UserInterfaceRepo userRepo;

    @GetMapping
    public String getProfilePage(@AuthenticationPrincipal org.springframework.security.core.userdetails.User authUser, Model model) {
        model.addAttribute("user", userRepo.findByUsername(authUser.getUsername()).orElseThrow());
        return "profile";
    }
}
