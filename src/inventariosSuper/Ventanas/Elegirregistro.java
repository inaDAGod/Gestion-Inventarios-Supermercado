package inventariosSuper.Ventanas;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.ListaComprasCompartida;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Ventanas.Nuevocli;
import inventariosSuper.Ventanas.RegistrandoCli;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Elegirregistro extends JFrame {

	private JPanel contentPane;
	private Compras compra;
	private List<Compras> listaCompras;
	private JTextArea textAreaCompras;
	private JTextArea textArea;
	private Inventario inventario;
	

	/**
	 * Launch the application.
	 */
    
	public Elegirregistro(List<Compras> listaCompras, Inventario inventario) {
		this.listaCompras = listaCompras;
		this.inventario =inventario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(233, 225, 221));
		contentPane.setBackground(new Color(233, 225, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(233, 225, 221));
		panel.setBackground(new Color(233, 225, 221));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textArea = new JTextArea();
        textArea.setBounds(353, 506, 421, 237);
        panel.add(textArea);
        textArea.setEditable(false);

        if (listaCompras != null && !listaCompras.isEmpty()) {
            StringBuilder comprasTexto = new StringBuilder();
            comprasTexto.append("Lista de Compras:\n");
            for (Compras compra : listaCompras) {
                comprasTexto.append("Producto: ")
                           .append(compra.getProd().getNombre())
                           .append(", Cantidad: ")
                           .append(compra.getCant())
                           .append("\n");
                // Puedes agregar más detalles si es necesario
            }
            textArea.setText(comprasTexto.toString());
        } else {
            textArea.setText("No hay elementos en la lista de compras.");
        }
		
		JButton btnNewButton = new JButton("Nuevo Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevocli clienteRecurrenteWindow = new Nuevocli(listaCompras,inventario);
		        clienteRecurrenteWindow.setVisible(true);
		        setVisible(false);
		        dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(246, 196, 205));
		btnNewButton.setBounds(101, 292, 352, 96);
		panel.add(btnNewButton);
		
		JButton btnClienteRecurente = new JButton("Cliente Recurente");
		btnClienteRecurente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrandoCli clienteRecurrenteWindow = new RegistrandoCli(listaCompras,inventario);
		        clienteRecurrenteWindow.setVisible(true);
		        setVisible(false);
	            dispose();
			}
		});
		btnClienteRecurente.setForeground(Color.WHITE);
		btnClienteRecurente.setBackground(new Color(246, 196, 205));
		btnClienteRecurente.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnClienteRecurente.setBounds(699, 293, 352, 96);
		panel.add(btnClienteRecurente);
		
		JLabel lblNewLabel = new JLabel("Eleccion de Cliente");
		lblNewLabel.setBackground(new Color(246, 196, 205));
		lblNewLabel.setForeground(new Color(246, 196, 205));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(310, 80, 488, 96);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Compras");
		lblNewLabel_1.setForeground(new Color(246, 196, 205));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(479, 448, 168, 48);
		panel.add(lblNewLabel_1);
		
		
	}
	private void abrirFacturaConCliente(Cliente cliente) {
	    FacturaPage facturaPage = new FacturaPage(cliente, inventario);
	    facturaPage.setVisible(true);
	    dispose();  // Cerrar la ventana actual
	}
	
	private void mostrarListaCompras() {
        StringBuilder comprasTexto = new StringBuilder();
        comprasTexto.append("Lista de Compras:\n");
        for (Compras compra : listaCompras) {
            comprasTexto.append("Producto: ").append(compra.getProd().getNombre()).append(", Cantidad: ").append(compra.getCant()).append("\n");
            // Agrega más detalles si es necesario
        }
        textAreaCompras.setText(comprasTexto.toString());
    }

}
