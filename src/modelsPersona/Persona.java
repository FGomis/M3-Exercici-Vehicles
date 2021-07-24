package modelsPersona;

import javax.swing.JOptionPane;

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
		return this.name + " " + this.surname + ", nacido en " + this.dateOfBirth;
	}
	
	public String datosMin() {
		return this.toString();
	}
	
	//métodos para pedir información sobre persona,
	public static String pedirNombre() {
		
		return JOptionPane.showInputDialog(
				"Escribe el nombre ");
	}
	
	public static String pedirApellidos() {
	
		return JOptionPane.showInputDialog(
				"Escribe el apellidos ");
	}
	
	public static String pedirFechaNacimiento() {
	
		return JOptionPane.showInputDialog(
				"Escribe el fecha de nacimiento ");
	}

}
