package Clases;

public class Rueda {
	
//	Atributos
	protected String marca;
	
	protected double diametro;
	
	protected String posicion;

	public Rueda(String marca, double diametro, String posicion) {
		this.marca = marca;
		this.diametro = diametro;
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + ", Diametro: " + diametro;
	}
	
	
}
