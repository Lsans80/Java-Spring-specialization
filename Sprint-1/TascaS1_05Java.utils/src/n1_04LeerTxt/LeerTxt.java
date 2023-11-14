package n1_04LeerTxt;

/*Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class LeerTxt {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		if (args.length == 0) {// Si NO le proporcionamos nada en la línea de comandos nos preguntará la ruta.

			System.out.println("Dime la ruta del directorio o archivo que quieres consultar:");
			String ruta = teclado.nextLine();

			File consulta = new File(ruta);

			if (consulta.exists() && consulta.isDirectory()) {

				listarDirectorioRecursivo(ruta);
				System.out.println("El fichero.txt se ha creado.");

			} else if (consulta.exists() && consulta.isFile()) {
				leerTxt(consulta);

			} else {
				System.err.println("La ruta no existe.");
			}

		}

	}

	public static void leerTxt(File consulta) {

		BufferedReader lector = null;

		try {

			lector = new BufferedReader(new FileReader(consulta));

			String linea;

			while ((linea = lector.readLine()) != null) {

				System.out.println(linea);
			}

			

		} catch (IOException e) {
			System.err.println(e.getMessage());
			
		} finally {//Buena práctica: bloque finally para cerrar lector.
			
			try {
				
				lector.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
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

	public static void listarDirectorioRecursivo(String ruta) {

		File carpeta = new File(ruta);

		if (carpeta.isDirectory()) {

			File[] directorio = carpeta.listFiles();
			SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

			Arrays.sort(directorio);

			for (int i = 0; i < directorio.length; i++) {

				if (directorio[i].isDirectory()) {

					ficherosenTxt("D:" + directorio[i].getName() + " "
							+ ("Última modificación: " + fecha.format(directorio[i].lastModified())));

					String ruta1 = directorio[i].getAbsolutePath();

					listarDirectorioRecursivo(ruta1);

				} else {

					ficherosenTxt("F:" + directorio[i].getName() + " "
							+ ("Última modificación: " + fecha.format(directorio[i].lastModified())));
				}

			}

		} else {

			System.err.println("El directorio no es válido.");
		}

	}

}
