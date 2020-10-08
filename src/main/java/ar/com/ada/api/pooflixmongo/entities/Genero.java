package ar.com.ada.api.pooflixmongo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genero")
public class Genero {
    public String nombre;
}