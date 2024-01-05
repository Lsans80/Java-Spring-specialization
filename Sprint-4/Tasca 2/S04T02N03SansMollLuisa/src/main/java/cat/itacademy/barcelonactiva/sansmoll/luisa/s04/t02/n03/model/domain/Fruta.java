package cat.itacademy.barcelonactiva.sansmoll.luisa.s04.t02.n03.model.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fruta")
public class Fruta {
    @Id //Primary Key.
    private ObjectId id;
    private String nombre;
    private int cantidadKilos;

    public Fruta(String nombre, int cantidadKilos) {
        this.nombre = nombre;
        this.cantidadKilos = cantidadKilos;
    }

    public Fruta() { // Constructor vacío para la recuperación de datos con JPA.
    }

    public ObjectId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(int cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadKilos=" + cantidadKilos +
                '}';
    }
}