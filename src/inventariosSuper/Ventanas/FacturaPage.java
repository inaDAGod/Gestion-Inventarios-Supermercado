package inventariosSuper.Ventanas;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.ManejadorArchivo;
import inventariosSuper.Ventanas.MostrarClientes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.Color;

public class FacturaPage extends JFrame {

    private JPanel contentPane;
    private Cliente cliente;
    private JButton btnMostrarCompras;
    private JTextArea textAreaCompras;
    private Comprado historialCompras;
    private Inventario inventario;
	private Auditoria auditoria;


    private MostrarClientes mostrarClientes;

    // Constructor que recibe MostrarClientes como parámetro adicional
    public FacturaPage(Cliente cliente) {
        this.cliente = cliente;
        this.historialCompras = new Comprado(cliente, LocalDateTime.now()); // Crear instancia con tiempo actual
        this.mostrarClientes = mostrarClientes; // Guarda la instancia de MostrarClientes
        initialize();
    }


    public void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 713);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblClienteSeleccionado = new JLabel("Factura Para el Cliente");
        lblClienteSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
        lblClienteSeleccionado.setForeground(Color.PINK);
        lblClienteSeleccionado.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        lblClienteSeleccionado.setBounds(413, 21, 324, 52);
        contentPane.add(lblClienteSeleccionado);

        JLabel lblNombre = new JLabel("Cliente");
        lblNombre.setBounds(279, 73, 100, 14);
        contentPane.add(lblNombre);

        // ... Aquí se agregan otros JLabel con los detalles del cliente

        textAreaCompras = new JTextArea();
        textAreaCompras.setBounds(279, 97, 574, 384);
        contentPane.add(textAreaCompras);

        btnMostrarCompras = new JButton("Mostrar Compras");
        btnMostrarCompras.setFont(new Font("Times New Roman", Font.ITALIC, 10));
        btnMostrarCompras.setBackground(Color.PINK);
        btnMostrarCompras.setForeground(Color.WHITE);
        btnMostrarCompras.setBounds(703, 516, 150, 30);
        contentPane.add(btnMostrarCompras);

        btnMostrarCompras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaDeCompras();
            }
        });
        
       
        
        JButton btnRegistrarCompra = new JButton("Registrar Compra");
        btnRegistrarCompra.setBackground(Color.PINK);
        btnRegistrarCompra.setFont(new Font("Times New Roman", Font.ITALIC, 10));
        btnRegistrarCompra.setForeground(Color.WHITE);
        btnRegistrarCompra.setBounds(279, 516, 150, 30);
        contentPane.add(btnRegistrarCompra);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaInicio ventanaInicio = new VentanaInicio(inventario,auditoria);
				ventanaInicio.setVisible(true);
				
			}
		});
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Times New Roman", Font.ITALIC, 10));
        btnVolver.setBackground(Color.PINK);
        btnVolver.setBounds(1014, 21, 150, 30);
        contentPane.add(btnVolver);

        btnRegistrarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	registrarCompra( );
            }
        });
    }

    public void mostrarListaDeCompras() {
        textAreaCompras.setText(""); // Limpia el área de texto antes de mostrar las compras

        textAreaCompras.append("Lista de compras de " + cliente.getNombre() + ":\n");
        for (Compras comp : cliente.getListaCompras()) {
            Producto producto = comp.getProd();
            int cantidad = comp.getCant();
            double costoTotal = comp.getCostoTotal();

            textAreaCompras.append("Producto: " + producto.getNombre() +
                    " - Cantidad: " + cantidad +
                    " - Costo Total: $" + costoTotal + "\n");
        }
    }

    
    
    public void registrarCompra() {
        LocalDateTime fechaActual = LocalDateTime.now(); // Obtiene la fecha actual
        historialCompras.agregarCompra(cliente, fechaActual); // Agrega la compra al historial
        JOptionPane.showMessageDialog(null, "Compra registrada para " + cliente.getNombre());

        // Guardar en un archivo de texto
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("compras.txt", true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = fechaActual.format(formatter);
            String data = cliente.getNombre() + "," + formattedDate + "\n";
            writer.write(data);
            writer.flush(); // Asegúrate de que los datos se escriban en el archivo
            
            // Actualiza la visualización de compras en la instancia de MostrarClientes
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}