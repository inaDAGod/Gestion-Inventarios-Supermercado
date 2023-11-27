package inventariosSuper.Ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Clases.Producto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class FacturaPage extends JFrame {

    private JPanel contentPane;
    private Cliente cliente;
    private JButton btnMostrarCompras;
    private JTextArea textAreaCompras;
    private Comprado historialCompras;

    public FacturaPage(Cliente cliente) {
    	this.cliente = cliente;
        this.historialCompras = new Comprado();
        initialize();
    }

    public void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblClienteSeleccionado = new JLabel("Cliente Seleccionado");
        lblClienteSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblClienteSeleccionado.setBounds(200, 10, 200, 20);
        contentPane.add(lblClienteSeleccionado);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 50, 100, 14);
        contentPane.add(lblNombre);

        // ... Aquí se agregan otros JLabel con los detalles del cliente

        textAreaCompras = new JTextArea();
        textAreaCompras.setBounds(30, 100, 500, 300);
        contentPane.add(textAreaCompras);

        btnMostrarCompras = new JButton("Mostrar Compras");
        btnMostrarCompras.setBounds(200, 420, 150, 30);
        contentPane.add(btnMostrarCompras);

        btnMostrarCompras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaDeCompras();
            }
        });
        
        JButton btnRegistrarCompra = new JButton("Registrar Compra");
        btnRegistrarCompra.setBounds(30, 420, 150, 30);
        contentPane.add(btnRegistrarCompra);

        btnRegistrarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	registrarCompra();
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
    }
    
}
