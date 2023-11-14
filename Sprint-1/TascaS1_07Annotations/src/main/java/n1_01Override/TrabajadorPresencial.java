package n1_01Override;

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
}
