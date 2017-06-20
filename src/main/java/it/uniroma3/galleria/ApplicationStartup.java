package it.uniroma3.galleria;

/**
 * Created by Dk_XfS on 20/06/2017.
 */
import it.uniroma3.galleria.models.Autore;
import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.models.Tecnica;
import it.uniroma3.galleria.models.Nazionalita;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.NazionalitaService;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.TecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    NazionalitaService nazionalitaService;

    @Autowired
    TecnicaService tecnicaService;

    @Autowired
    AutoreService autoreService;

    @Autowired
    OperaService operaService;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event)
    {
        Tecnica acq=new Tecnica("Acquerello");
        tecnicaService.save(acq);
        tecnicaService.save(new Tecnica("Pennello asciutto"));
        tecnicaService.save(new Tecnica("Chiaroscuro"));
        tecnicaService.save(new Tecnica("Linearismo"));
        Tecnica arr=new Tecnica("Arriccio");
        tecnicaService.save(arr);

        Nazionalita ita=new Nazionalita("Italia");
        ita=nazionalitaService.save(ita);
        Nazionalita ola=new Nazionalita("Olanda");
        ola=nazionalitaService.save(ola);
        nazionalitaService.save(new Nazionalita("Germania"));
        nazionalitaService.save(new Nazionalita("Francia"));
        nazionalitaService.save(new Nazionalita("Inghilterra"));

        Date dataNascita=new Date(-16337469600000L);
        Date dataMorte=new Date(-14221792800000L);
        Autore lDaVinci=new Autore("Leonardo","DaVinci", ita, dataNascita, dataMorte);
        lDaVinci=autoreService.save(lDaVinci);

        dataNascita=new Date(-3684535200000L);
        dataMorte=new Date(-2506471200000L);
        Autore vVanGogh=new Autore("Vincent","Van Gogh", ola, dataNascita, dataMorte);
        vVanGogh=autoreService.save(vVanGogh);

        operaService.save(new Opera("Mona Lisa", lDaVinci, arr, "Nessuna Descrizione", 1503, 77, 53));
        operaService.save(new Opera("Notte stellata sul Rodano", vVanGogh, acq, "Nessuna Descrizione", 1888, 92, 72.5));

    }

}