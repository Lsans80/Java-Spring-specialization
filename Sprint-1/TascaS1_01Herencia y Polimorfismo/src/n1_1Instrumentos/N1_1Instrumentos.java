package n1_1Instrumentos;

import instrumentos.Cuerda;
import instrumentos.Percusion;
import instrumentos.Viento;

public class N1_1Instrumentos {

	public static void main(String[] args) {

		Viento flauta = new Viento("Yamaha", 35.50f);
		Cuerda guitarra = new Cuerda("Fender", 90.67f);
		Percusion bateria = new Percusion("Alhambra", 500.98f);

		System.out.println(flauta.toString());
		System.out.println(guitarra.toString());
		System.out.println(bateria.toString());

		flauta.metodoEstatico();

		flauta.tocar();
		guitarra.tocar();
		bateria.tocar();

	}

}
