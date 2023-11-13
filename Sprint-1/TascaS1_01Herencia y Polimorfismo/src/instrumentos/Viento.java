package instrumentos;

public class Viento extends Instrumento {

	public Viento(String nombre, float precio) {
		super(nombre, precio);
	}
		
	@Override
	public void tocar() {
		System.out.println("Está sonando un instrumento de viento");
		
	}

	@Override
	public String toString() {
		return "Viento [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
