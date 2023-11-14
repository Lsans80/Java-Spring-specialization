package n1_03ArrayException;

import java.util.ArrayList;

/*Crea una classe amb un mètode que llanci una ArrayIndexOutOfBoundsException.
Verifica el seu correcte funcionament amb un test jUnit.*/

public class Exception {

	public static void numeros() {
		
		ArrayList<Integer> numero = new ArrayList<Integer>();

		try {

			numero.add(3);
			numero.add(5);
			numero.add(7);

			System.out.println(numero.get(5));

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		
		ArrayList<Integer> numero = new ArrayList<Integer> ();

		Exception.numeros();
	}

}
