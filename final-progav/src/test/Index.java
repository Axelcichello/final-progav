package test;

import clases.Supermercado;
import ventanas.VentanaBienvenida;

public class Index {

	public static void main(String[] args) {
		Supermercado sp = Supermercado.getInstance("Super Chonguitos");
		
		VentanaBienvenida vb = new VentanaBienvenida();
		vb.setVisible(true);

	}

}
