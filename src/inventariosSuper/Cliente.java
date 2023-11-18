package inventariosSuper;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Compras> compra;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.compra = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Compras> getCompras() {
        return compra;
    }


    public void realizarcompras(Producto producto, int cantidad) {
        Compras nuevaCompra = new Compras(producto, cantidad);
        this.compra.add(nuevaCompra);
        //producto.reducirStock(cantidad); // Reducir el stock del producto nose
    }

    public double calcularTotalGastado() {
        double total = 0;
        for (Compras comp : compra) {
            total += comp.getCostoTotal();
        }
        return total;
    }

    public void mostrarListaDeCompras() {
        System.out.println("Lista de compras de :");
        for (Compras comp : compra) {
            Producto producto = comp.getProd();
            int cantidad = comp.getCant();
            double costoTotal = comp.getCostoTotal();

            System.out.println("Producto: " + producto.getNombre() +
                    " - Cantidad: " + cantidad +
                    " - Costo Total: $" + costoTotal);

        }
    }




    }



