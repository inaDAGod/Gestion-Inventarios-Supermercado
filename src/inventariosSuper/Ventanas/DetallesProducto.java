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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario i = new Inventario();
					Proveedor prove = new Proveedor("1", "Juan", "Avenida siempre vivas", "454", "jj@gmail.com");
					Producto produ = new Producto("Tomate", "Fruta o verdura", 2.50, 5, LocalDate.now().plusDays(5)); // producto nuevo
					
			        CategoriaProducto c = new CategoriaProducto("Comestible", "Para comer");// categoria nueva

			        produ.anadirCategoria(produ,c); //se añade la categoria al producto
			        i.añadirProducto(produ, prove);
					DetallesProducto frame = new DetallesProducto(produ,i);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
			}
		});
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(255, 240, 245));
		panelCabecera.setPreferredSize(new Dimension(1800, 130));
		contentPane.add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(null);
		
		JLabel lblTitulo = new JLabel(producto.getNombre());
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(258, 48, 636, 50);
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
	     Proveedor prove = proveedor();
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
	public Proveedor proveedor() {
        for (Map.Entry<Proveedor, Producto> entry : inventario.getProveedoresProducto().entrySet()) {
            if (entry.getValue().equals(producto)) {
                return entry.getKey(); 
            }
        }
        return null;
    }
}
