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

public class VentanaSeleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static VentanaSeleccion frame = new VentanaSeleccion();

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
	public VentanaSeleccion() {
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
		
		JLabel lblSeleccioneUnaOpcion = new JLabel("Seleccione una opcion");
		lblSeleccioneUnaOpcion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSeleccioneUnaOpcion.setBounds(289, 136, 206, 39);
		panel.add(lblSeleccioneUnaOpcion);
		
		JButton btnNewButton = new JButton("Administracion");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(112, 270, 179, 63);
		panel.add(btnNewButton);
		
		JButton btnVen = new JButton("Ventas");
		btnVen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				VentanaProductos vp = new VentanaProductos();
				vp.setVisible(true);
			}
		});
		btnVen.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnVen.setBounds(481, 270, 179, 63);
		panel.add(btnVen);
		
		
		
		
		
	}

}
