package cat.itacademy.barcelonactiva.sansmoll.luisa.s05.t01.n03.model.dto;

import jakarta.validation.constraints.NotEmpty;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FlorDTO {
    private int pk_FlorID;
    @NotEmpty(message = "El nombre no puede estar vacío.")
    private String nombreFlor;
    @NotEmpty(message = "El nombre no puede estar vacío.")
    private String paisFlor;
    private String tipoFlor;

    private static final List<String> PAISES_EU = Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");

    public FlorDTO() {

    }

    public FlorDTO(int pk_FlorID, String nombreFlor, String paisFlor, String tipoFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
        this.tipoFlor = tipoFlor;
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

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }

    public String validarTipoFlor (){

        String resultado = "";

        if(paisFlor != null){
            Collator collator = Collator.getInstance(Locale.getDefault());
            collator.setStrength(Collator.PRIMARY); // Ignora acentos y mayúsculas/minúsculas.

            resultado = PAISES_EU.stream().anyMatch(pais -> collator.equals(pais, paisFlor)) ? "EU" : "Fuera de la UE";
        } else {
            resultado = "Pais no especificado.";
        }

        return resultado;

        //return paisesEU.contains(paisSucursal) ? "EU":"Fuera de la UE";
        //return paisesEU.stream().anyMatch(pais -> pais.equalsIgnoreCase(paisSucursal)) ? "EU" : "Fuera de la UE";
    }

    @Override
    public String toString() {
        return "FlorDTO{" +
                "pk_FlorID=" + pk_FlorID +
                ", nombreFlor='" + nombreFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                ", tipoFlor='" + tipoFlor + '\'' +
                '}';
    }
}
