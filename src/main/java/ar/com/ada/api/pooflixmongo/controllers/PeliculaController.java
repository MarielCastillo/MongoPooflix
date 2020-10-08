package ar.com.ada.api.pooflixmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pooflixmongo.entities.Pelicula;
import ar.com.ada.api.pooflixmongo.models.request.PeliculaRequest;
import ar.com.ada.api.pooflixmongo.models.response.GenericResponse;
import ar.com.ada.api.pooflixmongo.services.PeliculaService;

@RestController
public class PeliculaController {
    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/peliculas")
    public ResponseEntity<GenericResponse> crearPelicula(@RequestBody PeliculaRequest pR) {
        Pelicula pelicula = peliculaService.crearPelicula(pR.titulo, pR.directores, pR.generos, pR.actores);
        
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Pelicula creada con exito";
        r.id = pelicula.get_id();
        return ResponseEntity.ok(r);
    }

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> listarPelicula() {
        List<Pelicula> peliculas = peliculaService.obtenerPeliculas();
        return ResponseEntity.ok(peliculas);
    }
}
