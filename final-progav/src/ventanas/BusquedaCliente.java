package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Empleado;
import clases.Globales;

public class BusquedaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_dniBuscar;
	private String nombreEmpleado;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BusquedaCliente frame = new BusquedaCliente("empleado ");
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
	public BusquedaCliente(Empleado empleado) {
		nombreEmpleado = empleado.getNombre();
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
		//getContentPane().setLayout(null);

        textField_dniBuscar = new JTextField();
        textField_dniBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_dniBuscar.setBounds(78, 250, 135, 31);
        panel.add(textField_dniBuscar);
        textField_dniBuscar.setColumns(10);

        JLabel lblNewLabel_dni = new JLabel("INGRESE EL DNI DEL CLIENTE");
        lblNewLabel_dni.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_dni.setBounds(78, 201, 241, 39);
        panel.add(lblNewLabel_dni);

        JButton btnNewButton = new JButton("REGISTRAR CLIENTE");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);         			
    			RegistroCliente re = new RegistroCliente(empleado);
    			re.setVisible(true);
            }
        });
        btnNewButton.setBounds(530, 424, 221, 45);
        panel.add(btnNewButton);

        JButton botonBuscar = new JButton("BUSCAR");
        botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
        botonBuscar.setBounds(78, 301, 108, 39);
        panel.add(botonBuscar);
        
        JLabel lblNewLabel_dni_1 = new JLabel("Cajero: ");
        lblNewLabel_dni_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_dni_1.setBounds(470, 129, 79, 39);
        panel.add(lblNewLabel_dni_1);
        
        JLabel lblNewLabel_dni_1_1 = new JLabel("");
        lblNewLabel_dni_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_dni_1_1.setBounds(559, 129, 221, 39);
        lblNewLabel_dni_1_1.setText(nombreEmpleado);
        panel.add(lblNewLabel_dni_1_1);
        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	try {
                	int dni = Integer.parseInt(textField_dniBuscar.getText());
            		if (!Globales.esNumeroEnteroPositivo(dni)) {
                	JOptionPane.showMessageDialog(null, "Ingrese un DNI válido");
                	return;
            		}
            		Cliente clienteCompra = Cliente.verificarCliente(dni);
            		
            		
            		if (clienteCompra != null) {
            			JOptionPane.showMessageDialog(null, "Cliente encontrado");
            			setVisible(false);         			
            			VentanaProductos vp = new VentanaProductos(clienteCompra, empleado);
            			vp.setVisible(true);
            		} else {
            			JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            		}
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un DNI válido (número entero positivo)");
				}
 
            }
        });
    }
}
