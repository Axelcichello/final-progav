package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conector.Conexion;

public class Empleado extends Usuario{

		private int dni;
		private int cargo;
		private String password;
		
		
		public Empleado(String nombre, String password) {
			 super(nombre, null, 0); 
		        this.password = password;
		}


		public Empleado(String nombre, String apellido, int telefono, int dni, int cargo, String password) {
			super(nombre, apellido, telefono);
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


		public boolean ingresoEmpleado() {
		    String consulta = "SELECT 1 FROM empleado WHERE nombre_empleado = ? AND password_empleado = ?";
		    
		    try (Connection conect = new Conexion().conectar();
		         PreparedStatement stmt = conect.prepareStatement(consulta)) {

		        stmt.setString(1, super.getNombre());
		        stmt.setString(2, this.password);
		        
		        //System.out.println("Consultando con nombre: " + super.getNombre() + " y password: " + this.password);

		        try (ResultSet rs = stmt.executeQuery()) {
		            return rs.next(); // Retorna true si hay un resultado, false en caso contrario
		        }
		    } catch (SQLException e) {
		        System.out.println("Hubo un error y no pudimos ejecutar la consulta: " + e.getMessage());
		        return false;
		    }
		}



		





	


	
		
		
		
		
		
		
		
		
		
		
		
		
}
