package n2_01Genericoynogenerico;

/*Modifica l'exercici anterior de manera que un dels arguments del mètode genèric no sigui genèric.

 */

import n1_02Generico.MetodoGenerico;
import n1_02Generico.Persona;

public class Genericoynogenerico {

    public static void main(String[] args) {
        n1_02Generico.Persona pers1 = new Persona("Luisa", "Blue", 33);

        MetodoGenerico.soyUnmetodoGenerico(pers1, "Chocolate", 333);
        MetodoGenerico.soyUnmetodoGenerico(333, pers1, "Chocolate");

    }

    //Argumentos genéricos mezclados con no genéricos.
    public static <T> void soyUnmetodoGenerico(String uno, T dos, T tres) {
        System.out.println("Soy el dato genérico uno: " + uno);
        System.out.println("Soy el dato genérico dos: " + dos);
        System.out.println("Soy el dato genérico tres: " + tres);

    }

}
