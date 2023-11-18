package inventariosSuper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        // Creas instancias de Cliente y sus compras
        cliente cliente1 = new cliente("Juan");
        cliente cliente2 = new cliente("María");

        // Creas instancias de Producto para las compras
        Producto producto1 = new Producto("Tomate", "Descripción del Producto 1", 10.0, 50, LocalDate.now());
        Producto producto2 = new Producto("Manzana", "Descripción del Producto 2", 20.0, 30, LocalDate.now());

        // Creas instancias de Compra y las agregas a las listas de compras de cada cliente
        List<compras> comprasCliente1 = new ArrayList<>();
        List<compras> comprasCliente2 = new ArrayList<>();

        cliente1.realizarcompras(producto1, 3);
        cliente2.realizarcompras(producto2, 2);



        // Asignas las listas de compras a cada cliente en la instancia de 'comprado'
        comprado historialCompras = new comprado();
        historialCompras.agregarCompra(cliente1, LocalDateTime.now() );
        historialCompras.agregarCompra(cliente2,LocalDateTime.now());

        // Muestras el historial de compras con los detalles de productos y fechas
        historialCompras.mostrarCompras();

        System.out.println(producto1);
    }

}
