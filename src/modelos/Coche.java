package modelos;

public class Coche extends Vehiculo {

	// atributos,
	/*protected Rueda ruedaDelantera1;
	protected Rueda ruedaTrasera1;
	protected Rueda ruedaDelantera2;
	protected Rueda ruedaTrasera2;*/

	protected Rueda ruedas[] = new Rueda[4];

	// constructores,
	// por defecto,
	public Coche() {
		super();
	}

	// con todos atributos,
	public Coche(String matricula, String marca, String color) {
		super(matricula, marca, color);
	}

	@Override
	public void addRuedas(String tipoRueda, String marca, double diametro) {
		
		if (tipoRueda.equalsIgnoreCase("DELANTERAS")) {
			Rueda ruedaDelantera1 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaDelantera2 = new Rueda(tipoRueda, marca, diametro);
			this.ruedas[0] = ruedaDelantera1;
			this.ruedas[1] = ruedaDelantera2;
		}else {
			Rueda ruedaTrasera1 = new Rueda(tipoRueda, marca, diametro);
			Rueda ruedaTrasera2 = new Rueda(tipoRueda, marca, diametro);
			this.ruedas[2] = ruedaTrasera1;
			this.ruedas[3] = ruedaTrasera2;			
		}		
	}
	
	//método para mostrar datos de ruedas,
	public void showRuedas() {
		for (int i = 0; i < ruedas.length; i++) {
			System.out.println(ruedas[i]);			
		}
	}

}
