package inventariosSuper.Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Comprado;

import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.GestorComprado;

import inventariosSuper.Clases.Inventario;


import javax.swing.JTextArea;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarClientes extends JFrame {

    private JTextArea textArea;
    private List<Cliente> listaClientes;
    private Comprado comprado;
    private Inventario inventario;
	private Auditoria auditoria;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public MostrarClientes(Inventario i, Auditoria a, List<Cliente> listaClientes, Comprado comprado) {
        this.listaClientes = listaClientes;
        this.comprado = comprado;
        this.inventario = i;
        this.auditoria = a;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        textArea.setBounds(168, 168, 859, 521);
        contentPane.add(textArea);
        textArea.setEditable(false);
        
        JLabel lblNewLabel = new JLabel("Clientes registrados");
        lblNewLabel.setForeground(Color.PINK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(437, 74, 346, 59);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			setVisible(false);
        			VentanaInicio ventanaInicio = new VentanaInicio(inventario,auditoria);
        			ventanaInicio.setVisible(true);
        			
        		}
        	});;
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        btnNewButton.setBackground(Color.PINK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(989, 26, 133, 53);
        contentPane.add(btnNewButton);

        mostrarCompras();
    }
    

    public void mostrarCompras() {
        if (listaClientes != null && comprado != null) {
            textArea.append("\n\nHistorial de compras:\n");
            for (Cliente cliente : listaClientes) {
                LocalDateTime fechaCompra = comprado.obtenerFechaDeCompra(cliente);
                if (fechaCompra != null) {
                    textArea.append("Cliente: " + cliente.getNombre() + "\n");
                    textArea.append("Fecha de compra: " + fechaCompra.format(formatter) + "\n\n");
                }
            }
        } else {
            textArea.setText("No se han proporcionado clientes o historial de compras.");
        }
    }

 

    private static List<Cliente> cargarClientesDesdeArchivo(String rutaArchivo) {
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

    private static Comprado cargarComprasDesdeArchivo(String rutaArchivo, List<Cliente> listaClientes) {
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

    private static Cliente buscarClientePorNombre(String nombreCliente, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }
}
