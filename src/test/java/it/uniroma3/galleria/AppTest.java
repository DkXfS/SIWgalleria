package it.uniroma3.galleria;

import it.uniroma3.galleria.models.Autore;
import it.uniroma3.galleria.models.Nazionalita;
import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.models.Tecnica;
import it.uniroma3.galleria.service.AutoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dk_XfS on 16/06/2017.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private AutoreService service;

    Autore autore;
    Nazionalita naz;
    Date nascita;
    Date morte;
    List<Opera> opere;
    Opera op;
    Tecnica tech;

    @Before
    public void setup()
    {
        naz=new Nazionalita();
        naz.setNome("Italia");

        nascita= new Date ();

        tech=new Tecnica();
        tech.setNome("Puntinismo");


/**
        op=new Opera("L'opera", autore, tech, nascita, "200*300");
        opere=new ArrayList<Opera>();
        opere.add(op);
        autore = new Autore("Leonardo","DaVinci", naz, nascita, nascita, opere);
**/
        autore=service.save(autore);
    }

    @Test
    public void ExistTest()
    {
        List<Autore> retrievedList=service.get();
        assertTrue(retrievedList.size()==1);
    }

    @Test
    public void RetrieveTest()
    {
        List<Autore> retrievedList=service.get();
        assertEquals(autore, retrievedList.get(0));
    }
}
