package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.Radio;
import hu.gamf.javalabproject.repositories.CountyInterfaceRepo;
import hu.gamf.javalabproject.repositories.RadioInterfaceRepo;
import hu.gamf.javalabproject.services.FrequencyBinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.*;


@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired private RadioInterfaceRepo radioRepo;

    @GetMapping
    public String showStatistics(Model model) {
        model.addAttribute("newest", radioRepo.findNewestRadio());

        Map<String, Integer> freqBuckets = new LinkedHashMap<>();
        int totalRadios = 0;

        for (Radio radio : radioRepo.findAll()) {
            double f = radio.getFrequency();
            String range = FrequencyBinderService.getRange(f);

            freqBuckets.put(range, freqBuckets.getOrDefault(range, 0) + 1);
            totalRadios++;
        }

        model.addAttribute("count", totalRadios);
        model.addAttribute("freqRanges", new ArrayList<>(freqBuckets.keySet()));
        model.addAttribute("freqCounts", new ArrayList<>(freqBuckets.values()));

        return "statistics";
    }
}