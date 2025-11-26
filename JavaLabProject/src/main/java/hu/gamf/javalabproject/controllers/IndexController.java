package hu.gamf.javalabproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String GetIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String GetIndex2() {
        return "index";
    }
}
