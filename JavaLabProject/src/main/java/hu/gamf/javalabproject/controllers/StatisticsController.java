package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.NewestRadioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Controller
public class StatisticsController {

    @GetMapping("/statistics")
    public String showStatistics(Model model) {

        int totalCount = 42;
        model.addAttribute("count", totalCount);

        NewestRadioDTO newestRadio = new NewestRadioDTO(
                "Rádió Minta",
                "Budapest",
                101.5,
                5.0,
                "1051 Budapest, Példa utca 1.",
                LocalDateTime.now().minusDays(1)
        );
        model.addAttribute("newest", newestRadio);

        List<String> countyNames = Arrays.asList(
                "Budapest", "Pest", "Baranya", "Győr-Moson-Sopron"
        );
        List<Integer> countyCounts = Arrays.asList(
                12, 8, 5, 7
        );
        model.addAttribute("countyNames", countyNames);
        model.addAttribute("countyCounts", countyCounts);

        return "statistics";
    }
}