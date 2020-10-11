package ar.com.ada.api.pooflixmongo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pooflixmongo.entities.*;
import ar.com.ada.api.pooflixmongo.entities.Temporada;
import ar.com.ada.api.pooflixmongo.repos.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public Serie crearSerie(String titulo, List<Director> directores, List<Genero> generos, List<Actor> actores, List<Temporada> temporadas) {
        if (existeSerie(titulo)) {
            return null;
        } else {
            Serie serie = new Serie(titulo, directores, generos, actores, temporadas);
            grabar(serie);
            return serie;
        }
    }

    public boolean existeSerie(String titulo) {
        Serie serie = serieRepository.findByTitulo(titulo);
        return serie != null ? true : false;
    }

    public void grabar(Serie serie) {
        serieRepository.save(serie);
    }

    public List<Serie> obtenerSeries() {
        return serieRepository.findAll();
    }

    public Serie buscarPorId(ObjectId idSerie) {
        Optional<Serie> opSerie = serieRepository.findById(idSerie);
        return opSerie.isPresent() ? opSerie.get() : null;
    }

    public List<Temporada> traerTemporadasPorSerieId(ObjectId _id) {
        return buscarPorId(_id).getTemporadas();
    }
}