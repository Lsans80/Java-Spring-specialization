package n1_02DirectorioRecursivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectorioRecursivo {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// C:\Users\Luisa Sans\Desktop\IT Academy

		if (args.length == 0) {// Si NO le proporcionamos nada en la línea de comandos nos preguntará la ruta.

			System.out.println("Dime la ruta del directorio que quieres consultar:");
			String ruta = teclado.nextLine();
			File consulta = new File(ruta);

			if (consulta.exists() && consulta.isDirectory()) {

				try {
					listarDirectorioRecursivo(ruta);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			} else {

				System.err.println("La ruta no existe.");
			}
		}

	}

	public static void listarDirectorioRecursivo(String ruta) throws FileNotFoundException {

		// C:\Users\Luisa Sans\Desktop\IT Academy

		File carpeta = new File(ruta);

		File[] directorio = carpeta.listFiles();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

		Arrays.sort(directorio);

		for (int i = 0; i < directorio.length; i++) {

			if (directorio[i].isDirectory()) {

				System.out.println("D:" + directorio[i].getName() + " "
						+ ("Última modificación: " + fecha.format(directorio[i].lastModified())));

				String ruta1 = directorio[i].getAbsolutePath();

				listarDirectorioRecursivo(ruta1);

			} else {

				System.out.println("F:" + directorio[i].getName() + " "
						+ ("Última modificación: " + fecha.format(directorio[i].lastModified())));
			}

		}

	}

}
