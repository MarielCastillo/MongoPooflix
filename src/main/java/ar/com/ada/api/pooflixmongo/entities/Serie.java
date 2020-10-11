package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Serie")
public class Serie extends Contenido {

    public Serie(String titulo, List<Director> directores, List<Genero> generos, List<Actor> actores, List<Temporada> temporadas) {
        super(titulo, directores, generos, actores);
        this.temporadas = temporadas;
    }

    private List<Temporada> temporadas = new ArrayList<Temporada>();

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporada(Temporada temporada){
        this.temporadas.add(temporada);
    }

}