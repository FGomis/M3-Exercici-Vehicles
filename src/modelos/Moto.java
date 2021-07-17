package modelos;

public class Moto extends Vehiculo {

	// atributos,
	//protected Rueda ruedas[] = new Rueda[2];

	
	// constructores,
	public Moto() {
		super();
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

	// método para mostrar datos de ruedas,
	public void showRuedas() {
		for (int i = 0; i < ruedas.length; i++) {
			System.out.println(ruedas[i]);
		}
	}

	@Override
	public String toString() {
		return "Moto [matricula=" + matricula + ", marca=" + marca + ", color=" + color + "]";
	}

}
