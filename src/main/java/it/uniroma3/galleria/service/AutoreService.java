package it.uniroma3.galleria.service;

import it.uniroma3.galleria.models.Autore;
import it.uniroma3.galleria.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository repo;

    public List<Autore> get() { return repo.findAll(); }

    public Autore find(long Id) { return repo.findAutoreByIdEquals(Id); }

    public Autore save(Autore autore){ return repo.save(autore); }

    public void remove(Autore autore){ repo.delete(autore);}
}
