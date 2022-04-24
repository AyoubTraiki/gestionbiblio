package com.example.Demo.service;

import com.example.Demo.entities.Livre;
import com.example.Demo.repos.LivreRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepos livreRepos;

    @OrderBy
    public List<Livre> getAllLivres(){
      return livreRepos.findAll();
    };

    public Livre getLivreById(Long id){
        return livreRepos.findById(id).get();
    };

    public void saveLivre(Livre l){
        livreRepos.save(l);
    }

    public void deleteLivre(Long l){
        livreRepos.deleteById(l);
    }
}
