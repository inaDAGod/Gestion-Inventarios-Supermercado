package inventariosSuper.Ventanas;

import inventariosSuper.Clases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class VentanaInicio extends JFrame {
	private Inventario inventario;
	private Auditoria auditoria;
	private List<Cliente> listaClientes;
    private Comprado historialCompras;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public VentanaInicio(Inventario i, Auditoria a) {
    	this.inventario = i;
    	this.auditoria = a;
    	this.listaClientes = cargarClientesDesdeArchivo("clientescomp.txt");
	    this.historialCompras = cargarComprasDesdeArchivo("compras.txt", listaClientes);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear y agregar el panel de la cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(255, 240, 245));
        panelCabecera.setPreferredSize(new Dimension(1800, 130));
        getContentPane().add(panelCabecera, BorderLayout.NORTH);
        panelCabecera.setLayout(null);

        JLabel lblTitulo = new JLabel("GESTIÓN DE INVENTARIOS DE SUPERMERCADO");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 35));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(100, 40, 1000, 60);
        panelCabecera.add(lblTitulo);

        // Crear y agregar el panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 30, 30));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        getContentPane().add(panelBotones, BorderLayout.CENTER);

        // Ajustes comunes para los botones
        Font fontBotones = new Font("Times New Roman", Font.BOLD, 16);

        // Botón "Añadir Producto"
        JButton btnAnadirProducto = new JButton("AÑADIR PRODUCTO");
        btnAnadirProducto.setFont(fontBotones);
        btnAnadirProducto.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnAnadirProducto);

        // Botón "Elegir Producto"
        JButton btnElegirProducto = new JButton("COMPRAR");
        btnElegirProducto.setFont(fontBotones);
        btnElegirProducto.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnElegirProducto);

        // Botón "Cliente"
        JButton btnCliente = new JButton("CLIENTE");
        btnCliente.setFont(fontBotones);
        btnCliente.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnCliente);

        // Botón "Productos"
        JButton btnProductos = new JButton("INVENTARIO");
        btnProductos.setFont(fontBotones);
        btnProductos.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnProductos);

        // Botón "Auditoría"
        JButton btnAuditoria = new JButton("AUDITORÍA");
        btnAuditoria.setFont(fontBotones);
        btnAuditoria.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnAuditoria);

        // Botón "Recordatorios"
        JButton btnRecordatorios = new JButton("RECORDATORIOS");
        btnRecordatorios.setFont(fontBotones);
        btnRecordatorios.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnRecordatorios);

        //EVENTOS DE LOS BOTONES

        //Botón Añadir Producto
        btnAnadirProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AnadirProducto frame = new AnadirProducto(inventario,auditoria);
                frame.setVisible(true);
                setVisible(false);
            }
        });

        //Botón elegir Producto
        btnElegirProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Elegirproduc frame = new Elegirproduc(inventario);
                frame.setVisible(true);
            }
        });

     // Assuming you have the list of clients (listaClientes) and purchase history (historialCompras)

        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarClientes frame = new MostrarClientes(inventario, auditoria, listaClientes, historialCompras);
                
                frame.setVisible(true);
            }
        });


        //Botón Productos
        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaProductos frame = new ListaProductos(inventario,auditoria);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        //Boton Auditorías
        btnAuditoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAuditoria ventanaAuditoria = new VentanaAuditoria(auditoria);
                ventanaAuditoria.setVisible(true);
            }
        });

        // ActionListener para el botón "Recordatorios"
        btnRecordatorios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                RecordatoriosVentana recordatoriosVentana = new RecordatoriosVentana(creacionRecordatorio());
                recordatoriosVentana.setVisible(true);
            }
        });

    }
    
    public Recordatorios creacionRecordatorio() {
    	Recordatorios recordatorios = new Recordatorios();
        for (Producto producto : inventario.getProductos()) {
            recordatorios.agregarAlerta(new Alerta(producto));
        }
        return recordatorios;

	}
    private Comprado cargarComprasDesdeArchivo(String rutaArchivo, List<Cliente> listaClientes) {
        Comprado historialCompras = new Comprado(null, null);
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCompra = linea.split(",");
                String nombreCliente = datosCompra[0];
                // Buscar por nombre
                Cliente cliente = buscarClientePorNombre(nombreCliente, listaClientes);
                if (cliente != null) {
                    LocalDateTime fechaCompra = LocalDateTime.parse(datosCompra[1], formatter);
                    historialCompras.agregarCompra(cliente, fechaCompra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return historialCompras;
    }
	private Cliente buscarClientePorNombre(String nombreCliente, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }
	
	private  List<Cliente> cargarClientesDesdeArchivo(String rutaArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]),
                        Integer.parseInt(datosCliente[2]), datosCliente[3], null);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }


}
