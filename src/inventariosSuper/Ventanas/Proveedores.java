package inventariosSuper.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Proveedores extends JFrame {
	private Inventario inventario;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JPanel panelTarjetas;
	private Auditoria auditoria;
	public Proveedores(Inventario inventario, Auditoria a) {
		this.auditoria = a;
		this.inventario = inventario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmVolver = new JMenuItem("< Volver");
		mntmVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListaProductos frame = new ListaProductos(inventario,auditoria);
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmVolver);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscador = new JPanel();
		panelBuscador.setBackground(new Color(246, 196, 205));
		contentPane.add(panelBuscador, BorderLayout.NORTH);
		panelBuscador.setLayout(null);
		panelBuscador.setPreferredSize(new Dimension(1200, 200));
		
		JLabel lblBuscarProveedor = new JLabel("BUSCAR PROVEEDOR: ");
		lblBuscarProveedor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBuscarProveedor.setBounds(26, 152, 343, 14);
		panelBuscador.add(lblBuscarProveedor);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscar.setBounds(262, 137, 518, 34);
		panelBuscador.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProveedores(buscarPorNombre(inventario.getProveedores(),txtBuscar.getText()), panelTarjetas);
			}
		});
		btnBuscar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBuscar.setBounds(797, 150, 122, 23);
		panelBuscador.add(btnBuscar);
		
		JButton btnMostrarTodo = new JButton("MOSTRAR TODO");
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProveedores(inventario.getProveedores(), panelTarjetas);
			}
		});
		btnMostrarTodo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMostrarTodo.setBounds(961, 150, 189, 23);
		panelBuscador.add(btnMostrarTodo);
		
		JLabel lblTitulo = new JLabel("PROVEEDORES");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblTitulo.setBounds(354, 42, 479, 47);
		panelBuscador.add(lblTitulo);
		
		panelTarjetas = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panelTarjetas);
        contentPane.add(scrollPane, BorderLayout.CENTER);
		mostrarProveedores(inventario.getProveedores(), panelTarjetas);
		
	}
	
	private void mostrarProveedores(ArrayList<Proveedor> proveedores, JPanel panelTarjetas) {
		  panelTarjetas.removeAll();
		 int numProveedor = proveedores.size();
		    
		    int filas = Math.max((int) Math.ceil((double) numProveedor / 4), 1);
	        panelTarjetas.setLayout(new GridLayout(filas, 4, 10, 10));

	        for (Proveedor proveedor : proveedores) {
	            JButton buttonProvee = new JButton();
	            buttonProvee.setLayout(new BorderLayout());

	            String rutaImagen = "/imagenes/proveedores.png";
	            ImageIcon iconProducto = new ImageIcon(ListaProductos.class.getResource(rutaImagen));
	            Image imagenRedimensionada = iconProducto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	            ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
	            JLabel labelImagen = new JLabel(iconRedimensionado);
	            buttonProvee.add(labelImagen, BorderLayout.CENTER);
	            buttonProvee.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				ProductosProveedor ventanaProductosProve = new ProductosProveedor(inventario, proveedor,auditoria);
	    				ventanaProductosProve.setVisible(true);
	    				setVisible(false);
	    			}
	    		});

	            JPanel panelDetalles = new JPanel();
	            panelDetalles.setLayout(new GridLayout(0, 1));

	            JLabel labelNombre = new JLabel("Nombre: " + proveedor.getNombre());
	            JLabel labelDireccion= new JLabel("Direccion: " + proveedor.getDireccion());
	            JLabel labelTelefono = new JLabel("Telefono: " + proveedor.getTelefono());
	            JLabel labelCorreo = new JLabel("Correo: " + proveedor.getCorreoElectronico());

	            panelDetalles.add(labelNombre);
	            panelDetalles.add(labelDireccion);
	            panelDetalles.add(labelTelefono);
	            panelDetalles.add(labelCorreo);

	            buttonProvee.add(panelDetalles, BorderLayout.SOUTH);

	            buttonProvee.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	            panelTarjetas.add( buttonProvee);
	        }
	        panelTarjetas.revalidate();
	        panelTarjetas.repaint();
	    }
	
	private ArrayList<Proveedor>  buscarPorNombre(ArrayList<Proveedor>  proveedores, String nombre) {
		ArrayList<Proveedor>  resultados = new ArrayList<>();

	    for (Proveedor proveedor : proveedores) {
	        if (proveedor.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
	            resultados.add(proveedor);
	        }
	    }

	    // Agrega mensajes de depuración
	    System.out.println("Texto a buscar: " + nombre);
	    System.out.println("Resultados encontrados: " + resultados.size());
	    for (Proveedor p : resultados) {
	        System.out.println("Producto encontrado: " + p.getNombre());
	    }

	    return resultados;
	}
}
