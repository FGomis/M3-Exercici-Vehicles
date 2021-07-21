package Clases;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Licencia {

//	Constantes
	private static final AtomicInteger contador = new AtomicInteger(0);
	
//	Atributos
	protected int id;
	
	protected String tipo;
	
	protected String nombre;
	
	protected Date fechacaducidad;

	public Licencia(String tipo, String nombre, Date fechacaducidad) {
		this.id = contador.incrementAndGet();
		this.tipo = tipo;
		this.nombre = nombre;
		this.fechacaducidad = fechacaducidad;
	}

	@Override
	public String toString() {
		return "Licencia [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", fechacaducidad=" + fechacaducidad
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechacaducidad() {
		return fechacaducidad;
	}

	public void setFechacaducidad(Date fechacaducidad) {
		this.fechacaducidad = fechacaducidad;
	}
	
	
}
