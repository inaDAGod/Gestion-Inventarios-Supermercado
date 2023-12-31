package inventariosSuper.Ventanas;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    private Comprado u;
    private Inventario inventario;
	private Auditoria auditoria;
	private List<Cliente> listaClientes = new ArrayList<>();
	private List<Comprado> historialCompras = new ArrayList<>();
	//private MostrarClientes ventanaMostrarClientes;
	

    private MostrarClientes mostrarClientes;

    // Constructor que recibe MostrarClientes como parámetro adicional
    public FacturaPage(Cliente cliente, Inventario inventario,Auditoria auditoria, List<Cliente> listaClientes,List<Comprado> historialCompras ) {
        this.cliente = cliente;
        this.inventario = inventario;
        this.u = new Comprado(cliente, LocalDateTime.now()); // Crear instancia con tiempo actual
        this.mostrarClientes = mostrarClientes;
        this.auditoria = auditoria;
        this.listaClientes = listaClientes;
        this.historialCompras=historialCompras;
        //this.ventanaMostrarClientes = ventanaMostrarClientes;
        
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
        textAreaCompras.setEditable(false);

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
				
				
				VentanaInicio ventanaInicio = new VentanaInicio(inventario,auditoria, listaClientes, historialCompras);
				ventanaInicio.setVisible(true);
				setVisible(false);
				
			}
		});
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Times New Roman", Font.ITALIC, 10));
        btnVolver.setBackground(Color.PINK);
        btnVolver.setBounds(1014, 21, 150, 30);
        contentPane.add(btnVolver);

        btnRegistrarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	registrarCompra(cliente,historialCompras );
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
    
    
    
    public void registrarCompra(Cliente cliente, List<Comprado> historialCompras) {
        LocalDateTime fechaActual = LocalDateTime.now();
        if (!historialCompras.isEmpty()) {
            Comprado firstItem = historialCompras.get(0);
            firstItem.agregarCompra(cliente, fechaActual);
            JOptionPane.showMessageDialog(null, "Compra registrada para " + cliente.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "No hay compras en el historial.");
        }
    }




	
}