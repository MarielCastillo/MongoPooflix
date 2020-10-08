package ar.com.ada.api.pooflixmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Director;
import ar.com.ada.api.pooflixmongo.models.request.DirectorRequest;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.DirectorService;

@RestController
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @PostMapping("/directores")
    public ResponseEntity<GenericResponse> crearDirector(@RequestBody DirectorRequest dR) {
        Director director = directorService.crearDirector(dR.nombre, dR.estilo);
        
        if (director == null) {
            return ResponseEntity.notFound().build();
        }

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Director creada con exito";
        r.id = director.get_id();
        return ResponseEntity.ok(r);
    }

    @GetMapping("/directores")
    public ResponseEntity<List<Director>> listarDirector() {
        List<Director> directores = directorService.obtenerDirectores();
        return ResponseEntity.ok(directores);
    }
}
