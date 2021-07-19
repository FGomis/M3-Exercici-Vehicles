package modelos;

public class Persona {

	// atributos,
	protected String name;
	protected String surname;
	protected String dateOfBirth;

	// constructores,

	// por defecto,
	public Persona() {

		this.name = "";
		this.surname = "";
		this.dateOfBirth = "";
	}

	// con dos parametros: nombre y fecha de nacimiento,
	public Persona(String name, String surname, String dateOfBirth) {

		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return " [nombre=" + this.name + "apellidos=" + this.surname + ", fecha de nacimiento=" + this.dateOfBirth
				+ "]";
	}

}
