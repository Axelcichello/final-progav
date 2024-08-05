package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Empleado;
import clases.Globales;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_apellido;
	private JTextField textField_dni;
	private JLabel lblNewLabel_1;
	private JLabel lblNombre;
	private JButton btnConfirmar;
	//static RegistroCliente frame = new RegistroCliente();
	private JLabel lblTelefono_1;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistroCliente frame = new RegistroCliente(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegistroCliente(Empleado empleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(230, 230, 250));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 820, 529);
		panel.setBackground(new Color(230, 230, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supermercado Chonguitos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(258, 27, 275, 39);
		panel.add(lblNewLabel);
		
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(105, 194, 82, 40);
		panel.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nombre.setBounds(207, 199, 150, 32);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:\r\n");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setBounds(105, 244, 82, 40);
		panel.add(lblApellido);
		
		textField_apellido = new JTextField();
		textField_apellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_apellido.setColumns(10);
		textField_apellido.setBounds(207, 249, 150, 32);
		panel.add(textField_apellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(105, 296, 82, 40);
		panel.add(lblDni);
		
		textField_dni = new JTextField();
		textField_dni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_dni.setColumns(10);
		textField_dni.setBounds(207, 301, 150, 32);
		panel.add(textField_dni);
		
		lblNewLabel_1 = new JLabel("INGRESAR DATOS DEL CLIENTE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(105, 144, 334, 25);
		panel.add(lblNewLabel_1);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
			
					String nombre = textField_nombre.getText();
	    			if (!Globales.esSoloLetras(nombre)) {
						JOptionPane.showMessageDialog(null, "Ingrese un nombre válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			
	  
	    			String apellido = textField_apellido.getText();
	    			if (!Globales.esSoloLetras(apellido)) {
						JOptionPane.showMessageDialog(null, "Ingrese un apellido válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			
	    			
	    			int dni;
	    			try {
	    				dni = Integer.parseInt(textField_dni.getText());
		    			if (!Globales.esNumeroEnteroPositivo(dni)) {
		    				JOptionPane.showMessageDialog(null, "Ingrese un DNI válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
							return;
						}
	    				
	    				
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Ingrese un DNI válido (número entero positivo)", "Error de validación", JOptionPane.ERROR_MESSAGE);
				        return;
					}
	    			
	    			int telefono;
	    			try {
	    				telefono = Integer.parseInt(textField.getText());
		    			if (!Globales.esNumeroEnteroPositivo(telefono)) {
		    				JOptionPane.showMessageDialog(null, "Ingrese un telefono válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
							return;
		    			}
					} catch (NumberFormatException e2) {
				        JOptionPane.showMessageDialog(null, "Ingrese un teléfono válido (número entero positivo)", "Error de validación", JOptionPane.ERROR_MESSAGE);
				        return;
				    }
	    			
						
					Cliente clienteNuevo = new Cliente(nombre, apellido, telefono, dni);
					
				if (clienteNuevo.guardarCliente()) {
					JOptionPane.showMessageDialog(null, "Se guardo el cliente en la base de datos");
					setVisible(false);
					VentanaProductos vp = new VentanaProductos(clienteNuevo, empleado);
					vp.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No se guardo el cliente en la base de datos");

				}	
						
					} catch (Exception e2) {
						 e2.printStackTrace(); 
					}
				
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirmar.setBounds(524, 391, 168, 46);
		panel.add(btnConfirmar);
		
		lblTelefono_1 = new JLabel("Telefono:");
		lblTelefono_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono_1.setBounds(105, 357, 82, 40);
		panel.add(lblTelefono_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(207, 357, 150, 32);
		panel.add(textField);
		
	    JButton btnVolver = new JButton("Volver al menu");
	    btnVolver.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        setVisible(false);

	          new BusquedaCliente(empleado).setVisible(true);
	      }
	    });
	    btnVolver.setFont(new Font("Tahoma", Font.BOLD, 18));
	    btnVolver.setBounds(38, 461, 182, 39);
	    panel.add(btnVolver);
		
		
	}
}
