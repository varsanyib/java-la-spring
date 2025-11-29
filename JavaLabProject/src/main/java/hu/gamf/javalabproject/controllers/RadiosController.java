package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.County;
import hu.gamf.javalabproject.models.Radio;
import hu.gamf.javalabproject.models.Town;
import hu.gamf.javalabproject.models.TownDTO;
import hu.gamf.javalabproject.repositories.CountyInterfaceRepo;
import hu.gamf.javalabproject.repositories.RadioInterfaceRepo;
import hu.gamf.javalabproject.repositories.TownInterfaceRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.oauth2.client.OAuth2ClientSecurityMarker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/radios")
public class RadiosController {
    @Autowired private RadioInterfaceRepo radioRepo;
    @Autowired private TownInterfaceRepo townRepo;
    @Autowired private CountyInterfaceRepo countyRepo;

    @GetMapping
    public String listRadios(Model model) {

        model.addAttribute("radios", radioRepo.findAll());
        return "radios";
    }

    @GetMapping("/view/{id}")
    public String viewRadio(@PathVariable int id, Model model) {
        Iterable<Town> towns  = townRepo.findAll();
        Iterable<County> counties = countyRepo.findAll();

        Radio selectedRadio = radioRepo.findById(id).orElse(null);
        if (selectedRadio == null) {
            return "radios";
        }
        model.addAttribute("radio", selectedRadio);
        model.addAttribute("towns", towns);
        model.addAttribute("counties", counties);
        return "radios_view";
    }
    @GetMapping("/edit/{id}")
    public String editRadioForm(@PathVariable int id, Model model) {
        Radio selectedRadio = radioRepo.findById(id).orElse(null);

        if (selectedRadio == null) {
            return "radios";
        }


        model.addAttribute("radio", selectedRadio);
        model.addAttribute("towns", townRepo.findAll());

        return "radios_edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedRadio(@PathVariable int id, @ModelAttribute("radio") Radio radio) {
        if  (radio == null) {
            return "radios_edit";
        }
        radio.setId(id);
        radioRepo.save(radio);

        return "redirect:/radios";
    }

    @GetMapping("/create")
    public String createRadioForm(Model model) {
        model.addAttribute("radio", new Radio());
        model.addAttribute("towns", townRepo.findAll());
        return "radios_create";
    }

    @PostMapping("/create")
    public String saveRadio(@Valid @ModelAttribute("radio") Radio radio, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("towns", townRepo.findAll());
            model.addAttribute("radio", radio);
            return "radios_create";
        }
        radioRepo.save(radio);
        return "redirect:/radios";
    }

    @GetMapping("/delete/{id}")
    public String deleteRadio(@PathVariable int id) {
        radioRepo.deleteById(id);
        return "redirect:/radios";
    }
}