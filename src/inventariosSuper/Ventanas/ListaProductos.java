package inventariosSuper.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;


public class ListaProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Inventario inventario;
	private JTextField txtDatoABuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario inventario = new Inventario();
					Producto producto1 = new Producto("Producto 1", "Descripción del Producto 1", 10.0, 100, LocalDate.now().plusDays(30));
			        Producto producto2 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto1, null); // No se especifica el proveedor en este ejemplo
			        inventario.añadirProducto(producto2, null); // No se especifica el proveedor en este ejemplo
			        Producto producto11 = new Producto("Producto 1", "Descripción del Producto 1", 10.0, 100, LocalDate.now().plusDays(30));
			        Producto producto21 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto11, null); // No se especifica el proveedor en este ejemplo
			        inventario.añadirProducto(producto21, null); // No se especifica el proveedor en este ejemplo
			        Producto producto12 = new Producto("Producto 1", "Descripción del Producto 1", 10.0, 100, LocalDate.now().plusDays(30));
			        Producto producto22 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto12, null); // No se especifica el proveedor en este ejemplo
			        inventario.añadirProducto(producto22, null); // No se especifica el proveedor en este ejemplo
			        Producto producto112 = new Producto("Producto 1", "Descripción del Producto 1", 10.0, 100, LocalDate.now().plusDays(30));
			        Producto producto212 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto112, null); // No se especifica el proveedor en este ejemplo
			        inventario.añadirProducto(producto212, null); // No se especifica el proveedor en este ejemplo
			        Producto producto5 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto5, null); // No se especifica el proveedor en este ejemplo
			        Producto producto54 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto54, null); // No se especifica el proveedor en este ejemplo
			        Producto producto541 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto541, null); // No se especifica el proveedor en este ejemplo
			        Producto producto543 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto543, null); // No se especifica el proveedor en este ejemplo
			        Producto producto5413 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto5413, null); // No se especifica el proveedor en este ejemplo
			        Producto producto77 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto77, null); // No se especifica el proveedor en este ejemplo
			        Producto producto88 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto88, null); // No se especifica el proveedor en este ejemplo
			        Producto producto889 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto889, null); // No se especifica el proveedor en este ejemplo
			        Producto producto8899 = new Producto("Producto 2", "Descripción del Producto 2", 15.0, 50, LocalDate.now().plusDays(60));
			        inventario.añadirProducto(producto8899, null); // No se especifica el proveedor en este ejemplo
					ListaProductos frame = new ListaProductos(inventario);
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
	public ListaProductos(Inventario inventario) {
			this.inventario = inventario;
	        

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 1200, 800);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel de cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBounds(5, 5, 1176, 117);
        contentPane.add(panelCabecera);
        panelCabecera.setLayout(new BorderLayout(0, 0));

        JLabel imagenCaritas = new JLabel("");
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelCabecera.add(panelBotonesCabecera, BorderLayout.EAST);
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAtras = new JButton("< Volver");
        panelBotonesCabecera.add(btnAtras);
        btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaInicio ventanaInicio = new VentanaInicio(inventario);
				ventanaInicio.setVisible(true);
			}
		});

        JButton btnPerfil = new JButton("");
        ImageIcon iconOriginal = new ImageIcon("/imagenes/perfilpersona.png");
        Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
        btnPerfil.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add(btnPerfil);

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.setBounds(5, 120, 1176, 638);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1176, 96);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Ingrese el dato a buscar:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(10, 51, 282, 31);
        panel_1.add(lblNewLabel);
        
        txtDatoABuscar = new JTextField();
        txtDatoABuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        txtDatoABuscar.setText("Dato a Buscar");
        txtDatoABuscar.setBounds(302, 48, 701, 37);
        panel_1.add(txtDatoABuscar);
        txtDatoABuscar.setColumns(10);
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton rdbtnNewRadioButton = new JRadioButton(" Nombre");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton.setBounds(721, 5, 123, 39);
        panel_1.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Categoria");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton_1.setBounds(415, 5, 133, 39);
        panel_1.add(rdbtnNewRadioButton_1);

        buttonGroup.add(rdbtnNewRadioButton); // Agregar al ButtonGroup
        buttonGroup.add(rdbtnNewRadioButton_1); // Agregar al ButtonGroup


        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 96, 1176, 542);
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout());

        JPanel panelTarjetas = new JPanel(new GridLayout(0, 4, 10, 10));
        JScrollPane scrollPane = new JScrollPane(panelTarjetas);
        panel_2.add(scrollPane, BorderLayout.CENTER);

        mostrarProductos(inventario.getProductos(), panelTarjetas);
        
        JLabel lblSedatoABuscar = new JLabel("Seleccione el tipo de dato:");
        lblSedatoABuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSedatoABuscar.setBounds(0, 9, 298, 31);
        panel_1.add(lblSedatoABuscar);
        
        JButton btnNewButton = new JButton("Buscar ");
        btnNewButton.setBounds(1013, 47, 153, 39);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar productos
                String datoABuscar = txtDatoABuscar.getText();

                if (rdbtnNewRadioButton.isSelected()) {
                    // Buscar por nombre
                    List<Producto> productosPorNombre = buscarPorNombre(inventario.getProductos(), datoABuscar);
                    mostrarProductos(productosPorNombre, panelTarjetas);
                } else if (rdbtnNewRadioButton_1.isSelected()) {
                    // Buscar por categoría
                    List<Producto> productosPorCategoria = buscarPorCategoria(inventario.getProductos(), datoABuscar);
                    mostrarProductos(productosPorCategoria, panelTarjetas);
                }
            }
        });
        panel_1.add(btnNewButton);

       
     
        
     // Agrupar los JRadioButtons para permitir solo una selección
       
        
    }
	 private void mostrarProductos(List<Producto> listaProductos, JPanel panelTarjetas) {
		  panelTarjetas.removeAll();
		 int numProductos = listaProductos.size();
		    
		    // Asegúrate de que haya al menos una fila
		    int filas = Math.max((int) Math.ceil((double) numProductos / 4), 1);
	        panelTarjetas.setLayout(new GridLayout(filas, 4, 10, 10));

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
	    				DetallesProducto detalleProducto = new DetallesProducto(producto,inventario);
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

	private void mostrarProductosEnPanelEspecifico(JScrollPane scrollPane) {
	    JPanel panelEspecifico = new JPanel();
	    panelEspecifico.setLayout(new BorderLayout());
	    panelEspecifico.add(scrollPane, BorderLayout.CENTER);

	    // Asegúrate de agregar este panel al lugar correcto de tu interfaz
	    // Por ejemplo:
	    // contentPane.add(panelEspecifico, BorderLayout.WEST);
	}

	private void mostrarTodosLosProductos(JScrollPane scrollPane) {
	    contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	private List<Producto> buscarPorNombre(List<Producto> productos, String nombre) {
	    List<Producto> resultados = new ArrayList<>();

	    for (Producto producto : productos) {
	        if (producto.getNombre().equalsIgnoreCase(nombre)) {
	            resultados.add(producto);
	        }
	    }

	    // Agrega mensajes de depuración
	    System.out.println("Texto a buscar: " + nombre);
	    System.out.println("Resultados encontrados: " + resultados.size());
	    for (Producto p : resultados) {
	        System.out.println("Producto encontrado: " + p.getNombre());
	    }

	    return resultados;
	}

	private List<Producto> buscarPorCategoria(List<Producto> productos, String categoria) {
	    List<Producto> resultados = new ArrayList<>();

	    for (Producto producto : productos) {
	        Queue<CategoriaProducto> categorias = producto.getCategorias();

	        // Iterar sobre las categorías del producto
	        for (CategoriaProducto cat : categorias) {
	            // Comparar el nombre de la categoría con la categoría buscada
	            if (cat.getNombre().equalsIgnoreCase(categoria)) {
	                resultados.add(producto);
	                break;  // No necesitas seguir iterando si encontraste una coincidencia
	            }
	        }
	    }

	    return resultados;
	}
	
	}