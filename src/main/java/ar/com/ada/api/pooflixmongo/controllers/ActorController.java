package ar.com.ada.api.pooflixmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Actor;
import ar.com.ada.api.pooflixmongo.models.request.ActorRequest;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.ActorService;

@RestController
public class ActorController {
    @Autowired
    ActorService actorService;

    @PostMapping("/actores")
    public ResponseEntity<GenericResponse> crearActor(@RequestBody ActorRequest aR) {
        Actor actor = actorService.crearActor(aR.nombre, aR.nivel);

        if (actor == null) {
            return ResponseEntity.notFound().build();
        }

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Actor creada con exito";
        r.id = actor.get_id();
        return ResponseEntity.ok(r);
    }

    @GetMapping("/actores")
    public ResponseEntity<List<Actor>> listarActor() {
        List<Actor> actores = actorService.obtenerActores();
        return ResponseEntity.ok(actores);
    }
}
