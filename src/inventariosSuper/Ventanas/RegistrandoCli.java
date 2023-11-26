package inventariosSuper.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Comprado;


import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;

public class RegistrandoCli extends JFrame {

    private List<Cliente> listaClientes;
    private Cliente clienteRegistrado;
    private JTextField campoBusqueda;
    private JTextArea areaResultado;

    public RegistrandoCli() {
        super("Búsqueda de Clientes");
        listaClientes = new ArrayList<>();

        // Crear algunos clientes de ejemplo
        //Cliente cliente1 = new Cliente("Juan", 1, 12345, "Calle A");
        //Cliente cliente2 = new Cliente("María", 2, 67890, "Calle B");
        //listaClientes.add(cliente1);
        //listaClientes.add(cliente2);

        // Configurar la interfaz gráfica
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cargarClientesDesdeArchivo("clientes.txt");
        

        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel("Nombre del Cliente:");
        etiqueta.setForeground(Color.PINK);
        etiqueta.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(69, 222, 146, 53);
        campoBusqueda = new JTextField(20);
        campoBusqueda.setBounds(225, 229, 221, 42);
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(Color.PINK);
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        botonBuscar.setBounds(646, 227, 130, 42);

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
        panel.setLayout(null);

        panel.add(etiqueta);
        panel.add(campoBusqueda);
        panel.add(botonBuscar);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(69, 298, 707, 402);
        panel.add(scrollPane);
        areaResultado = new JTextArea(10, 30);
        scrollPane.setViewportView(areaResultado);
        areaResultado.setEditable(false);

        getContentPane().add(panel);
        
        JButton btnNewButton = new JButton("Siguiente");
        btnNewButton.setBackground(Color.PINK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		abrirPaginaFactura();
        	}
        });
        btnNewButton.setBounds(882, 638, 221, 62);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Clientes Recurentes");
        lblNewLabel.setForeground(Color.PINK);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 45));
        lblNewLabel.setBounds(349, 54, 500, 84);
        panel.add(lblNewLabel);
        setVisible(true);
    }

    private void buscarCliente1() {
        String nombreBusqueda = campoBusqueda.getText();
        Cliente clienteEncontrado = null;

        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            areaResultado.setText(
                    "Cliente encontrado:\n" +
                            "Nombre: " + clienteEncontrado.getNombre() + "\n" +
                            "ID: " + clienteEncontrado.getId() + "\n" +
                            "Número: " + clienteEncontrado.getNumero() + "\n" +
                            "Dirección: " + clienteEncontrado.getDireccion()
            );
        } else {
            areaResultado.setText("Cliente no encontrado.");
        }
    }
//-----
    

    private void buscarCliente() {
        String nombreBusqueda = campoBusqueda.getText();
        List<Cliente> clientesEncontrados = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                clientesEncontrados.add(cliente);
            }
        }

        if (!clientesEncontrados.isEmpty()) {
        	clienteRegistrado = seleccionarCliente(clientesEncontrados);
            if (clienteRegistrado != null) {
                areaResultado.setText(
                        "Cliente seleccionado:\n" +
                                "Nombre: " + clienteRegistrado.getNombre() + "\n" +
                                "ID: " + clienteRegistrado.getId() + "\n" +
                                "Número: " + clienteRegistrado.getNumero() + "\n" +
                                "Dirección: " + clienteRegistrado.getDireccion()
                );
            }
        } else {
            areaResultado.setText("Cliente no encontrado.");
        }
    }


        private Cliente seleccionarCliente(List<Cliente> clientes) {
            Cliente[] clientesArray = clientes.toArray(new Cliente[0]);
            Cliente clienteSeleccionado = (Cliente) JOptionPane.showInputDialog(
                    this,
                    "Selecciona un cliente:",
                    "Clientes encontrados",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    clientesArray,
                    clientesArray[0]
            );

            return clienteRegistrado;
        }
        
        private void abrirPaginaFactura() {
        	if (clienteRegistrado != null) {
                FacturaPage facturaPage = new FacturaPage(clienteRegistrado);
                facturaPage.setVisible(true);
                setVisible(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente primero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
//-----------        
        private void cargarClientesDesdeArchivo(String rutaArchivo) {
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datosCliente = linea.split(",");
                    // Crear el cliente a partir de los datos del archivo
                    Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]), Integer.parseInt(datosCliente[2]), datosCliente[3]);
                    listaClientes.add(cliente);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//--------    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrandoCli();
            }
        });
    }
}
