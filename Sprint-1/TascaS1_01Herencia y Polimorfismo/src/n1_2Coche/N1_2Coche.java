package n1_2Coche;

public class N1_2Coche {

	public static void main(String[] args) {

		Coche coche1 = new Coche();
		Coche coche2 = new Coche();
		Coche coche3 = new Coche();

		System.out.println(coche1.toString());
		System.out.println(coche2.toString());
		System.out.println(coche3.toString());

		Coche.setModelo("Dinamique");// Se cambia el modelo en todos los objetos.

		System.out.println(coche1.toString());
		System.out.println(coche2.toString());
		System.out.println(coche3.toString());
		
		coche1.acelerar();//M�todo asociado al objeto.
		Coche.frenar();//M�todo est�tico, m�todo asociado a la clase.

	}

}
