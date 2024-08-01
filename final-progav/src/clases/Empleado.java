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


		public boolean esAdmin() {
		    String consulta = "SELECT * FROM empleado WHERE nombre_empleado = ? AND password_empleado = ? AND cargo_empleado = 1";
		    Connection conect = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    
		    
		    try {
		    	conect = new Conexion().conectar();
		    	stmt = conect.prepareStatement(consulta);
		        stmt.setString(1, super.getNombre());
		        stmt.setString(2, this.password);
		        
		        //((ResultSet) stmt).getInt(super.getId());
		        
		        rs = stmt.executeQuery();	        
		        return rs.next();
		    } catch (SQLException e) {
		        System.out.println("Hubo un error y no pudimos ejecutar la consulta: " + e.getMessage());
		        return false;
		    } finally {
		    	try {
		            if (rs != null) rs.close();
		            if (stmt != null) stmt.close();
		            if (conect != null) conect.close();
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar los recursos: " + e.getMessage());
		        }
			}
		}


		public boolean esCajero() {
		    String consulta = "SELECT * FROM empleado WHERE nombre_empleado = ? AND password_empleado = ? AND cargo_empleado = 2";
		    Connection conect = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    
		    
		    try {
		    	conect = new Conexion().conectar();
		    	stmt = conect.prepareStatement(consulta);
		        stmt.setString(1, super.getNombre());
		        stmt.setString(2, this.password);
		        //stmt.setInt(3, cargo);
		        
		        rs = stmt.executeQuery();
		        return rs.next();
		    } catch (SQLException e) {
		        System.out.println("No tiene permitido el acceso: " + e.getMessage());
		        return false;
		    } finally {
		    	try {
		            if (rs != null) rs.close();
		            if (stmt != null) stmt.close();
		            if (conect != null) conect.close();
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar los recursos: " + e.getMessage());
		        }
			}	
		}
		

		public int obtenerIdEmpleado(String nombre, String password) {
		    String consulta = "SELECT id_empleado FROM empleado WHERE nombre_empleado = ? AND password_empleado = ?";
		    Connection conect = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    int idEmpleado = -1; // Valor predeterminado en caso de que no se encuentre el empleado

		    try {
		        // Establece la conexión a la base de datos
		        conect = new Conexion().conectar();
		        
		        // Prepara la consulta SQL
		        stmt = conect.prepareStatement(consulta);
		        stmt.setString(1, nombre);
		        stmt.setString(2, password);
		        
		        // Ejecuta la consulta
		        rs = stmt.executeQuery();
		        
		        // Si hay resultados, obtiene el ID del empleado
		        if (rs.next()) {
		            idEmpleado = rs.getInt("id_empleado");
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al obtener el ID del empleado: " + e.getMessage());
		    } finally {
		        // Cierra los recursos
		        try {
		            if (rs != null) rs.close();
		            if (stmt != null) stmt.close();
		            if (conect != null) conect.close();
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar los recursos: " + e.getMessage());
		        }
		    }

		    return idEmpleado;
		}



	


	
		
		
		
		
		
		
		
		
		
		
		
		
}
