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
    private List<Cliente> listaClientes = new ArrayList<>();
    private Comprado comprado;
    private Inventario inventario;
	private Auditoria auditoria;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private List<Comprado> historialCompras = new ArrayList<>();

    public MostrarClientes(List<Cliente> listaClientes,Inventario inventario,Auditoria auditoria,List<Comprado> historialCompras) {
        this.listaClientes = listaClientes;
        this.comprado = comprado;
        this.inventario = inventario;
        this.auditoria=auditoria;
        this.historialCompras=historialCompras;
        

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(233, 225, 221));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        textArea.setBounds(168, 168, 859, 521);
        contentPane.add(textArea);
        textArea.setEditable(false);
        
        JLabel lblNewLabel = new JLabel("Clientes registrados");
        lblNewLabel.setForeground(new Color(246,196,205));
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(437, 74, 346, 59);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			setVisible(false);
        			VentanaInicio ventanaInicio = new VentanaInicio(inventario, auditoria, listaClientes, historialCompras);
        			ventanaInicio.setVisible(true);
        			
        		}
        	});;
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        btnNewButton.setBackground(new Color(246,196,205));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(989, 26, 133, 53);
        contentPane.add(btnNewButton);

        mostrarCompras(historialCompras);
    }
    

    public void mostrarCompras(List<Comprado> historialCompras) {
        if (listaClientes != null && historialCompras != null && !listaClientes.isEmpty() && !historialCompras.isEmpty()) {
            //textArea.append("\n\nHistorial de compras:\n");
            
            for (Comprado comprado : historialCompras) {
                // Call the modified mostrarCompras() method which now returns a String
                textArea.append(comprado.mostrarCompras() + "\n\n");
            }
        } else {
            textArea.setText("No se han proporcionado clientes o historial de compras.");
        }
    }

    


    

    

    
    
}
