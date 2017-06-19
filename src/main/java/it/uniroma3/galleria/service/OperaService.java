package it.uniroma3.galleria.service;

import it.uniroma3.galleria.models.Opera;
import it.uniroma3.galleria.repository.OperaRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dk_XfS on 15/06/2017.
 */

@Service
public class OperaService {

    @Autowired
    private OperaRepository repo;

    private ServletContext servletContext;

    public List<Opera> get(){ return repo.findAll(); }

    public List<Opera> getOrdered() { return repo.getAllByOrderByTitoloAsc(); }

    public Opera find(long Id) { return repo.findOperaByIdEquals(Id); }

    public Opera save(Opera opera) { return repo.save(opera); }

    public Opera save(Opera opera, MultipartFile file) {
        Opera savedOpera = repo.save(opera);
        String imageName = String.valueOf(opera.getId());
        saveImage(imageName, file);

        savedOpera.setImageUri("/pictures/" + imageName);
        return repo.save(savedOpera);

    }

    private void saveImage(String filename, MultipartFile image) {
        File file = new File(servletContext.getRealPath("/") + "/pictures/"
                + filename + ".jpg");

        try {
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeThroughId(long Id) { repo.removeById(Id); }
}
