package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Globales;
import clases.Producto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlStock extends JFrame {

	private static final long serialVersionUID = 1L;
	//private String nombreUsuario;
	private JPanel contentPane;
	private JTable tabla;
	private int idEmpleado;
	
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlStock frame = new ControlStock(0);
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
	public ControlStock(int id) {
		idEmpleado = id;
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
		
		JLabel lblNewLabel = new JLabel("CONTROL DE STOCK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 32, 211, 39);
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
        lblNewLabel_1.setBounds(91, 139, 179, 24);
        panel.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(91, 189, 600, 300);
        panel.add(scrollPane);
        
        tabla = new JTable();
        scrollPane.setViewportView(tabla);
        
        JButton btnNewButton = new JButton("Actualizar Stock");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {

        			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del producto"));
        			if (!Globales.esNumeroEntero(id)) {
            		    JOptionPane.showMessageDialog(null, "El id no puede ser negativo.");
            		    return;
            		}
        			
        			if (!Producto.buscarPorId(id)) {
        				return;
					}
        			
            		int stock = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nuevo stock"));
            		if (!Globales.esNumeroEntero(stock)) {
            		    JOptionPane.showMessageDialog(null, "El número no puede ser negativo.");
            		    return;
            		}
            		
            		if (Producto.actualizarStock(id, stock)) {
    					JOptionPane.showMessageDialog(null, "Actualización con éxito");
    					cargarProductos();
    				} else {
    					JOptionPane.showMessageDialog(null, "No se pudo actualizar, chequee los datos");
    				}
				}  catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(null, "El stock debe ser un número válido.");
				} catch (Exception ex) {
				    JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + ex.getMessage());
				}
        		
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnNewButton.setBounds(558, 132, 191, 39);
        panel.add(btnNewButton);
        
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
