package inventariosSuper.Clases;

import java.time.*;
import java.util.*;

public class Producto {
    private String nombre;
    private String detalle;
    private Double precio;
    private int cantidadStock;
    private LocalDate fechaVencimiento;
    private Queue<CategoriaProducto> categorias;

    public Producto(String nombre, String detalle, Double precio, int cantidadStock, LocalDate fechaVencimiento, Queue<CategoriaProducto> categorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.fechaVencimiento = fechaVencimiento;
        this.categorias = categorias;
    }

    public Producto(String nombre, String detalle, Double precio, int cantidadStock, LocalDate fechaVencimiento) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.fechaVencimiento = fechaVencimiento;
        this.categorias = new LinkedList<CategoriaProducto>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Queue<CategoriaProducto> getCategorias() {
        return categorias;
    }

    public void setCategorias(Queue<CategoriaProducto> categorias) {
        this.categorias = categorias;
    }

    /***
     * Funcion para añadir una categoria al producto
     * @param p producto al que se añade la categoria
     * @param categoria la categoria nueva del producto
     */
    public void anadirCategoria(Producto p,CategoriaProducto categoria) {
    	Producto producto = new Producto(p.nombre, p.detalle, p.precio, p.cantidadStock, p.fechaVencimiento);
        categorias.add(categoria);
        categoria.anadirProducto(producto);
    }

    @Override
    public String toString() {
        return "\n===========\nProducto \n Nombre: " + nombre + "\ndetalle: " + detalle + "\nprecio: " + precio + "\n cantidadStock: "
                + cantidadStock + "\n fechaVencimiento: " + fechaVencimiento ;
    }

    public static void main(String[] args) {
        
    }
}
