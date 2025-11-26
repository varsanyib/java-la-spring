package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.RadioDTO;
import hu.gamf.javalabproject.models.TownDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/radios")
public class RadiosController {

    @GetMapping
    public String listRadios(Model model) {
        List<RadioDTO> radios = Arrays.asList(
                new RadioDTO(
                        1L,
                        "Rádió Minta 1",
                        "Budapest",
                        "Budapest",
                        "Közép-Magyarország",
                        101.5,
                        5.0,
                        "1051 Budapest, Példa utca 1.",
                        LocalDateTime.now().minusDays(10),
                        LocalDateTime.now().minusDays(1)
                ),
                new RadioDTO(
                        2L,
                        "Rádió Minta 2",
                        "Pécs",
                        "Baranya",
                        "Dél-Dunántúl",
                        98.3,
                        3.0,
                        "7621 Pécs, Minta tér 2.",
                        LocalDateTime.now().minusDays(20),
                        LocalDateTime.now().minusDays(2)
                )
        );

        model.addAttribute("radios", radios);
        return "radios";
    }

    @GetMapping("/view/{id}")
    public String viewRadio(@PathVariable Long id, Model model) {

        RadioDTO radio = new RadioDTO(
                id,
                "Rádió Minta " + id,
                "Budapest",
                "Budapest",
                "Közép-Magyarország",
                101.5,
                5.0,
                "1051 Budapest, Példa utca 1.",
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(1)
        );

        model.addAttribute("radio", radio);
        return "radios_view";
    }
    @GetMapping("/edit/{id}")
    public String editRadioForm(@PathVariable Long id, Model model) {

        RadioDTO radio = new RadioDTO(
                id,
                "Rádió Minta " + id,
                "Budapest",
                "Budapest",
                "Közép-Magyarország",
                101.5,
                5.0,
                "1051 Budapest, Példa utca 1.",
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(1)
        );

        List<TownDTO> towns = Arrays.asList(
                new TownDTO("Budapest", "Budapest"),
                new TownDTO("Pécs", "Baranya"),
                new TownDTO("Győr", "Győr-Moson-Sopron")
        );

        model.addAttribute("radio", radio);
        model.addAttribute("towns", towns);

        return "radios_edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedRadio(@PathVariable Long id,
                                  @RequestParam String name,
                                  @RequestParam("town_name") String townName,
                                  @RequestParam Double frequency,
                                  @RequestParam Double power,
                                  @RequestParam(required = false) String address) {


        return "redirect:/radios";
    }

    @GetMapping("/create")
    public String createRadioForm(Model model) {
        System.out.println("create művelet");
        return "redirect:/radios";
    }

    @GetMapping("/delete/{id}")
    public String deleteRadio(@PathVariable Long id) {
        System.out.print("Törlés művelet");
        return "redirect:/radios";
    }
}