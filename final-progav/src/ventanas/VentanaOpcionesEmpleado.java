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
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

public class VentanaOpcionesEmpleado extends JFrame {

	private static String nombre;
	//private String password;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static VentanaOpcionesEmpleado frame = new VentanaOpcionesEmpleado(nombre);
	
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
	public VentanaOpcionesEmpleado(String nombre) {
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
		
        JLabel lblNewLabel_1 = new JLabel("Bienvenido:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(91, 105, 116, 24);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(225, 105, 413, 24);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setText(nombre);
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setBounds(91, 150, 600, 150);
        textArea.setEditable(false);
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
        btnSeleccionar.setBounds(325, 320, 150, 30);
        panel.add(btnSeleccionar);

        btnSeleccionar.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el número de la opción que desea:");
                try {
                    int opcionSeleccionada = Integer.parseInt(input);
                    if (opcionSeleccionada >= 1 && opcionSeleccionada <= 6) {
                        JOptionPane.showMessageDialog(null, "Opción seleccionada: " + opciones[opcionSeleccionada - 1]);
                        mostrarVentana(opcionSeleccionada);
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Número no válido. Ingrese un número entre 1 y 6.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número.");
                }
            }
        });
        }
	
	
	
	
        private void mostrarVentana(int opcion) {
            switch (opcion) {
                case 1:
                    new ControlStock().setVisible(true);
                    break;
                case 2:
                    //new VentanaOpcion2().setVisible(true);
                    break;
                case 3:
                    //new VentanaOpcion3().setVisible(true);
                    break;
                case 4:
                    //new VentanaOpcion4().setVisible(true);
                    break;
                case 5:
                   // new VentanaOpcion5().setVisible(true);
                    break;
                case 6:
                    //new VentanaOpcion6().setVisible(true);
                    break;
                default:
                    break;
            }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }	
}
