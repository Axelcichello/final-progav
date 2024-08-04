package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Cargo;
import clases.Empleado;
import clases.Globales;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int idEmpleado;
	private JTextField textField_apellido;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private int intCargo;
	private JComboBox<Cargo> comboBox;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CargarEmpleado frame = new CargarEmpleado(78);
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
	public CargarEmpleado(Empleado empleado) {
		idEmpleado = empleado.obtenerIdEmpleado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 820, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CARGA DE EMPLEADOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(58, 25, 257, 39);
		panel.add(lblNewLabel);
		
        JLabel lblNewLabel_b = new JLabel("ID Usuario:");
        lblNewLabel_b.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_b.setBounds(563, 33, 116, 24);
        panel.add(lblNewLabel_b);
        
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(689, 34, 27, 24);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setText(String.valueOf(idEmpleado));
	    
		JLabel lblNewLabel_1 = new JLabel("Ingresar datos del nuevo empleado");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_1.setBounds(58, 74, 377, 24);
	    panel.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_nombre = new JLabel("Nombre: ");
	    lblNewLabel_nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_nombre.setBounds(58, 122, 87, 29);
	    panel.add(lblNewLabel_nombre);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("DNI:\r\n");
	    lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_1.setBounds(61, 220, 66, 29);
	    panel.add(lblNewLabel_2_1);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Teléfono:");
	    lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_2.setBounds(413, 220, 87, 29);
	    panel.add(lblNewLabel_2_2);
	    
	    JLabel lblNewLabel_2_3 = new JLabel("Cargo: ");
	    lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_3.setBounds(58, 272, 74, 29);
	    panel.add(lblNewLabel_2_3);
	    
	    JTextField textField_nombre = new JTextField();
	    textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_nombre.setBounds(156, 122, 344, 29);
	    panel.add(textField_nombre);
	    textField_nombre.setColumns(10);
	    
	    JTextField textField_dni = new JTextField();
	    textField_dni.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_dni.setColumns(10);
	    textField_dni.setBounds(156, 221, 166, 29);
	    panel.add(textField_dni);
	    
	    JTextField textField_telefono = new JTextField();
	    textField_telefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_telefono.setColumns(10);
	    textField_telefono.setBounds(528, 221, 166, 29);
	    panel.add(textField_telefono);
	    
	    JLabel lblNewLabel_nombre_1 = new JLabel("Apellido:");
	    lblNewLabel_nombre_1.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_nombre_1.setBounds(58, 169, 87, 29);
	    panel.add(lblNewLabel_nombre_1);
	    
	    textField_apellido = new JTextField();
	    textField_apellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_apellido.setColumns(10);
	    textField_apellido.setBounds(156, 170, 344, 29);
	    panel.add(textField_apellido);
	    
	    JLabel lblNewLabel_2_3_1 = new JLabel("Contraseña:");
	    lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_3_1.setBounds(58, 322, 116, 29);
	    panel.add(lblNewLabel_2_3_1);
	    
	    JLabel lblNewLabel_2_3_1_1 = new JLabel("Confirmar contraseña:");
	    lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_3_1_1.setBounds(58, 373, 200, 29);
	    panel.add(lblNewLabel_2_3_1_1);
	    
	    passwordField = new JPasswordField();
	    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    passwordField.setBounds(184, 324, 284, 28);
	    panel.add(passwordField);
	    
	    passwordField_1 = new JPasswordField();
	    passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    passwordField_1.setBounds(268, 375, 284, 28);
	    panel.add(passwordField_1);
	    
	    List<Cargo> cargos = Cargo.mostrarCargos();
	    comboBox = new JComboBox<>();
	    comboBox.addItem(new Cargo(0, " Elija un cargo"));
	    for (Cargo cargo : cargos) {
			comboBox.addItem(cargo);
		}
	    //JComboBox<Cargo> combo = new JComboBox<>(cargos.toArray(new Cargo[0]));
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		Cargo selectedCargo = (Cargo) comboBox.getSelectedItem();
	    		if (selectedCargo != null && selectedCargo.getIdCargo() != 0) {
	    			intCargo = selectedCargo.getIdCargo();					
				} else {
					intCargo = 0;
				}
	    	}
	    });
	    comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    comboBox.setBounds(156, 273, 166, 28);
	    panel.add(comboBox);
	    
	    
	    JButton btnNewButton = new JButton("Volver al menu");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		setVisible(false);
	    		new VentanaOpcionesEmpleado(empleado).setVisible(true);
	    	}
	    });
	    btnNewButton.setBounds(58, 452, 182, 39);
	    btnNewButton.setFont((new Font("Tahoma", Font.BOLD, 18)));
	    panel.add(btnNewButton);
	    
	    JButton btnRegistrarEmpleado = new JButton("Registrar empleado");
	    btnRegistrarEmpleado.addActionListener(new ActionListener() {
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
	    			
	    			int dni = Integer.parseInt(textField_dni.getText()) ;
	    			if (!Globales.esNumeroEnteroPositivo(dni)) {
	    				JOptionPane.showMessageDialog(null, "Ingrese un DNI válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			if (Empleado.validarDni(dni)) {
	    				JOptionPane.showMessageDialog(null, "Ya existe un empleado con el mismo DNI");
	    				return;
					}
	    			
	    			int telefono = Integer.parseInt(textField_telefono.getText());
	    			if (!Globales.esNumeroEnteroPositivo(telefono)) {
	    				JOptionPane.showMessageDialog(null, "Ingrese un telefono válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			
	    			int cargo = intCargo;
	    			if (cargo < 1) {
						JOptionPane.showMessageDialog(null, "Seleccione un cargo", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			
	    			String password = passwordField.getText();
	    			if (!Globales.esAlfanumerico(password)) {
	    				JOptionPane.showMessageDialog(null, "El password debe contener solo letras y números", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			
	    			String password2 = passwordField_1.getText();
	    			if (!Globales.esAlfanumerico(password2)) {
	    				JOptionPane.showMessageDialog(null, "El password debe contener solo letras y números", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
	    			
	    			if (!password.equals(password2)) {
	    				JOptionPane.showMessageDialog(null, "Los password deben coincidir", "Error de validación", JOptionPane.ERROR_MESSAGE);
	    				return;
					}
	    			
	    			
	    			Empleado em = new Empleado(nombre, apellido, telefono, dni, cargo, password);
	    			if (em.guardarEmpleado()) {
		    			JOptionPane.showMessageDialog(null, "Empleado registrado con éxito");
		    			setVisible(false);
		    			new CargarEmpleado(empleado).setVisible(true);;
					} 
	    			
	    			
	    			
	    			
				} catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(null, "Cheque los datos ingresados.");
				}
	    		
	    	}
	    });
	    btnRegistrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
	    btnRegistrarEmpleado.setBounds(528, 452, 232, 39);
	    panel.add(btnRegistrarEmpleado);
	    
	    
	    
	    
	}
}
