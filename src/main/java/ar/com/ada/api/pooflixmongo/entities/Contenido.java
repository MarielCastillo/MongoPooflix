package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contenido")
public class Contenido {
    private ObjectId _id;
    private String titulo;
    private List<Director> directores = new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();
    private List<Actor> actores = new ArrayList<>();
    
    public Contenido(String titulo, List<Director> directores, List<Genero> generos, List<Actor> actores) {
        this.titulo = titulo;
        this.directores = directores;
        this.generos = generos;
        this.actores = actores;
    }
    
    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }


}