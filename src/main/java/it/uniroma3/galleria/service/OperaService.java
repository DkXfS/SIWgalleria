package it.uniroma3.galleria.service;

import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.repository.OperaRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */

@Service
public class OperaService implements ServletContextAware{

    @Autowired
    private OperaRepository repo;

    private ServletContext servletContext;

    public List<Opera> get(){ return repo.findAll(); }

    public List<Opera> getOrdered() { return repo.getAllByOrderByTitoloAsc(); }

    public Opera find(long Id) { return repo.findOne(Id); }

    public Opera save(Opera opera) { return repo.save(opera); }
    
    public Opera save(Opera Opera, MultipartFile file) {
        Opera OperaSaved = repo.save(Opera);
        String nameImage = String.valueOf(Opera.getId());
        saveImage(nameImage, file);


        return repo.save(OperaSaved);

    }

    private void saveImage(String filename, MultipartFile image) {

        System.out.println("SAVE IMAGE");
        System.out.println(servletContext.getRealPath("/") + "/img/" + filename + ".jpg");
        System.out.println("SAVE IMAGE END");

        File file = new File(servletContext.getRealPath("/") + "/img/" + filename + ".jpg");

        System.out.println(servletContext.getRealPath("/") + "/img/" + filename + ".jpg");
        try {
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeThroughId(long Id) { repo.removeById(Id); }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
