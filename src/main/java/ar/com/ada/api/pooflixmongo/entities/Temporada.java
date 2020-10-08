package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temporada")
public class Temporada {
    private int numero;
    private List<Episodio> episodios = new ArrayList<>();
    
    public Temporada(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public void agregarEpisodio(Episodio episodio){
        this.episodios.add(episodio);
    }

}