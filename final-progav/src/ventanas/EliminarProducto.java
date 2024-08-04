package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Empleado;
import clases.Globales;
import clases.Producto;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EliminarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private int idEmpleado;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EliminarProducto frame = new EliminarProducto(78);
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
	public EliminarProducto(Empleado empleado) {
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
		panel.setBounds(10, 10, 820, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELIMINAR PRODUCTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 32, 241, 39);
		panel.add(lblNewLabel);
		
        JLabel lblNewLabel_b = new JLabel("ID Usuario:");
        lblNewLabel_b.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_b.setBounds(524, 40, 116, 24);
        panel.add(lblNewLabel_b);
        
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(650, 41, 23, 24);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setText(String.valueOf(idEmpleado));
        
        JLabel lblNewLabel_1 = new JLabel("Lista de Productos");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(93, 118, 179, 24);
        panel.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(91, 152, 624, 239);
        panel.add(scrollPane);
        
        tabla = new JTable();
        scrollPane.setViewportView(tabla);
        
        JButton btnNewButton = new JButton("Eliminar producto");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {

        			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del producto"));
        			if (!Globales.esNumeroEntero(id)) {
            		    JOptionPane.showMessageDialog(null, "El id no puede ser negativo.");
            		    return;
            		}
        			
        			Producto pr = Producto.buscarPorId(id);
        			
        			if (pr == null) {
        				JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        				return;
					} 
        			
        			if (pr.mostrarUnProducto()) {
						if (pr.eliminarProducto()) {
							JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
							cargarProductos();
						} 
					} 	
				}  catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
				} catch (Exception ex) {
				    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + ex.getMessage());
				}
        		
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnNewButton.setBounds(524, 437, 191, 39);
        panel.add(btnNewButton);
        
        JButton btnVolverAlMenu = new JButton("Volver al menu");
        btnVolverAlMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
    			new VentanaOpcionesEmpleado(empleado).setVisible(true);;
        	}
        });
        btnVolverAlMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnVolverAlMenu.setBounds(91, 437, 191, 39);
        panel.add(btnVolverAlMenu);
        
	    JButton btnNewButton_2 = new JButton("Volver al menu");
	    btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		setVisible(false);
    			new VentanaOpcionesEmpleado(empleado).setVisible(true);;
	    	}
	    });
        
        cargarProductos();
        
     }   

	
	
     private void cargarProductos() {
    	 List<Producto> productos = Producto.mostrarProductos();
    	 
    	 DefaultTableModel model = new DefaultTableModel();
    	 model.addColumn("ID");
    	 model.addColumn("Nombre");
    	 model.addColumn("Precio");
    	 model.addColumn("Stock");
    	 model.addColumn("Descripción");
    	 
    	 for (Producto producto : productos) {
			model.addRow(new Object[]{
					producto.getId(),
					producto.getNombre(),
					producto.getPrecio(),
					producto.getStock(),
					producto.getDescripcion()			
			});
		}
    	 tabla.setModel(model);
    }
     


}
