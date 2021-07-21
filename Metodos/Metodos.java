package Metodos;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Clases.*;

public class Metodos {
//	Creamos 3 hashtables para guardar datos de los objectos, a modo de base de datos
	Hashtable<String, Vehiculo> vehiculos = new Hashtable<String, Vehiculo>();
	Hashtable<String, Persona> titulares = new Hashtable<String, Persona>();
	Hashtable<String, Persona> conductores = new Hashtable<String, Persona>();

//	M�todo que genera la ventana de men� principal
	public void menuInicial() {
//		Pedimos al usuario que seleccione una opci�n del men�
		String[] botones = { "Nuevo usuario", "Nuevo vehiculo", "Listar", "Cerrar" };
		int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opci�n", "Men� principal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		switch (seleccion) {
		case 0:
			seleccionUsuario();
			break;
		case 1:
			seleccionVehiculo();
			break;
		case 2:
			menuListar();
			break;
		}
	}

//	M�todo que genera la ventana donde se selecciona el tipo de usuario a crear
	public void seleccionUsuario() {
//		Pedimos al usuario el usuario a crear
		String[] botones = { "Titular", "Conductor" };
		int seleccion = JOptionPane.showOptionDialog(null, "Que tipo de usuario deseas crear?", "Usuarios",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		switch (seleccion) {
		case 0:
			crearTitular("", 0);
			break;
		case 1:
			crearConductor(0);
			break;
		}
	}
	
//	M�todo que genera la ventana para escoger que tipo de datos queremos listar por pantalla
	public void menuListar() {
//		Pedimos al usuario el tipo de vehiculo
		String[] botonesVehiculos = { "Titulares", "Conductores", "Vehiculos" };
		int seleccionVehiculo = JOptionPane.showOptionDialog(null, "Selecciona que quieres listar", "Listar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesVehiculos, botonesVehiculos[0]);

//		Case para cada tipo de vehiculo
		switch (seleccionVehiculo) {

		case 0:
			listar("titular");
			break;

		case 1:
			listar("conductor");
			break;

		case 2:
			listar("vehiculo");
			break;
		}
	}
	
//	M�todo que genera la ventana de seleccion de Garaje Si/No
	private boolean tieneGaraje() {
		String[] botones = { "Si", "No" };
		int seleccion = JOptionPane.showOptionDialog(null, "Dispone de garaje propio?", "Garaje",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		if (seleccion == 0) {
			return true;
		} else {
			return false;
		}
	}

//	M�todo que genera la ventana de seleccion de Seguro Si/No
	private boolean tieneSeguro() {
		String[] botones = { "Si", "No" };
		int seleccion = JOptionPane.showOptionDialog(null, "Tiene seguro?", "Vehiculos", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		if (seleccion == 0) {
			return true;
		} else {
			return false;
		}
	}

//	M�todo para filtrar que tipo de vehiculo vamos a generar seg�n el input del usuario
	public void seleccionVehiculo() {
//		Pedimos al usuario el tipo de vehiculo
		String[] botonesVehiculos = { "Coche", "Moto", "Camion" };
		int seleccionVehiculo = JOptionPane.showOptionDialog(null, "Selecciona un vehiculo a generar", "Vehiculos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesVehiculos, botonesVehiculos[0]);

//		Case para cada tipo de vehiculo
		switch (seleccionVehiculo) {

		case 0:
			tieneTitular("B", "coche");
			break;

		case 1:
			tieneTitular("A", "moto");
			break;

		case 2:
			tieneTitular("C", "camion");
			break;
		}
	}


	
//	M�todo para hacer un output de cualquiera de los hashtables
	public void listar(String lista) {
		String output = "";
		if (lista.equals("titular")) {
			Enumeration<Persona> enumeration = titulares.elements();
			while (enumeration.hasMoreElements()) {
				output += enumeration.nextElement() + "\n";
			}
		} else if (lista.equals("conductor")) {
			Enumeration<Persona> enumeration = conductores.elements();
			while (enumeration.hasMoreElements()) {
				output += enumeration.nextElement() + "\n";
			}
		} else {
			Enumeration<Vehiculo> enumeration = vehiculos.elements();
			while (enumeration.hasMoreElements()) {
				output += enumeration.nextElement() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, new JTextArea(output));
		menuInicial();
	}

//	M�todo para crear un objeto titular
	public void crearTitular(String vehiculo, int control) {
//		Pedimos los datos del titular
		String nombre = JOptionPane.showInputDialog("Indica el nombre del titular");
		String apellidos = JOptionPane.showInputDialog("Indica los apellidos del titular");
		String id = JOptionPane.showInputDialog("Indica el DNI del titular");
		String fechaNacimiento = JOptionPane.showInputDialog("Indica la fecha de nacimiento del titular");
		String tipoLicencia = JOptionPane.showInputDialog("Indica el tipo de licencia del titular (A, B, C)");
//		Como fecha de caducidad pondremos el dia de hoy dentro de 5 a�os
		Date hoy = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoy);
		c.add(Calendar.YEAR, 5);
		Date fechaCad = c.getTime();
//		Creamos una licencia y un titular
		Licencia licencia = new Licencia(tipoLicencia, nombre + " " + apellidos, fechaCad);
		Titular titular = new Titular(id, nombre, apellidos, fechaNacimiento, licencia, tieneSeguro(), tieneGaraje());
//		A�adimos el titular a la lista de usuarios y lo mandamos a la seleccion de vehiculo
		titulares.put(id, titular);

//		control sirve para saber de que parte del menu hemos llamado el m�todo.
//		Si lo hemos llamado desde el men� solo queremos crear el titular
//		Si lo hemos llamado desde el m�todo tieneTitular queremos crear tambi�n un vehiculo
		if (control == 0) {
			menuInicial();
		} else {
			crearVehiculo(vehiculo, titular);
		}
	}
	
//	M�todo para crear un objeto conductor
	public Conductor crearConductor(int ctrl) {
//		Pedimos los datos del conductor
		String nombre = JOptionPane.showInputDialog("Indica el nombre del conductor");
		String apellidos = JOptionPane.showInputDialog("Indica los apellidos del conductor");
		String id = JOptionPane.showInputDialog("Indica el DNI del titular");
		String fechaNacimiento = JOptionPane.showInputDialog("Indica la fecha de nacimiento del conductor");
		String tipoLicencia = JOptionPane.showInputDialog("Indica el tipo de licencia del conductor (A, B, C)");
//		Como fecha de caducidad pondremos el dia de hoy dentro de 5 a�os en formato DATE
		Date hoy = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoy);
		c.add(Calendar.YEAR, 5);
		Date fechaCad = c.getTime();
//		Creamos una licencia y un conductor
		Licencia licencia = new Licencia(tipoLicencia, nombre + " " + apellidos, fechaCad);
		Conductor conductor = new Conductor(id, nombre, apellidos, fechaNacimiento, licencia);
		conductores.put(id, conductor);
//		ctrl sirve para diferenciar si hemos creado un conductor desde cero o si lo estamos creando
//		despues de generar un Vehiculo. La diferencia es que si es un nuevo conductor podemos indicarle al user si
//		quiere asignarlo a un vehiculo existente, mientras que con la otra opci�n se asigna directamente al vehiculo creado previamente.
		if (ctrl == 1) {
			if (a�adirAVehiculo()) {
				String matricula = JOptionPane
						.showInputDialog("Indica la matricula del vehiculo al que asignar como conductor");
				Vehiculo vehiculo = vehiculos.get(matricula);
				String vehiculoLicencia = vehiculo.getLICENCIA();
				if(comprobarLicencia(conductor, vehiculoLicencia)) {
					vehiculo.a�adirConductor(conductor);
				} else {
					JOptionPane.showMessageDialog(null, "La licencia del conductor no coincide con la requerida para el vehiculo.");
				}
				
			}
		}
		menuInicial();
		return conductor;
	}

//	M�todo para crear un objeto vehiculo
	public void crearVehiculo(String vehiculo, Titular titular) {
//		Pedimos por pantalla matricula, marca y color y lo asignamos a variables
		String matricula = "";
//		Bucle para controlar el formato correcto de la matr�cula
		do {
			matricula = JOptionPane.showInputDialog("Indica la matr�cula del vehiculo");
		} while (!isMatricula(matricula));

		String marca = JOptionPane.showInputDialog("Indica la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Indica el color del vehiculo");
		switch (vehiculo) {
		case "coche":
			Coche coche = new Coche(matricula, marca, color, titular);
			vehiculos.put(matricula, coche);
//			Preguntamos si el titular es tambien conductor del vehiculo
			titularEsConductor(coche, titular);
			crearRuedas(coche, titular);
			break;

		case "moto":
			Moto moto = new Moto(matricula, marca, color, titular);
			vehiculos.put(matricula, moto);
			titularEsConductor(moto, titular);
			crearRuedas(moto, titular);
			break;

		case "camion":
			Camion camion = new Camion(matricula, marca, color, titular);
			vehiculos.put(matricula, camion);
			titularEsConductor(camion, titular);
			crearRuedas(camion, titular);
			break;
		}

	}

//	M�todo para crear objetos rueda para un vehiculo
	private void crearRuedas(Vehiculo vehiculo, Titular titular) {
//		Pedimos por pantalla los datos de las ruedas delanteras y traseras y las a�adimos al objeto coche
		String marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas delanteras");
		double diametro = 0;
		do {
			diametro = Double.parseDouble(JOptionPane.showInputDialog("Indica el diametro de las ruedas delanteras"));
		} while (!rangoDiametro(diametro));

		vehiculo.a�adirRueda(marcaRueda, diametro, "delantera");

		marcaRueda = JOptionPane.showInputDialog("Indica la marca de las ruedas traseras");
		do {
			diametro = Double.parseDouble(JOptionPane.showInputDialog("Indica el diametro de las ruedas traseras"));
		} while (!rangoDiametro(diametro));
		vehiculo.a�adirRueda(marcaRueda, diametro, "trasera");
//		Output de los datos del objeto coche
		JOptionPane.showMessageDialog(null, new JTextArea(vehiculo.toString()));
		menuInicial();
	}

//	M�todo para controlar el formato de la matr�cula
	private boolean isMatricula(String matricula) {
//		Comprobamos que la matriculo tiene el formato que indicamos con una expresion regular,
//		en este caso 4 digitos y de dos a tres letras mayusculas
		if (matricula.matches("^\\d{4}[A-Z]{2,3}")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"El formato de la matr�cula introducida no es correcto, introducela de nuevo (ej. 1234XYZ / 1234YZ)");
			return false;
		}
	}

//	M�todo para controlar el diametro de las ruedas
	private boolean rangoDiametro(double diametro) {
		if (diametro >= 0.4 && diametro <= 4) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El di�metro introducido no es correcto (debe estar entre 0.4 y 4)");
			return false;
		}
	}



//	M�todo para preguntar si el titular del vehiculo es tambien el conductor, si se da el caso lo a�ade al hashtable de conductores
	private void titularEsConductor(Vehiculo vehiculo, Titular titular) {
		String[] botones = { "Si", "No" };
		int seleccionTitularConductor = JOptionPane.showOptionDialog(null,
				"Es el titular tambi�n el conductor del veh�culo?", "Vehiculos", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		switch (seleccionTitularConductor) {
		case 0:
			vehiculo.a�adirConductor(titular);
			conductores.put(titular.getId(), titular);
			break;
		case 1:
			int seleccionCrearConductor = JOptionPane.showOptionDialog(null,
					"Deseas crear un conductor para este vehiculo?", "Vehiculos", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
			if (seleccionCrearConductor == 0) {
				vehiculo.a�adirConductor(crearConductor(1));
			} else {
			}
			break;
		}
	}

//	M�todo para preguntar si el vehiculo creado tiene un titular registrado, si se da el caso se a�ade al atributo titular del vehiculo
	private void tieneTitular(String licencia, String vehiculo) {
		String[] botonesTitular = { "Si", "No" };
		int seleccionTitular = JOptionPane.showOptionDialog(null,
				"Tiene el vehiculo un titular registrado en la aplicaci�n?", "Vehiculos", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botonesTitular, botonesTitular[0]);

		if (seleccionTitular == 0) {
//			Si tiene titular le pedimos el DNI del mismo y guardamos el objeto titular en una variable
			String id = JOptionPane.showInputDialog("Indica el DNI del titular:");
			if (titulares.containsKey(id)) {
				Titular titular = (Titular) titulares.get(id);
				if (comprobarLicencia(titular, licencia)) {
					crearVehiculo(vehiculo, titular);
				} else { // Si la licencia del titular no coincide con la que requiere el vehiculo
							// mostramos mensaje de error y volvemos a lanzar el m�todo
					JOptionPane.showMessageDialog(null,
							"La licencia del titular no es v�lida para este tipo de vehiculo");
					seleccionVehiculo();
				}
			} else {
				JOptionPane.showMessageDialog(null, "El titular introducido no existe.");
				menuInicial();
			}

		} else {
			crearTitular(vehiculo, 1);
		}
	}

//	M�todo para preguntar al usuario si el conductor creado es conductor de un vehiculo ya creado
	private boolean a�adirAVehiculo() {
		String[] botones = { "Si", "No" };
		int seleccion = JOptionPane.showOptionDialog(null, "Es conductor de un vehiculo ya registrado?", "Vehiculos",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);

		if (seleccion == 0) {
			return true;
		} else {
			return false;
		}
	}

//	M�todo para comprobar si el tipo de licencia del objeto persona coincide con el del vehiculo a crear
	private boolean comprobarLicencia(Persona persona, String licencia) {
			if(persona.getLicencia().getTipo().equals(licencia)) {			
				return true;
			}else {
				return false;
			}
	}
}
