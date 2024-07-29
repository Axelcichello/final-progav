package ventanas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Producto;
import clases.Venta;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;

public class FormularioCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Producto producto;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textField;
	private boolean actualizarStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioCompra frame = new FormularioCompra(producto);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioCompra(Producto producto) {
		this.producto = producto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 820, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JComboBox comboPago = new JComboBox<>(new String[] {"Debito", "Efectivo"});
		comboPago.setBounds(150, 150, 200, 25);
		panel.add(comboPago);
		
		JLabel lblPago = new JLabel("Metodo de Pago");
		lblPago.setBounds(30, 150, 120, 25);
		panel.add(lblPago);
		
		JButton btnConfirmar = new JButton("Confirmar Compra");
		btnConfirmar.setBounds(150, 200, 150, 25);
		panel.add(btnConfirmar);
		
		JLabel lblCliente = new JLabel("Seleccionar Cliente");
		lblCliente.setBounds(30, 100, 120, 25);
		panel.add(lblCliente);
		
		JComboBox comboClientes = new JComboBox<>();
        cargarClientes();
		comboClientes.setBounds(150, 100, 200, 25);
		panel.add(comboClientes);
	}
	
	 private void cargarClientes() {
	        ArrayList<Cliente> clientes = Cliente.obtenerClientes();
	        for (Cliente cliente : clientes) {
	            JComboBox comboClientes = null;
				comboClientes.addItem(cliente);
	        }
	    }
	 
	 
	    private void realizarCompra() {
	        JComboBox comboClientes = null;
			Cliente cliente = (Cliente) comboClientes.getSelectedItem();
	        if (cliente != null) {
	            JComboBox comboPago = null;
				String metodoPago = (String) comboPago.getSelectedItem();
	            double descuento = metodoPago.equals("Efectivo") ? 0.1 : 0.0;
	            double total = producto.getPrecio() * (1 - descuento);

	            Venta venta = new Venta();
	            venta.generarTicket();
	            actualizarStock = Producto.actualizarStock();
	            dispose();
	        } else {
	            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.");
	        }
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
