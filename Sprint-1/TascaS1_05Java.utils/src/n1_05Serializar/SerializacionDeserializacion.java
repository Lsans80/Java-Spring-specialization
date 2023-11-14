package n1_05Serializar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class SerializacionDeserializacion {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		if (args.length == 0) {// Si NO le proporcionamos nada en la línea de comandos nos preguntará la ruta.

			System.out.println("Dime la ruta del directorio que quieres consultar:");
			String ruta = teclado.nextLine();

			File consulta = new File(ruta);

			if (consulta.exists() && consulta.isDirectory()) {

				listarDirectorioRecursivo(ruta);
				System.out.println("El fichero.txt se ha creado.");

			} else {
				System.err.println("La ruta no existe.");
			}

			// Serialización / Deserialización.
			// Creamos un objeto Fichero para hacer la serialización y deserialización.

			Fichero fichero = new Fichero("fichero", "F", "01/10/2023 16:15");

			serializar(fichero);

			deserializar();

		}
	}

	public static void serializar(Fichero fichero) {

		// Creamos el flujo de salida de datos con ObjectOutputStream.

		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ficheroSerializado.ser"))) {
			outputStream.writeObject(fichero);
			System.out.println("Objecto serializado.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deserializar() {

		// Creamos el flujo de entrada de datos con ObjectInputStream.

		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ficheroSerializado.ser"))) {
			Fichero ficheroDeserializado = (Fichero) inputStream.readObject();
			System.out.println("Objecto deserializado: " + ficheroDeserializado);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
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
