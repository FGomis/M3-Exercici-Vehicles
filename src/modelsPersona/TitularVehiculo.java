package modelsPersona;

public class TitularVehiculo extends Persona {

	// atributos,
	protected Licencia license;
	protected boolean hasSeguro;
	protected boolean hasGaraje;

	final protected boolean SEGURO = true;
	final protected boolean GARAJE = true;

	// constructores,

	// por defecto,
	public TitularVehiculo() {
		super();
		this.license = new Licencia();
		this.hasSeguro = this.SEGURO;
		this.hasGaraje = this.GARAJE;

	}

	// con 4 parámetros: nombre
	public TitularVehiculo(String name, String surname, String dateOfBirth, Licencia license, boolean hasSeguro,
			boolean hasGaraje) {
		super(name, surname, dateOfBirth);
		this.license = license;
		this.hasSeguro = hasSeguro;
		this.hasGaraje = hasGaraje;
	}

	public Licencia getLicense() {
		return this.license;
	}

	@Override
	public String toString() {
		String seguro = "";
		String garaje = "";

		if (hasSeguro) {
			seguro = ", tiene seguro";
		} else {
			seguro = ", no tiene seguro";
		}

		if (hasGaraje) {
			garaje = ", tiene garaje";
		} else {
			garaje = ", no tiene garaje";
		}

		
		return "Titular de vehículo: " + super.toString() + ", tiene " + this.license.toString() + seguro + garaje;
	}
	
	//para el menu donde asignas titulares a un vehículo,
	//para que no se muestra toda la información,
	
	public String datosMin() {
		return "Titular de vehículo: " + super.toString();
	}

}
