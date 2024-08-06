package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import clases.Globales;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class RegistroEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_usuario;
	private JPasswordField passwordField;
	private String seccionSeleccionada;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistroEmpleado frame = new RegistroEmpleado("");
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
	
	public RegistroEmpleado(String seccion) {
		seccionSeleccionada = seccion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(25, 10, 805, 513);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supermercado Chonguitos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(208, 49, 419, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_Contraseña = new JLabel("Usuario:");
		lblNewLabel_Contraseña.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_Contraseña.setBounds(65, 159, 92, 39);
		panel.add(lblNewLabel_Contraseña);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(65, 248, 114, 39);
		panel.add(lblNewLabel_1_1);
		
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField_usuario.getText();
				String password = passwordField.getText();

				
			    if (!Globales.esSoloLetras(nombre)) {
			        JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras", "Error de validación", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
			    
			    if (!Globales.esAlfanumerico(password)) {
					JOptionPane.showMessageDialog(null, "El password debe contener solo letras y números", "Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
			    }
			    

				Empleado empleado = new Empleado(nombre, password);
				
				if (seccionSeleccionada.equals("COMPRAS") && empleado.esAdmin()) {
                    JOptionPane.showMessageDialog(null, "No puedes acceder a la sección Compras como Administrador", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                    return;
				} else if (seccionSeleccionada.equals("ADMINISTRACION") && empleado.esCajero()) {
                    JOptionPane.showMessageDialog(null, "No puedes acceder a la sección Administracion como Cajero", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                    return;
				} else if (seccionSeleccionada.equals("COMPRAS") && empleado.esCajero()) {
					JOptionPane.showMessageDialog(null, "Ingreso permitido","Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					BusquedaCliente bc = new BusquedaCliente(empleado);
					bc.setVisible(true);
				} else if (seccionSeleccionada.equals("ADMINISTRACION") && empleado.esAdmin()) {
					JOptionPane.showMessageDialog(null, "Ingreso permitido","Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					VentanaOpcionesEmpleado voe = new VentanaOpcionesEmpleado(empleado);
					voe.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Ingreso denegado, usuario o contraseña incorrectos","Acceso denegado", JOptionPane.ERROR_MESSAGE);
					}
				

			}
		});
		
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnIniciarSesion.setBounds(291, 350, 234, 54);
		panel.add(btnIniciarSesion);
		
		textField_usuario = new JTextField();
		textField_usuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_usuario.setBounds(187, 159, 440, 32);
		panel.add(textField_usuario);
		textField_usuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(189, 248, 438, 32);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Volver al inicio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBienvenida vb = new VentanaBienvenida();
        		vb.setVisible(true);
        		setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(65, 438, 163, 39);
		panel.add(btnNewButton);

		

	}
}
