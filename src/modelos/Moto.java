package modelos;

public class Moto extends Vehiculo{
	
	//atributos,
	protected Rueda ruedas [] = new Rueda[2];
	/*protected Rueda ruedaDelantera;
	protected Rueda ruedaTrasera;*/

	
	//constructores,
	public Moto() {
		super();
	}

	//con todos atributos,
	public Moto(String matricula, String marca, String color) {
		super(matricula, marca, color);
	}
	
	//métodos,
	public void addRuedas(String tipoRueda, String marca, double diametro) {
		
		if (tipoRueda.equalsIgnoreCase("DELANTERAS")) {
			Rueda ruedaDelantera1 = new Rueda(tipoRueda, marca, diametro);
			
			this.ruedas[0] = ruedaDelantera1;
		
		}else {
			Rueda ruedaTrasera1 = new Rueda(tipoRueda, marca, diametro);

			this.ruedas[1] = ruedaTrasera1;
						
		}		
	}
	
	
	
	
	

}
