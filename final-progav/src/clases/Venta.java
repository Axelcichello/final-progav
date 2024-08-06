package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import conector.Conexion;
import ventanas.BusquedaCliente;

public class Venta {
	
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private double total_venta;
	private Cliente cliente;
	private Empleado empleado;
	private MetodoPago mp;
	private Producto producto;
	private int cantidadProducto;

	public Venta() {
		super();
	}

	public Venta(LocalDate fecha, LocalTime hora, double total_venta, Cliente cliente, Empleado empleado, MetodoPago mp,
			Producto producto, int cantidadProducto) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.total_venta = total_venta;
		this.cliente = cliente;
		this.empleado = empleado;
		this.mp = mp;
		this.producto = producto;
		this.cantidadProducto = cantidadProducto;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public double getTotal_venta() {
		return total_venta;
	}


	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public MetodoPago getMp() {
		return mp;
	}


	public void setMp(MetodoPago mp) {
		this.mp = mp;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", total_venta=" + total_venta + ", cliente="
				+ cliente + ", empleado=" + empleado + ", mp=" + mp + ", producto=" + producto + ", cantidadProducto="
				+ cantidadProducto + "]";
	}
	
	
/////////////////////////////////////////////// METODO FINALIZAR LA VENTA  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	
	public static void finalizarVenta(Producto producto, int cantSeleccionada, MetodoPago metodoPagoOBJ, Cliente cliente,
			Empleado empleado, double totalVenta) {

		LocalDate fechaVenta = LocalDate.now();
		LocalTime horaVenta = LocalTime.now();

		Conexion con = new Conexion();
		Connection conect = con.conectar();

		PreparedStatement stmt;
		String consulta = "INSERT INTO `venta`(`fecha_venta`, `hora_venta`, `total_venta`, `cliente_id_venta`, `empleado_id_venta`, `metodo_pago_venta`, `producto_id_venta`, `cantidad_producto_venta`) VALUES (?,?,?,?,?,?,?,?)";

		try {
			stmt = conect.prepareStatement(consulta);
			
			stmt.setDate(1, java.sql.Date.valueOf(fechaVenta));
			stmt.setTime(2, java.sql.Time.valueOf(horaVenta));
			stmt.setDouble(3, totalVenta);
			stmt.setInt(4, cliente.obtenerIdCliente());
			stmt.setInt(5, empleado.obtenerIdEmpleado());
			stmt.setInt(6, metodoPagoOBJ.getId());
			stmt.setInt(7, producto.getId());
			stmt.setInt(8, cantSeleccionada);

			stmt.executeUpdate();
			conect.close();
			
			JOptionPane.showMessageDialog(null, "La compra se realizo satisfactoriamente");			
//			BusquedaCliente bc = new BusquedaCliente(empleado);
//			bc.setVisible(true);

		} catch (Exception e) {
			System.out.println("Hubo un error y no pudimos ejecutar la consulta" + e.getMessage());
			 e.printStackTrace(); 
		}
	}
	
	
/////////////////////////////////////////////// METODO MOSTRAR RECAUDACION \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	
	
	public static double recaudacionDia(java.util.Date fecha2) {
		String consulta = "SELECT SUM(total_venta) AS total_del_dia FROM venta WHERE fecha_venta = ?";
		Connection conect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
            Conexion con = new Conexion();
            conect = con.conectar();
            stmt = conect.prepareStatement(consulta);
            stmt.setDate(1, new java.sql.Date(fecha2.getTime()));
            rs = stmt.executeQuery();
            
            if (rs.next()) {
            	
            	return rs.getDouble("total_del_dia");
            }			
		} catch (SQLException e) {
	        e.printStackTrace(); 
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conect != null) conect.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return 0;
	}
	


	
	
	
	
	
	
}
