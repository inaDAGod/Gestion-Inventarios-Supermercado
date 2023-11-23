package inventariosSuper.Clases;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
public class Comprado {

    private HashMap<Cliente, LocalDateTime> compras;

    public Comprado() {
        this.compras = new HashMap<>();
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
            Cliente currentCliente = entry.getKey();
            LocalDateTime fechaCompra = entry.getValue();

            System.out.println("Cliente: " + currentCliente.getNombre() + ", Fecha: " + fechaCompra);
            currentCliente.mostrarListaDeCompras(); 
            System.out.println(); 
        }
    }
}

