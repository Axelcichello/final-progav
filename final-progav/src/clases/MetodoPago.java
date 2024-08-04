package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import conector.Conexion;

public class MetodoPago {
	private int id;
	private String nombre;
	
	public MetodoPago() {
		super();
	}

	public MetodoPago(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	public static List<MetodoPago> obtenerMetodosPago() {
        List<MetodoPago> metodosPago = new ArrayList<>();
        Conexion con = new Conexion();
        Connection conect = con.conectar();
        
        String consulta = "SELECT * FROM metodo_pago"; // Ajusta la consulta si es necesario

        try {
            PreparedStatement stmt = conect.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_metodo_pago");
                String nombre = rs.getString("nombre_metodo_pago");
                MetodoPago metodoPago = new MetodoPago(id, nombre);
                metodosPago.add(metodoPago);
            }

            conect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return metodosPago;
    }
	
	
	
	public static MetodoPago seleccionarMetodoPago() {
        List<MetodoPago> metodosPago = MetodoPago.obtenerMetodosPago();
        
        JComboBox<MetodoPago> comboBox = new JComboBox<>();
        for (MetodoPago metodo : metodosPago) {
            comboBox.addItem(metodo);
        }

        int opcion = JOptionPane.showConfirmDialog(null, comboBox, "Seleccione un método de pago", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            return (MetodoPago) comboBox.getSelectedItem();
        } else {
            return null; // Indica que no se seleccionó ningún método de pago
        }
    }
	
}
