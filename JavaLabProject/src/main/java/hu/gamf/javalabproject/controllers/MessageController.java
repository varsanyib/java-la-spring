package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.MessageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String showMessages(Model model) {
        List<MessageDTO> messages = Arrays.asList(
                new MessageDTO(
                        "Teszt Elek",
                        "tesztuser",
                        "Első üzenet",
                        "Ez egy példa üzenet a messages oldal teszteléséhez.",
                        LocalDateTime.now().minusDays(1)
                ),
                new MessageDTO(
                        "Vendég Feladó",
                        null,
                        "Kérdés az oldalról",
                        "Vendégként írtam egy kérdést a rádióadók adatbázisáról.",
                        LocalDateTime.now().minusHours(5)
                )
        );

        model.addAttribute("messages", messages);
        return "messages";
    }
}
