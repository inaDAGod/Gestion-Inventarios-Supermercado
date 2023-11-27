package inventariosSuper.Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> listaClientes;

    public GestorClientes() {
        listaClientes = new ArrayList<>();
        cargarClientesDesdeArchivo("clientes.txt");
    }

    private void cargarClientesDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]), Integer.parseInt(datosCliente[2]), datosCliente[3]);
                listaClientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}

