package inventariosSuper.Ventanas;

import inventariosSuper.Clases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;


public class VentanaInicio extends JFrame {
	private Inventario inventario;
	private List<Cliente> listaClientes;

    public VentanaInicio(Inventario i) {
    	this.inventario = i;
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

                AnadirProducto frame = new AnadirProducto(inventario);
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

        //Botón Clientes
        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                

                MostrarClientes frame = new MostrarClientes();
                frame.setVisible(true);
            }
        });

        //Botón Productos
        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaProductos frame = new ListaProductos(inventario);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        //Boton Auditorías
        btnAuditoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAuditoria ventanaAuditoria = new VentanaAuditoria();
                ventanaAuditoria.setVisible(true);
            }
        });

        // ActionListener para el botón "Recordatorios"
        btnRecordatorios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RecordatoriosVentana recordatoriosVentana = new RecordatoriosVentana();
                recordatoriosVentana.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        // Create an instance of Inventario or retrieve it from somewhere
        Inventario inventario = new Inventario();

        // Create an instance of VentanaInicio
        VentanaInicio ventanaInicio = new VentanaInicio(inventario);

        // Set the frame visible
        ventanaInicio.setVisible(true);
    }

}
