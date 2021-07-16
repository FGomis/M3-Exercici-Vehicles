package modelos;

public class Rueda {
	
	//atributos,
	protected String tipoRueda;
	protected String marca;
	protected double diametro;
	
	//constructor,
	public Rueda(String tipoRueda, String marca, double diametro) {
		
		this.tipoRueda = tipoRueda;
		this.marca = marca;
		this.diametro = diametro;
		
	}


	@Override
	public String toString() {
		return "Rueda [tipoRueda=" + tipoRueda + ", marca=" + marca + ", diametro=" + diametro + "]";
	}

}
