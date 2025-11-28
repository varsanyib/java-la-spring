package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.MessageDTO;
import hu.gamf.javalabproject.repositories.MessageInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {
    @Autowired private MessageInterfaceRepo messageRepo;

    @GetMapping
    public String showMessages(Model model) {
        model.addAttribute("messages", messageRepo.findAllOrderByCreatedAtDesc());
        return "messages";
    }
}
