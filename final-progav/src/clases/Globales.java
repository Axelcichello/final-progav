package clases;

public class Globales {
	
	
	public Globales() {
		super();
	}
	
	// Verifica si la cadena es solo letras
	public static boolean esSoloLetras(String input) {
	    return input != null && input.matches("[a-zA-Z ]+");
	}
	
	// Verifica si la cadena es alfanumerica
	public static boolean esAlfanumerico(String input) {
	    return input != null && input.matches("[a-zA-Z0-9 ]+");
	}
	
	// Verifica si el número es positivo 
	public static boolean esNumeroEntero(int numero) {
	    return numero >= 0; 
	}
	
	// Verifica si el número es positivo
	public static boolean esNumeroEnteroPositivo(int numero) {
	    return numero > 0; 
	}
	
	// Verifica si el número es double
	public static boolean esDouble(double numero) {
	    return numero >= 0; 
	}
	
	public static boolean esProducto(String input) {
	    return input != null && input.matches("[a-zA-Z0-9 .,'()\\s-]+");
	}

	
	
}
