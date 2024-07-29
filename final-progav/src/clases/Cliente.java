package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conector.Conexion;

public class Cliente extends Usuario{
	private int numeroMembresia;

//	 // Lista de clientes para el singleton
//    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
//    
//    // Instancia del singleton
//    private static Cliente instance;
//
//	private static String nombre;
//
//	private static String apellido;
//
//	public Cliente(String nombre, String apellido, int telefono) {
//		super();
//	}
	
	
	
	
	
	
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int telefono) {
		super(nombre, apellido, telefono);
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
	
	public boolean guardarCliente() {
		Conexion con = new Conexion();
		Connection conect = con.conectar();
		
		PreparedStatement stmt;
		
		String consulta = "INSERT INTO `cliente`(`nombre_cliente`, `apellido_cliente`, `telefono_cliente`) VALUES (?,?,?)";
		try {
			stmt = conect.prepareStatement(consulta);
			stmt.setString(1, super.getNombre());
			stmt.setString(2, super.getApellido());
			stmt.setInt(3, super.getTelefono());
			stmt.executeUpdate();
			
			conect.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Hubo un error y no pudimos ejecutar la consulta" +
							e.getMessage());
			return false;
		}
	}
	
	
	///////////////////// AYE
	
//	 public static ArrayList<Cliente> obtenerClientes() {
//	        if (listaClientes.isEmpty()) {
//	            Conexion con = new Conexion();
//	            Connection conect = con.conectar();
//	            String consulta = "SELECT * FROM `cliente`";
//
//	            try (PreparedStatement stmt = conect.prepareStatement(consulta);
//	                 ResultSet rs = stmt.executeQuery()) {
//	                while (rs.next()) {
//	                    int id = rs.getInt("id_cliente");
//	                    String nombre = rs.getString("nombre_cliente");
//	                    String apellido = rs.getString("apellido_cliente");
//	                    int telefono = rs.getInt("telefono_cliente");
//	                    int numeroMembresia = rs.getInt("numero_membresia");
//	                    listaClientes.add(new Cliente(nombre, apellido, telefono, numeroMembresia));
//	                }
//	            } catch (Exception e) {
//	                System.out.println("Error al obtener los clientes: " + e.getMessage());
//	            }
//	        }
//	        return listaClientes;
//	    }
//
//	    public static Cliente getInstance() {
//	        if (instance == null) {
//	            instance = new Cliente(nombre, apellido, numeroMembresia); 
//	        }
//	        return instance;
//	    }
	
	
	
	
	
	
	
	
	
	
	
	
}
