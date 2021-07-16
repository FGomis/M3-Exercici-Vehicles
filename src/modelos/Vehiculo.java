package modelos;

abstract class Vehiculo {
	
	//atributos,
	protected String matricula;
	protected String marca;
	protected String color;
	
	//constructores,
	//por defecto,
	public Vehiculo() {
		this.matricula = "";
		this.marca = "";
		this.color = "";
	}
	
	//constructor con valores,
	public Vehiculo(String matricula, String marca, String color) {

		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}
	
	//métodos,
	
	abstract void addRuedas(String tipoRueda, String marca, double diametro);
	

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", color=" + color + "]";
	}
	
	
}
