package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_UbtnIniciarSesion;
	private JTextField textField;
	static VentanaInicio frame = new VentanaInicio();
	private JPasswordField passwordField;

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
	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 10, 805, 513);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supermercado Chonguitos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(258, 27, 275, 39);
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
				frame.setVisible(false);
				VentanaSeleccion vs = new VentanaSeleccion();
				vs.setVisible(true);
			}
		});
		
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIniciarSesion.setBounds(307, 326, 187, 33);
		panel.add(btnIniciarSesion);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(187, 159, 440, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(189, 248, 438, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Si aún no tiene una cuenta, registrese");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(84, 419, 257, 32);
		panel.add(lblNewLabel_1);
		
		JButton btnRegistrar = new JButton("Crear Cuenta");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrar.setBounds(351, 417, 187, 33);
		panel.add(btnRegistrar);
	}
}
