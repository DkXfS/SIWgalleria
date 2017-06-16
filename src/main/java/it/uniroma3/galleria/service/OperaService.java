package it.uniroma3.galleria.service;

import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.repository.OperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */

@Service
public class OperaService {

    @Autowired
    private OperaRepository repo;

    public List<Opera> get(){ return repo.findAll(); }

    public Opera getById(long Id) { return repo.findOperaByIdEquals(Id); }
}
