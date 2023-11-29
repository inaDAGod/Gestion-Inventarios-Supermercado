package inventariosSuper.Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import inventariosSuper.Clases.Cliente;
import inventariosSuper.Clases.Comprado;
import inventariosSuper.Clases.Compras;
import inventariosSuper.Clases.GestorComprado;

import javax.swing.JTextArea;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MostrarClientes<JButton> extends JFrame {

    private JTextArea textArea;
    private List<Cliente> listaClientes;
    private Comprado comprado; // Removed static

    public MostrarClientes(List<Cliente> clientes, Comprado comprado) {
        this.listaClientes = clientes;
        this.comprado = comprado;

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
        for (Cliente cliente : listaClientes) {
            LocalDateTime fechaCompra = comprado.obtenerFechaDeCompra(cliente);
            if (fechaCompra != null) {
                textArea.append("Cliente: " + cliente.getNombre() + "\n");
                textArea.append("Fecha de compra: " + fechaCompra.format(formatter) + "\n");

                // Retrieve and display the items bought by the client
                List<Compras> itemsComprados = cliente.getListaCompras();
                textArea.append("Items comprados:\n");
                for (Compras item : itemsComprados) {
                    textArea.append("- Producto: " + item.getProd().getNombre() + ", Cantidad: " + item.getCant() + "\n");
                    // Add other relevant details of purchased items
                }
                textArea.append("\n");
            }
        }
    }



    public static void main(String[] args) {
        List<Cliente> listaClientes = cargarClientesDesdeArchivo("clientescomp.txt");
        Comprado historialCompras = cargarComprasDesdeArchivo("compras.txt", listaClientes);

        EventQueue.invokeLater(() -> {
            try {
                MostrarClientes frame = new MostrarClientes(listaClientes, historialCompras);
                frame.setVisible(true);
                // Display clients and their purchases
                for (Cliente cliente : listaClientes) {
                    LocalDateTime fechaCompra = historialCompras.obtenerFechaDeCompra(cliente);
                    if (fechaCompra != null) {
                        displayClienteAndCompras(cliente, fechaCompra); // Adjust this method accordingly
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }




    private static void displayClienteAndCompras(Cliente cliente, LocalDateTime fechaCompra) {
		// TODO Auto-generated method stub
		
	}

	private static List<Cliente> cargarClientesDesdeArchivo(String rutaArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]),
                        Integer.parseInt(datosCliente[2]), datosCliente[3], null);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private static Comprado cargarComprasDesdeArchivo(String rutaArchivo, List<Cliente> listaClientes) {
        Comprado historialCompras = new Comprado(null, null);
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCompra = linea.split(",");
                String nombreCliente = datosCompra[0];
                Cliente cliente = buscarClientePorId(nombreCliente, listaClientes);
                if (cliente != null) {
                    // Assuming the date is in the format yyyy-MM-dd HH:mm:ss
                    LocalDateTime fechaCompra = LocalDateTime.parse(datosCompra[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    historialCompras.agregarCompra(cliente, fechaCompra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return historialCompras;
    }

    private static Cliente buscarClientePorId(String nombreCliente, List<Cliente> listaClientes2) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Cliente buscarClientePorId(int id, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
