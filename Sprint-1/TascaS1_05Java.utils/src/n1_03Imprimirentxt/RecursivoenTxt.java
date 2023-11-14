package n1_03Imprimirentxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class RecursivoenTxt {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		if (args.length == 0) {// Si NO le proporcionamos nada en la línea de comandos nos preguntará la ruta.

			System.out.println("Dime la ruta del directorio que quieres consultar:");
			String ruta = teclado.nextLine();
			File consulta = new File(ruta);

			if (consulta.exists() && consulta.isDirectory()) {

				try {
					listarDirectorioenTxt(ruta);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				System.out.println("El fichero.txt se ha creado.");

			} else {

				System.err.println("La ruta no existe.");
			}
		}

	}

	public static void ficherosenTxt(String fichero) {

		try (FileWriter listaFicheros = new FileWriter("ficheros.txt", true)) {

			listaFicheros.write(fichero + "\n");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void listarDirectorioenTxt(String ruta) throws FileNotFoundException {

		File carpeta = new File(ruta);

		File[] directorio = carpeta.listFiles();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

		Arrays.sort(directorio);

		for (int i = 0; i < directorio.length; i++) {

			if (directorio[i].isDirectory()) {

				ficherosenTxt("D:" + directorio[i].getName() + " - "
						+ ("Última modificación: " + fecha.format(directorio[i].lastModified())));

				String ruta1 = directorio[i].getAbsolutePath();

				listarDirectorioenTxt(ruta1);

			} else {

				ficherosenTxt("F:" + directorio[i].getName() + " - "
						+ ("Última modificación: " + fecha.format(directorio[i].lastModified())));
			}

		}

	}

}
