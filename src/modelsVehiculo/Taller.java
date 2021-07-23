package modelsVehiculo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelsPersona.*;

public class Taller {

	// atributos;

	protected String[] arrayTiposVehiculo = { "coche", "moto", "camion" };
	protected String[] arrayTiposRueda = { "delantera", "trasera" };

	protected String marcaRuedaDelantera;
	protected String marcaRuedaTrasera;

	protected double diametroRuedaDelantera;
	protected double diametroRuedaTrasera;

	protected String[] arrayDatosVehiculo;
	protected Vehiculo vehiculo;
	protected String optionMenu;

	// Lista de personas y de vehículos,
	protected ArrayList<Persona> personas = new ArrayList<Persona>();
	protected ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	// métodos,

	// el método que se ejecuta en el main,
	public void startTaller() {

		// inicializar el menu,
		optionMenu = showMenuPrincipal();

		// while
		try {

			// mientras usuario ne elige botón 5 continuo
			// ejecutar el programa,
			while (!optionMenu.equalsIgnoreCase("0")) {

				this.runMenu(optionMenu);
				optionMenu = showMenuPrincipal();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Message: " + e.getMessage() + "\n");
			System.out.println("File: " + e.getClass() + "\n");
			System.out.println("Line: " + e.getStackTrace() + "\n");
			System.out.println("Localized message: " + e.getLocalizedMessage() + "\n");
			System.out.println("Cause: " + e.getCause() + "\n");
		}

		catch (Exception e) {
			System.out.println("Message: " + e.getMessage() + "\n");
			System.out.println("File: " + e.getClass() + "\n");
			System.out.println("Line: " + e.getStackTrace() + "\n");
			System.out.println("Localized message: " + e.getLocalizedMessage() + "\n");
			System.out.println("Cause: " + e.getCause() + "\n");
			JOptionPane.showMessageDialog(null, "Taller ha acabado su trabajo por hoy. Hasta pronto.");
		}

	}

	// método principal donde se ejecuta todo el programa,
	public void runMenu(String optionMenu) {
		String optionPersona;
		String optionVehiculo;
		String numVehiculoaAsignar;

		switch (optionMenu) {
		// para crear personas,
		case "1":
			optionPersona = showMenuCrearPersonas();

			while (!optionPersona.equalsIgnoreCase("0")) {

				this.crearPersonas(optionPersona);
				optionPersona = showMenuCrearPersonas();
			}

			break;

		// para crear vehículos,
		case "2":

			optionVehiculo = showMenuCrearVehiculos();

			while (!optionVehiculo.equalsIgnoreCase("0")) {

				this.crearVehiculos(optionVehiculo);
				optionVehiculo = showMenuCrearVehiculos();
			}

			break;

		// para mostrar lista de personas creadas,
		case "3":
			this.showArrayListPersonas(this.personas);
			break;

		// para mostrar lista de vehículos,
		case "4":
			this.showArrayListVehiculos(this.vehiculos);
			break;

		// asignar titular y conductores al vehículo,
		case "5":
			
			// optionVehiculo obtenemos position-1 de vehiculo en arraylist,
			numVehiculoaAsignar = elegirVehiculo(this.vehiculos);

			// mientras usuario no ha elegido 0 se puede asignar personas a vehículos,
			while (!numVehiculoaAsignar.equalsIgnoreCase("0")) {

				this.asignarPersonasVehiculo(numVehiculoaAsignar);

				// para que se ejecuta while de nuevo,
				numVehiculoaAsignar = elegirVehiculo(this.vehiculos);
			}

			break;
		default:
			break;
		}
	}
	
	//método que permite asignar personas a un vehículo,
	private void asignarPersonasVehiculo(String numVehiculoaAsignar) {
		
		String optionTitularConductor;		
		Vehiculo vehiculoAsignar;
		int numPersona;
		Persona conductor;
		TitularVehiculo titular = null;
		

		// guardamos vehículo a lo cual asignarémos personas,
		vehiculoAsignar = this.vehiculos.get(Integer.parseInt(numVehiculoaAsignar) - 1);

		// preguntamos si asignamos un titular o conductor,
		optionTitularConductor = showMenuAsignarPersonas();

		//según la opción obtenida,
		switch (optionTitularConductor) {
		
		// asignamos un titular,
		case "1":
		//mostramos datos de todos titulaes para que se pueda elegir uno,
			numPersona = Integer.parseInt(elegirPersona(this.personas, optionTitularConductor)) - 1; //?????
		
			//buscamos entre personas
			for (Persona persona : this.personas) {
				if (persona instanceof TitularVehiculo) {
					titular = (TitularVehiculo) this.personas.get(numPersona);
				}
			}

			try {
				vehiculoAsignar.setTitular(titular);
			} catch (Throwable e) {
				JOptionPane.showMessageDialog(null, "Titular no tiene licencia correcta");
				e.printStackTrace();
			}

			break;
		// o un conductor,
		case "2":
			//mostramos datos de todas personas,
			numPersona = Integer.parseInt(elegirPersona(this.personas, optionTitularConductor)) - 1;
			
			//con el índice de la persona la buscamos en el array de personas,
			conductor = this.personas.get(numPersona);
			
			//añadimos conductor en la lista de conductores,
			vehiculoAsignar.addConductor(conductor);
			
			break;

		default:
			break;
		}
	}

	// método que permite crear diferentes tipos de vehículos,
	private void crearVehiculos(String optionVehiculo) {

		Vehiculo vehiculo;

		// pedimos datos del vehículo,
		this.arrayDatosVehiculo = Vehiculo
				.getDatosVehiculo(this.arrayTiposVehiculo[Integer.parseInt(optionVehiculo) - 1]);

		// según el tipo de vehículo creamos un objeto de ese tipo,
		switch (optionVehiculo) {
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

		// añadimos ruedas,
		this.addRuedas(vehiculo, this.arrayTiposRueda[0]);

		this.addRuedas(vehiculo, this.arrayTiposRueda[1]);

		this.vehiculos.add(vehiculo);

	}

	// metodo que se ejecuta cuando usuario quiere crear titulares o conductores,
	private void crearPersonas(String optionPersona) {

		String nombre = Persona.pedirNombre();
		String apellidos = Persona.pedirApellidos();
		String fechaNacimiento = Persona.pedirFechaNacimiento();
		// Licencia licencia = Taller.setLicencia();
		int tieneSeguro;
		int tieneGaraje;

		// según la opción elegida creamos o un titular de vehículo o un conductor,
		switch (optionPersona) {

		// titular,
		case "1":

			tieneSeguro = JOptionPane.showOptionDialog(null, "Titular tiene seguro? ", "Tiene seguro",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "No", "Sí" },
					"No");

			tieneGaraje = JOptionPane.showOptionDialog(null, "Titular tiene garaje? ", "Tiene garaje",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "No", "Sí" },
					"No");

			personas.add(new TitularVehiculo(nombre, apellidos, fechaNacimiento, Taller.setLicencia(),
					tieneSeguro > 0 ? true : false, tieneGaraje > 0 ? true : false));

			break;

		// si usuario ha elegido crear un conductor,
		case "2":
			personas.add(new Conductor(nombre, apellidos, fechaNacimiento, Taller.setLicencia()));

			break;

		default:
			break;
		}
	}

