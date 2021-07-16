package Metodos;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Clases.Coche;

public class Metodos {
	
	public static void crearVehiculo() {
		String matricula = JOptionPane.showInputDialog("Indica la matrícula del vehiculo");
		String marca = JOptionPane.showInputDialog("Indica la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Indica el color del vehiculo");
		
		Coche coche1 = new Coche(matricula, marca, color);
		
		String marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas delanteras");
		String diametro = JOptionPane.showInputDialog("Indica el diametro de las ruedas delanteras");
		coche1.añadirRueda(marcaRueda, diametro, "delantera");
		marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas traseras");
		diametro = JOptionPane.showInputDialog("Indica el diametro de las ruedas traseras");
		coche1.añadirRueda(marcaRueda, diametro, "trasera");
		JOptionPane.showMessageDialog(null, new JTextArea(coche1.toString()));
	}
	
}
