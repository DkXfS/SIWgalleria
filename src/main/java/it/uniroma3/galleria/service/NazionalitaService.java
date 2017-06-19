package it.uniroma3.galleria.service;

import it.uniroma3.galleria.models.Nazionalita;
import it.uniroma3.galleria.repository.NazionalitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Dk_XfS on 19/06/2017.
 */

@Service
public class NazionalitaService
{
    @Autowired
    private NazionalitaRepository repo;

    public List<Nazionalita> get(){ return repo.findAll(); }

    public Nazionalita find(long Id) { return repo.findNazionalitaById(Id); }
}
