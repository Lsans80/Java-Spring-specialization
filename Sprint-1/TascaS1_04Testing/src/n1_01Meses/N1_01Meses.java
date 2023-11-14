package n1_01Meses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Crea una classe Java que insereixi en una llista ordenada els noms dels mesos de l'any.
 
Verifica amb jUnit que la llista té 12 posicions, que no és nul·la i que en la seva posició 8 conté el nom 'agost'.*/

public class N1_01Meses {

	public static void main(String[] args) {

		List<Mes> meses = new ArrayList<>();
		
		agregarMeses(meses);

		for (Mes mes : meses) {

			System.out.println(mes);
		}

		Collections.sort(meses);// compareTo en la clase Mes y implements Comparable<Mes> para que podamos usar
								// .sort.

		System.out.println("\n****Meses ordenados alfabéticamente****\n");

		for (Mes mes : meses) {

			System.out.println(mes);
		}
	}

	public static List<Mes> agregarMeses(List<Mes> meses) {

		meses.add(new Mes("Enero"));
		meses.add(new Mes("Febrero"));
		meses.add(new Mes("Marzo"));
		meses.add(new Mes("Abril"));
		meses.add(new Mes("Mayo"));
		meses.add(new Mes("Junio"));
		meses.add(new Mes("Julio"));
		meses.add(new Mes("Agosto"));
		meses.add(new Mes("Septiembre"));
		meses.add(new Mes("Octubre"));
		meses.add(new Mes("Noviembre"));
		meses.add(new Mes("Diciembre"));

		return meses;

	}

}
