package inventariosSuper.Ventanas;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.ListaComprasCompartida;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Clases.Compras;
public class Nuevocli extends JFrame {

	private List<Cliente> listaClientes = new ArrayList<>();
	private Cliente clienteRegistrado; 
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCarnet;
	private JTextField txtDirecion;
	private JTextField txtNumero;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnRegistro;
	private Compras compras;
	private Auditoria auditoria;
	private List<Compras> listaCompras = ListaComprasCompartida.getListaCompras();
	private Inventario inventario;
	private List<Comprado> historialCompras = new ArrayList<>();

	
	public Nuevocli(List<Compras> listaCompras, Inventario inventario,Auditoria auditoria,List<Cliente> listaClientes,List<Comprado> historialCompras ) {
	    this.listaCompras = new ArrayList<>(listaCompras != null ? listaCompras : new ArrayList<>());
	    this.inventario=inventario;
	    this.auditoria = auditoria;
	    this.listaClientes = listaClientes;
	    this.historialCompras=historialCompras;
	    


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 225, 221));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Nuevo Cliente");
		lblNewLabel.setForeground(new Color(246, 196, 205));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 66, 755, 104);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(175, 263, 715, 408);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(48, 103, 152, 38);
		txtNombre.setText("Nombre");
		txtNombre.setForeground(new Color(246, 196, 205));
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCarnet = new JTextField();
		txtCarnet.setText("Carnet");
		txtCarnet.setForeground(new Color(255, 175, 175));
		txtCarnet.setColumns(10);
		txtCarnet.setBounds(48, 195, 152, 38);
		panel_1.add(txtCarnet);
		
		txtDirecion = new JTextField();
		txtDirecion.setText("Direcion");
		txtDirecion.setForeground(new Color(255, 175, 175));
		txtDirecion.setColumns(10);
		txtDirecion.setBounds(48, 297, 152, 38);
		panel_1.add(txtDirecion);
		
		txtNumero = new JTextField();
		txtNumero.setText("Numero");
		txtNumero.setForeground(new Color(255, 175, 175));
		txtNumero.setColumns(10);
		txtNumero.setBounds(436, 195, 152, 38);
		panel_1.add(txtNumero);
		
		lblNewLabel_2 = new JLabel("Nombre del Cliente");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(48, 62, 130, 31);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Carnet del Cliente");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(48, 154, 130, 31);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Direccion del Cliente");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_4.setBounds(48, 256, 152, 31);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Numero del Cliente");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_5.setBounds(446, 154, 130, 31);
		panel_1.add(lblNewLabel_5);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBackground(new Color(246, 196, 205));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarNuevoCliente();
			}
		});
		btnRegistro.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnRegistro.setBounds(458, 297, 117, 29);
		panel_1.add(btnRegistro);
		
		JLabel lblNewLabel_1 = new JLabel("Datos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(468, 195, 139, 41);
		panel.add(lblNewLabel_1);
		
		
		
	}
	//------------------------------------------
	
			private void registrarNuevoCliente() {
			    String nombre = txtNombre.getText();
			    String carnetText = txtCarnet.getText();
			    String numeroText = txtNumero.getText();
			    String direccion = txtDirecion.getText();

			    if (nombre.isEmpty() || carnetText.isEmpty() || numeroText.isEmpty() || direccion.isEmpty()) {
			        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			    } else {

			    	try {
			    	    int id = Integer.parseInt(carnetText);
			    	    int numero = Integer.parseInt(numeroText);
			    	    Cliente nuevoCliente = new Cliente(nombre, id, numero, direccion, listaCompras);
			    	    listaClientes.add(nuevoCliente);

			    	    

			    	    clienteRegistrado = nuevoCliente;


			    	    JOptionPane.showMessageDialog(null, "Nuevo cliente registrado: " + nuevoCliente.getNombre(), "Nuevo Cliente", JOptionPane.INFORMATION_MESSAGE);

			    	    abrirPaginaFactura(clienteRegistrado);

			    	    limpiarCampos();
			    	} catch (NumberFormatException e) {
			    	    JOptionPane.showMessageDialog(this, "El ID y el número deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
			    	}
			    	}

			    }
			    
			    private void limpiarCampos() {
			        txtNombre.setText("");
			        txtCarnet.setText("");
			        txtNumero.setText("");
			        txtDirecion.setText("");
			    }
			    
			    
			    private void abrirPaginaFactura(Cliente clienteRegistrado) {
			        if (clienteRegistrado != null) {
			            if (!clienteRegistrado.getListaCompras().isEmpty()) {
			                FacturaPage facturaPage = new FacturaPage(clienteRegistrado, inventario, auditoria, listaClientes, historialCompras);
			                facturaPage.setVisible(true);
			                setVisible(false);
			                dispose();
			            } else {
			                JOptionPane.showMessageDialog(this, "El cliente no tiene compras registradas.", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        } else {
			            JOptionPane.showMessageDialog(this, "Por favor, registra un cliente primero.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }


			
			
			//--------------
}
