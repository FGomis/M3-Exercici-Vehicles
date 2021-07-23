package modelsPersona;

import java.util.Scanner;

public class Licencia {

	static Scanner teclado = new Scanner(System.in);

	// atributos,
	protected long id;
	protected String tipoDeLicencia; //A - moto, B - coche, C - camion
	protected String nombreCompleto;
	protected String fechaCaducidad;
	public static int numTotalLicencias;


	// constructores,

	// por defecto,
	public Licencia() {
		this.id = 0;
		this.tipoDeLicencia = "A";
		this.nombreCompleto = "";
		this.fechaCaducidad = "00/00/1997";
	}

	// con todos los atributos,
	public Licencia(long id, String tipoDeLicencia, String nombreCompleto, String fechaCaducidad) {

		this.id = id;
		this.tipoDeLicencia = tipoDeLicencia;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
		Licencia.numTotalLicencias++;
	}
	
	//getter del tipo de licencia,
	public String getTipoDeLicencia() {
		return this.tipoDeLicencia;
	}

	@Override
	public String toString() {
		return "Licencia [id=" + this.id + ", tipo de Licencia=" + this.tipoDeLicencia + ", "
				+ this.nombreCompleto + ", fechaCaducidad=" + this.fechaCaducidad + "]";
	}
}
