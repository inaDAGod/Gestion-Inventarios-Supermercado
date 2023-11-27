package inventariosSuper.Ventanas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.Inventario;
import inventariosSuper.Clases.Producto;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class Agregarproduc extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea_1;
    private double numeroIngresado; // Variable para almacenar el número ingresado
    private Producto producto;
    private Compras compra;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Agregarproduc frame = new Agregarproduc(null, null, null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Agregarproduc(Producto produ, Inventario i, Compras compras) {
    	this.producto = produ;
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(36, 49, 463, 536);
        contentPane.add(textArea);

        if (produ != null) {
            StringBuilder productDetails = new StringBuilder();
            productDetails.append("Nombre: ").append(produ.getNombre()).append("\n");
            productDetails.append("Descripción: ").append(produ.getDetalle()).append("\n");
            productDetails.append("Precio: ").append(produ.getPrecio()).append("\n");
            // Añade más detalles si es necesario

            textArea.setText(productDetails.toString());
        }

        textField = new JTextField();
        textField.setBounds(704, 83, 293, 45);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(767, 411, 217, 76);
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

        JButton btnNewButton = new JButton("Registrar"); // Renombrado el botón
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    String texto = textField.getText();
                    numeroIngresado = Double.parseDouble(texto);

                    double resultado = numeroIngresado * producto.getPrecio();

                    textArea_1.setText("El total es: " + resultado);

                    int cantidad = Integer.parseInt(textField.getText()); // Suponiendo que aquí ingresas la cantidad
                    compra = new Compras(producto, cantidad);

                    // Si necesitas hacer algo más con 'compra', es el momento de hacerlo aquí
                    // Por ejemplo, guardar 'compra' en una lista de compras
                    // listaDeCompras.add(compra);

                    // O imprimir información sobre la compra
                    JOptionPane.showMessageDialog(null, "¡Registro exitoso!\nEl total es: " + resultado);
                    Elegirregistro detalleProducto = new Elegirregistro(compra);
                    detalleProducto.setVisible(true);
                    setVisible(false);
    	            dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido");
                }
            }
        });
        	
        btnNewButton.setBounds(767, 500, 217, 76);
        contentPane.add(btnNewButton);
        
        
        
        textArea_1 = new JTextArea();
        textArea_1.setBounds(713, 169, 284, 226);
        contentPane.add(textArea_1);
    }
}
