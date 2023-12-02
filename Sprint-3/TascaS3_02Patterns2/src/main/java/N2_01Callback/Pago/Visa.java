package N2_01Callback.Pago;

public class Visa implements MetodoPago {

    private int numeroTargeta;

    public Visa(int numeroTargeta) {
        this.numeroTargeta = numeroTargeta;
    }
    @Override
    public void realizarPago(Callback callback) {

    }

    @Override
    public String toString() {
        return "Visa{" +
                "numeroTargeta=" + numeroTargeta +
                '}';
    }


}
