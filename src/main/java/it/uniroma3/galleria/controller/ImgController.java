package it.uniroma3.galleria.controller;

import it.uniroma3.galleria.service.OperaService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.*;

@Controller
@RequestMapping("/img")
public class ImgController implements ServletContextAware{


    @Autowired
    OperaService service;

    ServletContext servletContext;


    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPicture(@PathVariable String id) throws IOException {
        if (id != null) {

            File file = new File(servletContext.getRealPath("/") + "/" + "img/" + Long.parseLong(id) + ".jpg");

            try{
                return IOUtils.toByteArray(new FileInputStream(file));
            }
            catch (FileNotFoundException f){
                return null;
            }

        }
        return null;

    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}