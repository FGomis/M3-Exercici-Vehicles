package modelos;

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Conductor: " + super.toString() + "license=" + this.license.toString();
	}

}
