package n1_01Meses;

/*Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el nom del mes de l'any). 
Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, a excepció de l'objecte amb atribut "Agost". 
Després, efectua la inserció en el lloc que correspon a aquest mes i demostra que l’ArrayList manté l'ordre correcte.

Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.

Recorre la llista amb un for i amb un iterador.*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class N1_01Meses {

	public static void main(String[] args) {

		ArrayList<Month> meses = new ArrayList<Month>();

		Month mes1 = new Month("Enero");
		Month mes2 = new Month("Febrero");
		Month mes3 = new Month("Marzo");
		Month mes4 = new Month("Abril");
		Month mes5 = new Month("Mayo");
		Month mes6 = new Month("Junio");
		Month mes7 = new Month("Julio");
		Month mes9 = new Month("Septiembre");
		Month mes10 = new Month("Octubre");
		Month mes11 = new Month("Noviembre");
		Month mes12 = new Month("Diciembre");

		meses.add(mes1);
		meses.add(mes2);
		meses.add(mes3);
		meses.add(mes4);
		meses.add(mes5);
		meses.add(mes6);
		meses.add(mes7);
		meses.add(mes9);
		meses.add(mes10);
		meses.add(mes11);
		meses.add(mes12);

		Month mes8 = new Month("Agosto");

		meses.add(7, mes8);

		// Tenemos Agosto en la posición 7.

		for (Month mes : meses) {
			System.out.println(mes.getName());
		}

		// Collection Set que no permite repetidos, pero desordenados.
		// Convertimos el ArrayList en Collection HashSet.

		Set<Month> mesesSinRepetidos = new HashSet<Month>(meses);

		// Instanciamos nuevos meses con atributo nombre repetido a la Collection.

		Month mes13 = new Month("Diciembre");
		Month mes14 = new Month("Enero");

		mesesSinRepetidos.add(mes13);
		mesesSinRepetidos.add(mes14);

		System.out.println("\n****Meses sin repetidos****\n");

		for (Month mes : mesesSinRepetidos) {
			System.out.println(mes.getName());
		}

		// Recorremos la lista con un Iterator.

		System.out.println("\n****Lista con iterador****\n");

		Iterator<Month> it = mesesSinRepetidos.iterator();

		while (it.hasNext()) {
			Month mes = it.next();
			System.out.println(mes.getName());
		}

	}

}
