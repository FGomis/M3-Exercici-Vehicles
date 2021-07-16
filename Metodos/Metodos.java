package Metodos;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Clases.Coche;

public class Metodos {
	
	public static void crearVehiculo() {
//		Pedimos por pantalla matricula, marca y color y lo asignamos a variables
		String matricula = "";
//		Bucle para controlar el formato correcto de la matrícula
		do {
			 matricula = JOptionPane.showInputDialog("Indica la matrícula del vehiculo");
		} while (!isMatricula(matricula));
		
		String marca = JOptionPane.showInputDialog("Indica la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Indica el color del vehiculo");
		
//		Creamos un nuevo objecto coche
		Coche coche1 = new Coche(matricula, marca, color);
		
//		Pedimos por pantalla los datos de las ruedas delanteras y traseras y las añadimos al objeto coche
		String marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas delanteras");
		double diametro = 0;
		do {
			diametro = Double.parseDouble(JOptionPane.showInputDialog("Indica el diametro de las ruedas delanteras"));
		} while (!rangoDiametro(diametro));
		
		coche1.añadirRueda(marcaRueda, diametro, "delantera");
		
		marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas traseras");
		do {
			diametro = Double.parseDouble(JOptionPane.showInputDialog("Indica el diametro de las ruedas traseras"));
		} while (!rangoDiametro(diametro));
		coche1.añadirRueda(marcaRueda, diametro, "trasera");
//		Output de los datos del objeto coche
		JOptionPane.showMessageDialog(null, new JTextArea(coche1.toString()));
	}
	
//	Método para controlar el formato de la matrícula
	private static boolean isMatricula(String matricula) {
		if(matricula.matches("^\\d{4}[A-Z]{2,3}")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El formato de la matrícula introducida no es correcto, introducela de nuevo (ej. 1234XYZ / 1234YZ)");
			return false;
		}	
	}
	
	private static boolean rangoDiametro(double diametro) {
		if(diametro >= 0.4 && diametro <= 4) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El diámetro introducido no es correcto (debe estar entre 0.4 y 4)");
			return false;
		}
	}
	
}
