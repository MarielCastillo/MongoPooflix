package ar.com.ada.api.pooflixmongo.entities;

import org.bson.types.ObjectId;

public class Director {
    private ObjectId _id;
    private String nombre;
    private String estilo;
    
    public Director(String nombre, String estilo) {
        this.nombre = nombre;
        this.estilo = estilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

}
