package Clases;

public class Rueda {
	
	//Atributos
	protected String marca;
	
	protected double diametro;
	
	protected String posicion;

	public Rueda(String marca, double diametro, String posicion) {
		this.marca = marca;
		this.diametro = diametro;
		this.posicion = posicion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + ", Diametro: " + diametro;
	}
	
	
}
