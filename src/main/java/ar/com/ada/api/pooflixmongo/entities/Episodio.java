package ar.com.ada.api.pooflixmongo.entities;

public class Episodio {
    private int numero;
    private String nombre;
    private double duracion;
    
    public Episodio(int numero, String nombre, double duracion) {
        this.numero = numero;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

	public void agregarEpisodio(Episodio episodio) {
	}

}