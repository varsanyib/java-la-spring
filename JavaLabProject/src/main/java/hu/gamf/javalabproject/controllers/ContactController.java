package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.ContactDTO;
import hu.gamf.javalabproject.models.MessageDTO;
import hu.gamf.javalabproject.repositories.MessageInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired private MessageInterfaceRepo messageRepo;

    @GetMapping
    public String showContactForm(@RequestParam(value = "success", required = false) Boolean success, Model model) {
        if (!model.containsAttribute("contactDTO")) {
            model.addAttribute("contactDTO", new ContactDTO());
        }
        if (success != null && success) {
            model.addAttribute("success", true);
        }
        return "contact";
    }

    @PostMapping
    public String handleContactForm(@Valid @ModelAttribute ContactDTO contactDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contactDTO", contactDTO);
            return "contact";
        }

        messageRepo.save(new MessageDTO(contactDTO.getFullname(), contactDTO.getSubject(), contactDTO.getMessage()));

        redirectAttributes.addAttribute("success", true);
        return "redirect:/contact";
    }
}
