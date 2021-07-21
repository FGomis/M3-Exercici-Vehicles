package Clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Moto extends Vehiculo{
	
//	Constantes
	protected String LICENCIA = "A";
	
public String getLICENCIA() {
		return LICENCIA;
	}

	public void setLICENCIA(String lICENCIA) {
		LICENCIA = lICENCIA;
	}

	//	Atributos
	protected Rueda[] ruedas;
	

	public Moto(String matriculo, String marca, String color, Titular titular) {
		super(matriculo, marca, color, titular);
		this.ruedas = new Rueda[2];
		this.conductores = new ArrayList<>();
	}

	@Override
	public void añadirRueda(String marca, double diametro, String posicion) {
		if(posicion.equalsIgnoreCase("delantera")) {
			this.ruedas[0] =  new Rueda(marca, diametro, posicion);
		} else {
			this.ruedas[1] =  new Rueda(marca, diametro, posicion);
		}
	}

	@Override
	public String toString() {
		return "Moto\n"
				+ "-------------------------------\n"
				+ " Matricula: " + matricula + "  Marca: " + marca + "  Color: " + color + "\n"
				+ " Rueda delantera \t" + ruedas[0].toString() + "\n"
				+ " Rueda trasera\t" + ruedas[1].toString() + "\n\n"
				+ " Conductores\n"
				+ " -------------------------------\n"
				+ displayConductores();
	}

	@Override
	public void añadirConductor(Persona conductor) {
		this.conductores.add(conductor);
	}

	@Override
	public String displayConductores() {
		String output = "";
		Iterator<Persona> it = conductores.iterator();
		while(it.hasNext()) {
			output += it.next()+"\n";
		}
		return output;
	}
	
}
