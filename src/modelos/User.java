package modelos;

import java.util.Scanner;

public class User {

	// atributos;
	Scanner teclado = new Scanner(System.in);

	protected String[] tipoVehiculo = { "coche", "moto" };
	protected String[] tipoRueda = { "DELANTERAS", "TRASERAS" };

	protected String marcaRuedaDelantera;
	protected String marcaRuedaTrasera;

	protected double diametroRuedaDelantera;
	protected double diametroRuedaTrasera;

	protected String[] datosVehiculo;

	// métodos,

	// método que pide al usuario que tipo de vehículo quiere crear
	// y con esa información llama función que ,
	public void vehiculo() {
		String option;

		System.out.println(
				"Que tipo de vehículo quieres crear: \n1. " + this.tipoVehiculo[0] + "\n2. " + this.tipoVehiculo[1]);
		option = teclado.next();

		switch (option) {
		case "1":
			this.crearVehiculo(this.tipoVehiculo[0]);

			break;
		case "2":
			this.crearVehiculo(this.tipoVehiculo[1]);
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

		if (tipoVehiculo.equalsIgnoreCase("coche")) {

								// matrícula,           marca,                 color,
			vehiculo = new Coche(this.datosVehiculo[0], this.datosVehiculo[1], this.datosVehiculo[2]);
		} else {
			vehiculo = new Moto(this.datosVehiculo[0], this.datosVehiculo[1], this.datosVehiculo[2]);
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
