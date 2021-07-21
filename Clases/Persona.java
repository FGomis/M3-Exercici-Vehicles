package Clases;

public abstract class Persona {
	
//		Atributos
		protected String id;
		
		protected String nombre;
		
		protected String apellidos;
		
		protected String fechaNacimiento;

		protected Licencia licencia;


		public Persona(String id, String nombre, String apellidos, String fechaNacimiento) {
			this.id = id;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.fechaNacimiento = fechaNacimiento;
		}



		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
					+ "]";
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getApellidos() {
			return apellidos;
		}



		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}



		public String getFechaNacimiento() {
			return fechaNacimiento;
		}



		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}



		public Licencia getLicencia() {
			return licencia;
		}



		public void setLicencia(Licencia licencia) {
			this.licencia = licencia;
		}



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}

		
}
