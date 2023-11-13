package instrumentos;

public class Cuerda extends Instrumento {

	public Cuerda(String nombre, float precio) {
		super(nombre, precio);

	}

	@Override
	public void tocar() {
		System.out.println("Está sonando un instrumento de cuerda");

	}

	@Override
	public String toString() {
		return "Cuerda [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
