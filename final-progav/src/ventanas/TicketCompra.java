package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Empleado;
import clases.MetodoPago;
import clases.Producto;
import clases.Venta;

public class TicketCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String nombreCliente;
	private String nombreEmpleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketCompra frame = new TicketCompra(null, 31, null, null, null);
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
	public TicketCompra(Producto producto, int cantSeleccionada, MetodoPago metodoPagoOBJ, Cliente cliente, Empleado empleado) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
		nombreCliente = cliente.getNombre();
		nombreEmpleado = empleado.getNombre();
		
		
//		
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 854, 586); // Mismo tamaño que VentanaProductos
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
		
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

        JLabel lblTitulo = new JLabel("Ticket de Compra");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(30, 95, 200, 30);
        panel.add(lblTitulo);

        JLabel lblNombre = new JLabel("Producto: " + producto.getNombre());
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNombre.setBounds(30, 163, 300, 25);
        panel.add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio: $" + producto.getPrecio());
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPrecio.setBounds(30, 198, 300, 25);
        panel.add(lblPrecio);

        JLabel lblDescripcion = new JLabel("Descripción: " + producto.getDescripcion());
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDescripcion.setBounds(30, 233, 400, 25);
        panel.add(lblDescripcion);
        
        JLabel lblCantidad = new JLabel("Cantidad: " + cantSeleccionada);
        lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCantidad.setBounds(30, 268, 400, 25);
        panel.add(lblCantidad);
        
        JLabel lblMPago = new JLabel("Metodo de Pago: " + metodoPagoOBJ.getNombre());
        lblMPago.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMPago.setBounds(30, 303, 400, 25);
        panel.add(lblMPago);
        
        JLabel lblCliente = new JLabel("Nombre del cliente: " + nombreCliente);
        lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCliente.setBounds(30, 338, 400, 25);
        panel.add(lblCliente);
        
        JLabel lblCliente_1 = new JLabel("Nombre del empleado: " + nombreEmpleado);
        lblCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCliente_1.setBounds(30, 373, 400, 25);
        panel.add(lblCliente_1);
        

        JButton btnFinalizarVenta = new JButton("Finalizar Venta");
        btnFinalizarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnFinalizarVenta.setBounds(350, 450, 150, 30);
        panel.add(btnFinalizarVenta);
        
        
        
	}}

//        btnFinalizarVenta.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Venta.finalizarVenta(producto, cantSeleccionada, metodoPagoOBJ.getId(), clienteCompra.getId(), idEmpleado);
//            }
//        });
    

	
		
	


