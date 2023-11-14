package n1_02LetraDNI;

/*Crea una classe anomenada CalculoDni que calculi la lletra del DNI en rebre el número com a paràmetre.
 
Crea una classe jUnit que verifiqui el seu correcte funcionament, 
parametritzant-la perquè el test rebi un espectre de dades ampli i validi 
si el càlcul és correcte per a 10 números de DNI predefinits.*/

public class CalculoDni {

	public static String calcularLetraDni(int numeroDni) {

		char letraDniCorrecta = ' ';

		if (numeroDni < 0 || numeroDni > 99999999) {
			System.out.println("El numero no és válido.");
		} else {

			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int letraDni = numeroDni % 23;
			letraDniCorrecta = letras.charAt(letraDni);
		}
		
		String dni = "" + numeroDni + letraDniCorrecta;
		
		return dni;
		
		//Otra opción para devolver int + char:
		
			//return String.format("%d%c", numeroDni, letraDniCorrecta);
	}

}
