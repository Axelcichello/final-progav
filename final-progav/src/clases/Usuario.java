package clases;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String password;
	private int dni;
	private int telefono;
	private int cargo;
	
	
	public Usuario() {
		super();
	}


	public Usuario(int id, String nombre, String apellido, String password, int dni, int telefono, int cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.dni = dni;
		this.telefono = telefono;
		this.cargo = cargo;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getCargo() {
		return cargo;
	}


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password
				+ ", dni=" + dni + ", telefono=" + telefono + ", cargo=" + cargo + "]";
	}
}
