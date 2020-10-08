package ar.com.ada.api.pooflixmongo.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "peliculas")
public class Pelicula extends Contenido {

    public Pelicula(String titulo, List<Director> directores, List<Genero> generos, List<Actor> actores) {
        super(titulo, directores, generos, actores);
    }

}