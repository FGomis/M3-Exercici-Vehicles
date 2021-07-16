package Metodos;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Clases.*;

public class Metodos {
	
	public static void seleccionVehiculo() {
		String[] botones = {"Coche", "Moto"};
		int seleccion = JOptionPane.showOptionDialog(null, "Selecciona un vehiculo a generar", "Vehiculos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		switch (seleccion) {
		case 0:
			crearVehiculo("coche");
			break;
			
		case 1:
			crearVehiculo("moto");
			break;

		}
	}
	
	public static void crearVehiculo(String vehiculo) {
//		Pedimos por pantalla matricula, marca y color y lo asignamos a variables
		String matricula = "";	
//		Bucle para controlar el formato correcto de la matrícula
		do {
			 matricula = JOptionPane.showInputDialog("Indica la matrícula del vehiculo");
		} while (!isMatricula(matricula));
		
		String marca = JOptionPane.showInputDialog("Indica la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Indica el color del vehiculo");
		switch (vehiculo) {
		case "coche":
			Coche coche = new Coche(matricula, marca, color);
			crearRuedas(coche);
			break;
			
		case "moto":
			Moto moto = new Moto(matricula, marca, color);
			crearRuedas(moto);
			break;
		}
			
	}

	
	private static void crearRuedas(Vehiculo vehiculo) {
//		Pedimos por pantalla los datos de las ruedas delanteras y traseras y las añadimos al objeto coche
		String marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas delanteras");
		double diametro = 0;
		do {
			diametro = Double.parseDouble(JOptionPane.showInputDialog("Indica el diametro de las ruedas delanteras"));
		} while (!rangoDiametro(diametro));
		
		vehiculo.añadirRueda(marcaRueda, diametro, "delantera");
		
		marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas traseras");
		do {
			diametro = Double.parseDouble(JOptionPane.showInputDialog("Indica el diametro de las ruedas traseras"));
		} while (!rangoDiametro(diametro));
		vehiculo.añadirRueda(marcaRueda, diametro, "trasera");
//		Output de los datos del objeto coche
		JOptionPane.showMessageDialog(null, new JTextArea(vehiculo.toString()));
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
