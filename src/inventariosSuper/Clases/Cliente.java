package inventariosSuper.Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int id;
    private int numero;
    private String direccion;
    private List<Compras> listaCompras; // Lista de compras del cliente

    public Cliente(String nombre, int id, int numero, String direccion, List<Compras> listaCompras) {
        this.nombre = nombre;
        this.id = id;
        this.numero = numero;
        this.direccion = direccion;
        this.listaCompras = new ArrayList<>(listaCompras != null ? listaCompras : new ArrayList<>());
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarCompra(Compras compra) {
        listaCompras.add(compra);
    }

    public List<Compras> getListaCompras() {
        return listaCompras;
    }

    public void realizarCompra(Producto producto, int cantidad) {
        Compras nuevaCompra = new Compras(producto, cantidad);
        listaCompras.add(nuevaCompra);
        //producto.reducirStock(cantidad); // Reducir el stock del producto
    }

    public double calcularTotalGastado() {
        double total = 0;
        for (Compras comp : listaCompras) {
            total += comp.getCostoTotal();
        }
        return total;
    }

    public void mostrarListaDeCompras() {
        System.out.println("Lista de compras de " + nombre + ":");
        for (Compras comp : listaCompras) {
            Producto producto = comp.getProd();
            int cantidad = comp.getCant();
            double costoTotal = comp.getCostoTotal();

            System.out.println("Producto: " + producto.getNombre() +
                    " - Cantidad: " + cantidad +
                    " - Costo Total: $" + costoTotal);
        }
    }

    public void setListacompras(List<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }
    public void setListaCompras(List<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }
}
