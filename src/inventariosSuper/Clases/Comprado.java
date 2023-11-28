package inventariosSuper.Clases;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Comprado {
    private HashMap<Cliente, LocalDateTime> compras;

    public Comprado(Cliente cliente, LocalDateTime fecha) {
        this.compras = new HashMap<>();
        agregarCompra(cliente, fecha);
    }

    public void agregarCompra(Cliente cliente, LocalDateTime fecha) {
        compras.put(cliente, fecha);
    }

    public LocalDateTime obtenerFechaDeCompra(Cliente cliente) {
        return compras.getOrDefault(cliente, null);
    }

    public void mostrarCompras() {
        System.out.println("Historial de compras:");
        for (Map.Entry<Cliente, LocalDateTime> entry : compras.entrySet()) {
            Cliente cliente = entry.getKey();
            LocalDateTime fecha = entry.getValue();

            System.out.println("Cliente: " + cliente.getNombre() + ", Fecha: " + fecha);
            cliente.mostrarListaDeCompras(); // Método para mostrar la lista de compras del cliente
            System.out.println();
        }
    }
}
