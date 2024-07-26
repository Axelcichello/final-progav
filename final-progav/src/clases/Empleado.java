package clases;

public class Empleado extends Usuario{

		private int dni;
		private int cargo;
		private String password;
		
		
		public Empleado() {
			super();
		}


		public Empleado(int id, String nombre, String apellido, int telefono, int dni, int cargo, String password) {
			super(id, nombre, apellido, telefono);
			this.dni = dni;
			this.cargo = cargo;
			this.password = password;
		}


		public int getDni() {
			return dni;
		}


		public void setDni(int dni) {
			this.dni = dni;
		}


		public int getCargo() {
			return cargo;
		}


		public void setCargo(int cargo) {
			this.cargo = cargo;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		@Override
		public String toString() {
			return "Empleado [toString()=" + super.toString() + ", dni=" + dni + ", cargo=" + cargo + ", password="
					+ password + "]";
		}



		


		





	


	
		
		
		
		
		
		
		
		
		
		
		
		
}
