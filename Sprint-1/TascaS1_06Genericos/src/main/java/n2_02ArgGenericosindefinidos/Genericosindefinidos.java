package n2_02ArgGenericosindefinidos;

/*Modifica l'apartat anterior de manera que els arguments del mètode genèric
siguin una llista d'arguments de variable indefinida.*/

import n1_02Generico.Persona;

public class Genericosindefinidos {

    public static void main(String[] args) {
        Persona pers1 = new Persona("Luisa", "Blue", 33);
        Persona pers2 = new Persona("Blanca", "Pink", 18);

        Genericosindefinidos.soyUnmetodoGenerico(pers1, "Chocolate", 333, "Mango", "Luna", 7.8f, pers2);

    }

    //Argumentos genéricos indefinidos.
    public static <T> void soyUnmetodoGenerico(T... args) {
        for (T argumentos : args) {
            System.out.println(argumentos);
        }

    }

}
