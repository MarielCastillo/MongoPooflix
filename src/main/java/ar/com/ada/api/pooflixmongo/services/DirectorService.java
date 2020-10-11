package ar.com.ada.api.pooflixmongo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Director;
import ar.com.ada.api.pooflixmongo.repos.DirectorRepository;

@Service
public class DirectorService {

	@Autowired
    DirectorRepository directorRepository;

    public Director crearDirector(String nombre, String nivel) {
        if(existeDirector(nombre)){
            return null;
        }else{
            Director director = new Director(nombre, nivel);
            grabar(director);
            return director;
        }
    }

    public boolean existeDirector(String nombre) {
        Director director = directorRepository.findByNombre(nombre);
        return director != null? true : false;
    }

    public void grabar(Director director) {
        directorRepository.save(director);
    }

    public List<Director> obtenerDirectores() {
        return directorRepository.findAll();
    }

    public Director buscarPorId(ObjectId idDirector) {
        Optional<Director> opDirector = directorRepository.findById(idDirector);
        return opDirector.isPresent() ? opDirector.get() : null;
    }
}
