package modelos;

import java.util.Scanner;

public class User {

	// atributos;
	Scanner teclado = new Scanner(System.in);

	protected String[] tipoVehiculo = { "coche", "moto", "camion" };
	protected String[] tipoRueda = { "DELANTERAS", "TRASERAS" };

	protected String marcaRuedaDelantera;
	protected String marcaRuedaTrasera;

	protected double diametroRuedaDelantera;
	protected double diametroRuedaTrasera;

	protected String[] datosVehiculo;
	

	// métodos,

	public void titular() {
		Licencia licenciaA = new Licencia(1, 'A', "Coche", "31/01/2023");
		
		TitularVehiculo titular1 = new TitularVehiculo("Greg Larson", "Larson", "15/09/1956", licenciaA, true, false);
	}
	
	
	
	// método que pide al usuario que tipo de vehículo quiere crear
	// y con esa información llama función que ,
	public void vehiculo() {
		String option;

		System.out.println(
				"Que tipo de vehículo quieres crear: \n1. " + this.tipoVehiculo[0] + "\n2. " + this.tipoVehiculo[1]
						+ "\n3. " + this.tipoVehiculo[2]);
		option = teclado.next();

		switch (option) {
		case "1":
			this.crearVehiculo(this.tipoVehiculo[0]);

			break;
		case "2":
			this.crearVehiculo(this.tipoVehiculo[1]);
			break;
		case "3":
			this.crearVehiculo(this.tipoVehiculo[2]);
			break;

		default:
			System.out.println("La opción no existe. Intenta más tarde.");
			break;
		}
	}

	// el método que que pide datos al usuario sobre vehículo y ruedas que quiere
	// crear,
	// crea el objeto coche o moto y ejecuta función para añadir ruedas,
	public void crearVehiculo(String tipoVehiculo) {

		this.datosVehiculo = Vehiculo.getDatosVehiculo(tipoVehiculo);

		Vehiculo vehiculo;
		
		switch (tipoVehiculo) {
		case "moto":
			// matrícula,           marca,                 color,
			vehiculo = new Moto(this.datosVehiculo[0], this.datosVehiculo[1], this.datosVehiculo[2]);
			break;
		case "camion":
			vehiculo = new Camion(this.datosVehiculo[0], this.datosVehiculo[1], this.datosVehiculo[2]);
			break;

		default:
			//coche,
			vehiculo = new Coche(this.datosVehiculo[0], this.datosVehiculo[1], this.datosVehiculo[2]);
			break;
		}

		System.out.println(vehiculo.toString());

		this.addRuedas(vehiculo, this.tipoRueda[0]);

		this.addRuedas(vehiculo, this.tipoRueda[1]);

		vehiculo.showRuedas();
	}

	// método que pide datos sobre ruedas, hace comprobación del
	// diámetro y las añade,
	public void addRuedas(Vehiculo vehiculo, String tipoRueda) {
		String marcaRueda;
		double diametroRueda;

		Rueda.pedirMarcaRueda(tipoRueda);
		marcaRueda = this.getValorTeclado();

		do {
			Rueda.pedirDiametroRueda(tipoRueda);
			diametroRueda = Double.parseDouble(getValorTeclado());

		} while (!Rueda.isDiametroCorrecto(diametroRueda));

		vehiculo.addRuedas(tipoRueda, marcaRueda, diametroRueda);
	}

	// get value de teclado de tipo String,
	private String getValorTeclado() {
		return teclado.next();
	}
}
