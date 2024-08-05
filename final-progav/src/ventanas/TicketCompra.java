package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private double totalVenta = 0;

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
		nombreCliente = cliente.getNombre();
		nombreEmpleado = empleado.getNombre();
		//int metPag = metodoPagoOBJ.getId();
		
        if(metodoPagoOBJ.getNombre().equalsIgnoreCase("Efectivo")) {
			
			totalVenta =  (cantSeleccionada * producto.getPrecio() * 0.9);
			String descuento = "Descuento efectivo 10%";
			
		}else {
			totalVenta =  (cantSeleccionada * producto.getPrecio());
		}
		
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
        lblNombre.setBounds(30, 163, 387, 25);
        panel.add(lblNombre);

        JLabel lblPrecio = new JLabel("Total: $ " + totalVenta + "    " +(metodoPagoOBJ.getNombre().equalsIgnoreCase("Efectivo") ? " Descuento 10% efectivo" : "" ));
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
        
        
	
        btnFinalizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
//        		LocalDate fechaVenta = LocalDate.now();
//        		LocalTime horaVenta = LocalTime.now();
//            	
//            	Venta vt = new Venta(fechaVenta, horaVenta, totalVenta, cliente, empleado, metodoPagoOBJ, producto,cantSeleccionada );
//                if (vt.guardarVenta()) {
//					JOptionPane.showMessageDialog(null, "Venta realizada con existo");
//				} else {
//					JOptionPane.showMessageDialog(null, "no se realizo la venta");
//				}
//            	
            	Venta.finalizarVenta(producto, cantSeleccionada, metodoPagoOBJ, cliente, empleado, totalVenta);
                VentanaProductos vp = new VentanaProductos(cliente, empleado);
                vp.setVisible(true);
                setVisible(false);
				
            }
        });
        
        
        
	}}
    

	
		
	


