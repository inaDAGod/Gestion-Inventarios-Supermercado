package inventariosSuper.Ventanas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.awt.event.ActionEvent;

public class DetallesProducto extends JFrame {
	private Producto producto;
	private Inventario inventario;
	private JPanel contentPane;
	private JTextField txtPrecioProducto;
	private JTextField txtExistencias;
	private JTextField txtFechaVence;
	private JTextField txtProveedor;

	

	public DetallesProducto(Producto produ,Inventario i) {
		this.producto = produ;
		this.inventario = i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("< Volver");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListaProductos frame = new ListaProductos(inventario);
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(255, 240, 245));
		panelCabecera.setPreferredSize(new Dimension(1200, 130));
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(null);
		
		JLabel lblTitulo = new JLabel(producto.getNombre());
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(270, 48, 636, 50);
		panelCabecera.add(lblTitulo);
		
		JPanel panelFormularioProducto = new JPanel();
		contentPane.add(panelFormularioProducto, BorderLayout.CENTER);
		panelFormularioProducto.setLayout(null);
		
		JLabel lblDetalle = new JLabel("DETALLES PRODUCTO:");
		lblDetalle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDetalle.setBounds(39, 37, 202, 24);
		panelFormularioProducto.add(lblDetalle);
		
		JLabel lblPrecio = new JLabel("PRECIO PRODUCTO:");
		lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrecio.setBounds(39, 149, 202, 24);
		panelFormularioProducto.add(lblPrecio);
		
		JLabel lblFechaVencimiento = new JLabel("FECHA VENCIMIENTO:");
		lblFechaVencimiento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFechaVencimiento.setBounds(39, 241, 202, 24);
		panelFormularioProducto.add(lblFechaVencimiento);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setText(String.valueOf(producto.getPrecio()));
		txtPrecioProducto.setEditable(false);
		txtPrecioProducto.setBounds(39, 184, 146, 20);
		panelFormularioProducto.add(txtPrecioProducto);
		txtPrecioProducto.setColumns(10);
		
		JLabel lblBs = new JLabel("Bs.");
		lblBs.setBounds(211, 187, 46, 14);
		panelFormularioProducto.add(lblBs);
	     JScrollPane scrollDetalles = new JScrollPane(); // Por si son muchas observaciones
	     scrollDetalles.setBounds(39, 72, 450, 50);
	     panelFormularioProducto.add(scrollDetalles);
	     JTextArea txtDetalles = new JTextArea();
	     txtDetalles.setText(producto.getDetalle());
	     txtDetalles.setEditable(false);
	     scrollDetalles.setViewportView(txtDetalles);
	     
	     JLabel lblCantidad = new JLabel("EXISTENCIAS:");
	     lblCantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
	     lblCantidad.setBounds(39, 314, 122, 24);
	     panelFormularioProducto.add(lblCantidad);
	     
	     txtExistencias = new JTextField();
	     txtExistencias.setText(Integer.toString(producto.getCantidadStock()));
	     txtExistencias.setEditable(false);
	     txtExistencias.setBounds(171, 317, 86, 20);
	     panelFormularioProducto.add(txtExistencias);
	     txtExistencias.setColumns(10);
	     
	     JLabel lblProveedor = new JLabel("PROVEEDOR:");
	     lblProveedor.setFont(new Font("Times New Roman", Font.BOLD, 15));
	     lblProveedor.setBounds(759, 200, 122, 24);
	     panelFormularioProducto.add(lblProveedor);
	 
	     JLabel lblCategorias = new JLabel("CATEGORIAS PRODUCTO:");
	     lblCategorias.setFont(new Font("Times New Roman", Font.BOLD, 15));
	     lblCategorias.setBounds(759, 37, 250, 24);
	     panelFormularioProducto.add(lblCategorias);
	     JScrollPane scrollCategorias  = new JScrollPane();
	     scrollCategorias.setBounds(823, 72, 200, 100);
	     panelFormularioProducto.add(scrollCategorias);
	     
	     JTextArea txtCategorias = new JTextArea();
	     txtCategorias.setText(categorias());
	     txtCategorias.setEditable(false);
	     scrollCategorias.setViewportView(txtCategorias);
	     
	     txtFechaVence = new JTextField();
	     txtFechaVence.setText(producto.getFechaVencimiento().toString());
	     txtFechaVence.setEditable(false);
	     txtFechaVence.setBounds(260, 244, 202, 20);
	     panelFormularioProducto.add(txtFechaVence);
	     txtFechaVence.setColumns(10);
	     
	     txtProveedor = new JTextField();
	     Proveedor prove = proveedor(producto,inventario.getProveedoresProducto());
	     if(prove!= null) {
	    	 txtProveedor.setText(prove.getNombre());
	     }
	     else {
	    	 txtProveedor.setText("Este producto no cuenta con proveedor");
	     }
	     txtProveedor.setEditable(false);
	     txtProveedor.setBounds(823, 244, 200, 20);
	     panelFormularioProducto.add(txtProveedor);
	     txtProveedor.setColumns(10);
	     
	     JButton btnMasExistencias = new JButton("AGREGAR STOCK");
	    
	     btnMasExistencias.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     btnMasExistencias.setBounds(300, 316, 189, 23);
	     panelFormularioProducto.add(btnMasExistencias);
	     
	     JButton btnGuardar = new JButton("GUARDAR");
	    
	     btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     btnGuardar.setBounds(156, 360, 113, 23);
	     btnGuardar.setVisible(false);
	     panelFormularioProducto.add(btnGuardar);
	     btnMasExistencias.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		btnMasExistencias.setVisible(false);
		     		txtExistencias.setEditable(true);
		     		btnGuardar.setVisible(true);
		     	}
		     });
	     btnGuardar.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		btnGuardar.setVisible(false);
		     		txtExistencias.setEditable(false);
		     		btnMasExistencias.setVisible(true);
		     		producto.setCantidadStock(Integer.parseInt(txtExistencias.getText()));
		     		txtExistencias.setText(Integer.toString(producto.getCantidadStock()));
		     	}
		     });
	}
	
	public String categorias() {
		String categorias = "";
		Queue<CategoriaProducto> cate = producto.getCategorias();
		if(cate.size()>0) {
			for(CategoriaProducto cp: cate) {
				categorias += cp.getNombre();
				categorias += "\n";
			}
		}
		else {
			categorias = "Este producto no tiene categorias";
		}
		return categorias;
	}
	public Proveedor proveedor(Producto producto, Map<Proveedor, ArrayList<Producto>> inventario) {
	    for (Map.Entry<Proveedor, ArrayList<Producto>> entry : inventario.entrySet()) {
	        ArrayList<Producto> productosDelProveedor = entry.getValue();
	        if (productosDelProveedor.contains(producto)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}

}


