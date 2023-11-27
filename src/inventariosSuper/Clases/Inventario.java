package inventariosSuper.Clases;
import java.time.LocalDate;
import java.util.*;

public class Inventario {
	private ArrayList<Producto> productos;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<CategoriaProducto> categoriasProductos;
	private Map <Proveedor,ArrayList<Producto> > proveedoresProducto;
	
	
	public Inventario() {
		this.productos = new ArrayList<Producto>();
		this.proveedores = new ArrayList<Proveedor>();
		this.proveedoresProducto = new HashMap<>();
		this.categoriasProductos = new ArrayList<CategoriaProducto>();
	}

	


	
	public Map<Proveedor, ArrayList<Producto>> getProveedoresProducto() {
		return proveedoresProducto;
	}





	public void setProveedoresProducto(Map<Proveedor, ArrayList<Producto>> proveedoresProducto) {
		this.proveedoresProducto = proveedoresProducto;
	}





	public ArrayList<Producto> getProductos() {
		return productos;
	}


	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}


	public void añadirProducto (Producto producto, Proveedor proveedor) {
		productos.add(producto);
		ArrayList<Producto> productosAsociados = proveedoresProducto.get(proveedor);
		productosAsociados.add(producto);
		
		 for( CategoriaProducto categorias: producto.getCategorias()) {
			categorias.anadirProducto(producto);
		}
		 
		
	}
	public void añadirCategoriaProducto(CategoriaProducto c) {
		categoriasProductos.add(c);
		
	}
	


	public ArrayList<CategoriaProducto> getCategoriasProductos() {
		return categoriasProductos;
	}


	public void setCategoriasProductos(ArrayList<CategoriaProducto> categoriasProductos) {
		this.categoriasProductos = categoriasProductos;
	}
	
	

	
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}


	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public void añadirProveedor(Proveedor p) {
		proveedores.add(p);
		ArrayList<Producto> nuevaListaProductos = new ArrayList<>();
	    proveedoresProducto.put(p, nuevaListaProductos);
	}

	@Override
	public String toString() {
		return "Inventario [productos=" + productos + ", proveedores=" + proveedores + ", categoriasProductos="
				+ categoriasProductos + ", proveedoresProducto=" + proveedoresProducto + "]";
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
