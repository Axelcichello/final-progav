package clases;

public class Cargo {
	
	private int cargo;
	private String nombre;
	
	
	public Cargo() {
		super();
	}


	public Cargo(int cargo, String nombre) {
		super();
		this.cargo = cargo;
		this.nombre = nombre;
	}


	public int getCargo() {
		return cargo;
	}


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Cargo [cargo=" + cargo + ", nombre=" + nombre + "]";
	}
		
}
