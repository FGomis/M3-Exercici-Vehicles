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
	
	public abstract void añadirRueda(String marca, String diametro, String posicion);

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
	
	
}
