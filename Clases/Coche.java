package Clases;

public class Coche extends Vehiculo{
	
//	Atributos
	protected Rueda[] ruedas;

//	Constructor heredado de la superclase
	
	
	public Coche(String matricula, String marca, String color) {
		super(matricula, marca, color);
		this.ruedas = new Rueda[4];
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
				+ " Rueda trasera derecha\t" + ruedas[3].toString() + "\n";
	}

	
}
