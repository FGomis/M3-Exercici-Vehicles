package Clases;

public class Moto extends Vehiculo{
	
//	Atributos
	protected Rueda[] ruedas;
	

	public Moto(String matriculo, String marca, String color) {
		super(matriculo, marca, color);
		this.ruedas = new Rueda[2];
	}

	@Override
	public void añadirRueda(String marca, double diametro, String posicion) {
			this.ruedas[0] =  new Rueda(marca, diametro, posicion);
			this.ruedas[1] =  new Rueda(marca, diametro, posicion);
	}

	@Override
	public String toString() {
		return "Moto\n"
				+ "-------------------------------\n"
				+ " Matricula: " + matricula + "  Marca: " + marca + "  Color: " + color + "\n"
				+ " Rueda delantera \t" + ruedas[0].toString() + "\n"
				+ " Rueda trasera\t" + ruedas[1].toString() + "\n";
	}
	
	
	
	
}
