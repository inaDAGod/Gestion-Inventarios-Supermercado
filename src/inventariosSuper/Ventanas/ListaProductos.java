package inventariosSuper.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Clases.Inventario;


public class ListaProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Inventario inventario;
	private JTextField txtDatoABuscar;
	private Auditoria auditoria;

	private List<Cliente> listaClientes;
    private Comprado historialCompras;
	
	
	public ListaProductos(Inventario inventario,Auditoria a) {
			this.inventario = inventario;
	        this.auditoria = a;
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
        panelCabecera.setBackground(new Color(246, 196, 205)); 
        panelCabecera.setLayout(new BorderLayout());

        JLabel lblNewLabel2 = new JLabel("Productos");
        lblNewLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 70));
        panelCabecera.add(lblNewLabel2, BorderLayout.CENTER);

        JLabel imagenCaritas = new JLabel("");
        panelCabecera.add(imagenCaritas, BorderLayout.WEST);

        JPanel panelBotonesCabecera = new JPanel();
        panelBotonesCabecera.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));  // Ajusta la orientación a la derecha
        panelBotonesCabecera.setBackground(new Color(246, 196, 205)); 
        JButton btnAtras = new JButton("< Volver");
        btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnAtras.setPreferredSize(new Dimension(150, 40));
        btnAtras.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaInicio ventanaInicio = new VentanaInicio(inventario,auditoria, listaClientes, historialCompras);
				ventanaInicio.setVisible(true);
				
			}
		});


        JButton btnProveedor = new JButton(" Proveedores");
        btnProveedor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnProveedor.setPreferredSize(new Dimension(150, 40));

        panelBotonesCabecera.add(btnAtras);
        panelBotonesCabecera.add(btnProveedor);

        panelCabecera.add(panelBotonesCabecera, BorderLayout.NORTH);

        ImageIcon iconOriginal = new ImageIcon("/imagenes/perfilpersona.png");
        Image imagenOriginal = iconOriginal.getImage();
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionadoPerfil = new ImageIcon(imagenRedimensionada);
        btnProveedor.setIcon(iconRedimensionadoPerfil);
        panelBotonesCabecera.add( btnProveedor);
        btnProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Proveedores ventanaProveedores= new Proveedores(inventario,auditoria);
				ventanaProveedores.setVisible(true);
			}
		});

        JSeparator separator = new JSeparator();
        panelCabecera.add(separator, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.setBounds(5, 120, 1176, 638);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(246, 196, 205)); 
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1176, 96);
        panel.add(panel_1);
        panel_1.setLayout(null);

        panel_1.setBackground(new Color(246, 196, 205)); 
        
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
        
        txtDatoABuscar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
              txtDatoABuscar.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            
            }
        });

        
        
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton rdbtnNewRadioButton = new JRadioButton(" Nombre");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton.setBounds(721, 5, 123, 39);

        rdbtnNewRadioButton.setBackground(new Color(246, 196, 205)); 
        panel_1.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Categoria");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton_1.setBounds(415, 5, 133, 39);

        rdbtnNewRadioButton_1.setBackground(new Color(246, 196, 205)); 
        panel_1.add(rdbtnNewRadioButton_1);

        buttonGroup.add(rdbtnNewRadioButton); // Agregar al ButtonGroup
        buttonGroup.add(rdbtnNewRadioButton_1); // Agregar al ButtonGroup


        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 96, 1176, 542);
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout());
        panel_2.setBackground(new Color(246, 196, 205)); 

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
                    List<Producto> productosPorCategoria = buscarPorCategoria(inventario.getCategoriasProductos(), datoABuscar);
                    mostrarProductos(productosPorCategoria, panelTarjetas);
                }
            }
        });
        panel_1.add(btnNewButton);
        
       
       
     
        
     // Agrupar los JRadioButtons para permitir solo una selección
       
        
    }
	 private void mostrarProductos(List<Producto> listaProductos, JPanel panelTarjetas) {
		  panelTarjetas.removeAll();
		  panelTarjetas.setBackground(new Color(246, 196, 205)); 
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
	    				DetallesProducto detalleProducto = new DetallesProducto(producto,inventario,auditoria);
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
	        if (producto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
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
	
	private List<Producto> buscarPorCategoria(ArrayList <CategoriaProducto> categorias , String nombre) {
	    List<Producto> resultados = new ArrayList<>();
	  
	    for (CategoriaProducto categoria : categorias) {
	    	System.out.println(categoria.getNombre()+"-----------------------------"+nombre );
	        if (categoria.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
	        	System.out.println(categoria.getNombre()+"-----------------------------"+nombre );

	            for (Producto producto : categoria.getProductos()) {
	            	System.out.println(producto );
	    	            resultados.add(producto);
	    	        
	    	    }
	            
	        }
	    }


	    System.out.println("Texto a buscar: " + nombre);
	    System.out.println("Resultados encontrados: " + resultados.size());
	    for (Producto p : resultados) {
	        System.out.println("Producto encontrado: " + p.getNombre());
	    }

	    return resultados;
	}
	

	private List<Producto> buscarPorCategoria1(List<Producto> productos, String categoria) {
		  List<Producto> resultados = new ArrayList<>();
		
				
		  
		    List<CategoriaProducto> categorias = inventario.getCategoriasProductos();

		    for (Producto producto : productos) {
		        Queue<CategoriaProducto> categoriasProducto = producto.getCategorias();
		        System.out.println("-----------------------------" );
		        System.out.println(producto);
		        System.out.println("-----------------------------" );

		            for (CategoriaProducto categoriaInventario : categorias) {
		            	System.out.println("=======================" );
		            	System.out.println(categoriaInventario.getNombre().toLowerCase()+"======"+ categoria.toLowerCase());
		            	System.out.println("=======================" );
		            	 if (categoriaInventario.getNombre().toLowerCase().contains(categoria.toLowerCase())) {
		            		 
		            		 
		            	 }
		                	System.out.println("/////////////////////////" );
		                	System.out.println(producto );
			            	System.out.println("/////////////////////////" );
		                    resultados.add(producto);
		                    break;  
		        
		            }
		        }
		   

		    System.out.println("Texto a buscar: " + categoria);
		    System.out.println("Resultados encontrados: " + resultados.size());
		    for (Producto p : resultados) {
		        System.out.println("Producto encontrado: " + p.getNombre());
		    }

		    return resultados;
		}
	
	}