package n1_01Producto;

public class Producto {
	private String nombre;
	private float precio;

	public Producto(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	// Se puede cambiar precio pero NO el nombre del producto. He supuesto que no se
	// cambia el nombre de un producto.

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}

}
