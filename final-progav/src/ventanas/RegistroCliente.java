package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;

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
	private JTextField textField_telefono;
	private JLabel lblNewLabel_1;
	private JLabel lblNombre;
	private JButton btnConfirmar;
	static RegistroCliente frame = new RegistroCliente();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public RegistroCliente() {
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
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(105, 296, 82, 40);
		panel.add(lblTelefono);
		
		textField_telefono = new JTextField();
		textField_telefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_telefono.setColumns(10);
		textField_telefono.setBounds(207, 301, 150, 32);
		panel.add(textField_telefono);
		
		lblNewLabel_1 = new JLabel("INGRESAR DATOS DEL CLIENTE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(105, 132, 334, 25);
		panel.add(lblNewLabel_1);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField_nombre.getText();
				String apellido = textField_apellido.getText();
				int telefono = Integer.parseInt(textField_telefono.getText());
				
				Cliente cl = new Cliente(nombre, apellido, telefono);
				if (cl.guardarCliente()) {
					JOptionPane.showMessageDialog(null, "Se guardo el cliente en la base de datos");
					frame.setVisible(false);
					VentanaProductos vp = new VentanaProductos(nombre);
					vp.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No se guardo el cliente en la base de datos");

				}
				
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirmar.setBounds(524, 391, 168, 46);
		panel.add(btnConfirmar);
		
		
	}

}
