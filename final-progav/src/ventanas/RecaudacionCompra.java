package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import clases.Venta;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class RecaudacionCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int idEmpleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecaudacionCompra frame = new RecaudacionCompra(null);
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
	public RecaudacionCompra(Empleado empleado) {
		//idEmpleado = empleado.obtenerIdEmpleado();
		idEmpleado = 12;
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
	
        JLabel lblNewLabel_dni = new JLabel("INGRESE LA FECHA");
        lblNewLabel_dni.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_dni.setBounds(80, 164, 155, 39);
        panel.add(lblNewLabel_dni);
        
        JTextField textField_fecha = new JTextField();
        textField_fecha.setHorizontalAlignment(SwingConstants.CENTER);
        textField_fecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_fecha.setBounds(80, 213, 135, 31);
        panel.add(textField_fecha);
        textField_fecha.setColumns(10);
        
        JButton btnNewButton = new JButton("Consultar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(80, 260, 129, 39);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("CONSULTA DE RECAUDACION");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel_1.setBounds(80, 98, 262, 41);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("(AAAA--MM--DD)");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(225, 215, 107, 29);
        panel.add(lblNewLabel_2);
        
        JLabel lblInfoAdicional = new JLabel("");
        lblInfoAdicional.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInfoAdicional.setBounds(508, 163, 244, 39);
        panel.add(lblInfoAdicional);
        
        JLabel lblInfoAdicional2 = new JLabel("");
        lblInfoAdicional2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInfoAdicional2.setBounds(508, 208, 117, 39);
        panel.add(lblInfoAdicional2);
        
        JLabel lblInfoAdicional3 = new JLabel("");
        lblInfoAdicional3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblInfoAdicional3.setBounds(508, 260, 166, 39);
        panel.add(lblInfoAdicional3);
        
        JLabel lblInfoAdicional4 = new JLabel("");
        lblInfoAdicional4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblInfoAdicional4.setBounds(508, 260, 155, 39);
        panel.add(lblInfoAdicional4);
        
        JLabel lblNewLabel_1_1 = new JLabel("ID Usuario:\r\n");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel_1_1.setBounds(557, 98, 97, 41);
        panel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel_1_1_1.setBounds(673, 98, 106, 41);
        panel.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setText(String.valueOf(idEmpleado));
	
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fechaTexto = textField_fecha.getText();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                formatoFecha.setLenient(false); // No permitir fechas fuera del rango

                try {
                    Date fecha = formatoFecha.parse(fechaTexto);
                    //Venta.recaudacionDia(fecha);
                    double recaudacion = Venta.recaudacionDia(fecha);
                    
                    if (recaudacion != 0) {
                    	lblInfoAdicional.setText("RECAUDACION DEL DIA: " );
                    	lblInfoAdicional2.setText(formatoFecha.format(fecha));
                    	lblInfoAdicional3.setText("$ " + recaudacion);
                    	
                        lblInfoAdicional.setVisible(true);
                        lblInfoAdicional2.setVisible(true);
                        lblInfoAdicional3.setVisible(true);  
                    } else {
                    	JOptionPane.showMessageDialog(null, "No hay registro en esa fecha");
                    	lblInfoAdicional.setVisible(false);
                    	lblInfoAdicional2.setVisible(false);
                    	lblInfoAdicional3.setVisible(false);
                    }
                    
                    // La fecha es válida, puedes continuar con el procesamiento
                    //JOptionPane.showMessageDialog(null, "Fecha válida: " + formatoFecha.format(fecha));
                } catch (ParseException ex) {
                    // La fecha no es válida
                    JOptionPane.showMessageDialog(null, "Fecha no válida. Por favor ingrese la fecha en formato dd/MM/yyyy.");
                	lblInfoAdicional.setVisible(false);
                	lblInfoAdicional2.setVisible(false);
                	lblInfoAdicional3.setVisible(false);
                }
            }
        });
    }
	
	}

