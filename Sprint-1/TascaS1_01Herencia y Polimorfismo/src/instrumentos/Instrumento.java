package instrumentos;

public abstract class Instrumento {
	protected String nombre;
	protected float precio;

	public Instrumento(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	{

		System.out.println("Bloque de inicialización."); //lo llama en cada constructor.
	}
	
	static {

		System.out.println("Bloque estático.");
	}

	public static void metodoEstatico() {
		
		System.out.println("Soy un método estático.");
	}

	public abstract void tocar();

	@Override
	public String toString() {
		return "Instrumento [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
