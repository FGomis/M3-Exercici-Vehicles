package modelsPersona;

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
	
	//los getters y setters,
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return " [nombre=" + this.name + "apellidos=" + this.surname + ", fecha de nacimiento=" + this.dateOfBirth
				+ "]";
	}
	
/*	public static void pedirNombre() {
		System.out.println("Diga nombre  ");
	}
	
	public static void pedirApellidos() {
		System.out.println("Diga apellidos  ");
	}
	
	public static void pedirFechaNacimiento() {
		System.out.println("Diga la fecha de nacimiento ");
	}*/

}
