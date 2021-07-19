package modelos;

public class Licencia {
	
	// atributos,
	protected long id;
	protected char tipoDeLicencia;
	protected String nombreCompleto;
	protected String fechCaducidad;
	
	//constructores,
	
	//por defecto,
	public Licencia() {
		this.id = 0;
		this.tipoDeLicencia = 'A';
		this.nombreCompleto = "";
		this.fechCaducidad = "00/00/1997";		
	}

	//con todos los atributos,
	public Licencia(long id, char tipoOfLicencia, String nombreCompleto, String fechCaducidad) {
		
		this.id = id;
		this.tipoDeLicencia = tipoOfLicencia;
		this.nombreCompleto = nombreCompleto;
		this.fechCaducidad = fechCaducidad;
	}

	@Override
	public String toString() {
		return "Licencia [id=" + this.id + ", tipoOfLicencia=" + this.tipoDeLicencia + ", nombreCompleto=" + 
				this.nombreCompleto + ", fechCaducidad=" + this.fechCaducidad + "]";
	}
	
	
	public boolean equals(Licencia obj) {
		
		if (obj.nombreCompleto.equals(this.nombreCompleto) ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	

}
