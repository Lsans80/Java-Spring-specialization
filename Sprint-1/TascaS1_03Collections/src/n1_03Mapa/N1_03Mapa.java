package n1_03Mapa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals. 
 * El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. 
 * El programa demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, 
 * guardat en el HashMap. 
 * 
 * Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. 
 * Si l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. 
 * Un cop demanades les capitals de 10 països de forma aleatòria, 
 * llavors s’ha de guardar en un fitxer anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.*/

public class N1_03Mapa {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Map<String, String> countriesList = leerCountries();

		System.out.println("Hola!! Vamos a adivinar capitales!!\n");
		System.out.println("Dime tu nombre:");
		String nombre = teclado.nextLine();

		int puntuacion = 0;
		int vecesJugadas = 0;

		do {

			String countryRandom = countryRandom(countriesList);

			System.out.println("Dime la capital de " + countryRandom);
			String countryFound = teclado.nextLine();

			if (countryFound.equalsIgnoreCase(countriesList.get(countryRandom))) {

				System.out.println("Enhorabuena!! La capital de " + countryRandom + " es " + countryFound + ".");
				System.out.println("Has ganado un punto! :)");
				System.out.println("******************************\n");

				puntuacion++;
				vecesJugadas++;

			} else {

				System.out.println("Oh! Lo siento, no has acertado.");
				vecesJugadas++;
			}

		} while (vecesJugadas < 3);

		guardarPuntuacion(nombre, puntuacion);

	}

	private static Map<String, String> leerCountries() {

		Map<String, String> countriesList = new HashMap<>();
		// FileReader countries;
		BufferedReader lectura = null;

		try { 
																	
			FileReader countries = new FileReader("countries.txt");	// No poner ruta absoluta, si no el programa no será portable.											
			
			if (countries.ready()) {

				lectura = new BufferedReader(countries);
				String reading;

				while ((reading = lectura.readLine()) != null) {

					String[] splitPaises = reading.split(" ");// Descomponemos pais y capital para almacenarlo en Map.

					if (splitPaises.length == 2) {
						String pais = splitPaises[0].trim();// Quitamos espacios del String.
						String capital = splitPaises[1].trim();
						countriesList.put(pais, capital);

					}

				}

				// Otra forma de almacenar la informacion en la colección: Map<String, String>
				// countriesList.

				/*
				 * for (Map.Entry<String, String> entry : countriesList.entrySet()) { String key
				 * = entry.getKey(); String val = entry.getValue(); System.out.print(key + " ");
				 * System.out.println(val); }
				 */

				

			} else {

				System.err.println("El fichero no está disponible.");
			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
			
		} finally {
			
			try {
				
				lectura.close();//Siempre cerrar recursos. Buena práctica.
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		return countriesList;

	}

	private static String countryRandom(Map<String, String> countriesList) {

		Random random = new Random();
		int numRandom = random.nextInt(countriesList.size());
		String countryRandom = (String) countriesList.keySet().toArray()[numRandom];

		return countryRandom;
	}

	private static void guardarPuntuacion(String nombre, int puntuacion) {

		try (FileWriter clasificacion = new FileWriter("clasificacion.txt", true)) {

			clasificacion.write(nombre + " - Puntuación = " + puntuacion + "\n");
			System.out.println("Puntuación guardada.");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
