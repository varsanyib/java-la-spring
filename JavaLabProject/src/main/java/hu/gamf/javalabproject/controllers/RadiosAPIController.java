package hu.gamf.javalabproject.controllers;

import hu.gamf.javalabproject.models.Radio;
import hu.gamf.javalabproject.repositories.RadioInterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/radios")
public class RadiosAPIController {
    @Autowired RadioInterfaceRepo radioRepo;

    @GetMapping
    @ResponseBody
    public Iterable<Radio> getRadios() {
        return radioRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Radio> getRadio(@PathVariable int id) {
        Radio radio = radioRepo.findById(id).orElse(null);
        if (radio == null) { return  new ResponseEntity<>(HttpStatus.NOT_FOUND); }
        return new ResponseEntity<>(radio, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Radio> addRadio(@RequestBody Radio radio) {
        return new ResponseEntity<>(radioRepo.save(radio), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Radio> updateRadio(@RequestBody Radio radio) {
        return new ResponseEntity<>(radioRepo.save(radio), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRadio(@PathVariable int id) {
        radioRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
