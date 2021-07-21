package Clases;

public class Conductor extends Persona{
	
//	Atributos
	protected Licencia licencia;

	public Conductor(String id, String nombre, String apellidos, String fechaNacimiento, Licencia licencia) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.licencia = licencia;
	}
	
	public Licencia getLicencia() {
		return licencia;
	}
	
	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}
	
	@Override
	public String toString() {
		return " Titular\n"
				+ " Nombre: " + nombre + "\tApellidos: " + apellidos + "\tFecha de nacimiento: " + fechaNacimiento  + "\tDNI: " + id
				+ "\n Licencia: " + licencia.getTipo();
	}
	
	
}
