package cat.itacademy.barcelonactiva.SansMoll.Luisa.s04.t02.n02.model.domain;

import jakarta.persistence.*;

@Entity//Mapeo a base de datos.
@Table(name = "Fruta")
public class Fruta {
    @Id //Primary Key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//El id se autoincrementa.
    private int id;
    @Column(name = "nombre")//Podemos prescindir de @Column, genera columnas por defecto con los nombres de los atributos.
    private String nombre;
    @Column(name = "cantidadKilos")
    private int cantidadKilos;

    public Fruta(String nombre, int cantidadKilos) {
        this.nombre = nombre;
        this.cantidadKilos = cantidadKilos;
    }

    public Fruta() { // Constructor vacío para la recuperación de datos con JPA.
    }

    public int getId() {
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
