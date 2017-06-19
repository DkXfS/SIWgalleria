package it.uniroma3.galleria.repository;

import it.uniroma3.galleria.models.Tecnica;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dk_XfS on 18/06/2017.
 */
public interface TecnicaRepository extends CrudRepository<Tecnica, Long>
{
    List<Tecnica> findAll();

    Tecnica save(Tecnica tecnica);

    void delete(Tecnica tecnica);

    void removeById(long Id);

    Tecnica findTecnicaById(long Id);
}
