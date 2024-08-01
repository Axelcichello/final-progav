package ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaBienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static VentanaBienvenida frame = new VentanaBienvenida();
	private static String seccionSeleccionada;

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
	public VentanaBienvenida() {
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
		
		JLabel lblSeleccioneUnaOpcion = new JLabel("Bienvenidos ");
		lblSeleccioneUnaOpcion.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSeleccioneUnaOpcion.setBounds(317, 124, 142, 39);
		panel.add(lblSeleccioneUnaOpcion);
		
		JButton btnNewButton = new JButton("ADMINISTRACION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seccionSeleccionada = "ADMINISTRACION";
				frame.setVisible(false);
				RegistroEmpleado re = new RegistroEmpleado(seccionSeleccionada);
				re.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(459, 277, 207, 63);
		panel.add(btnNewButton);
		
		JButton btnCompras = new JButton("COMPRAS");
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seccionSeleccionada = "COMPRAS";
				frame.setVisible(false);
				RegistroEmpleado re = new RegistroEmpleado(seccionSeleccionada);
				re.setVisible(true);
			}
		});
		btnCompras.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCompras.setBounds(153, 277, 216, 58);
		panel.add(btnCompras);
	}
	
	public static String getSeccionSeleccionada() {
		return seccionSeleccionada;
	}
	
	

}
