package inventariosSuper.Ventanas;

import inventariosSuper.Clases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class VentanaInicio extends JFrame {
    private Inventario inventario;
    private Auditoria auditoria;
    private List<Cliente> listaClientes;
    private Producto produ;
    private List<Compras> listaCompras;
    private List<Comprado> historialCompras;

    public VentanaInicio(Inventario i, Auditoria a,List<Cliente> listaClientes,List<Comprado> historialCompras) {
        this.inventario = i;
        this.auditoria = a;
        this.listaClientes = listaClientes;
        this.historialCompras = historialCompras;
        this.listaCompras = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear y agregar el panel de la cabecera
        JPanel panelCabecera = new JPanel();
        panelCabecera.setBackground(new Color(246, 196, 205));
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

                AnadirProducto frame = new AnadirProducto(inventario, auditoria, historialCompras, listaClientes);
                frame.setVisible(true);
                setVisible(false);
            }
        });

        //Botón elegir Producto
        btnElegirProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Elegirproduc frame = new Elegirproduc(inventario, auditoria, listaCompras, listaClientes, historialCompras);
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Assuming you have the list of clients (listaClientes) and purchase history (historialCompras)

        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarClientes frame = new MostrarClientes(listaClientes, inventario, auditoria, historialCompras);

                frame.setVisible(true);
                setVisible(false);
            }
        });


        //Botón Productos
        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaProductos frame = new ListaProductos(inventario, auditoria, listaClientes, historialCompras);
                frame.setVisible(true);
                setVisible(false);
            }
        });
        //Boton Auditorías
        btnAuditoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAuditoria ventanaAuditoria = new VentanaAuditoria(auditoria,inventario, listaClientes, historialCompras);
                ventanaAuditoria.setVisible(true);
                setVisible(false);


            }
        });

        // ActionListener para el botón "Recordatorios"
        btnRecordatorios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                RecordatoriosVentana recordatoriosVentana = new RecordatoriosVentana(creacionRecordatorio(),auditoria,inventario, listaClientes, historialCompras);
                recordatoriosVentana.setVisible(true);
                setVisible(false);



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


}