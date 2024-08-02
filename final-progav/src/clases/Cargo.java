package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conector.Conexion;

public class Cargo {
	
	private int idCargo;
	private String nombre;
	
	
	public Cargo() {
		super();
	}


	public Cargo(int id_cargo, String nombre) {
		super();
		this.idCargo = id_cargo;
		this.nombre = nombre;
	}


	public int getIdCargo() {
		return idCargo;
	}


	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return  nombre;
	}
		



	public static List<Cargo> mostrarCargos(){
		List<Cargo> cargos = new ArrayList<>();
		String consulta = "SELECT id_cargo, nombre_cargo FROM cargo";
		Connection conect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
	    	conect = new Conexion().conectar();
	    	stmt = conect.prepareStatement(consulta);
	    	rs = stmt.executeQuery();
			
            while (rs.next()) {
                int idCargo = rs.getInt("id_cargo");
                String nombreCargo = rs.getString("nombre_cargo");
                cargos.add(new Cargo(idCargo, nombreCargo));
            }
	    	
	    	
		} catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al cargar los productos", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conect != null) conect.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
		return cargos;	
	}








}