package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

	Connection con;
	
	public Connection conectar() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado", "root", "");
			//JOptionPane.showMessageDialog(null, "Se conecto a la BBDD");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se conecto a la BBDD");
			e.printStackTrace();
		}
		
		
		return con;
	}
}
