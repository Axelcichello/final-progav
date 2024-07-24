package clases;

public class Producto {
	
	private int id;
	private String nombre;
	private int stock;
	private String descripcion;
	
	
	public Producto() {
		super();
	}


	public Producto(int id, String nombre, int stock, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
