package clases;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conector.Conexion;

public class Cliente extends Usuario{
	private int dni;

	
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int telefono, int dni) {
		super(nombre, apellido, telefono);
		this.dni = dni;
	}
		

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + "]";
	}

	
/////////////////////////////////////////////// METODO GUARDAR CLIENTE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public boolean guardarCliente() {
		Conexion con = new Conexion();
		Connection conect = con.conectar();
		
		PreparedStatement stmt;
		
		String consulta = "INSERT INTO `cliente`(`nombre_cliente`, `apellido_cliente`, `telefono_cliente`, `dni_cliente`) VALUES (?,?,?,?)";
		try {
			stmt = conect.prepareStatement(consulta);
			stmt.setString(1, super.getNombre());
			stmt.setString(2, super.getApellido());
			stmt.setInt(3, super.getTelefono());
			stmt.setInt(4, getDni());
			stmt.executeUpdate();
			
			conect.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Hubo un error y no pudimos ejecutar la consulta" +
							e.getMessage());
			return false;
		}
	}
	
	
/////////////////////////////////////////////// METODO VERIFICAR CLIENTE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static Cliente verificarCliente(int dni) {
        Connection conect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Conexion con = new Conexion();
            conect = con.conectar();

            String consulta = "SELECT * FROM `cliente` WHERE `dni_cliente` = ?";
            stmt = conect.prepareStatement(consulta);
            stmt.setInt(1, dni);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente clienteEncontrado = new Cliente(
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getInt("telefono_cliente"),
                    rs.getInt("dni_cliente")
                );
                
                clienteEncontrado.setId(rs.getInt("id_cliente"));
                return clienteEncontrado;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos en el bloque finally
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conect != null) conect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
	
	
/////////////////////////////////////////////// METODO OBTENER ID CLIENTE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public int obtenerIdCliente() {
	    String consulta = "SELECT id_cliente FROM cliente WHERE telefono_cliente = ?";
	    Connection conect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int idCliente = -1; 

	    try {
	        conect = new Conexion().conectar();
	        stmt = conect.prepareStatement(consulta);
	        stmt.setInt(1, this.getTelefono());

	        rs = stmt.executeQuery();
	        
	        
	        if (rs.next()) {
	            idCliente = rs.getInt("id_cliente");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener el dni del cliente: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conect != null) conect.close();
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar los recursos: " + e.getMessage());
	        }
	    }

	    return idCliente;
	}
	
/////////////////////////////////////////////// METODO OBTENER NOMBRE CLIENTE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public String obtenerNombreCliente(int dni) {
	    String consulta = "SELECT nombre_cliente, apellido_cliente FROM cliente WHERE dni_cliente = ?";
	    Connection conect = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String nombreCliente = null;
	    try {
	        conect = new Conexion().conectar();
	        stmt = conect.prepareStatement(consulta);
	        stmt.setInt(1, dni);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            nombreCliente = rs.getString("nombre_cliente");      
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener el dni del cliente: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conect != null) conect.close();
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar los recursos: " + e.getMessage());
	        }
	    }

	    return nombreCliente;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
