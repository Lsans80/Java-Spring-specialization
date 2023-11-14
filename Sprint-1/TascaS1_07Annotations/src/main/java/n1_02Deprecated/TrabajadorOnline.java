package n1_02Deprecated;

public class TrabajadorOnline extends Trabajador {
    private final float internet;

    public TrabajadorOnline(String nombre, String apellido, float precioHora, float internet) {
        super(nombre, apellido, precioHora);
        this.internet = internet;
    }

    public float getInternet() {

        return internet;
    }

    @Override
    public float calcularSueldo(float horasTrabajadas) {

        return (horasTrabajadas * super.getPrecioHora()) + internet;
    }

    @Deprecated
    public static void desplazamiento (){
        System.out.println("No se paga desplazamiento para los empleados online.");
    }
}
