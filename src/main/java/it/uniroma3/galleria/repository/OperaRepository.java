package it.uniroma3.galleria.repository;

import it.uniroma3.galleria.models.Opera;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */
public interface OperaRepository extends CrudRepository<Opera, Long> {

    List<Opera> findAll ();

    List<Opera> getAllByOrderByTitoloAsc();

    List<Opera> findAllByAutore_Id(long Id);

    Opera save (Opera opera);

    void removeById (long Id);

    Opera findOperaByIdEquals(long Id);
}
