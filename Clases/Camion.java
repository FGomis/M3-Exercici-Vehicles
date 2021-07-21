package Clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Camion extends Vehiculo{
	
//	Constantes
	protected String LICENCIA = "C";
	
public String getLICENCIA() {
		return LICENCIA;
	}

	public void setLICENCIA(String lICENCIA) {
		LICENCIA = lICENCIA;
	}

	//	Atributos
	protected Rueda[] ruedas;

//	Constructor principal
	public Camion(String matricula, String marca, String color, Titular titular) {
		super(matricula, marca, color, titular);
		this.ruedas = new Rueda[8];
		this.conductores = new ArrayList<>();
	}
	
	@Override
	public void añadirRueda(String marca, double diametro, String posicion) {
		if(posicion.equalsIgnoreCase("delantera")) {
			this.ruedas[0] = new Rueda(marca, diametro, posicion);
			this.ruedas[1] =  new Rueda(marca, diametro, posicion);
			this.ruedas[2] =  new Rueda(marca, diametro, posicion);
			this.ruedas[3] =  new Rueda(marca, diametro, posicion);
		} else {
			this.ruedas[4] =  new Rueda(marca, diametro, posicion);
			this.ruedas[5] =  new Rueda(marca, diametro, posicion);
			this.ruedas[6] =  new Rueda(marca, diametro, posicion);
			this.ruedas[7] =  new Rueda(marca, diametro, posicion);
		}
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

	@Override
	public String toString() {
		return "Camion\n"
				+ "-------------------------------\n"
				+ " Matricula: " + matricula + "  Marca: " + marca + "  Color: " + color + "\n"
				+ " Ruedas delanteras \n" + ruedas[0].toString() + "\n"
				+ ruedas[1].toString() + "\n"
				+ ruedas[2].toString() + "\n"
				+ ruedas[3].toString() + "\n"
				+ " Ruedas traseras \n" + ruedas[4].toString() + "\n"
				+ ruedas[5].toString() + "\n"
				+ ruedas[6].toString() + "\n"
				+ ruedas[7].toString() + "\n"
				+ " Conductores\n"
				+ " -------------------------------\n"
				+ displayConductores();
	}
}
