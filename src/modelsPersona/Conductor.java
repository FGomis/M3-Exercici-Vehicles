package modelsPersona;

public class Conductor extends Persona {

	// atributos,
	protected Licencia license;

	// constructores,

	// por defecto,
	public Conductor() {
		super();
		this.license = new Licencia();

	}

	// con tres parametros: nombre, fecha de nacimiento y licencia de conducir,
	public Conductor(String name, String surname, String dateOfBirth, Licencia license) {
		super(name, surname, dateOfBirth);
		this.license = license;
	}
	
	public Licencia getLicense() {
		return this.license;
	}


	@Override
	public String toString() {
		
		return "Conductor: " + super.toString() + ", " + this.license.toString();
	}			
	
	//para el menu donde asignas conductores a un vehículo,
	//para que no se muestra toda la información
	public String datosMin() {
		return "Conductor: " + super.toString();
	}
}
