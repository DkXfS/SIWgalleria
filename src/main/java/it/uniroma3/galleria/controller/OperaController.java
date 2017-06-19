package it.uniroma3.galleria.controller;

import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.TecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * Created by Dk_XfS on 18/06/2017.
 */

@Controller
public class OperaController
{
    @Autowired
    AutoreService autoreService;

    @Autowired
    OperaService operaService;

    @Autowired
    TecnicaService tecnicaService;

    @GetMapping("/addPainting")
    public String aggiungiOpera(Model model)
    {
        model.addAttribute("autori", autoreService.get());
        model.addAttribute("tecniche", tecnicaService.get());
        model.addAttribute("opera",new Opera());
        return "aggiungiOpera";
    }

    @PostMapping("/save")
    public String salvaOpera(@RequestParam("file") MultipartFile file, Model model, @Valid Opera opera, BindingResult bindingResult, @RequestParam long autoreId, @RequestParam long tecnicaId)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("autori", autoreService.get());
            model.addAttribute("tecniche", tecnicaService.get());
            model.addAttribute("opera",opera);
        }
        opera.setAutore(autoreService.find(autoreId));
        opera.setTecnica(tecnicaService.find(tecnicaId));
        operaService.save(opera, file);
        return "fineAggiuntaOpera";
    }

    @GetMapping("/delete/{id}")
    public String cancellaQuadro(@PathVariable long id, Model model){
        operaService.removeThroughId(id);
        model.addAttribute("opere",operaService.get());
        return "admin/welcome";
    }
}