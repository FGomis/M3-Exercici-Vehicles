package Clases;

public class Moto extends Vehiculo{
	
//	Atributos
	protected Rueda ruedaDelantera;
	
	protected Rueda ruedaTrasera;

	public Moto(String matriculo, String marca, String color) {
		super(matriculo, marca, color);
	}

	@Override
	public void añadirRueda(String marca, double diametro, String posicion) {
			this.ruedaDelantera =  new Rueda(marca, diametro, posicion);
			this.ruedaTrasera =  new Rueda(marca, diametro, posicion);
	}
	
	
}
