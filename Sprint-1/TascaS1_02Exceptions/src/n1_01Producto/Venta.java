package n1_01Producto;

import java.util.ArrayList;

public class Venta {
	private float precioTotalVenta;
	private ArrayList<Producto> productos;

	public Venta(ArrayList<Producto> productos, float precioTotalVenta) {

		this.productos = new ArrayList<Producto>();
		this.precioTotalVenta = precioTotalVenta;
	}

	public float getPrecioTotalVenta() {
		return precioTotalVenta;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	// Generamos una Exception personalizada VentaVaciaException por si el ArrayList
	// productos está vacio.

	public void calcularTotal() throws VentaVaciaException {

		if (productos.isEmpty()) {
			throw new VentaVaciaException("Para hacer una venta primero debes añadir productos.");

		} else {
			precioTotalVenta = 0.0f;

			for (Producto producto : productos) {
				precioTotalVenta += producto.getPrecio();

			}

			System.out.println(precioTotalVenta);
		}
	}

}
