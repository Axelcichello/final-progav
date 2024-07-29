package clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Venta {
	
	private int id;
	private int cajero;
	private LocalDate fecha;
	private LocalTime hora;
	private int cliente;
	private double total_venta;
	
	
	public Venta() {
		super();
	}


	public Venta(int id, int cajero, LocalDate fecha, LocalTime hora, int cliente, double total_venta) {
		super();
		this.id = id;
		this.cajero = cajero;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.total_venta = total_venta;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCajero() {
		return cajero;
	}


	public void setCajero(int cajero) {
		this.cajero = cajero;
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


	public int getCliente() {
		return cliente;
	}


	public void setCliente(int cliente) {
		this.cliente = cliente;
	}


	public double getTotal_venta() {
		return total_venta;
	}


	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}


	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente
				+ ", total_venta=" + total_venta + "]";
	}
	
	public void generarTicket() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
