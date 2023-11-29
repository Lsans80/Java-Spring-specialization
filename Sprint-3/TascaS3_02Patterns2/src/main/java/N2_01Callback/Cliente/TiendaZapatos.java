package N2_01Callback.Cliente;

import N2_01Callback.Pago.Cuenta;
import N2_01Callback.Pago.Paypal;
import N2_01Callback.Pago.Visa;

import java.util.Scanner;

public class TiendaZapatos {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        PasarelaPago pasarelaPago = new PasarelaPago();

        int opcion;

        do {

            System.out.println("Escoge el método de pago para realizar tu compra:\n"
                    + "1.Paypal\n" + "2.Visa\n" + "3.Cargo en cuenta bancaria\n");
            opcion = sc.nextInt();
            sc.nextLine();

        } while (opcion < 1 && opcion > 3);

        switch (opcion){

            case 1:
                System.out.println("Introduce tu usuario de Paypal:");
                String userPaypal = sc.nextLine();
                pasarelaPago.procesarPago(new Paypal(userPaypal));
                break;

            case 2:
                System.out.println("Introduce tu usuario de Paypal:");
                int numeroTargeta = sc.nextInt();
                sc.nextLine();
                pasarelaPago.procesarPago(new Visa(numeroTargeta));
                break;

            case 3:
                System.out.println("Introduce tu numero de cuenta bancaria.");
                int numeroCuenta = sc.nextInt();
                sc.nextLine();
                pasarelaPago.procesarPago(new Cuenta(numeroCuenta));
                break;
        }

    }


}
