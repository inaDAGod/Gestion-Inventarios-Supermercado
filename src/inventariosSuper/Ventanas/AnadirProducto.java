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
import java.awt.event.ActionEvent;

public class AnadirProducto extends JFrame {
	private Inventario inventario;
	private JPanel contentPane;
	private JTextField txtNombreProducto;
	private JTextField txtPrecioProducto;
	private JTextField txtAnio;
	private JTextField txtDia;
	private JTextField txtExistencias;
	private JPanel panelCategorias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario i = new Inventario();
					
					
			        CategoriaProducto c = new CategoriaProducto("Comestible", "Para comer");// categoria nueva
			        CategoriaProducto c2 = new CategoriaProducto("Ropa", "Para ponerte");// categoria nueva
			        Proveedor p = new Proveedor("1", "Coca Cola", "Obrajes", "4564", "coca@gmail.com");
			        i.añadirProveedor(p);
			        i.añadirCategoriaProducto(c);
			        i.añadirCategoriaProducto(c2);
			        
					AnadirProducto frame = new AnadirProducto(i);
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
	public AnadirProducto(Inventario i) {
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
		
		JLabel lblTitulo = new JLabel("AÑADIR PRODUCTO NUEVO");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(258, 48, 636, 50);
		panelCabecera.add(lblTitulo);
		
		JPanel panelFormularioProducto = new JPanel();
		contentPane.add(panelFormularioProducto, BorderLayout.CENTER);
		panelFormularioProducto.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE PRODUCTO: ");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(39, 57, 202, 24);
		panelFormularioProducto.add(lblNombre);
		
		JLabel lblDetalle = new JLabel("DETALLES PRODUCTO:");
		lblDetalle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDetalle.setBounds(39, 123, 202, 24);
		panelFormularioProducto.add(lblDetalle);
		
		JLabel lblPrecio = new JLabel("PRECIO PRODUCTO:");
		lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrecio.setBounds(39, 219, 202, 24);
		panelFormularioProducto.add(lblPrecio);
		
		JLabel lblFechaVencimiento = new JLabel("FECHA VENCIMIENTO:");
		lblFechaVencimiento.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblFechaVencimiento.setBounds(39, 275, 202, 24);
		panelFormularioProducto.add(lblFechaVencimiento);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(39, 92, 450, 20);
		panelFormularioProducto.add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setBounds(39, 244, 146, 20);
		panelFormularioProducto.add(txtPrecioProducto);
		txtPrecioProducto.setColumns(10);
		
		JLabel lblBs = new JLabel("Bs.");
		lblBs.setBounds(195, 247, 46, 14);
		panelFormularioProducto.add(lblBs);
		
		txtAnio = new JTextField();
		txtAnio.setText("Ej: 2023");
		txtAnio.setBounds(38, 304, 86, 20);
		panelFormularioProducto.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setBounds(65, 328, 31, 14);
		panelFormularioProducto.add(lblAnio);
		
		JComboBox comboBoxMeses = new JComboBox();
		comboBoxMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBoxMeses.setBounds(134, 303, 107, 22);
		panelFormularioProducto.add(comboBoxMeses);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(181, 328, 46, 14);
		panelFormularioProducto.add(lblMes);
		
		txtDia = new JTextField();
		txtDia.setText("Ej:28");
		txtDia.setBounds(251, 304, 86, 20);
		panelFormularioProducto.add(txtDia);
		txtDia.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(273, 328, 46, 14);
		panelFormularioProducto.add(lblDia);
	     JScrollPane scrollDetalles = new JScrollPane(); // Por si son muchas observaciones
	     scrollDetalles.setBounds(39, 158, 450, 50);
	     panelFormularioProducto.add(scrollDetalles);
	     JTextArea txtDetalles = new JTextArea();
	     scrollDetalles.setViewportView(txtDetalles);
	     
	     JLabel lblCantidad = new JLabel("EXISTENCIAS:");
	     lblCantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
	     lblCantidad.setBounds(38, 368, 122, 24);
	     panelFormularioProducto.add(lblCantidad);
	     
	     txtExistencias = new JTextField();
	     txtExistencias.setText("Ej:120");
	     txtExistencias.setBounds(174, 371, 86, 20);
	     panelFormularioProducto.add(txtExistencias);
	     txtExistencias.setColumns(10);
	     
	     JLabel lblProveedor = new JLabel("PROVEEDOR:");
	     lblProveedor.setFont(new Font("Times New Roman", Font.BOLD, 15));
	     lblProveedor.setBounds(759, 241, 122, 24);
	     panelFormularioProducto.add(lblProveedor);
	     
	     JComboBox comboBoxProveedores = new JComboBox();
	     DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(); 

		    for (Proveedor p : inventario.getProveedores()) {
		        model.addElement(p.getNombre()); // Agrega elementos al modelo
		    }

		    comboBoxProveedores.setModel(model); // Establece el modelo en el JComboBox
	     comboBoxProveedores.setBounds(879, 243, 139, 22);
	     panelFormularioProducto.add(comboBoxProveedores);
	     
	     JLabel lblCategorias = new JLabel("CATEGORIAS PRODUCTO:");
	     lblCategorias.setFont(new Font("Times New Roman", Font.BOLD, 15));
	     lblCategorias.setBounds(759, 37, 250, 24);
	     panelFormularioProducto.add(lblCategorias);
	     
	     panelCategorias = new JPanel();
	     panelCategorias.setLayout(new GridLayout(0, 1, 0, 0));
	     JScrollPane scrollCategorias  = new JScrollPane(panelCategorias);
	     scrollCategorias.setBounds(823, 72, 200, 100);
	     panelFormularioProducto.add(scrollCategorias);
	     
	     JButton btnRegistrar = new JButton("REGISTRAR");
	     btnRegistrar.setBackground(new Color(250, 240, 230));
	     btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 15));
	     btnRegistrar.setBounds(915, 533, 184, 23);
	     panelFormularioProducto.add(btnRegistrar);
	     
	     JButton btnAñadirCategoria = new JButton("+");
	     
	     btnAñadirCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
	     btnAñadirCategoria.setBounds(976, 39, 51, 23);
	     panelFormularioProducto.add(btnAñadirCategoria);
	     
	     JButton btnEliminarCategoria = new JButton("-");
	     btnEliminarCategoria.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		if(panelCategorias.getComponentCount()>1) {
	     			panelCategorias.remove(panelCategorias.getComponentCount()-1);
	     			panelCategorias.revalidate();
	     			panelCategorias.repaint();
				}
	     	}
	     });
	     btnEliminarCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
	     btnEliminarCategoria.setBounds(1036, 38, 51, 23);
	     panelFormularioProducto.add(btnEliminarCategoria);
	     
	     btnAñadirCategoria.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		anadirCategoria();
		     	}
		     });
		
	}
	public void anadirCategoria() {
	    JComboBox<String> cb = new JComboBox<>(); // Especifica el tipo de elementos en el JComboBox
	    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(); 

	    for (CategoriaProducto c : inventario.getCategoriasProductos()) {
	        model.addElement(c.getNombre()); // Agrega elementos al modelo
	    }

	    cb.setModel(model); // Establece el modelo en el JComboBox
	    panelCategorias.add(cb);
	    panelCategorias.revalidate();
	    panelCategorias.repaint();
	}
}
