package ar.com.ada.api.pooflixmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Serie;
import ar.com.ada.api.pooflixmongo.models.request.SerieRequest;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.SerieService;

@RestController
public class SerieController {
    @Autowired
    SerieService serieService;

    @PostMapping("/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody SerieRequest sR) {
        Serie serie = serieService.crearSerie(sR.titulo, sR.directores, sR.generos, sR.actores, sR.temporadas);
        
        if (serie == null) {
            return ResponseEntity.notFound().build();
        }
        
        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Serie creada con exito";
        r.id = serie.get_id();
        return ResponseEntity.ok(r);
    }

    @GetMapping("/series")
    public ResponseEntity<List<Serie>> listarSerie() {
        List<Serie> series = serieService.obtenerSeries();
        return ResponseEntity.ok(series);
    }

}

