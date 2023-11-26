package inventariosSuper.Clases;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;

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
    public void mostrarCompras() {
        System.out.println("Registro de Compras:");
        for (Compra compra : compras) {
            System.out.println(compra);
        }
    }
    //solo facturas emitidas entre cierto rango de fechas
    public void mostrarComprasEnRango(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        // Mostrar compras en el rango de fechas
        System.out.println("Compras en el rango de fechas:");
        for (Compra compra : compras) {
            LocalDateTime fechaCompra = compra.getFechaCompra();
            if (fechaCompra != null && fechaCompra.isAfter(fechaInicio) && fechaCompra.isBefore(fechaFin)) {
                System.out.println(compra);
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
        auditoria.mostrarCompras();

        // Filtrar compras por rango de fechas
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        LocalDate fechaInicio = LocalDate.from(LocalDate.parse(scanner.nextLine(), formatter).atStartOfDay());

        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        LocalDate fechaFin = LocalDate.from(LocalDate.parse(scanner.nextLine(), formatter).plusDays(1).atStartOfDay());

        auditoria.mostrarComprasEnRango(fechaInicio.atStartOfDay(), fechaFin.atStartOfDay());

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