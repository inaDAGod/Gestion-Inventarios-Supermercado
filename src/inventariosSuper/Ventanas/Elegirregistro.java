package inventariosSuper.Ventanas;


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

import inventariosSuper.Clases.CategoriaProducto;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Producto;
import inventariosSuper.Clases.Proveedor;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Comprado;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Elegirregistro frame = new Elegirregistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Elegirregistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Nuevo Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevocli nuevoCliWindow = new Nuevocli();
		        nuevoCliWindow.setVisible(true);
		        setVisible(false);
	            dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(117, 327, 352, 96);
		panel.add(btnNewButton);
		
		JButton btnClienteRecurente = new JButton("Cliente Recurente");
		btnClienteRecurente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrandoCli clienteRecurrenteWindow = new RegistrandoCli();
		        clienteRecurrenteWindow.setVisible(true);
		        setVisible(false);
	            dispose();
			}
		});
		btnClienteRecurente.setForeground(Color.WHITE);
		btnClienteRecurente.setBackground(Color.PINK);
		btnClienteRecurente.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnClienteRecurente.setBounds(644, 328, 352, 96);
		panel.add(btnClienteRecurente);
		
		JLabel lblNewLabel = new JLabel("Eleccion de Cliente");
		lblNewLabel.setBackground(new Color(255, 175, 175));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(310, 80, 488, 96);
		panel.add(lblNewLabel);
	}
}
