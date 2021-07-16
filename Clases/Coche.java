package Clases;

public class Coche extends Vehiculo{
	
//	Atributos
	protected Rueda ruedaDelantera1;
	
	protected Rueda ruedaDelantera2;
	
	protected Rueda ruedaTrasera1;
	
	protected Rueda ruedaTrasera2;

//	Constructor heredado de la superclase
	public Coche(String matricula, String marca, String color) {
		super(matricula, marca, color);
	}

	@Override
	public void añadirRueda(String marca, double diametro, String posicion) {
		if(posicion.equals("delantera")) {
			this.ruedaDelantera1 = new Rueda(marca, diametro, posicion);
			this.ruedaDelantera2 =  new Rueda(marca, diametro, posicion);
		} else {
			this.ruedaTrasera1 =  new Rueda(marca, diametro, posicion);
			this.ruedaTrasera2 =  new Rueda(marca, diametro, posicion);
		}
	}

	@Override
	public String toString() {
		return "Coche\n Matricula: " + matricula + ", Marca: " + marca + ", Color: " + color + "\n"
				+ " Rueda delantera 1 " + ruedaDelantera1 + "\n"
				+ " Rueda delantera 2 " + ruedaDelantera1 + "\n"
				+ " Rueda trasera 1 " + ruedaTrasera1 + "\n"
				+ " Rueda trasera 2 " + ruedaTrasera2 + "\n";
	}

}
