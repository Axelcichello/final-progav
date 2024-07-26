package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conector.Conexion;

public class Cliente extends Usuario{
	private int numeroMembresia;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int telefono) {
		super(nombre, apellido, telefono);
		this.numeroMembresia = numeroMembresia;
	}

	public int getNumeroMembresia() {
		return numeroMembresia;
	}

	public void setNumeroMembresia(int numeroMembresia) {
		this.numeroMembresia = numeroMembresia;
	}

	@Override
	public String toString() {
		return "Cliente [toString()=" + super.toString() + ", numeroMembresia=" + numeroMembresia + "]";
	}
	
	public boolean guardarCliente() {
		Conexion con = new Conexion();
		Connection conect = con.conectar();
		
		PreparedStatement stmt;
		
		String consulta = "INSERT INTO `cliente`(`nombre_cliente`, `apellido_cliente`, `telefono_cliente`) VALUES (?,?,?)";
		try {
			stmt = conect.prepareStatement(consulta);
			stmt.setString(1, super.getNombre());
			stmt.setString(2, super.getApellido());
			stmt.setInt(3, super.getTelefono());
			stmt.executeUpdate();
			
			conect.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Hubo un error y no pudimos ejecutar la consulta" +
							e.getMessage());
			return false;
		}
	}
	
	
	
	
}
