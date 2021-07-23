package modelsVehiculo;

import javax.swing.JOptionPane;

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
		return tipoRueda + ": marca=" + marca + ", diametro=" + diametro;
	}

	// métodos para pedir datos sobre ruedas,
	// método para pedir la marca de ruedas,
	protected static String pedirMarcaRueda(String tipoRuedas) {
	
		return JOptionPane.showInputDialog("Introduce la marca de rueda "  + tipoRuedas );
	}

	// método para pedir el diametro de ruedas,
	protected static String pedirDiametroRueda(String tipoRuedas) {
		return JOptionPane.showInputDialog("Introduce el diametro de rueda "+ tipoRuedas);
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
