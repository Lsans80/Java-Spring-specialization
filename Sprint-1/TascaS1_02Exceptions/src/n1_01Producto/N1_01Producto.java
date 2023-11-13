package n1_01Producto;

/*Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra classe anomenada "Venda". 
 * Aquesta classe té com a atributs una col·lecció de productes i el preu total de la venda.

La classe "Venda", té un mètode anomenat calcularTotal() que llança l’excepció personalitzada VendaBuidaException 
i mostra per pantalla “Per fer una venda primer has d’afegir productes” si la col·lecció de productes està buida. 
Si la col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la suma de tots els preus dels productes 
a l’atribut preu total de la venda.

L’excepció personalitzada VendaBuidaException ha de ser filla de la classe Exception. 

Al seu constructor li hem de passar el missatge  “Per fer una venda primer has d’afegir productes” 
i quan capturem l’excepció, l’hem de mostrar per pantalla amb el mètode getMessage() de l’excepció.

Escriu el codi necessari per a generar i capturar una excepció de tipus ArrayIndexOutOfBoundsException.*/

import java.util.ArrayList;

public class N1_01Producto {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		Producto perfume = new Producto("Gucci", 56.90f);
		Producto crema = new Producto("Garnier", 19.67f);
		Producto aceite = new Producto("Chanel", 78.89f);

		productos.add(perfume);
		productos.add(crema);
		productos.add(aceite);

		Venta venta = new Venta(productos, 0.0f);

		venta.agregarProducto(perfume);
		venta.agregarProducto(crema);
		venta.agregarProducto(aceite);

		// Exception personalizada.

		try {

			System.out.println("Lista de productos a la venta: ");

			for (Producto producto : productos) {
				System.out.println(producto);
			}

			System.out.print("El precio total de los productos a la venta es de: ");

			venta.calcularTotal();

		} catch (VentaVaciaException e) {
			System.err.println(e.getMessage());
		}

		// ArrayIndexOutOfBoundsException.

		try {

			System.out.println(productos.get(3));

		} catch (IndexOutOfBoundsException e) {
			System.out.println("El producto que buscas no está en nuestra lista");

		}

	}

}
