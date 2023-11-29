package inventariosSuper.Ventanas;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;


import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.ListaComprasCompartida;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.GestorClientes;
import inventariosSuper.Clases.Comprado;
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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;

public class RegistrandoCli extends JFrame {

    private List<Cliente> listaClientes;
    private Compras compras;
    private List<Compras> listaCompras = ListaComprasCompartida.getListaCompras();
    private Cliente clienteRegistrado;
    private Cliente clienteSeleccionado;
    private JTextField campoBusqueda;
    private JTextArea areaResultado;
    private GestorClientes gestorClientes;
    
    public static void main(String[] args) {
    	 List<Compras> listaCompras = new ArrayList<>(); // Populate this with your actual data

 	    EventQueue.invokeLater(new Runnable() {
 	        public void run() {
 	            try {
 	                RegistrandoCli frame = new RegistrandoCli(listaCompras);
 	                frame.setVisible(true);
 	            } catch (Exception e) {
 	                e.printStackTrace();
 	            }
 	        }
 	    });
 	}
    
    public RegistrandoCli(List<Compras> listaCompras) {
    	
        super("Búsqueda de Clientes");
        listaClientes = new ArrayList<>();
        areaResultado = new JTextArea();
        this.listaCompras = new ArrayList<>(listaCompras != null ? listaCompras : new ArrayList<>());
	    // ... rest of your constructor code
	    for (Compras compra : listaCompras) {
	        System.out.println("Producto: " + compra.getProd().getNombre() + ", Cantidad: " + compra.getCant());;
        
        gestorClientes = new GestorClientes();
        mostrarClientesRegistrados();
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
                buscarCliente1();
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
        setVisible(true);}
    }

    private void buscarCliente1() {
        String nombreBusqueda = campoBusqueda.getText();
        List<Cliente> clientesEncontrados = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                clientesEncontrados.add(cliente);
            }
        }

        if (!clientesEncontrados.isEmpty()) {
            clienteSeleccionado = seleccionarCliente(clientesEncontrados);
            if (clienteSeleccionado != null) {
                areaResultado.setText(
                        "Cliente seleccionado:\n" +
                                "Nombre: " + clienteSeleccionado.getNombre() + "\n" +
                                "ID: " + clienteSeleccionado.getId() + "\n" +
                                "Número: " + clienteSeleccionado.getNumero() + "\n" +
                                "Dirección: " + clienteSeleccionado.getDireccion()
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

            return clienteSeleccionado;
        }
        
        private void abrirPaginaFactura() {
            if (clienteSeleccionado != null) {
                if (!clienteSeleccionado.getListaCompras().isEmpty()) {
                	try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientescomp.txt", true))) {
		    	        writer.write(clienteSeleccionado.getNombre() + "," + clienteSeleccionado.getId() + "," + clienteSeleccionado.getNumero() + "," + clienteSeleccionado.getDireccion()+ "," +clienteSeleccionado.getListaCompras());
		    	        writer.newLine();
		    	    } catch (IOException ex) {
		    	        ex.printStackTrace();
		    	    }
                    FacturaPage facturaPage = new FacturaPage(clienteSeleccionado);
                    facturaPage.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "El cliente no tiene compras registradas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
                    Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]), Integer.parseInt(datosCliente[2]), datosCliente[3], listaCompras);
                    listaClientes.add(cliente);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        private void mostrarClientesRegistrados() {
            List<Cliente> clientes = gestorClientes.getListaClientes();

            StringBuilder clientesRegistrados = new StringBuilder();
            for (Cliente cliente : clientes) {
                clientesRegistrados.append("Nombre: ").append(cliente.getNombre())
                        .append(", ID: ").append(cliente.getId())
                        .append(", Número: ").append(cliente.getNumero())
                        .append(", Dirección: ").append(cliente.getDireccion())
                        .append("\n");
            }

            areaResultado.setText(clientesRegistrados.toString());
        }
        
//--------    
       
}
