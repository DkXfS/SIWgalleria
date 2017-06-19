package it.uniroma3.galleria.service;

import it.uniroma3.galleria.models.Tecnica;
import it.uniroma3.galleria.repository.TecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dk_XfS on 18/06/2017.
 */

@Service
public class TecnicaService {

    @Autowired
    private TecnicaRepository repo;

    public List<Tecnica> get(){return repo.findAll();}

    public void remove(Tecnica tech){repo.delete(tech);}

    public void removeThroughId(long Id){repo.removeById(Id);}

    public Tecnica find(long Id){return repo.findTecnicaById(Id);}
}
