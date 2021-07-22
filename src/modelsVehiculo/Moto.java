package modelsVehiculo;

public class Moto extends Vehiculo {

	// atributos,
	//protected Rueda ruedas[] = new Rueda[2];
	final protected String TIPOLICENCIA = "A";

	
	// constructores,
	public Moto() {
		super();
		this.ruedas = new Rueda[2];
	}

	// con todos atributos,
	public Moto(String matricula, String marca, String color) {
		super(matricula, marca, color);
		this.ruedas = new Rueda[2];
	}

	// métodos,
	//para añadir ruedas,
	@Override
	public void addRuedas(String tipoRueda, String marca, double diametro) {

		if (tipoRueda.equalsIgnoreCase("DELANTERAS")) {
			Rueda ruedaDelantera1 = new Rueda(tipoRueda, marca, diametro);

			this.ruedas[0] = ruedaDelantera1;

		} else {
			Rueda ruedaTrasera1 = new Rueda(tipoRueda, marca, diametro);

			this.ruedas[1] = ruedaTrasera1;

		}
	}

	@Override
	public String toString() {
		return "Moto [matricula=" + matricula + ", marca=" + marca + ", color=" + color + "]";
	}

}
