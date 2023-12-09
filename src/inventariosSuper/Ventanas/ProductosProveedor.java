package inventariosSuper.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.*;

public class ProductosProveedor extends JFrame {

	private JPanel contentPane;
	private Inventario inventario;
	private Proveedor proveedor;
	private Auditoria auditoria;
	private List<Cliente> listaClientes = new ArrayList<>();
    private List<Comprado> historialCompras = new ArrayList<>();
	
	public ProductosProveedor(Inventario inventario, Proveedor proveedor,Auditoria a,List<Cliente> listaClientes, List<Comprado> historialCompras) {
		this.inventario = inventario;
		this.proveedor = proveedor;
		this.auditoria = a;
		this.listaClientes=listaClientes;
		this.historialCompras=historialCompras;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("< Volver");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Proveedores ventanaProveedores= new Proveedores(inventario, a, listaClientes, historialCompras);
				ventanaProveedores.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(246, 196, 205));
		panelCabecera.setPreferredSize(new Dimension(1200, 130));
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(null);
		
		JLabel lblTitulo = new JLabel(proveedor.getNombre());
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(272, 37, 636, 50);
		panelCabecera.add(lblTitulo);
		
		JPanel panelTarjetas = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panelTarjetas);
        contentPane.add(scrollPane, BorderLayout.CENTER);
		if(productos().isEmpty()) {
			
		}
		else {
			mostrarProductos(productos(), panelTarjetas);
		}
		
	}
	private ArrayList<Producto> productos (){
		return inventario.getProveedoresProducto().get(proveedor);
	}
	private void mostrarProductos(ArrayList<Producto> listaProductos, JPanel panelTarjetas) {
		  panelTarjetas.removeAll();
		 int numProductos = listaProductos.size();
		    
		  
		    
		 	//int filas = Math.max((int) Math.ceil((double) numProductos / 4), 1);
	        panelTarjetas.setLayout(new GridLayout(4, 4, 4, 4));

	        for (Producto producto : listaProductos) {
	            JButton buttonProducto = new JButton();
	            buttonProducto.setLayout(new BorderLayout());

	            String rutaImagen = "/imagenes/producto.png";
	            ImageIcon iconProducto = new ImageIcon(ListaProductos.class.getResource(rutaImagen));
	            Image imagenRedimensionada = iconProducto.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	            ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);
	            JLabel labelImagen = new JLabel(iconRedimensionado);
	            buttonProducto.add(labelImagen, BorderLayout.CENTER);
	            buttonProducto.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				DetallesProducto detalleProducto = new DetallesProducto(producto, inventario, auditoria, listaClientes, historialCompras);
	    				detalleProducto.setVisible(true);
	    				setVisible(false);
	    			}
	    		});

	            JPanel panelDetalles = new JPanel();
	            panelDetalles.setLayout(new GridLayout(0, 1));

	            JLabel labelNombre = new JLabel("Nombre: " + producto.getNombre());
	            JLabel labelDetalle = new JLabel("Detalle: " + producto.getDetalle());
	            JLabel labelPrecio = new JLabel("Precio: " + producto.getPrecio());
	            JLabel labelStock = new JLabel("Stock: " + producto.getCantidadStock());

	            panelDetalles.add(labelNombre);
	            panelDetalles.add(labelDetalle);
	            panelDetalles.add(labelPrecio);
	            panelDetalles.add(labelStock);

	            buttonProducto.add(panelDetalles, BorderLayout.SOUTH);

	            buttonProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	            panelTarjetas.add(buttonProducto);
	        }
	        panelTarjetas.revalidate();
	        panelTarjetas.repaint();
	    }

}
