package it.uniroma3.galleria.repository;

import it.uniroma3.galleria.models.Autore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */
public interface AutoreRepository extends CrudRepository<Autore, Long> {

    List<Autore> findAll();

    void removeById (long Id);

    //Autore save (Autore autore);

    Autore findAutoreByIdEquals(long Id);

    void delete (Autore autore);
}
