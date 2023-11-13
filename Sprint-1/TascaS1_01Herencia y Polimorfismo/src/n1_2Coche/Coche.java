package n1_2Coche;

public class Coche {
	private static final String MARCA = "Renault";// Todos los objetos tendrán la misma marca y no se puede modificar.
	private static String modelo = "Confort";// Si se modifica lo hará en todos los objetos.
	private final int POTENCIA = 190;// No se puede modificar.

	public static String getMarca() {
		return MARCA;
	}

	public static String getModelo() {
		return modelo;
	}

	public int getPOTENCIA() {
		return POTENCIA;
	}

	public static void setModelo(String modelo) {
		Coche.modelo = modelo;
	}

	public static void frenar() {

		System.out.println("El coche está frenando.");
	}

	public void acelerar() {

		System.out.println("El coche está acelerando.");
	}

	@Override
	public String toString() {
		return "Coche [marca=" + MARCA + ", modelo=" + modelo + ", POTENCIA=" + POTENCIA + "]";
	}

}
