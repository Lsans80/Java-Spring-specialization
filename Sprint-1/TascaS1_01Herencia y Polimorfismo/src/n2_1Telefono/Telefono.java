package n2_1Telefono;

public abstract class Telefono {
	private String marca;
	private String modelo;

	public Telefono(String marca, String modelo) {

		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public abstract void llamar (String numero);

	@Override
	public String toString() {
		return "Telefono [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	
		
	

}
