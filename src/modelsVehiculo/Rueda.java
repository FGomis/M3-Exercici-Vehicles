package modelsVehiculo;

public class Rueda {

	// atributos,
	protected String tipoRueda;
	protected String marca;
	protected double diametro;

	// constructor con atributos,
	public Rueda(String tipoRueda, String marca, double diametro) {

		this.tipoRueda = tipoRueda;
		this.marca = marca;
		this.diametro = diametro;

	}

	@Override
	public String toString() {
		return "Rueda: " + tipoRueda + ", marca=" + marca + ", diametro=" + diametro;
	}

	// métodos para pedir datos sobre ruedas,
	// método para pedir la marca de ruedas,
	protected static void pedirMarcaRueda(String tipoRuedas) {
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("RUEDAS " + tipoRuedas + ". Introduce su marca.");
	}

	// método para pedir el diametro de ruedas,
	protected static void pedirDiametroRueda(String tipoRuedas) {
		System.out.println("RUEDAS " + tipoRuedas + ". Introduce su diametro. ");
	}

	// método para controlar el diámetro de ruedas,
	protected static boolean isDiametroCorrecto(double diametroRueda) {

		if ((diametroRueda <= 0.4) || (diametroRueda >= 4)) {
			return false;
		} else {
			return true;
		}
	}
}
