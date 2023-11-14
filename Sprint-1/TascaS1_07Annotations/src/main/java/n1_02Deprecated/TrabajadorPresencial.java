package n1_02Deprecated;

public class TrabajadorPresencial extends Trabajador {
    private static float gasolina;
    public TrabajadorPresencial(String nombre, String apellido, float precioHora, float gasolina) {
        super(nombre, apellido, precioHora);
        this.gasolina = gasolina;
    }
    @Override
    public float calcularSueldo(float horasTrabajadas) {

        return (horasTrabajadas * super.getPrecioHora()) + gasolina;
    }

    @Deprecated
    public static void dietas (){
        System.out.println("No se pagan dietas para los empleados presenciales, hay cantina gratis en la ofi!.");
    }
}
