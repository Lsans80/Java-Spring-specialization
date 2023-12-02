package N2_01Callback.Cliente;

import N2_01Callback.Pago.Callback;
import N2_01Callback.Pago.MetodoPago;

public class PasarelaPago {

    public void procesarPago (MetodoPago metodoPago, Callback callback){

        metodoPago.realizarPago(callback);
    }
}
