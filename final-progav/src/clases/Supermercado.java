package clases;


public class Supermercado {
	
	  private String nombre;
	  private static Supermercado instance;
	  
	  
	  private Supermercado(String nombre) {
		    this.nombre = nombre;
		    
		  }

		  public static Supermercado getInstance(String nombre) {
		    if(instance == null) {
		      instance = new Supermercado(nombre);
		    }
		    return instance;
		  }
		  
		  
		    public String getNombre() {
		        return nombre;
		    }
	
		   
}
