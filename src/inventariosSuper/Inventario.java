package inventariosSuper;
import java.time.LocalDate;
import java.util.*;

public class Inventario {
	private ArrayList<Producto> productos;
	private Map <Proveedor,Producto> proveedoresProducto;
	private Map <Integer,Producto> productoExistencias;
	
	
	public Inventario() {
		this.productos = new ArrayList<>();
		this.proveedoresProducto = new HashMap<>();
		this.productoExistencias = new HashMap<>();
	}

	
	public Map<Proveedor, Producto> getProveedoresProducto() {
		return proveedoresProducto;
	}


	public void setProveedoresProducto(Map<Proveedor, Producto> proveedoresProducto) {
		this.proveedoresProducto = proveedoresProducto;
	}


	public Map<Integer,Producto> getProductoExistencias() {
		return productoExistencias;
	}


	public void setProductoExistencias(Map<Integer,Producto> productoExistencias) {
		this.productoExistencias = productoExistencias;
	}
	
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}


	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}


	public void añadirProducto (Producto producto, Proveedor proveedor) {
		productos.add(producto);
		proveedoresProducto.put(proveedor, producto);
		productoExistencias.put(producto.getCantidadStock(),producto);
	}

	

	@Override
	public String toString() {
		return "Inventario : \n" + productos + "\n proveedoresProducto:" + proveedoresProducto
				+ "\nproductoExistencias:" + productoExistencias;
	}


	public static void main(String[] args) {
		Inventario i = new Inventario();
		Proveedor prove = new Proveedor("1", "Juan", "Avenida siempre vivas", "454", "jj@gmail.com");
		Producto produ = new Producto("Tomate", "Fruta o verdura", 2.50, 5, LocalDate.now().plusDays(5)); // producto nuevo
        CategoriaProducto c = new CategoriaProducto("Comestible", "Para comer");// categoria nueva

        produ.anadirCategoria(produ,c); //se añade la categoria al producto
        i.añadirProducto(produ, prove);
        System.out.println("Proveedor: " + prove);
        System.out.println("Producto: " + produ);
        System.out.println("Categoria: " + c);
        System.out.println(i);
    }
}
