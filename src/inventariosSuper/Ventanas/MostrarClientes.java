package inventariosSuper.Ventanas;



import javax.swing.*;
import javax.swing.border.EmptyBorder;

import inventariosSuper.Clases.Cliente;

import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;

public class MostrarClientes extends JFrame {

    private JTextArea textArea;
    private List<Cliente> listaClientes;

    public MostrarClientes(List<Cliente> clientes) {
        listaClientes = clientes;

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

    public static void main(String[] args) {
        List<Cliente> listaClientes = cargarClientesDesdeArchivo("clientes.txt");
        EventQueue.invokeLater(() -> {
            try {
                MostrarClientes frame = new MostrarClientes(listaClientes);
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
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]), Integer.parseInt(datosCliente[2]), datosCliente[3]);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
