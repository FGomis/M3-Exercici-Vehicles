package Clases;

public class Titular extends Persona{
	
//	Atributos
	protected Licencia licencia;
	
	protected boolean seguro;
	
	protected boolean garaje;

//	Constructor principal
	public Titular(String id, String nombre, String apellidos, String fechaNacimiento, Licencia licencia, boolean seguro, boolean garaje) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.licencia = licencia;
		this.seguro = seguro;
		this.garaje = garaje;
	}




	@Override
	public String toString() {
		return " Titular\n"
				+ " Nombre: " + nombre + "\tApellidos: " + apellidos + "\tFecha de nacimiento: " + fechaNacimiento  + "\tDNI: " + id
				+ "\n Licencia: " + licencia.getTipo() + "\tSeguro: " + seguro + "\tGaraje: " + garaje;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public boolean isGaraje() {
		return garaje;
	}

	public void setGaraje(boolean garaje) {
		this.garaje = garaje;
	}
	
}
