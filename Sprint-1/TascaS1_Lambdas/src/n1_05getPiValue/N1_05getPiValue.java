package n1_05getPiValue;

/*Crea una Functional Interface con un m�todo llamado getPiValue() que debe devolver un double.

Desde el main() de la clase principal, instancia la interfaz y as��ale el valor 3.1415.

Invoca el m�todo getPiValue() e imprime el resultado.*/

public class N1_05getPiValue {
	
    public static void main (String[] args) {

        FunctionalInterface pi = () -> 3.1415;

        System.out.println(pi.getPiValue());

    }

}


