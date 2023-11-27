package inventariosSuper.Clases;

import java.util.*;

public class CategoriaProducto {
	private String nombre;
	private String detalle;
	private ArrayList<Producto> productos;
	
	
	public CategoriaProducto(String nombre, String detalle, ArrayList<Producto> productos) {
	
		this.nombre = nombre;
		this.detalle = detalle;
		this.productos = productos;
	}
	

	public CategoriaProducto(String nombre, String detalle) {
	
		this.nombre = nombre;
		this.detalle = detalle;
		this.productos = new ArrayList<Producto>();
	}
	
	public CategoriaProducto(String nombre) {	
		this.nombre = nombre;
		this.detalle = "";
		this.productos = new ArrayList<Producto>();
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


	public ArrayList<Producto> getProductos() {
		return productos;
	}


	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	/***
	 * Funcion para añadir producto a esta categoria 
	 * @param producto , Producto que sera añadido a esta categoria
	 */
	 public void anadirProducto(Producto producto) {
	
	        this.productos.add(producto); 
	 }
	 
	@Override
	public String toString() {
		return "CategoriaProducto: " + nombre + "," + detalle + ", " + productos;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
