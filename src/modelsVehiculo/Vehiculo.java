package modelsVehiculo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelsPersona.Conductor;
import modelsPersona.Persona;
import modelsPersona.TitularVehiculo;

public abstract class Vehiculo {

	// atributos,
	protected String matricula;
	protected String marca;
	protected String color;
	protected Rueda ruedas[];
	protected TitularVehiculo titular;
	protected ArrayList<Persona> conductores = new ArrayList<Persona>();
	protected String tipoLicencia;
	
	final protected String TIPOLICENCIA = "";

	// constructores,
	// por defecto,
	public Vehiculo() {
		this.matricula = "";
		this.marca = "";
		this.color = "";
		this.ruedas = new Rueda[1];	
		this.tipoLicencia = this.TIPOLICENCIA;
	}

	// constructor con valores,
	public Vehiculo(String matricula, String marca, String color) {

		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.ruedas = new Rueda[1];
		this.tipoLicencia = this.TIPOLICENCIA;
	}

	// métodos,

	// para añadir ruedas,
	abstract void addRuedas(String tipoRueda, String marca, double diametro);

	// para añadir titular al vehículo,
	protected void setTitular(TitularVehiculo titular) throws Throwable  {
				
		if (titular.getLicense().getTipoDeLicencia().equalsIgnoreCase(this.tipoLicencia)) {
			this.titular = titular;
			
			JOptionPane.showMessageDialog(null, "Ha sido añadido un titular nuevo correctamente. \n"  
			+ this.datosMin() + " " + this.titular.toString());
		} else {
			throw new Exception();
		}				
	}

	// método que permite añadir un conductor al vehículo,
	protected void addConductor(Persona conductor) {
		
		//para poder acceder a licencia de conductor comprobar si Persona es instancia,
		//de clase Titular de coche,
		if (conductor instanceof TitularVehiculo)  {
			
			//si licencia de titular coincide con el tipo de licencia que requiere vehiculo,
			//añadimos titular de vehículo como uno de los conductores,
			if(((TitularVehiculo) conductor).getLicense().getTipoDeLicencia().equalsIgnoreCase(this.tipoLicencia)){
				
				this.conductores.add(conductor);
				
				JOptionPane.showMessageDialog(null, "Ha sido añadido el titular de vehículo como un conductor nuevo. \n"
						+ this.datosMin() + " " + this.showConductores());
			}else {
				JOptionPane.showMessageDialog(null, "Titular no tiene licencia correcta para conducir vehículo");
			}
		}
		
		//o es instancia de clase Conductor,
		else if (conductor instanceof Conductor) {
			
			//si licencia de conductor coincide con el tipo de licencia que requiere vehiculo,
			//añadimoslo como uno de los conductores,
			if(((Conductor) conductor).getLicense().getTipoDeLicencia().equalsIgnoreCase(this.tipoLicencia)){
								
				this.conductores.add(conductor);
				JOptionPane.showMessageDialog(null, "Ha sido añadido un conductor nuevo. \n"
						+ this.datosMin() + "\n" + this.showConductores());
			}else {
				JOptionPane.showMessageDialog(null, "Conductor no tiene licencia correcta");
			}
		}
	}

	//métodos para mostrar información sobre vehículo,
	@Override
	public String toString() {
		return "matricula=" + matricula + ", marca=" + marca + ", color=" + color + ", ruedas: "  + ruedasToString();
	}
	
	public String datosMin() {
		return "matricula=" + matricula + ", marca=" + marca + ", color=" + color + ", requiere licencia tipo " + this.tipoLicencia;
	}
	
	//para mostrar lista de conductores,
	public String showConductores() {
		
		String listaConductores = "Conductores: ";
		for (int i = 0; i < conductores.size(); i++) {
			listaConductores += "\n"+ conductores.get(i).toString();
		}
		
		return listaConductores;
	}
	
	// para mostrar datos de ruedas,
		public String ruedasToString() {
			
			String ruedasDatos = " ";
			
			ruedasDatos += this.ruedas[0].toString() 
					+ "\n" + this.ruedas[this.ruedas.length -1].toString();
			return ruedasDatos;
		}

	// métodos para pedir datos sobre vehículo,

	// devuelve datos de vehículo pedido a usuario en forma de un array,
	protected static String[] getDatosVehiculo(String tipoVehiculo) {
		String[] datosVehiculo = new String[3];

		// pedimos al usuario la matrícula de coche,
		// y hacemos su comprobación que es correcta:
		// o sea tiene 4 números y 2/3 letras,
		do {

			datosVehiculo[0] = pedirMatricula(tipoVehiculo);
		} while (!isMatchMatricula(datosVehiculo[0]));

		// pedimos al usuario la marca de coche,

		datosVehiculo[1] = pedirMarca(tipoVehiculo);

		// pedimos al usuario el color de coche,

		datosVehiculo[2] = pedirColor(tipoVehiculo);

		return datosVehiculo;
	}

	// pide matrícula de vehículo,
	private static String pedirMatricula(String tipoVehiculo) {
		return JOptionPane.showInputDialog("Introduce la matrícula de " + tipoVehiculo);
	}

	// pide marca de vehículo,
	private static String pedirMarca(String tipoVehiculo) {
		return JOptionPane.showInputDialog("Introduce la marca de " + tipoVehiculo);
	}

	// pide color de vehículo,
	private static String pedirColor(String tipoVehiculo) {
		return JOptionPane.showInputDialog("Introduce el color de " + tipoVehiculo);

	}

	// comprobación de matrícula,
	private static boolean isMatchMatricula(String matricula) {

		String pattern = "(\\d{4}[a-zA-Z]{2,3})";
		return matricula.matches(pattern);
	}

}
