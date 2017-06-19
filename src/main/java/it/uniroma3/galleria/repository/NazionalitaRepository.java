package it.uniroma3.galleria.repository;

import it.uniroma3.galleria.models.Nazionalita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dk_XfS on 19/06/2017.
 */
public interface NazionalitaRepository extends CrudRepository<Nazionalita, Long>{

    List<Nazionalita> findAll();

    Nazionalita findNazionalitaById(long Id);
}
