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
	
	
	
	
	
	
	
}