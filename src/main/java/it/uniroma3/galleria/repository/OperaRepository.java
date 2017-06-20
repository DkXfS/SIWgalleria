package it.uniroma3.galleria.repository;

import it.uniroma3.galleria.models.Opera;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */
@Transactional
public interface OperaRepository extends CrudRepository<Opera, Long> {

    List<Opera> findAll ();

    List<Opera> getAllByOrderByTitoloAsc();

    List<Opera> findAllByAutore_Id(long Id);

    Opera save (Opera opera);

    //Opera update

    void removeById (long Id);

    Opera findOperaByIdEquals(long Id);
}
