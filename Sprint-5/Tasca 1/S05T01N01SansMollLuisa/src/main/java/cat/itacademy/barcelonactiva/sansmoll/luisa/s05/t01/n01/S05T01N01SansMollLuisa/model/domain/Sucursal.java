package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_SucursalID;
    //@NotEmpty(message = "El nombre de la sucursal no puede estar vacío.")
    private String nombreSucursal;
    //@NotEmpty(message = "El nombre de la sucursal no puede estar vacío.")
    private String paisSucursal;

    public Sucursal(int pk_SucursalID, String nombreSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal(String nombreSucursal, String paisSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal() {
    }

    public int getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(int pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                '}';
    }
}
