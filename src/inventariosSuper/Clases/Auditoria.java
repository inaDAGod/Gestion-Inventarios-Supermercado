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

    public static void main(String[] args) {

        Auditoria auditoria = new Auditoria();
        Cliente cliente1 = new Cliente("Cliente1", 3234364, 78754635,"Cota cota");
        Producto producto1 = new Producto("Tomate", "Fruta o verdura", 2.50, 5, LocalDate.now().plusDays(5));

        // Simular una compra
        LocalDateTime fechaCompra = LocalDateTime.now();
        auditoria.agregarCompra(cliente1, producto1, 2, fechaCompra);

        // Mostrar todas las compras
        JTextArea txtADisplay = new JTextArea();  // Crea un JTextArea para mostrar las compras
        auditoria.mostrarCompras(txtADisplay);

        // Filtrar compras por rango de fechas
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        LocalDate fechaInicio = LocalDate.from(LocalDate.parse(scanner.nextLine(), formatter).atStartOfDay());

        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        LocalDate fechaFin = LocalDate.from(LocalDate.parse(scanner.nextLine(), formatter).plusDays(1).atStartOfDay());

        auditoria.mostrarComprasEnRango(fechaInicio.atStartOfDay(), fechaFin.atStartOfDay(), txtADisplay);

        scanner.close();
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