package n1_01Directorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DirectorioOrdenadoAlfabeticamente {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		if (args.length == 0) {// Si NO le proporcionamos nada en la línea de comandos nos preguntará la ruta.

			System.out.println("Dime la ruta del directorio que quieres consultar:");
			String ruta = teclado.nextLine();

			try {

				directorioOrdenado(ruta);

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		} else {

			System.out.println("La ruta no existe.");
		}

	}

	public static void directorioOrdenado(String ruta) throws FileNotFoundException {

		File carpeta = new File(ruta);// Clase File para leer la ruta.

		File[] directorio;

		if (carpeta.exists()) {

			directorio = carpeta.listFiles();
			Arrays.sort(directorio);

			for (int i = 0; i < directorio.length; i++) {

				System.out.println(directorio[i]);

			}

		} else {

			System.err.println("La ruta no es correcta.");

		}

	}

}
