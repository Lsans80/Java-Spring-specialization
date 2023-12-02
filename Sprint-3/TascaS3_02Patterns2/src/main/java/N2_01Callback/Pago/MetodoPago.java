package N2_01Callback.Pago;

@FunctionalInterface
public interface MetodoPago {

    void realizarPago(Callback callback);
}
