package inventariosSuper.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Inventario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ProveedorProductos extends JFrame {
	private Inventario inventario;
	private JPanel contentPane;
	private JTextField textField;

	public ProveedorProductos(Inventario inventario) {
		this.inventario = inventario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  1200, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmVolver = new JMenuItem("< Volver");
		menuBar.add(mntmVolver);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscador = new JPanel();
		panelBuscador.setBackground(new Color(255, 192, 203));
		contentPane.add(panelBuscador, BorderLayout.NORTH);
		panelBuscador.setLayout(null);
		panelBuscador.setPreferredSize(new Dimension(1200, 200));
		
		JLabel lblBuscarProveedor = new JLabel("BUSCAR PROVEEDOR: ");
		lblBuscarProveedor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBuscarProveedor.setBounds(26, 152, 343, 14);
		panelBuscador.add(lblBuscarProveedor);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(262, 148, 518, 23);
		panelBuscador.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBuscar.setBounds(797, 150, 122, 23);
		panelBuscador.add(btnBuscar);
		
		JButton btnMostrarTodo = new JButton("MOSTRAR TODO");
		btnMostrarTodo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMostrarTodo.setBounds(961, 150, 189, 23);
		panelBuscador.add(btnMostrarTodo);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
	}
}
