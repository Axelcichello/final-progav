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
		
		JLabel lblSeleccioneUnaOpcion = new JLabel("Bienvenidos ... ");
		lblSeleccioneUnaOpcion.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblSeleccioneUnaOpcion.setBounds(343, 124, 120, 39);
		panel.add(lblSeleccioneUnaOpcion);
		
		JButton btnNewButton = new JButton("Administracion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RegistroEmpleado re = new RegistroEmpleado();
				re.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(609, 441, 179, 63);
		panel.add(btnNewButton);
		
		JButton btnVen = new JButton("REALIZAR COMPRA");
		btnVen.setBackground(new Color(102, 153, 255));
		btnVen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RegistroCliente rc = new RegistroCliente();
				rc.setVisible(true);
			}
		});
		btnVen.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnVen.setBounds(258, 214, 275, 87);
		panel.add(btnVen);
		
		
		
		
		
	}

}
