package n1_05Serializar;

import java.io.Serializable;

public class Fichero implements Serializable {

	private String nombre;
	private String tipo;
	private String fechaModificaci�n;

	public Fichero(String nombre, String tipo, String fechaModificaci�n) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaModificaci�n = fechaModificaci�n;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getFechaModificaci�n() {
		return fechaModificaci�n;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setFechaModificaci�n(String fechaModificaci�n) {
		this.fechaModificaci�n = fechaModificaci�n;
	}

	@Override
	public String toString() {
		return "Fichero [nombre=" + nombre + ", tipo=" + tipo + ", fechaModificaci�n=" + fechaModificaci�n + "]";
	}

}
