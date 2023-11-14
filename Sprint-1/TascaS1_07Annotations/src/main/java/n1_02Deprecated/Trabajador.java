package n1_02Deprecated;

public abstract class Trabajador {
    private String nombre;
    private String apellido;
    private float precioHora;

    public Trabajador(String nombre, String apellido, float precioHora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.precioHora = precioHora;
    }

    public String getNombre() {

        return nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public float getPrecioHora() {

        return precioHora;
    }

    public void setPrecioHora(float precioHora) {

        this.precioHora = precioHora;
    }

    public float calcularSueldo (float horasTrabajadas){

        return horasTrabajadas*precioHora;

    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", precioHora=" + precioHora +
                '}';
    }
}
