package clases;

public class ProductoVenta {
	
	private int venta;
	private int producto;
	private int cantidad;
	
	
	public ProductoVenta() {
		super();
	}


	public ProductoVenta(int venta, int producto, int cantidad) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public int getVenta() {
		return venta;
	}


	public void setVenta(int venta) {
		this.venta = venta;
	}


	public int getProducto() {
		return producto;
	}


	public void setProducto(int producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "ProductoVenta [venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
}
