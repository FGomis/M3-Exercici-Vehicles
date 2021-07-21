package Clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Coche extends Vehiculo{
	
//	Constantes
	protected String LICENCIA = "B";
	
//	Atributos
	protected Rueda[] ruedas;

//	Constructor heredado de la superclase
	public Coche(String matricula, String marca, String color, Titular titular) {
		super(matricula, marca, color, titular);
		this.ruedas = new Rueda[4];
		this.conductores = new ArrayList<>();
	}

	@Override
	public void añadirRueda(String marca, double diametro, String posicion) {
		if(posicion.equalsIgnoreCase("delantera")) {
			this.ruedas[0] = new Rueda(marca, diametro, posicion);
			this.ruedas[1] =  new Rueda(marca, diametro, posicion);
		} else {
			this.ruedas[2] =  new Rueda(marca, diametro, posicion);
			this.ruedas[3] =  new Rueda(marca, diametro, posicion);
		}
	}

	@Override
	public String toString() {
		return "Coche\n"
				+ "-------------------------------\n"
				+ " Matricula: " + matricula + "  Marca: " + marca + "  Color: " + color + "\n"
				+ " Rueda delantera izquierda\t" + ruedas[0].toString() + "\n"
				+ " Rueda delantera derecha\t" + ruedas[1].toString() + "\n"
				+ " Rueda trasera izquierda\t" + ruedas[2].toString() + "\n"
				+ " Rueda trasera derecha\t" + ruedas[3].toString() + "\n"
				+ " Conductores\n"
				+ " -------------------------------\n"
				+ displayConductores();
	}

	@Override
	public void añadirConductor(Persona conductor) {
		conductores.add(conductor);
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

	public String getLICENCIA() {
		return LICENCIA;
	}

	public void setLICENCIA(String lICENCIA) {
		LICENCIA = lICENCIA;
	}

	
}
