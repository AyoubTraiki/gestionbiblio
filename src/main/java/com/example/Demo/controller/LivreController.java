package com.example.Demo.controller;

import com.example.Demo.entities.Livre;
import com.example.Demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/emsi_api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // GET http://localhost:8082/emsi_api/livres
    @GetMapping("/livres")
    public List<Livre> findAllLivres(){
        return livreService.getAllLivres();
    }

    // GET http://localhost:8082/emsi_api/livres/{id}
    @GetMapping("/livres/{id}")
    public Livre findLivreById(@PathVariable Long id){
        return livreService.getLivreById(id);
    }
}
