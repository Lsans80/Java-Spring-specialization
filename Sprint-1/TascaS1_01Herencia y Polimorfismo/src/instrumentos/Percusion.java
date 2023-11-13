package instrumentos;

public class Percusion extends Instrumento {

	public Percusion(String nombre, float precio) {
		super(nombre, precio);

	}

	@Override
	public void tocar() {
		System.out.println("Est� sonando un instrumento de percusi�n");

	}

	@Override
	public String toString() {
		return "Percusion [nombre=" + nombre + ", precio=" + precio + "]";
	}
}
