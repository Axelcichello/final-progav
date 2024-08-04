package clases;

import java.time.LocalDate;
import java.time.LocalTime;

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



	public Venta(LocalDate fecha, LocalTime hora, double total_venta, Cliente cliente, Empleado empleado,
		MetodoPago mp, Producto producto, int cantidadProducto) {
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
	
	
	public void generarTicket() {
		
	}
	
	
	
	
	
	
	
	
	
	
}
