package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n02.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Flor")
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    @NotEmpty(message = "El nombre de la flor no puede estar vacío.")
    private String nombreFlor;
    @NotEmpty(message = "El nombre de la flor no puede estar vacío.")
    private String paisFlor;

    public Flor(int pk_FlorID, String nombreFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    public Flor(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    public Flor() {
    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public void setNombreFlor(String nombreFlor) {
        this.nombreFlor = nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "pk_FlorID=" + pk_FlorID +
                ", nombreFlor='" + nombreFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                '}';
    }
}