	// para mostrar menu principal,
	private static String showMenuPrincipal() {

		return JOptionPane.showInputDialog(
				"Elige una de las opciones: " + "\n1. Crear Persona" + "\n2. Crear vehículo" + "\n3. Mostrar personas"
						+ "\n4. Mostrar vehículos" + "\n5. Asignar personas a vehículos" + "\n0. Acadar el programa");
	}

	// para mostrar menu personas,
	private static String showMenuCrearPersonas() {

		return JOptionPane.showInputDialog(
				"Crear: " + "\n1. Titular de Vehículo" + "\n2. Conductor" + "\n0. Salir al menu principal");
	}

	// para mostrar menu vehículos,
	private static String showMenuCrearVehiculos() {

		return JOptionPane.showInputDialog(
				"Crear: " + "\n1. Coche" + "\n2. Moto" + "\n3. Camión" + "\n0. Salir al menu principal");
	}

	// para mostrar menu de asignación de personas a un vehículo elegido,
	private static String showMenuAsignarPersonas() {

		return JOptionPane.showInputDialog(
				"Asignar al vehículo: " + "\n1. Titular" + "\n2. Conductor" + "\n0. Salir al menu principal");
	}

	// para mostrar titulares y conductores de vehículos,
	private static String elegirPersona(ArrayList<Persona> personas, String optionAsignarPersona) {
		String datosPersonas = "";
		int contador;

		if (personas.size() > 0) {

			switch (optionAsignarPersona) {
			// titular,
			case "1":
				contador = 0;
				for (int i = 0; i < personas.size(); i++) {

					if (personas.get(i) instanceof TitularVehiculo) {

						contador++;
						datosPersonas += "\n" + contador + ". " + personas.get(i).datosMin() + "\n";
					}
				}

				break;
			// conductores,
			// mostramos todos porque titular también puede ser conductor,
			case "2":

				for (int i = 0; i < personas.size(); i++) {

					datosPersonas += "\n" + (i + 1) + ". " + personas.get(i).datosMin() + "\n";
				}

				break;
			default:
				break;
			}
			return JOptionPane.showInputDialog(null, datosPersonas + "\n0. Salir al menu principal");
		} else {
			return JOptionPane.showInputDialog(null, "No hay ningúna persona creada" + "\n0. Salir al menu principal");
		}

	}

