package modelos;

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

	@Override
	public String toString() {
		String garaje = "";
		String seguro = "";

		if (hasGaraje) {
			garaje = ", tiene garaje";
		} else {
			garaje = ", no tiene garaje";
		}

		if (hasSeguro) {
			garaje = ", tiene seguro";
		} else {
			garaje = ", no tiene seguro";
		}

		// TODO Auto-generated method stub
		return "Titular de vehículo: " + super.toString() + "license=" + this.license.toString() + seguro + garaje;
	}

}
