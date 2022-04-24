package com.example.Demo.controller;

import com.example.Demo.entities.Livre;
import com.example.Demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/emsi_api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // GET http://localhost:8080/emsi_api/livres
    @GetMapping("/livres")
    public List<Livre> findAllLivres(){
        return livreService.getAllLivres();
    }

    // GET http://localhost:8080/emsi_api/livres/{id}
    @GetMapping("/livres/{id}")
    public Livre findLivreById(@PathVariable Long id){
        return livreService.getLivreById(id);
    }
    @PostMapping("/save")
    public String saveLivre(@RequestBody Livre livre) {
        // save book to database
        livreService.saveLivre(livre);
        return "book saved";
    }
    @PutMapping("livres/{id}")
    public String updatebook(@PathVariable( value = "id") long id,@RequestBody Livre bookDetails) {
    	Livre livre = livreService.getLivreById(id);
        livre.setTitre(bookDetails.getTitre());
        livre.setMaisonEdition(bookDetails.getMaisonEdition());
        livre.setAuteur(bookDetails.getAuteur());
        livre.setDisponible(bookDetails.getDisponible());
        livre.setDateDerniereConsultation(bookDetails.getDateDerniereConsultation());
        livre.setDateSortie(bookDetails.getDateSortie());
        livre.setISBN(livre.getISBN());
        livre.setNombrePage(bookDetails.getNombrePage());
        livreService.saveLivre(livre);
		return "book updated";
    }
    @DeleteMapping("/livres/{id}")
    public String removeLire(@PathVariable Long id){
        livreService.deleteLivre(id);

        return "Deleted Successfuly";
    }
  
  
 
}
