package it.uniroma3.galleria.controller;

import it.uniroma3.galleria.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Dk_XfS on 20/06/2017.
 */

@Controller
public class AutoreController
{
    @Autowired
    private AutoreService autoreService;

    @GetMapping("/autore/{id}")
    public String visualizzaDettagliAutore(@PathVariable long id, Model model)
    {
        model.addAttribute("autore", autoreService.find(id));
        return "autore";
    }
}
