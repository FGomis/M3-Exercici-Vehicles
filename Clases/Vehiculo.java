package Clases;

import java.util.ArrayList;

public abstract class Vehiculo {
	
//	Constantes
	protected String LICENCIA;
	
public String getLICENCIA() {
		return LICENCIA;
	}

	public void setLICENCIA(String lICENCIA) {
		LICENCIA = lICENCIA;
	}

	//	Atributos
	protected String matricula;
	
	protected String marca;
	
	protected String color;
	
	protected ArrayList<Persona> conductores;
	
	protected Titular titular;


	public Vehiculo(String matricula, String marca, String color, Titular titular) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.titular = titular;
	}
	
	public abstract void añadirRueda(String marca, double diametro, String posicion);

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<Persona> getConductores() {
		return conductores;
	}

	public void setConductores(ArrayList<Persona> conductores) {
		this.conductores = conductores;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	public abstract void añadirConductor(Persona conductor);
	
	public abstract String displayConductores();
}
