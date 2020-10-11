package ar.com.ada.api.pooflixmongo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.*;
import ar.com.ada.api.pooflixmongo.repos.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    PeliculaRepository peliculaRepository;

    public Pelicula crearPelicula(String titulo, List<Director> directores, List<Genero> generos, List<Actor> actores) {
        if(existePelicula(titulo)){
            return null;
        }else{
            Pelicula pelicula = new Pelicula(titulo, directores, generos, actores);
            grabar(pelicula);
            return pelicula;
        }
    }

    boolean existePelicula(String titulo) {
        Pelicula pelicula = peliculaRepository.findByTitulo(titulo);
        return pelicula != null? true : false;
    }

    public void grabar(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula buscarPorId(ObjectId idPelicula) {
        Optional<Pelicula> opPelicula = peliculaRepository.findById(idPelicula);
        return opPelicula.isPresent() ? opPelicula.get() : null;
    }
}
