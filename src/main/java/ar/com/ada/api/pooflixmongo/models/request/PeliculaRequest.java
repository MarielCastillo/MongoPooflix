package ar.com.ada.api.pooflixmongo.models.request;

import java.util.*;

import ar.com.ada.api.pooflixmongo.entities.*;

public class PeliculaRequest {
    public String titulo;
    public List<Director> directores = new ArrayList<>();
    public List<Genero> generos = new ArrayList<>();
    public List<Actor> actores = new ArrayList<>();
}
