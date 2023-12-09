package inventariosSuper.Clases;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextArea;

public class Auditoria {
    private Queue<Compra> compras;

    public Auditoria() {
        this.compras = new LinkedList<>();
    }

    // Agrega a la cola
    public void agregarCompra(Cliente cliente, Producto producto, int cantidad, LocalDateTime fechaCompra) {
        Compra compra = new Compra(cliente, producto, cantidad, fechaCompra);
        compras.offer(compra);
    }
    //muestra las facturaas ingresadas sin el intervalo de fechas, como tal las transacciones
    public void mostrarCompras(JTextArea textArea) {
        textArea.append("Registro de Compras:\n");
        for (Compra compra : compras) {
            textArea.append(compra + "\n");
        }
    }

    //solo facturas emitidas entre cierto rango de fechas
    public void mostrarComprasEnRango(LocalDateTime fechaInicio, LocalDateTime fechaFin, JTextArea textArea) {
        // Mostrar compras en el rango de fechas
        textArea.append("Compras en el rango de fechas:\n");
        for (Compra compra : compras) {
            LocalDateTime fechaCompra = compra.getFechaCompra();
            if (fechaCompra != null && fechaCompra.isAfter(fechaInicio) && fechaCompra.isBefore(fechaFin)) {
                textArea.append(compra + "\n");
            }
        }
    }

}
//clase para centralizar la nfo y añadirla a la cola
class Compra {
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private LocalDateTime fechaCompra;

    public Compra(Cliente cliente, Producto producto, int cantidad, LocalDateTime fechaCompra) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() +
                ", Producto: " + producto.getNombre() +
                ", Cantidad: " + cantidad +
                ", Costo Total: $" + (producto.getPrecio() * cantidad) +
                ", Fecha de Compra: " + fechaCompra;
    }
}