package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

/////////////////////////////////////////////// METODO ES ADMINISTRADOR \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
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


/////////////////////////////////////////////// METODO ES CAJERO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
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
		

/////////////////////////////////////////////// METODO OBTENER ID EMPLEADO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		public int obtenerIdEmpleado() {
		    String consulta = "SELECT id_empleado FROM empleado WHERE nombre_empleado = ? AND password_empleado = ?";
		    Connection conect = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    int idEmpleado = -1; 

		    try {
		        conect = new Conexion().conectar();
		        stmt = conect.prepareStatement(consulta);
		        stmt.setString(1, super.getNombre());
		        stmt.setString(2, this.password);
		        rs = stmt.executeQuery();
		        
		        
		        if (rs.next()) {
		            idEmpleado = rs.getInt("id_empleado");
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al obtener el ID del empleado: " + e.getMessage());
		    } finally {
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

		
/////////////////////////////////////////////// METODO VALIDAR DNI  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		public static boolean validarDni(int dni) {
			String consulta = "SELECT * FROM empleado WHERE dni_empleado = ?";
			Connection conect = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
		    	conect = new Conexion().conectar();
		    	stmt = conect.prepareStatement(consulta);
		    	stmt.setInt(1, dni);
		    	rs = stmt.executeQuery();
				
		    	if (rs.next()) {
		    		return true;
				} else {
	                return false;
				}
			
			} catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Producto NO encontrado", "Error", JOptionPane.ERROR_MESSAGE);
	        }
			return false;
		}
			
			
/////////////////////////////////////////////// METODO INGRESAR EMPLEADO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		public boolean guardarEmpleado() {
			Conexion con = new Conexion();
			Connection conect = con.conectar();

			PreparedStatement stmt;

			String consulta = "INSERT INTO `empleado`(`nombre_empleado`, `apellido_empleado`, `dni_empleado`, `telefono_empleado`, `password_empleado`,`cargo_empleado`) "
					+ "VALUES (?,?,?,?,?,?)";

			try {
				stmt = conect.prepareStatement(consulta);
				stmt.setString(1, super.getNombre());
				stmt.setString(2, super.getApellido());
				stmt.setInt(3, this.dni);
				stmt.setInt(4, super.getTelefono());
				stmt.setString(5, this.password);
				stmt.setInt(6, this.cargo);
				stmt.executeUpdate();

				conect.close();
				return true;

			} catch (Exception e) {
				System.out.println("Hubo un error y no pudimos ejecutar la consulta" + e.getMessage());
				return false;
			}
		}

	
		
		
		
		
		
		
		
		
		
		
		
		
}
