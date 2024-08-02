package ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Globales;
import clases.Producto;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CargarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int idEmpleado;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarProducto frame = new CargarProducto(78);
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
	public CargarProducto(int id) {
		idEmpleado = id;
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
		
		JLabel lblNewLabel = new JLabel("CARGA DE PRODUCTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 32, 257, 39);
		panel.add(lblNewLabel);
		
        JLabel lblNewLabel_b = new JLabel("ID Usuario:");
        lblNewLabel_b.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_b.setBounds(517, 40, 116, 24);
        panel.add(lblNewLabel_b);
        
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(635, 41, 27, 24);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setText(String.valueOf(id));
	    
		JLabel lblNewLabel_1 = new JLabel("Ingresar datos del nuevo producto");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    lblNewLabel_1.setBounds(91, 105, 331, 24);
	    panel.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_nombre = new JLabel("Nombre: ");
	    lblNewLabel_nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_nombre.setBounds(91, 163, 87, 29);
	    panel.add(lblNewLabel_nombre);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Precio:");
	    lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_1.setBounds(91, 219, 66, 29);
	    panel.add(lblNewLabel_2_1);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Stock:");
	    lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_2.setBounds(91, 278, 60, 29);
	    panel.add(lblNewLabel_2_2);
	    
	    JLabel lblNewLabel_2_3 = new JLabel("Descripción:");
	    lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblNewLabel_2_3.setBounds(91, 329, 110, 29);
	    panel.add(lblNewLabel_2_3);
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField.setBounds(209, 166, 344, 29);
	    panel.add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_1.setColumns(10);
	    textField_1.setBounds(209, 220, 87, 29);
	    panel.add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_2.setColumns(10);
	    textField_2.setBounds(209, 279, 87, 29);
	    panel.add(textField_2);
	    
	    JTextArea textArea = new JTextArea();
	    textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textArea.setBounds(211, 334, 415, 61);
	    panel.add(textArea);
	    
	    JButton btnNewButton = new JButton("Registrar producto");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		try {
	    			String nombre = textField.getText();
		    		if (!Globales.esAlfanumerico(nombre)) {
						JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras y números", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
		    		
		    		if (Producto.buscarPorNombre(nombre)) {
					JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre");
					return;
		    		}
		    		
		    		Double precio = Double.parseDouble(textField_1.getText());
		    		if (!Globales.esDouble(precio)) {
		    			JOptionPane.showMessageDialog(null, "El precio no puede ser negativo", "Error de validación", JOptionPane.ERROR_MESSAGE);
		    			return;
					}
		    		
		    		int stock = Integer.parseInt(textField_2.getText());
		    		if (!Globales.esNumeroEntero(stock)) {
		    			JOptionPane.showMessageDialog(null, "El stock no puede ser negativo");
	        		    return;
					}
		    		
		    		
		    		String descripcion = textArea.getText();
		    		if (!Globales.esAlfanumerico(descripcion)) {
						JOptionPane.showMessageDialog(null, "La descripcion debe contener solo letras y números", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
		    		Producto pro = new Producto(nombre, precio, stock, descripcion);
		    		
		    		if(pro.guardarProducto()) {
		    			JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
		    			setVisible(false);
		    			new CargarProducto(idEmpleado).setVisible(true);;
//		    			VentanaOpcionesEmpleado voe = new VentanaOpcionesEmpleado(idEmpleado);
//		    			voe.setVisible(true);
		    		} else {
		    			JOptionPane.showMessageDialog(null, "No se pudo registrar el producto");
		    		}
		
	    		} catch (NumberFormatException ex) {
	    			JOptionPane.showMessageDialog(null, "Verifique que el precio o el stock sean correctos ");
				}catch (Exception ex) {
				    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + ex.getMessage());
				}

	    	}
	    });
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
	    btnNewButton.setBounds(488, 438, 227, 39);
	    panel.add(btnNewButton);
	    
	    JButton btnNewButton_1 = new JButton("Verificar producto");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		try {
	    			String nombre = textField.getText();
	    		if (!Globales.esAlfanumerico(nombre)) {
					JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras y números", "Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}
	    		
	    		if (Producto.buscarPorNombre(nombre)) {
				JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre");
				return;
	    		} else {
	    			JOptionPane.showMessageDialog(null, "No hay ningun producto registrado con ese nombre");
	    		}
				} catch (Exception e2) {
					// TODO: handle exception
				}

	    		
	    	}
	    });
	    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnNewButton_1.setBounds(595, 165, 184, 29);
	    panel.add(btnNewButton_1);
	    
	    JButton btnNewButton_2 = new JButton("Volver al menu");
	    btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		setVisible(false);
    			new VentanaOpcionesEmpleado(idEmpleado).setVisible(true);
	    	}
	    });
	    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnNewButton_2.setBounds(71, 438, 200, 39);
	    panel.add(btnNewButton_2);

	}

	}



