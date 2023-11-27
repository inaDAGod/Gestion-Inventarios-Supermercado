package inventariosSuper.Ventanas;

import inventariosSuper.Clases.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class VentanaInicio extends JFrame {

    public VentanaInicio() {
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
        JButton btnElegirProducto = new JButton("ELEGIR PRODUCTO");
        btnElegirProducto.setFont(fontBotones);
        btnElegirProducto.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnElegirProducto);

        // Botón "Cliente"
        JButton btnCliente = new JButton("CLIENTE");
        btnCliente.setFont(fontBotones);
        btnCliente.setPreferredSize(new Dimension(280, 120)); // Ajuste en el ancho
        panelBotones.add(btnCliente);

        // Botón "Productos"
        JButton btnProductos = new JButton("PRODUCTOS");
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
                Inventario i = new Inventario();
                CategoriaProducto c = new CategoriaProducto("Comestible", "Para comer");// categoria nueva
                CategoriaProducto c2 = new CategoriaProducto("Ropa", "Para ponerte");// categoria nueva
                Proveedor p = new Proveedor("1", "Coca Cola", "Obrajes", "4564", "coca@gmail.com");
                i.añadirProveedor(p);
                i.añadirCategoriaProducto(c);
                i.añadirCategoriaProducto(c2);

                AnadirProducto frame = new AnadirProducto(i);
                frame.setVisible(true);
            }
        });

        //Botón elegir Producto
        btnElegirProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                Elegirproduc frame = new Elegirproduc(inventario);
                frame.setVisible(true);
            }
        });

        //Botón Clientes
        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Compras compras = new Compras();

                Elegirregistro frame = new Elegirregistro(compras);
                frame.setVisible(true);
            }
        });

        //Botón Productos
        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        SwingUtilities.invokeLater(() -> {
            try {
                VentanaInicio frame = new VentanaInicio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
