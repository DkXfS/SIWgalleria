package it.uniroma3.galleria.controller;

        import it.uniroma3.galleria.models.Autore;
        import it.uniroma3.galleria.models.Dummy;
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
//import sun.jvm.hotspot.debugger.win32.coff.OptionalHeaderWindowsSpecificFields;

        import java.util.ArrayList;
        import java.util.Date;
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

    @GetMapping(value={"/", "/index","/home"})
    public String home(Model model)
    {
        //model.addAttribute("autori", autoreService.get());
        model.addAttribute("tecniche", tecnicaService.get());
        model.addAttribute("nazionalitas", nazionalitaService.get());
        model.addAttribute("dummy",new Dummy());
        //List <Opera> oldd = new ArrayList<Opera>();
        //Opera op = new Opera("nome", new Autore("NomeAutore", "CognomeAutore", new Nazionalita(), new Date(),new Date()), null, "Lorem ipsun dolor sit amen e poi un altra frase che descrive l'opera in tutto e per tutto",1900,20,30);
        //op.setId(0);
        //oldd.add(op);
        //model.addAttribute("opere", oldd);
        model.addAttribute("opere", operaService.getOrdered());
        return "index";
    }

    @GetMapping("/getByParam")
    public String homeWithSearch(Model model, @RequestParam long tecnica, @RequestParam long nazionalita)
    {
        List<Opera> allOpere=operaService.get();
        List<Opera> selectedOpere= new ArrayList<>();
        for(int i=0; i<allOpere.size(); i++)
            if(allOpere.get(i).getTecnica().getId()==tecnica && allOpere.get(i).getAutore().getNazionalita().getId()==nazionalita)
                selectedOpere.add(allOpere.get(i));

        model.addAttribute("opere", selectedOpere);
        model.addAttribute("tecniche", tecnicaService.get());
        model.addAttribute("nazionalitas", nazionalitaService.get());
        model.addAttribute("dummy",new Dummy());

        return "index";
    }

    @GetMapping("/login")
    public String redirect2SpringSecurityLogin(){ return "login"; }

    //@PostMapping("/logout")
    //public String redirect2SpringSecurityLogout(){ return "logout"; }
}