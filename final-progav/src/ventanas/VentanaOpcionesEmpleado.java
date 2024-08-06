package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Empleado;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.Color;

public class VentanaOpcionesEmpleado extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int idEmpleado;
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaOpcionesEmpleado frame = new VentanaOpcionesEmpleado(78);
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
	public VentanaOpcionesEmpleado(Empleado empleado) {
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
		panel.setBounds(0, 10, 840, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supermercado Chonguitos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(260, 30, 340, 49);
		panel.add(lblNewLabel);
		
        JLabel lblNewLabel_1 = new JLabel("ID Usuario:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(91, 105, 116, 24);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(230, 105, 28, 24);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setText(String.valueOf(idEmpleado));

        
        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(255, 250, 250));
        textArea.setEditable(false);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textArea.setBounds(103, 159, 621, 153);
        panel.add(textArea);
        
        String[] opciones = {
                "1 - Cargar stock de productos",
                "2 - Cargar productos",
                "3 - Eliminar productos",
                "4 - Modificar precio de productos",
                "5 - Consultar recaudación del dia",
                "6 - Registrar un usuario"
            };
        
        for (String opcion : opciones) {
            textArea.append(opcion + "\n");
        }
        JButton btnSeleccionar = new JButton("Seleccionar Opción");
        btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnSeleccionar.setBounds(316, 362, 234, 59);
        panel.add(btnSeleccionar);
        
        JButton btnNewButton = new JButton("Volver a inicio");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaBienvenida vb = new VentanaBienvenida();
        		vb.setVisible(true);
        		setVisible(false);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.setBounds(72, 436, 170, 34);
        panel.add(btnNewButton);

        btnSeleccionar.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el número de la opción que desea:");
                try {
                    int opcionSeleccionada = Integer.parseInt(input);
                    if (opcionSeleccionada >= 1 && opcionSeleccionada <= 6) {
                        mostrarVentana(opcionSeleccionada, empleado);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Número no válido. Ingrese un número entre 1 y 6.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número.");
                }
            }
        });
        }
	


		private void mostrarVentana(int opcion, Empleado empleado) {
            switch (opcion) {
                case 1:
                    new ControlStock(empleado).setVisible(true);
                    break;
                case 2:
                    new CargarProducto(empleado).setVisible(true);
                    break;
                case 3:
                    new EliminarProducto(empleado).setVisible(true);
                    break;
                case 4:
                    new ModificarPrecio(empleado).setVisible(true);
                    break;
                case 5:
                    new RecaudacionCompra(empleado).setVisible(true);
                    break;
                case 6:
                    new CargarEmpleado(empleado).setVisible(true);
                    break;
                default:
                    break;
            }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }	
}
