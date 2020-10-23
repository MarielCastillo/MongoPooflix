package ar.com.ada.api.pooflixmongo.entities;

import java.util.*;

public class Temporada {
    private int numero;
    private List<Episodio> episodios = new ArrayList<>();
    
    public Temporada(int numero, List<Episodio> episodios) {
        this.numero = numero;
        this.episodios = episodios;
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
}