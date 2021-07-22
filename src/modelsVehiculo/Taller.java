package modelsVehiculo;

import java.util.Scanner;

import modelsPersona.*;

public class Taller {

	// atributos;
	Scanner teclado = new Scanner(System.in);

	protected String[] arrayTiposVehiculo = { "coche", "moto", "camion" };
	protected String[] arrayTiposRueda = { "DELANTERAS", "TRASERAS" };

	protected String marcaRuedaDelantera;
	protected String marcaRuedaTrasera;

	protected double diametroRuedaDelantera;
	protected double diametroRuedaTrasera;

	protected String[] arrayDatosVehiculo;
	protected Vehiculo vehiculo;

	// métodos,

	// método principal donde se ejecuta todo el programa,
	public void runTaller() {
		String vehiculo;
		String conductor;
		Conductor conductor1;

		Licencia licenciaMoto = new Licencia(Licencia.numTotalLicencias, "A", "moto", "31/01/2023");
		TitularVehiculo titular1 = new TitularVehiculo("Egor", "Letov", "12/04/1965", licenciaMoto, true, false);
		
		Licencia licenciaCoche = new Licencia(Licencia.numTotalLicencias, "B", "coche", "01/10/2025");
		Licencia licenciaCamion = new Licencia(Licencia.numTotalLicencias, "C", "camion", "20/06/2033");
		
		System.out.println("Que tipo de vehículo quieres crear: \n1. " + this.arrayTiposVehiculo[0] + "\n2. "
				+ this.arrayTiposVehiculo[1] + "\n3. " + this.arrayTiposVehiculo[2]);
		vehiculo = teclado.next();

		// check licencia de conductor,
		try {

			//creamos un objeto de uno de los tipos de vehículo
			this.vehiculo = this.crearVehiculo(vehiculo, titular1.getLicense());

			System.out.println(this.vehiculo.toString());

			//añadimos ruedas,
			this.addRuedas(this.vehiculo, this.arrayTiposRueda[0]);

			this.addRuedas(this.vehiculo, this.arrayTiposRueda[1]);

			this.vehiculo.showRuedas();

			//preguntamos si Titular es Conductor de vehículo,
			System.out.println("El titular de " + arrayTiposVehiculo[Integer.parseInt(vehiculo) - 1]
					+ " será el conductor? \n1. Sí" + "\n2. No");

			conductor = teclado.next();
			
			if (conductor.equalsIgnoreCase("2")) {
				conductor1 = new Conductor("Inga", "Belova", "31/12/1999", licenciaCoche);
				
				this.checkLicenceConductor(conductor1.getLicense(), vehiculo);
			}

			
		} catch (Exception e) {
			System.out.println("Licencia del Titular no corresponde al tipo de vehículo");
		}

	}

	// devuelve un Objeto del tipo de Vehículo elegido por Usuario si,
	// su licencia coincide con el tipo de vehículo,

	public Vehiculo crearVehiculo(String tipoVehiculo, Licencia licencia) throws Exception {
		String vehiculoName = "";

		// hacemos comprobación si tipo de licencia del Titular de vehículo corresponde,
		// al tipo de vehículo elegido,
		// si no mostamos una exception,
		if (licencia.getTipoDeLicencia().equalsIgnoreCase(this.getTipoLicence(tipoVehiculo))) {
			vehiculoName = this.arrayTiposVehiculo[Integer.parseInt(tipoVehiculo) - 1];
		} else {
			throw new Exception();
		}

		Vehiculo vehiculo;

		// pedimos datos del vehículo,
		this.arrayDatosVehiculo = Vehiculo.getDatosVehiculo(vehiculoName);

		// según el tipo de vehículo creamos un objeto de ese tipo,
		switch (tipoVehiculo) {
		// moto,
		case "2":
			// matrícula, marca, color,
			vehiculo = new Moto(this.arrayDatosVehiculo[0], this.arrayDatosVehiculo[1], this.arrayDatosVehiculo[2]);
			break;
		// camion
		case "3":
			vehiculo = new Camion(this.arrayDatosVehiculo[0], this.arrayDatosVehiculo[1], this.arrayDatosVehiculo[2]);
			break;

		default:
			// coche,
			vehiculo = new Coche(this.arrayDatosVehiculo[0], this.arrayDatosVehiculo[1], this.arrayDatosVehiculo[2]);
			break;
		}

		return vehiculo;
	}

