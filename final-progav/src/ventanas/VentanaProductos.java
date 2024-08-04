package ventanas;


import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import clases.Cliente;
import clases.Empleado;
import clases.Globales;
import clases.MetodoPago;
import clases.Producto;
import clases.Venta;

import javax.swing.JScrollPane;


public class VentanaProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProductos;
	//private static String nombre;
	//VentanaProductos frame = new VentanaProductos(String, int);
	private String nombreCliente;
	private String nombreEmpleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProductos frame = new VentanaProductos(null, null);
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
	public VentanaProductos(Cliente cliente, Empleado empleado) {
		//nombreCliente = cliente.getNombre();
		nombreCliente = cliente.getNombre();
		nombreEmpleado = empleado.getNombre();
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
		
		
        JLabel lblNewLabel_1 = new JLabel("Cliente:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(91, 105, 116, 24);
        panel.add(lblNewLabel_1);
		
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(196, 105, 174, 24);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setText(nombreCliente);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 215, 608, 186);
		panel.add(scrollPane);
		
		tablaProductos = new JTable();
		scrollPane.setViewportView(tablaProductos);
		
		JLabel lblNewLabel1 = new JLabel("Seleccionar el producto a comprar:");
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel1.setBounds(91, 170, 291, 24);
		panel.add(lblNewLabel1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cajero:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(542, 115, 140, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(628, 111, 177, 34);
		lblNewLabel_2_1.setText(nombreEmpleado);
		panel.add(lblNewLabel_2_1);
		
		cargarProductos(cliente, empleado);
	}		
			
	
	private void cargarProductos(Cliente cliente, Empleado empleado) {
	    List<Producto> productos = Producto.mostrarProductos();
	    
	    DefaultTableModel model = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            // Hacer editable solo la columna "Seleccionar"
	            return column == 3;
	        }

	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            // Necesario para que funcione el JRadioButton
	            if (columnIndex == 3) {
	                return Boolean.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
	    };
	    
	    model.addColumn("Nombre");
	    model.addColumn("Precio");
	    model.addColumn("Descripción");
	    model.addColumn("Seleccionar");
	    
	    for (Producto producto : productos) {
	        model.addRow(new Object[]{
	                producto.getNombre(),
	                producto.getPrecio(),
	                producto.getDescripcion(),
	                false // Inicialmente, el JRadioButton está desmarcado
	        });
	    }
	    
	    tablaProductos.setModel(model);
	    
	    // Configurar el renderizador para la columna de selección
	    tablaProductos.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer() {
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            JCheckBox checkBox = new JCheckBox();
	            checkBox.setSelected((boolean)value);
	            checkBox.setHorizontalAlignment(JCheckBox.CENTER);
	            if (isSelected) {
	                checkBox.setBackground(table.getSelectionBackground());
	            } else {
	                checkBox.setBackground(table.getBackground());
	            }
	            return checkBox;
	        }
	    });
	    
	    // Configurar el editor para la columna de selección
	    JCheckBox checkBox = new JCheckBox();
	    DefaultCellEditor editor = new DefaultCellEditor(checkBox);
	    tablaProductos.getColumnModel().getColumn(3).setCellEditor(editor);
	    
	    // ButtonGroup para asegurar que solo un producto pueda ser seleccionado a la vez
	    ButtonGroup buttonGroup = new ButtonGroup();

	    // Agregar TableModelListener para manejar la selección de productos
	    model.addTableModelListener(e -> {
	        if (e.getType() == TableModelEvent.UPDATE) {
	            int row = e.getFirstRow();
	            int column = e.getColumn();
	            if (column == 3) {
	                Boolean isSelected = (Boolean) model.getValueAt(row, column);
	                if (isSelected) {
	                    for (int i = 0; i < model.getRowCount(); i++) {
	                        if (i != row && (Boolean) model.getValueAt(i, column)) {
	                            model.setValueAt(false, i, column);
	                        }
	                    }
	                }
	                // Aquí puedes manejar lo que deseas hacer con el producto seleccionado
	                Producto productoSeleccionado = productos.get(row);	                
	                try {
	                    // Intentar obtener la entrada del usuario
	                    String input = JOptionPane.showInputDialog("Seleccione la cantidad a comprar");
	                    
	                    // Verificar si se canceló el diálogo
	                    if (input == null) {
	                        return;
	                    }
	                    
	                    // Intentar convertir la entrada a un número entero
	                    int cantSeleccionada = Integer.parseInt(input);
	                    
	                    // Verificar si el número es positivo
	                    if (cantSeleccionada <= 0) {
	                        JOptionPane.showMessageDialog(this, "La cantidad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
	                        model.setValueAt(false, row, column);
	                        return;
	                    }
	                    
						MetodoPago metodoPago = MetodoPago.seleccionarMetodoPago();

						if (metodoPago != null) {
							// Abrir la ventana de ticket con el producto seleccionado
							TicketCompra ticket = new TicketCompra(productoSeleccionado, cantSeleccionada, metodoPago, cliente, empleado);
							ticket.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(this, "No se seleccionó ningún método de pago. Venta cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
						}

	                } catch (NumberFormatException em) {
	                    // Si ocurre una NumberFormatException, significa que el input no es un número
	                    JOptionPane.showMessageDialog(this, "Solo se permiten números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
	                    model.setValueAt(false, row, column);
	                } catch (Exception em) {
	                    // Manejo de otras excepciones
	                    em.printStackTrace(); // O algún otro manejo de excepción
	                }
	                
	                
	            }
	        }
	    });
	}
}
