package n1_05Serializar;

import java.io.Serializable;

public class Fichero implements Serializable {

	private String nombre;
	private String tipo;
	private String fechaModificación;

	public Fichero(String nombre, String tipo, String fechaModificación) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaModificación = fechaModificación;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getFechaModificación() {
		return fechaModificación;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setFechaModificación(String fechaModificación) {
		this.fechaModificación = fechaModificación;
	}

	@Override
	public String toString() {
		return "Fichero [nombre=" + nombre + ", tipo=" + tipo + ", fechaModificación=" + fechaModificación + "]";
	}

}
