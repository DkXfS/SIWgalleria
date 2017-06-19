package it.uniroma3.galleria.controller;

import it.uniroma3.galleria.models.Autore;
import it.uniroma3.galleria.models.Nazionalita;
import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.NazionalitaService;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.TecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */

@Controller
public class IndexController {

    @Autowired
    private AutoreService autoreService;

    @Autowired
    private OperaService operaService;

    @Autowired
    private TecnicaService tecnicaService;

    @Autowired
    private NazionalitaService nazionalitaService;

    @GetMapping(value={"/", "/index"})
    public String home(Model model)
    {
        //model.addAttribute("autori", autoreService.get());
        model.addAttribute("tecniche", tecnicaService.get());
        model.addAttribute("nazionalitas", nazionalitaService.get());
        model.addAttribute("opere", operaService.getOrdered());
        return "index";
    }

    @GetMapping("/getByParam")
    public String homeWithSearch(Model model, @RequestParam long tecnicaId, @RequestParam long nazionalitaId)
    {
        List<Opera> allOpere=operaService.get();
        for(int i=0; i<allOpere.size(); i++)
        {
            Opera iteratedOpera=allOpere.get(i);
            if(iteratedOpera.getTecnica().getId()!=tecnicaId && iteratedOpera.getAutore().getNazionalita().getId()!=nazionalitaId)
                allOpere.remove(iteratedOpera);
        }
        model.addAttribute("opere", allOpere);
        model.addAttribute("tecniche", tecnicaService.get());
        model.addAttribute("nazionalitas", nazionalitaService.get());
        return "index";
    }

    @PostMapping(value={"save"})
    public String salvaAutore(@RequestParam String nome, @RequestParam String cognome, @RequestParam String anno)
    {
        Autore a=new Autore(nome, cognome, null, null, null);
        a=autoreService.save(a);
        if(autoreService.get().size()==1)
            return "success";
        else return "fail";
    }
}
