package clases;

public class Cliente extends Usuario{
	private int numeroMembresia;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String apellido, int telefono, int numeroMembresia) {
		super(id, nombre, apellido, telefono);
		this.numeroMembresia = numeroMembresia;
	}

	public int getNumeroMembresia() {
		return numeroMembresia;
	}

	public void setNumeroMembresia(int numeroMembresia) {
		this.numeroMembresia = numeroMembresia;
	}

	@Override
	public String toString() {
		return "Cliente [toString()=" + super.toString() + ", numeroMembresia=" + numeroMembresia + "]";
	}
	
	
}
