package inventariosSuper.Ventanas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Auditoria;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.ListaComprasCompartida;
import inventariosSuper.Clases.Producto;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Agregarproduc extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea_1;
    private double numeroIngresado; // Variable para almacenar el número ingresado
    private Producto producto;
    private Compras compra;
    private JTextArea textArea_2;
    private StringBuilder comprasTexto;
    private List<Compras> listaCompras = ListaComprasCompartida.getListaCompras();
    private Inventario inventario;
    private List<Compras> comprasList;
    private Auditoria auditoria;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Comprado> historialCompras = new ArrayList<>();
    
    

    

    public Agregarproduc(Producto produ, Inventario inventario, List<Compras> listaCompras,Auditoria auditoria,List<Cliente> listaClientes, List<Comprado> historialCompras ) {
        this.producto = produ;
        this.listaCompras = listaCompras != null ? new ArrayList<>(listaCompras) : new ArrayList<>();
        this.inventario = inventario;
        this.auditoria = auditoria;
        this.listaClientes=listaClientes;
        this.historialCompras=historialCompras;
        




    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(233, 225, 221));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(36, 96, 470, 171);
        contentPane.add(textArea);
        textArea.setEditable(false);
        if (produ != null) {
            StringBuilder productDetails = new StringBuilder();
            productDetails.append("Nombre: ").append(produ.getNombre()).append("\n");
            productDetails.append("Descripción: ").append(produ.getDetalle()).append("\n");
            productDetails.append("Precio: ").append(produ.getPrecio()).append("\n");
            // Añade más detalles si es necesario

            textArea.setText(productDetails.toString());
        }

        textField = new JTextField();
        textField.setBounds(713, 86, 284, 45);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBackground(new Color(246, 196, 205));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        btnCalcular.setBounds(713, 409, 126, 56);
        contentPane.add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String texto = textField.getText();
                    numeroIngresado = Double.parseDouble(texto);

                    double resultado = numeroIngresado * producto.getPrecio();

                    textArea_1.setText("El total es: " + resultado);
                } catch (NumberFormatException ex) {
                    textArea_1.setText("Error: Ingresa un número válido");
                }
            }
        });
        
        textArea_2 = new JTextArea();
        textArea_2.setBounds(36, 405, 470, 171);
        contentPane.add(textArea_2);
        textArea_2.setEditable(false);
        comprasTexto = new StringBuilder(); // Inicializa comprasTexto aquí
        actualizarListaCompras();
        
        
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(246, 196, 205));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (listaCompras != null) {
                        int cantidad = Integer.parseInt(textField.getText());
                        Compras nuevaCompra = new Compras(producto, cantidad);
                        double resultado = Double.parseDouble(textField.getText()) * producto.getPrecio();
                        textArea_1.setText("El total es: " + resultado);

                        listaCompras.add(nuevaCompra);

                        JOptionPane.showMessageDialog(null, "¡Registro exitoso!\n");
                        

                        actualizarListaCompras();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: La lista de compras no está inicializada");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido");
                }
            }
        });

        btnRegistrar.setBounds(871, 409, 126, 56);
        contentPane.add(btnRegistrar);
        
        
        

        JButton btnNewButton = new JButton("Finalizar Compras");
        btnNewButton.setBackground(new Color(246, 196, 205));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Elegirregistro detalleProducto = new Elegirregistro(listaCompras,inventario, auditoria, listaClientes, historialCompras);
                    detalleProducto.setVisible(true);
                    setVisible(false);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido");
                }
            }
        });


        	
        btnNewButton.setBounds(735, 500, 245, 76);
        contentPane.add(btnNewButton);
        
        
        
        textArea_1 = new JTextArea();
        textArea_1.setBounds(713, 244, 284, 128);
        contentPane.add(textArea_1);
        textArea_1.setEditable(false);
        
        
        
        
        
        
        
        
        JButton btnVolver = new JButton("Elegir otro producto");
        btnVolver.setBackground(new Color(246, 196, 205));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        btnVolver.setBounds(79, 618, 347, 56);
        contentPane.add(btnVolver);
        
        JLabel lblNewLabel = new JLabel("Producto Elegido");
        lblNewLabel.setForeground(new Color(246, 196, 205));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel.setBounds(169, 53, 180, 20);
        contentPane.add(lblNewLabel);
        
        JLabel lblProductosElegidos = new JLabel("Productos Elegidos");
        lblProductosElegidos.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductosElegidos.setForeground(new Color(246, 196, 205));
        lblProductosElegidos.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblProductosElegidos.setBounds(169, 352, 180, 20);
        contentPane.add(lblProductosElegidos);
        
        JLabel lblCantidadDeseada = new JLabel("Cantidad Deseada");
        lblCantidadDeseada.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantidadDeseada.setForeground(new Color(246, 196, 205));
        lblCantidadDeseada.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblCantidadDeseada.setBounds(762, 56, 180, 20);
        contentPane.add(lblCantidadDeseada);
        
        JLabel lblCostoTotal = new JLabel("Costo Total");
        lblCostoTotal.setBackground(new Color(163, 163, 163));
        lblCostoTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblCostoTotal.setForeground(new Color(246, 196, 205));
        lblCostoTotal.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblCostoTotal.setBounds(762, 199, 180, 20);
        contentPane.add(lblCostoTotal);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Elegirproduc paginaAnterior = new Elegirproduc(inventario, auditoria, listaCompras, listaClientes, historialCompras); // Reemplaza 'PaginaAnterior' con el nombre de tu clase de página anterior
                paginaAnterior.setVisible(true); // Muestra la página anterior
                dispose(); // Cierra la página actual
            }
        });
        
    }
    
    private void actualizarListaCompras() {
        StringBuilder comprasTexto = new StringBuilder();
        comprasTexto.append("Lista de Compras:\n");
        for (Compras compra : listaCompras) {
            comprasTexto.append("Producto: ").append(compra.getProd().getNombre()).append(", Cantidad: ").append(compra.getCant()).append("\n");
            // Añade más detalles si es necesario, como el precio o información adicional de la compra
        }
        textArea_2.setText(comprasTexto.toString());
    }

}
