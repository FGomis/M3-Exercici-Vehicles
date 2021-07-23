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
	
	final protected String TIPOLICENCIA = "A";

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

	// para añadir ruedas,
	abstract void addRuedas(String tipoRueda, String marca, double diametro);

	// para mostrar datos de ruedas,
	public String ruedasToString() {
		
		String ruedasDatos = " ";
		
		ruedasDatos += this.ruedas[0].toString() 
				+ "\n" + this.ruedas[this.ruedas.length -1].toString();
		return ruedasDatos;
	}

	// para añadir titular al vehículo,
	protected void setTitular(TitularVehiculo titular) throws Throwable  {
				
		if (titular.getLicense().getTipoDeLicencia().equalsIgnoreCase(this.TIPOLICENCIA)) {
			this.titular = titular;
		} else {
			throw new Exception();
		}
				
	}

	// método que permite añadir conductores al vehículo,
	protected void addConductor(Persona conductor) {
		
		System.out.println("this.TIPOLICENCIA " + this.TIPOLICENCIA);
		if (conductor instanceof TitularVehiculo)  {
			
			if(((TitularVehiculo) conductor).getLicense().getTipoDeLicencia().equalsIgnoreCase(this.TIPOLICENCIA)){
				
				this.conductores.add(conductor);
				
				JOptionPane.showMessageDialog(null, "Ha sido añadido un conductor nuevo correctamente");
			}else {
				JOptionPane.showMessageDialog(null, "Titular no tiene licencia correcta");
			}
		}
		
		else if (conductor instanceof Conductor) {
			System.out.println("this.TIPOLICENCIA2 " + this.TIPOLICENCIA);
			if(((Conductor) conductor).getLicense().getTipoDeLicencia().equalsIgnoreCase(this.TIPOLICENCIA)){
				
				
				this.conductores.add(conductor);
				JOptionPane.showMessageDialog(null, "Ha sido añadido un conductor nuevo correctamente 1");
			}else {
				JOptionPane.showMessageDialog(null, "Conductor no tiene licencia correcta");
			}
		}

	}

	@Override
	public String toString() {
		return "matricula=" + matricula + ", marca=" + marca + ", color=" + color + ", ruedas: "  + ruedasToString();
	}
	
	public String datosMin() {
		return "matricula=" + matricula + ", marca=" + marca + ", color=" + color;
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
		return JOptionPane.showInputDialog("Introduce la matrícula de su " + tipoVehiculo);
	}

	// pide marca de vehículo,
	private static String pedirMarca(String tipoVehiculo) {
		return JOptionPane.showInputDialog("Introduce la marca de " + tipoVehiculo);
	}

	// pide color de vehículo,
	private static String pedirColor(String tipoVehiculo) {
		return JOptionPane.showInputDialog("Introduce el color de su " + tipoVehiculo);

	}

	// comprobación de matrícula,
	private static boolean isMatchMatricula(String matricula) {

		String pattern = "(\\d{4}[a-zA-Z]{2,3})";
		return matricula.matches(pattern);
	}

}
