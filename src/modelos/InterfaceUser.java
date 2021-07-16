package modelos;

import java.util.Scanner;

public class InterfaceUser {
	Scanner teclado = new Scanner(System.in);

	// métodos,

	//método que crea un coche y añade ruedas a ella, 
	public void crearCoche() {

		String marcaRuedaDelantera;
		double diametroRuedaDelantera;
		
		String marcaRuedaTrasera;
		double diametroRuedaTrasera;
		
		String[] tipoVehiculo = {"coche", "moto"};
		String[] tipoRueda = {"DELANTERAS", "TRASERAS"};
		
		String[] datosVehiculo = this.getDatosVehiculo(tipoVehiculo[0]);

		// matrícula, marca, color,
		Coche coche1 = new Coche(datosVehiculo[0], datosVehiculo[1], datosVehiculo[2]);

		System.out.println(coche1.toString());

		
		//añadir ruedas,
		
		this.pedirMarcaRueda(tipoRueda[0]);
		marcaRuedaDelantera = this.getValorTeclado();
		
		do {
			this.pedirDiametroRueda(tipoRueda[0]);
			diametroRuedaDelantera = Double.parseDouble(getValorTeclado());
			
		} while (!isDiametroCorrecto(diametroRuedaDelantera));
		
		coche1.addRuedas(tipoRueda[0], marcaRuedaDelantera, diametroRuedaDelantera);
		

		
		this.pedirMarcaRueda(tipoRueda[1]);		
		marcaRuedaTrasera = this.getValorTeclado();
						
		do {
			this.pedirDiametroRueda(tipoRueda[1]);
			diametroRuedaTrasera = Double.parseDouble(getValorTeclado());
			
		} while (!isDiametroCorrecto(diametroRuedaTrasera));
		
		coche1.addRuedas(tipoRueda[1], marcaRuedaTrasera, diametroRuedaTrasera);
		
		

		coche1.showRuedas();
	}
	
	

	// pide matrícula de vehículo,
	private void pedirMatricula(String tipoVehiculo) {
		System.out.println("Introduce la matrícula de su " + tipoVehiculo);
	}

	// pide marca de vehículo,
	private void pedirMarca(String tipoVehiculo) {
		System.out.println("Introduce la marca de su " + tipoVehiculo);
	}

	// pide color de vehículo,
	private void pedirColor(String tipoVehiculo) {
		System.out.println("Introduce el color de su " + tipoVehiculo);
		
	}

	// get value de teclado de tipo String,
	private String getValorTeclado() {
		return teclado.next();
	}

	// devuelve datos de vehículo pedido a usuario en forma de un array,
	private String[] getDatosVehiculo(String tipoVehiculo) {
		String[] datosVehiculo = new String[3];

		// pedimos al usuario la matrícula de coche,
		//y hacemos su comprobación que es correcta:
		//o sea tiene 4 números y 2/3 letras,
		do {
			this.pedirMatricula(tipoVehiculo);
			datosVehiculo[0] = this.getValorTeclado();
		} while (!isMatchMatricula(datosVehiculo[0]));
		

		// pedimos al usuario la marca de coche,
		this.pedirMarca(tipoVehiculo);
		datosVehiculo[1] = this.getValorTeclado();

		// pedimos al usuario el color de coche,
		this.pedirColor(tipoVehiculo);
		datosVehiculo[2] = this.getValorTeclado();

		return datosVehiculo;
	}

	//comprobación de matrícula,
	private boolean isMatchMatricula(String matricula) {
		
		String pattern = "(\\d{4}[a-zA-Z]{2,3})";
		return matricula.matches(pattern);
	}
	
	// métodos para pedir datos de las ruedas,

	// método para pedir la marca de ruedas,
	private void pedirMarcaRueda(String tipoRuedas) {
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("RUEDAS " + tipoRuedas + ". Introduce su marca." );
	}

	// método para pedir el diametro de ruedas,
	private void pedirDiametroRueda(String tipoRuedas) {
		System.out.println("RUEDAS " + tipoRuedas + ". Introduce su diametro. " );
	}
	
	//método para controlar el diámetro de ruedas,
	private boolean isDiametroCorrecto(double diametroRueda) {
		
		if ((diametroRueda < 0.4) || (diametroRueda > 4)) {
			return false;
		}else {
			return true;
		}	
	}

	
	
	

}
