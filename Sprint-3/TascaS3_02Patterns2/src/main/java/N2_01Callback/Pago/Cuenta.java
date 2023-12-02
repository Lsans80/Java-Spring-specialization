package N2_01Callback.Pago;

public class Cuenta implements MetodoPago {

    private int numeroCuenta;

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    @Override
    public void realizarPago(Callback callback) {

    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta=" + numeroCuenta +
                '}';
    }


}
