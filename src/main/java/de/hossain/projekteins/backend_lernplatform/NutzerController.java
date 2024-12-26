package de.hossain.projekteins.backend_lernplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nutzer")
public class NutzerController {

    @Autowired
    private NutzerService nutzerService;

    @PostMapping
    public ResponseEntity<Nutzer> createNutzer(@RequestBody Nutzer nutzer) {
        Nutzer createdNutzer = nutzerService.createNutzer(nutzer);
        return new ResponseEntity<>(createdNutzer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nutzer> getNutzerById(@PathVariable String id) {
        Nutzer nutzer = nutzerService.getNutzerById(id);
        return new ResponseEntity<>(nutzer, HttpStatus.OK);
    }

}
