package inventariosSuper.Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorCilientecompras {
    private List<Cliente> listaClientes;

    public GestorCilientecompras() {
        listaClientes = new ArrayList<>();
        cargarClientesDesdeArchivo("clientescomp.txt");
    }

    private void cargarClientesDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                // Crear el cliente a partir de los datos del archivo
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]), Integer.parseInt(datosCliente[2]), datosCliente[3], null);
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
