package it.uniroma3.galleria.controller;

import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.TecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * Created by Dk_XfS on 18/06/2017.
 */

@Controller
public class OperaController {
    @Autowired
    AutoreService autoreService;

    @Autowired
    OperaService operaService;

    @Autowired
    TecnicaService tecnicaService;

    @GetMapping("/protected/aggiungiOpera")
    public String aggiungiOpera(Model model) {
        model.addAttribute("autori", autoreService.get());
        model.addAttribute("tecniche", tecnicaService.get());
        model.addAttribute("opera", new Opera());
        return "formOperaSave";
    }

    @PostMapping("/protected/aggiungiOpera")
    public String salvaOpera(@RequestParam("file") MultipartFile file, Model model, @Valid Opera opera, BindingResult bindingResult, @RequestParam long autoreId, @RequestParam long tecnicaId) {
        if (bindingResult.hasErrors() || file.isEmpty())
        {
            if(file.isEmpty())
                model.addAttribute("immaginegNonInserita",true);
            model.addAttribute("autori", autoreService.get());
            model.addAttribute("tecniche", tecnicaService.get());
            return "formOperaSave";
        }
        opera.setAutore(autoreService.find(autoreId));
        opera.setTecnica(tecnicaService.find(tecnicaId));
        Opera operaSalvata=operaService.save(opera, file);
        return dettagliOperaDopoSave(operaSalvata,model);
    }

    @GetMapping("/protected/eliminaOpera/{id}")
    public String cancellaOpera(@PathVariable long id, Model model) {
        operaService.removeThroughId(id);
        model.addAttribute("opere", operaService.get());
        return "index";
    }

    @GetMapping("/protected/modificaOpera/{id}")
    public String modificaOpera(@PathVariable long id, Model model)
    {
        model.addAttribute("opera", operaService.find(id));
        model.addAttribute("autori", autoreService.get());
        model.addAttribute("tecniche", tecnicaService.get());
        return "formOperaUpdate";
    }

    @PostMapping("/protected/modificaOpera")
    public String salvaModificaOpera(@RequestParam("file") MultipartFile file, Model model, @Valid Opera opera, BindingResult bindingResult, @RequestParam long autoreId, @RequestParam long tecnicaId)
    {
        if (bindingResult.hasErrors() || file.isEmpty())
        {
            if(file.isEmpty())
                model.addAttribute("immaginegNonInserita",true);
            model.addAttribute("autori", autoreService.get());
            model.addAttribute("tecniche", tecnicaService.get());
            return "formOperaUpdate";
        }
        opera.setAutore(autoreService.find(autoreId));
        opera.setTecnica(tecnicaService.find(tecnicaId));
        Opera operaSalvata=operaService.save(opera, file);
        return dettagliOperaDopoSave(operaSalvata,model);
    }

    @GetMapping("/opera/{id}")
    public String dettagliOpera(@PathVariable long id, Model model)
    {
        model.addAttribute("opera", operaService.find(id));
        return "dettagliOpera";
    }

    public String dettagliOperaDopoSave(Opera opera, Model model)
    {
        model.addAttribute("opera", opera);
        return "dettagliOpera";
    }
}