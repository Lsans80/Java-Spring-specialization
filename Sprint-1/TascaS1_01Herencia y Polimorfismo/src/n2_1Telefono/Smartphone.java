package n2_1Telefono;

public class Smartphone extends Telefono implements Camara, Reloj{

	public Smartphone(String marca, String modelo) {
		super(marca, modelo);
		
	}

	@Override
	public void llamar(String numero) {

		System.out.println("Se esta llamando al número " + numero + ".");
		
	}

	@Override
	public void alarma() {
		System.out.println("Esta sonando la alarma.");
		
	}

	@Override
	public void fotografiar() {
		System.out.println("Se esta haciendo una foto.");
		
	}
	
	

}
