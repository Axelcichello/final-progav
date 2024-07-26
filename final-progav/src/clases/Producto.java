package clases;

public class Producto {
	
	private int id;
	private String nombre;
	private double precio;
	private double descuento;
	private String tipoPago;
	private int stock;
	private String descripcion;
	
	
	public Producto() {
		super();
	}

	
	
	public Producto(int id, String nombre, double precio, double descuento, String tipoPago, int stock,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.tipoPago = tipoPago;
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



	public double getDescuento() {
		return descuento;
	}



	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}



	public String getTipoPago() {
		return tipoPago;
	}



	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", tipoPago=" + tipoPago + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}

	
	
	
	
}
