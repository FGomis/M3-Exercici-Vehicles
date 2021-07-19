package modelos;

import java.util.Scanner;

abstract class Vehiculo {

	static Scanner teclado = new Scanner(System.in);
	// atributos,
	protected String matricula;
	protected String marca;
	protected String color;
	protected Rueda ruedas[];

	// constructores,
	// por defecto,
	public Vehiculo() {
		this.matricula = "";
		this.marca = "";
		this.color = "";
		this.ruedas = new Rueda[1];
	}

	// constructor con valores,
	public Vehiculo(String matricula, String marca, String color) {

		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.ruedas = new Rueda[1];
	}

	// métodos,

	//para añadir ruedas,
	abstract void addRuedas(String tipoRueda, String marca, double diametro);
	
	//para mostrar datos de ruedas,
	abstract void showRuedas();

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", color=" + color + "]";
	}
	
	// métodos para pedir datos sobre vehículo,
	// pide matrícula de vehículo,
		private static void pedirMatricula(String tipoVehiculo) {
			System.out.println("Introduce la matrícula de su " + tipoVehiculo);
		}

		// pide marca de vehículo,
		private static void pedirMarca(String tipoVehiculo) {
			System.out.println("Introduce la marca de su " + tipoVehiculo);
		}

		// pide color de vehículo,
		private static void pedirColor(String tipoVehiculo) {
			System.out.println("Introduce el color de su " + tipoVehiculo);

		}

		// get value de teclado de tipo String,
		private static String getValorTeclado() {
			return teclado.next();
		}

		// devuelve datos de vehículo pedido a usuario en forma de un array,
		protected static String[] getDatosVehiculo(String tipoVehiculo) {
			String[] datosVehiculo = new String[3];

			// pedimos al usuario la matrícula de coche,
			// y hacemos su comprobación que es correcta:
			// o sea tiene 4 números y 2/3 letras,
			do {
				pedirMatricula(tipoVehiculo);
				datosVehiculo[0] = getValorTeclado();
			} while (!isMatchMatricula(datosVehiculo[0]));

			// pedimos al usuario la marca de coche,
			pedirMarca(tipoVehiculo);
			datosVehiculo[1] = getValorTeclado();

			// pedimos al usuario el color de coche,
			pedirColor(tipoVehiculo);
			datosVehiculo[2] = getValorTeclado();

			return datosVehiculo;
		}

		// comprobación de matrícula,
		private static boolean isMatchMatricula(String matricula) {

			String pattern = "(\\d{4}[a-zA-Z]{2,3})";
			return matricula.matches(pattern);
		}

}
