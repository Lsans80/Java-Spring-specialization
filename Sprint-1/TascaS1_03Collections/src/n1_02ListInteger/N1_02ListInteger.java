package n1_02ListInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*Crea i emplena un List<Integer>. 

Crea un segon List<Integer> i insereix a la segona llista els elements de la primera en ordre invers. 

Empra els objectes ListIterator per a llegir els elements de la primera llista i inserir-los en la segona.*/

public class N1_02ListInteger {

	public static void main(String[] args) {

		List<Integer> primeraLista = new ArrayList<Integer>();

		primeraLista.add(1);
		primeraLista.add(5);
		primeraLista.add(3);
		primeraLista.add(4);
		primeraLista.add(2);

		System.out.println(primeraLista);

		List<Integer> segundaLista = new ArrayList<Integer>();
		
		//Agregamos los elementos de la primera en la segunda en orden inverso con un ListIterator.

		ListIterator<Integer> it = primeraLista.listIterator(primeraLista.size());

		while (it.hasPrevious()) {
			
			Integer elementoPrimeraLista = it.previous();
			segundaLista.add(elementoPrimeraLista);

		}
		
		System.out.println(segundaLista);

	}

}
