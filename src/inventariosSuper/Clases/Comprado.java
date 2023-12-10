package inventariosSuper.Clases;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Comprado {
    private HashMap<Cliente, LocalDateTime> compras;

    public Comprado() {
        this.compras = new HashMap<>();
    }
    public Comprado(Cliente cliente, LocalDateTime localDateTime) {
        this.compras = new HashMap<>();
    }

    public void agregarCompra(Cliente cliente, LocalDateTime fecha) {
        compras.put(cliente, fecha);
    }

    public LocalDateTime obtenerFechaDeCompra(Cliente cliente) {
        return compras.getOrDefault(cliente, null);
    }

    public LocalDateTime obtenerFechaDeCompra(String nombreCliente) {
        for (Map.Entry<Cliente, LocalDateTime> entry : compras.entrySet()) {
            Cliente cliente = entry.getKey();
            if (cliente.getNombre().equals(nombreCliente)) {
                return entry.getValue();
            }
        }
        return null; // Return null if no matching cliente name is found
    }

    public String mostrarCompras() {
        StringBuilder result = new StringBuilder("Historial de compras:\n");
        for (Map.Entry<Cliente, LocalDateTime> entry : compras.entrySet()) {
            Cliente cliente = entry.getKey();
            LocalDateTime fecha = entry.getValue();

            result.append("Cliente: ").append(cliente.getNombre()).append(", Fecha: ").append(fecha).append("\n");
            result.append(cliente.mostrarListaDeCompras()).append("\n\n"); // Append the client's purchase list
        }
        return result.toString();
    }

}
