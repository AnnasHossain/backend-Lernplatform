package de.hossain.projekteins.backend_lernplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NutzerService {

    @Autowired
    private NutzerRepository nutzerRepository;


    public Nutzer save(Nutzer nutzer) {
        return nutzerRepository.save(nutzer);
    }

    public Nutzer get(Long id) {
        return nutzerRepository.findById(String.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    /* Liste geht nur dann wenn auch bei Repo-Klasse  List,statt String ändere
    public List<Nutzer> getAll() {
        Iterable<Nutzer> iterator = nutzerRepository.findAll();
        List<Nutzer> Nutzers = new ArrayList<Nutzer>();
        for (Nutzer nutzer : iterator) Nutzers.add(nutzer);
        return Nutzers;
    }

     */


    public Nutzer createNutzer(Nutzer nutzer) {
        // Passwort hashen (z. B. BCrypt)
        nutzer.setPassword(new BCryptPasswordEncoder().encode(nutzer.getPassword()));
        nutzer.setCreatedAt(LocalDateTime.now());
        nutzer.setUpdatedAt(LocalDateTime.now());
        Nutzer savedNutzer = nutzerRepository.save(nutzer);

        System.out.println("Neuer Nutzer erstellt: " + savedNutzer);
        return savedNutzer;
    }

/*
    public Nutzer getNutzerById(String id) {
        return nutzerRepository.findById(id).orElseThrow(RuntimeException::new);

    }
 */

    public Nutzer getNutzerById(String id) {
        return nutzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nutzer nicht gefunden mit ID: " + id));
    }

}



