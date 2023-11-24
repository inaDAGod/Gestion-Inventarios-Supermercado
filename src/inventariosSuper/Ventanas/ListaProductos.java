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
import inventariosSuper.Clases.Inventario;


public class ListaProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
private JTextField txtDatoABuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProductos frame = new ListaProductos();
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
	public ListaProductos() {
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
        
        JLabel lblSedatoABuscar = new JLabel("Seleccione el tipo de dato:");
        lblSedatoABuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSedatoABuscar.setBounds(0, 9, 298, 31);
        panel_1.add(lblSedatoABuscar);
        
        JButton btnNewButton = new JButton("Buscar ");
        btnNewButton.setBounds(1051, 47, 115, 39);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar productos
                String datoABuscar = txtDatoABuscar.getText();
                // Puedes utilizar el datoABuscar para buscar productos en el inventario
                // y actualizar la visualización en consecuencia
            }
        });
        panel_1.add(btnNewButton);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton(" Nombre");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton.setBounds(721, 5, 123, 39);
        panel_1.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Categoria");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        rdbtnNewRadioButton_1.setBounds(415, 5, 133, 39);
        panel_1.add(rdbtnNewRadioButton_1);
        
     
        
     // Agrupar los JRadioButtons para permitir solo una selección
       
        

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 96, 1176, 542);
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout());

        JPanel panelTarjetas = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panelTarjetas);
        panel_2.add(scrollPane, BorderLayout.CENTER);

        mostrarProductos(inventario.getProductos(), panelTarjetas);
    }
	 private void mostrarProductos(List<Producto> listaProductos, JPanel panelTarjetas) {
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
	}