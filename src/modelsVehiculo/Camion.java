package modelsVehiculo;

public class Camion extends Vehiculo {

	// atributos,
	final protected String TIPOLICENCIA = "C";

	// constructores,
	// por defecto,
	public Camion() {
		super();
		this.ruedas = new Rueda[8];
	}

	// con todos atributos,
	public Camion(String matricula, String marca, String color) {
		super(matricula, marca, color);
		this.ruedas = new Rueda[8];
	}

	//para añadir ruedas,
	@Override
	public void addRuedas(String tipoRueda, String marca, double diametro) {

		if (tipoRueda.equalsIgnoreCase("delantera")) {
			Rueda ruedaDelantera1 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaDelantera2 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaDelantera3 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaDelantera4 = new Rueda(tipoRueda, marca, diametro);
			this.ruedas[0] = ruedaDelantera1;
			this.ruedas[1] = ruedaDelantera2;
			this.ruedas[2] = ruedaDelantera3;
			this.ruedas[3] = ruedaDelantera4;
		} else {
			Rueda ruedaTrasera1 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaTrasera2 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaTrasera3 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaTrasera4 = new Rueda(tipoRueda, marca, diametro);
			this.ruedas[4] = ruedaTrasera1;
			this.ruedas[5] = ruedaTrasera2;
			this.ruedas[6] = ruedaTrasera3;
			this.ruedas[7] = ruedaTrasera4;
		}
	}

	@Override
	public String toString() {
		return "Camion " + super.toString();
	}
	
	public String datosMin() {
		return "Camion " + super.datosMin();
	}

}
