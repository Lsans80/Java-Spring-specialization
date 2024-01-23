package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n01.S05T01N01SansMollLuisa.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SucursalDTO {

    private int pk_SucursalID;
    @NotEmpty(message = "El nombre no puede estar vacío.")
    private String nombreSucursal;
    @NotEmpty(message = "El país no puede estar vacío.")
    private String paisSucursal;
    private String tipoSucursal;

    private static final List<String> PAISES_EU = Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");
    public SucursalDTO() {
    }

    public SucursalDTO(int pk_SucursalID, String nombreSucursal, String paisSucursal, String tipoSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
        this.tipoSucursal = validarTipoSucursal();
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

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    public String validarTipoSucursal (){

        String resultado = "";

        if(paisSucursal != null){
            Collator collator = Collator.getInstance(Locale.getDefault());
            collator.setStrength(Collator.PRIMARY); // Ignora acentos y mayúsculas/minúsculas.

            resultado = PAISES_EU.stream().anyMatch(pais -> collator.equals(pais, paisSucursal)) ? "EU" : "Fuera de la UE";
        } else {
            resultado = "Pais no especificado.";
        }

        return resultado;

        //return paisesEU.contains(paisSucursal) ? "EU":"Fuera de la UE";
        //return paisesEU.stream().anyMatch(pais -> pais.equalsIgnoreCase(paisSucursal)) ? "EU" : "Fuera de la UE";
    }

    @Override
    public String toString() {
        return "SucursalDTO{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                ", tipoSucursal='" + tipoSucursal + '\'' +
                '}';
    }
}
