package Clases;

public abstract class Vehiculo {
	
	protected String matricula;
	
	protected String marca;
	
	protected String color;


	public Vehiculo(String matricula, String marca, String color) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}
	
	public abstract void añadirRueda(String marca, double diametro, String posicion);
	
	
}