	//para convertir número de tipo de vehículo,
	// a tipo de licencia que le corresponde,
	private String getTipoLicence(String tipoVehiculo) {
		String tipoLicence = "";

		switch (tipoVehiculo) {
		case "1":
			tipoLicence = "B";
			break;
		case "2":
			tipoLicence = "A";
			break;
		case "3":
			tipoLicence = "C";
			break;

		default:
			break;
		}
		return tipoLicence;
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
	
	
	//método que comprueba si una licencia (de conductor) corresponde al tipo de vehículo,
	private void checkLicenceConductor(Licencia licenciaConductor, String tipoVehiculo) {
		
		if (licenciaConductor.getTipoDeLicencia().equalsIgnoreCase(this.getTipoLicence(tipoVehiculo))) {
			
			System.out.println("Conductor tiene licencia para conducir " + this.arrayTiposVehiculo[Integer.parseInt(tipoVehiculo) - 1]);
		} else {
			
			System.out.println("Conductor no tiene licencia para conducir " + this.arrayTiposVehiculo[Integer.parseInt(tipoVehiculo) - 1]);
		}
	}

	// crear un titular de vehículo,
	/*
	 * public TitularVehiculo crearTitular() {
	 * 
	 * String titularNombre; String titularApellidos; String titularFechaNacimiento;
	 * 
	 * TitularVehiculo.pedirNombre(); titularNombre = getValorTeclado();
	 * 
	 * TitularVehiculo.pedirApellidos(); titularApellidos = getValorTeclado();
	 * 
	 * TitularVehiculo.pedirFechaNacimiento(); titularFechaNacimiento =
	 * getValorTeclado();
	 * 
	 * 
	 * Licencia licenciaTitular = this.crearLicencia();
	 * 
	 * TitularVehiculo titular = new TitularVehiculo(titularNombre,
	 * titularApellidos, titularFechaNacimiento, licenciaTitular, true, false);
	 * 
	 * return titular; }
	 * 
	 * //el método que pida datos de licencia y devuelve, //un objeto de tipo
	 * Licencia con los datos introducidos,
	 * 
	 * private Licencia crearLicencia() { String tipoLicencia; String
	 * nombreCompletoLicencia; String caducidadLicencia;
	 * 
	 * Licencia.pedirTipoLicencia(); tipoLicencia = getValorTeclado().trim();
	 * 
	 * Licencia.pedirNombreCompleto(); nombreCompletoLicencia = getValorTeclado();
	 * 
	 * Licencia.pedirFechaCaducidad(); caducidadLicencia = getValorTeclado();
	 * 
	 * return new Licencia(Licencia.numTotalLicencias, tipoLicencia,
	 * nombreCompletoLicencia, caducidadLicencia); }
	 * 
	 * //crear un conductor, private Conductor crearConductor(String conductor,
	 * TitularVehiculo titular) {
	 * 
	 * String conductorNombre; String conductorApellidos; String
	 * conductorFechaNacimiento;
	 * 
	 * 
	 * if (conductor.equalsIgnoreCase("2")) { //crear conductor,
	 * 
	 * Conductor.pedirNombre(); conductorNombre = getValorTeclado();
	 * 
	 * Conductor.pedirApellidos(); conductorApellidos = getValorTeclado();
	 * 
	 * Conductor.pedirFechaNacimiento(); conductorFechaNacimiento =
	 * getValorTeclado();
	 * 
	 * Licencia licenciaConductor = this.crearLicencia();
	 * 
	 * return new Conductor(conductorNombre, conductorApellidos,
	 * conductorFechaNacimiento, licenciaConductor); } else {
	 * 
	 * return new Conductor(this.titular1.getName(), titular.getSurname(),
	 * titular.getDateOfBirth(), titular.getLicense()); } }
	 */

	// get value de teclado de tipo String,
	private String getValorTeclado() {
		return teclado.next();
	}
}
