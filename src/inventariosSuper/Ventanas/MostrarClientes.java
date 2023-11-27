package inventariosSuper.Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Comprado;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Window;
import java.io.BufferedReader;

import javax.swing.JTextArea;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarClientes<JButton> extends JFrame {

    private JTextArea textArea;
    private List<Cliente> listaClientes;
    private Comprado historialCompras; // Agregamos el historial de compras

    public MostrarClientes(List<Cliente> clientes, Comprado historialCompras) {
        this.listaClientes = clientes;
        this.historialCompras = historialCompras;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBounds(49, 172, 859, 521);
        contentPane.add(textArea);

        mostrarClientes(listaClientes);
        mostrarCompras();
        
        
    }

    private void mostrarClientes(List<Cliente> clientes) {
        StringBuilder clientesInfo = new StringBuilder();
        for (Cliente cliente : clientes) {
            clientesInfo.append("Nombre: ").append(cliente.getNombre()).append("\n")
                    .append("ID: ").append(cliente.getId()).append("\n")
                    .append("Número: ").append(cliente.getNumero()).append("\n")
                    .append("Dirección: ").append(cliente.getDireccion()).append("\n\n");
        }
        textArea.setText(clientesInfo.toString());
    }

    public void mostrarCompras() {
        textArea.append("\n\nHistorial de compras:\n");
        historialCompras.mostrarCompras();
    }

    public static void main(String[] args) {
        List<Cliente> listaClientes = cargarClientesDesdeArchivo("clientes.txt");
        Comprado historialCompras = cargarComprasDesdeArchivo("compras.txt", listaClientes);
        EventQueue.invokeLater(() -> {
            try {
                MostrarClientes frame = new MostrarClientes(listaClientes, historialCompras);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static List<Cliente> cargarClientesDesdeArchivo(String rutaArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]),
                        Integer.parseInt(datosCliente[2]), datosCliente[3]);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private static Comprado cargarComprasDesdeArchivo(String rutaArchivo, List<Cliente> listaClientes) {
        Comprado historialCompras = new Comprado();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCompra = linea.split(",");
                int idCliente = Integer.parseInt(datosCompra[0]);
                Cliente cliente = buscarClientePorId(idCliente, listaClientes);
                if (cliente != null) {
                    historialCompras.agregarCompra(cliente, LocalDateTime.parse(datosCompra[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return historialCompras;
    }

    private static Cliente buscarClientePorId(int id, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
