package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conector.Conexion;

public class Producto {
	
	private int id;
	private String nombre;
	private double precio;
	private int stock;
	private String descripcion;
	
	public Producto() {
	
	}
	
	public Producto(String nombre, double precio, int stock,
			String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
	}

	
	
	public Producto(int id, String nombre, double precio, int stock,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
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



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}




	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}

	
/////////////////////////////////////////////// METODO MOSTRAR PRODUCTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static List<Producto> mostrarProductos(){
		List<Producto> productos = new ArrayList();
		String consulta = "SELECT * FROM producto";
		Connection conect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
	    	conect = new Conexion().conectar();
	    	stmt = conect.prepareStatement(consulta);
	    	rs = stmt.executeQuery();
			
			while (rs.next()) {
				productos.add(new Producto(
					rs.getInt("id_producto"),
					rs.getString("nombre_producto"),
					rs.getDouble("precio_producto"),
					rs.getInt("stock_producto"),
					rs.getString("descripcion_producto")	
					));
			}
	    	
	    	
		} catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
		return productos;	
	}
	

	/////////////////////////////////////////////// METODO ACTUALIZAR STOCK \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static boolean actualizarStock(int id, int nuevoStock) {
		String consulta = "UPDATE producto SET stock_producto = ? WHERE id_producto = ?";
		Connection conect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conect = new Conexion().conectar();
	    	stmt = conect.prepareStatement(consulta);
			stmt.setInt(1, nuevoStock);
			stmt.setInt(2, id);
			
			if (stmt.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Se modifico el stock");
				return true;
			} else {
				System.out.println("No se puedo realizar ninguna modificacion");
				return false;
			}
			
		} catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el stock", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conect != null) conect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

/////////////////////////////////////////////// METODO BUSCAR POR NOMBRE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static boolean buscarPorNombre(String nombre) {
		//Producto pr = new Producto();
		String consulta = "SELECT * FROM producto WHERE nombre_producto = ?";
		Connection conect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
	    	conect = new Conexion().conectar();
	    	stmt = conect.prepareStatement(consulta);
	    	stmt.setString(1, nombre);
	    	rs = stmt.executeQuery();
			
	    	if (rs.next()) {
	    		rs.getString("nombre_producto");
	    		return true;
			} else {
				//JOptionPane.showMessageDialog(null, "Producto no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                return false;
			}
		
		} catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Producto NO encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
		return false;
	}
	

/////////////////////////////////////////////// METODO BUSCAR POR ID \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	
	public static boolean buscarPorId(int id) {
		//Producto pr = new Producto();
		String consulta = "SELECT * FROM producto WHERE id_producto = ?";
		Connection conect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
	    	conect = new Conexion().conectar();
	    	stmt = conect.prepareStatement(consulta);
	    	stmt.setInt(1, id);
	    	rs = stmt.executeQuery();
			
	    	if (rs.next()) {
	    		rs.getString("nombre_producto");
	    		return true;
			} else {
				JOptionPane.showMessageDialog(null, "Producto no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                return false;
			}
		
		} catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Producto NO encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
		return false;
	}
	
/////////////////////////////////////////////// METODO INGRESAR PRODCUTO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public boolean guardarProducto() {
		Conexion con = new Conexion();
		Connection conect = con.conectar();
		
		PreparedStatement stmt;
		
		String consulta = "INSERT INTO `producto`(`nombre_producto`, `precio_producto`, `stock_producto`, `descripcion_producto`) VALUES (?,?,?,?)";
		
		try {
			stmt = conect.prepareStatement(consulta);
			stmt.setString(1, this.nombre);
			stmt.setDouble(2, this.precio);
			stmt.setInt(3, this.stock);
			stmt.setString(4, this.descripcion);
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
