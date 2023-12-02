package N2_01Callback.Pago;

public class Paypal implements MetodoPago {

    private String userPaypal;

    public Paypal(String userPaypal) {
        this.userPaypal = userPaypal;
    }
    @Override
    public void realizarPago(Callback callback) {

        callback.ejecutar(userPaypal);

    }

    @Override
    public String toString() {
        return "Paypal{" +
                "userPaypal='" + userPaypal + '\'' +
                '}';
    }


}
