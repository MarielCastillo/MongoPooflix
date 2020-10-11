package ar.com.ada.api.pooflixmongo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.Actor;
import ar.com.ada.api.pooflixmongo.repos.ActorRepository;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public Actor crearActor(String nombre, String nivel) {
        if(existeActor(nombre)){
            return null;
        }else{
            Actor actor = new Actor(nombre, nivel);
            grabar(actor);
            return actor;
        }
    }

    public boolean existeActor(String nombre) {
        Actor actor = actorRepository.findByNombre(nombre);
        return actor != null? true : false;
    }

    // List<String> collect = names.stream()
    // .filter(s -> s.contains("o"))
    // .collect(Collectors.toList());

    public void grabar(Actor actor) {
        actorRepository.save(actor);
    }

    public List<Actor> obtenerActores() {
        return actorRepository.findAll();
    }

    public Actor buscarPorId(ObjectId idActor) {
        Optional<Actor> opActor = actorRepository.findById(idActor);
        return opActor.isPresent() ? opActor.get() : null;
    }
}