	// para mostrar menu vehículos,
	private static String elegirVehiculo(ArrayList<Vehiculo> vehiculos) {

		String datosVehiculos = "";

		if (vehiculos.size() > 0) {

			for (int i = 0; i < vehiculos.size(); i++) {

				datosVehiculos += "\n" + (i + 1) + ". " + vehiculos.get(i).datosMin();
			}

			return JOptionPane.showInputDialog(
					"Elige vehiculo para asignar personas: " + datosVehiculos + "\n0. Salir al menu principal");

		}

		return JOptionPane.showInputDialog(null, "No hay ningún vehículo creado" + "\n0. Salir al menu principal");
	}

	
	// para mostrar el contenido de un array list de personas,
	private void showArrayListPersonas(ArrayList<Persona> personas) {

		String datosPersonas = "";

		if (personas.size() > 0) {

			for (Persona persona : personas) {
				
				datosPersonas += persona.toString() + "\n";
			}
			JOptionPane.showMessageDialog(null, datosPersonas);

		} else {
			JOptionPane.showMessageDialog(null, "Todavía no has creado ningúna pesona");
		}
	}

	// para mostrar el contenido de un array list de personas,
	private void showArrayListVehiculos(ArrayList<Vehiculo> vehiculos) {

		String datosVehiculos = "";

		if (vehiculos.size() > 0) {

			for (Vehiculo vehiculo : vehiculos) {
	
				datosVehiculos += vehiculo.toString() + "\n";
			}

			JOptionPane.showMessageDialog(null, datosVehiculos);

		} else {
			JOptionPane.showMessageDialog(null, "Todavía no has creado ningún vehículo");
		}
	}
	
	
	// para convertir número de tipo de vehículo,
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

			marcaRueda = Rueda.pedirMarcaRueda(tipoRueda);

			do {

				diametroRueda = Double.parseDouble(Rueda.pedirDiametroRueda(tipoRueda));

			} while (!Rueda.isDiametroCorrecto(diametroRueda));

			vehiculo.addRuedas(tipoRueda, marcaRueda, diametroRueda);
		}

	// para crear licencias sin pedir datos,
	// tenemos tres tipos licencias,
	private static Licencia setLicencia() {

		String tipoLicencia = JOptionPane
				.showInputDialog("Elige tipo de licencia:" + "\nA. Moto" + "\nB. Coche" + "\nC. Camión");

		switch (tipoLicencia.toUpperCase()) {
		// moto
		case "A":
			return new Licencia(Licencia.numTotalLicencias, "A", "moto", "31/01/2033");
		// break;
		// camion,
		case "C":
			return new Licencia(Licencia.numTotalLicencias, "C", "camion", "20/06/2033");
		// break;
		// coche,
		default:
			return new Licencia(Licencia.numTotalLicencias, "B", "coche", "01/10/2033");
		// break;
		}
	}
}
