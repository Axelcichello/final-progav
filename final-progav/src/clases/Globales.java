package clases;

public class Globales {
	
	
	public Globales() {
		super();
	}

	public static boolean esSoloLetras(String input) {
	    return input != null && input.matches("[a-zA-Z]+");
	}
	
	public static boolean esAlfanumerico(String input) {
	    return input != null && input.matches("[a-zA-Z0-9 ]+");
	}
	
	
	public static boolean esNumeroEntero(int numero) {
	    return numero >= 0; // Verifica si el número es positivo
	}
	
	public static boolean esNumeroEnteroPositivo(int numero) {
	    return numero > 0; // Verifica si el número es positivo
	}
	
	
	public static boolean esDouble(double numero) {
	    return numero >= 0; // Verifica si el número es positivo
	}
	
}
