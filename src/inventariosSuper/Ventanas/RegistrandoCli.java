package inventariosSuper.Ventanas;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;


import inventariosSuper.Clases.*;

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

	private List<Cliente> listaClientes = new ArrayList<>();
    private Compras compras;
    private Inventario inventario;
    private Auditoria auditoria;
    private List<Compras> listaCompras = ListaComprasCompartida.getListaCompras();
    private Cliente clienteRegistrado;
    private Cliente clienteSeleccionado;
    private JTextField campoBusqueda;
    private JTextArea areaResultado;
    private List<Comprado> historialCompras = new ArrayList<>();
    
    
 
    
    public RegistrandoCli(List<Compras> listaCompras,Inventario inventario,Auditoria auditoria,List<Cliente> listaClientes,List<Comprado> historialCompras ) {
    	
        
    	super("Búsqueda de Clientes");
        this.listaClientes = listaClientes;
        areaResultado = new JTextArea();
        this.listaCompras = listaCompras;
        this.inventario = inventario;
        this.auditoria=auditoria;
        this.listaClientes=listaClientes;
        this.historialCompras=historialCompras;
        
        mostrarClientesRegistrados(clienteSeleccionado);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        JPanel panel = new JPanel();
        panel.setBackground(new Color(233, 225, 221));
        JLabel etiqueta = new JLabel("Nombre del Cliente:");
        etiqueta.setForeground(new Color(246, 196, 205));
        etiqueta.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBounds(69, 222, 146, 53);
        campoBusqueda = new JTextField(20);
        campoBusqueda.setBounds(225, 229, 221, 42);
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(new Color(246, 196, 205));
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
        btnNewButton.setBackground(new Color(246, 196, 205));
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
        lblNewLabel.setForeground(new Color(246, 196, 205));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 45));
        lblNewLabel.setBounds(349, 54, 500, 84);
        panel.add(lblNewLabel);
        setVisible(true);
        }
    

    
        
    private void abrirPaginaFactura() {
        if (clienteSeleccionado != null) {
        	clienteSeleccionado.setListaCompras(listaCompras);
            if (!clienteSeleccionado.getListaCompras().isEmpty()) {
                 
                FacturaPage facturaPage = new FacturaPage(clienteSeleccionado, inventario, auditoria, listaClientes, historialCompras);
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
        
    private void buscarCliente1() {
        String nombreBusqueda = campoBusqueda.getText(); 
        List<Cliente> clientesEncontrados = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            String nombreCliente = cliente.getNombre().toLowerCase(); 
            if (nombreCliente.startsWith(nombreBusqueda.toLowerCase())) {
                clientesEncontrados.add(cliente);
            }
        }

        if (!clientesEncontrados.isEmpty()) {
            clienteSeleccionado = seleccionarCliente(clientesEncontrados);
            if (clienteSeleccionado != null) {
                mostrarClientesRegistrados(clienteSeleccionado);
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

    private void mostrarClientesRegistrados(Cliente cliente) {
        if (cliente != null) {
            StringBuilder clientesRegistrados = new StringBuilder();
            clientesRegistrados.append("Nombre: ").append(cliente.getNombre())
                .append(", ID: ").append(cliente.getId())
                .append(", Número: ").append(cliente.getNumero())
                .append(", Dirección: ").append(cliente.getDireccion())
                .append("\n");

            areaResultado.setText(clientesRegistrados.toString());
        } else {
            areaResultado.setText("Cliente no encontrado.");
        }
    }



        
//--------    
       
}
