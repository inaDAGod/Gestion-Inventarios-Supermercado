package inventariosSuper.Ventanas;

import java.time.*;
import java.util.*;

import inventariosSuper.Clases.*;

public class Main2 {

	public static void main(String[] args) {
		Inventario inventario = new Inventario();
		llenadoInventario(inventario);
		VentanaInicio ventanaInicio = new VentanaInicio(inventario);//se manda el inventario como parametro
		ventanaInicio.setVisible(true);
		

	}
	
	
	public static void llenadoInventario(Inventario inventario) {
	    // Categorías
	    CategoriaProducto comidaCategoria = new CategoriaProducto("comida", null);
	    CategoriaProducto cuidadoPersonalCategoria = new CategoriaProducto("CUIDADO PERSONAL", null);
	    CategoriaProducto limpiezaCategoria = new CategoriaProducto("LIMPIEZA", null);
	    CategoriaProducto bebidasCategoria = new CategoriaProducto("BEBIDAS", null);
	    CategoriaProducto hogarCategoria = new CategoriaProducto("HOGAR", null);
	    CategoriaProducto snacksCategoria = new CategoriaProducto("SNACKS", null);
	    
	    inventario.añadirCategoriaProducto(comidaCategoria);
	    inventario.añadirCategoriaProducto(cuidadoPersonalCategoria);
	    inventario.añadirCategoriaProducto(limpiezaCategoria);
	    inventario.añadirCategoriaProducto(bebidasCategoria);
	    inventario.añadirCategoriaProducto(hogarCategoria);
	    inventario.añadirCategoriaProducto(snacksCategoria);
	    
	    // Proveedores
	    Proveedor proveedor1 = new Proveedor("P001", "Coca-Cola", "Calle 123", "123-456-7890", "proveedora@ejemplo.com");
	    Proveedor proveedor2 = new Proveedor("P002", "Nestlé", "Avenida XYZ", "987-654-3210", "proveedorb@ejemplo.com");
	    Proveedor proveedor3 = new Proveedor("P003", "PepsiCo", "Carrera 456", "111-222-3333", "proveedorc@ejemplo.com");
	    Proveedor proveedor4 = new Proveedor("P004", "Pil", "Calle Principal", "555-555-5555", "proveedord@ejemplo.com");
	    Proveedor proveedor5 = new Proveedor("P005", "Walmart", "Avenida Central", "777-777-7777", "proveedore@ejemplo.com");
	    Proveedor proveedor6 = new Proveedor("P006", "Amazon", "Carretera Secundaria", "999-999-9999", "proveedorf@ejemplo.com");
	    Proveedor proveedor7 = new Proveedor("P007", "Kellogg's", "Calle 789", "111-222-3333", "proveedorg@ejemplo.com");
	    Proveedor proveedor8 = new Proveedor("P008", "Unilever", "Avenida ABC", "222-333-4444", "proveedorh@ejemplo.com");
	    Proveedor proveedor9 = new Proveedor("P009", "Danone", "Carrera 999", "333-444-5555", "proveedori@ejemplo.com");
	    Proveedor proveedor10 = new Proveedor("P010", "Colgate", "Ruta Principal", "444-555-6666", "proveedorj@ejemplo.com");
	    Proveedor proveedor11 = new Proveedor("P011", "Lays", "Calle 987", "555-666-7777", "proveedork@ejemplo.com");
	    Proveedor proveedor12 = new Proveedor("P012", "Heinz", "Avenida EFG", "666-777-8888", "proveedorl@ejemplo.com");
	    Proveedor proveedor13 = new Proveedor("P013", "Barilla", "Carretera 789", "777-888-9999", "proveedorm@ejemplo.com");
	    Proveedor proveedor14 = new Proveedor("P014", "Nivea", "Calle MNO", "888-999-0000", "proveedorn@ejemplo.com");
	    Proveedor proveedor15 = new Proveedor("P015", "Sprite", "Avenida PQR", "999-000-1111", "proveedoro@ejemplo.com");
	    Proveedor proveedor16 = new Proveedor("P016", "Puma", "Carretera 123", "000-111-2222", "proveedorp@ejemplo.com");
	    
	    inventario.añadirProveedor(proveedor1);
	    inventario.añadirProveedor(proveedor2);
	    inventario.añadirProveedor(proveedor3);
	    inventario.añadirProveedor(proveedor4);
	    inventario.añadirProveedor(proveedor5);
	    inventario.añadirProveedor(proveedor6);
	    inventario.añadirProveedor(proveedor7);
	    inventario.añadirProveedor(proveedor8);
	    inventario.añadirProveedor(proveedor9);
	    inventario.añadirProveedor(proveedor10);
	    inventario.añadirProveedor(proveedor11);
	    inventario.añadirProveedor(proveedor12);
	    inventario.añadirProveedor(proveedor13);
	    inventario.añadirProveedor(proveedor14);
	    inventario.añadirProveedor(proveedor15);
	    inventario.añadirProveedor(proveedor16);
	    
	    // Productos
	    Producto producto1 = new Producto("Leche", "Leche deslactosada", 2.5, 100, LocalDate.of(2023, 12, 31), new LinkedList<>(Arrays.asList(bebidasCategoria)));
	    Producto producto2 = new Producto("Arroz", "Arroz blanco", 1.8, 200, LocalDate.of(2024, 10, 15), new LinkedList<>(Arrays.asList(comidaCategoria)));
	    Producto producto3 = new Producto("Jabón", "Jabón de manos", 3.0, 50, LocalDate.of(2023, 9, 30), new LinkedList<>(Arrays.asList(cuidadoPersonalCategoria, limpiezaCategoria)));
	    Producto producto4 = new Producto("Refresco", "Refresco de cola", 1.0, 150, LocalDate.of(2023, 11, 30), new LinkedList<>(Arrays.asList(bebidasCategoria)));
	    Producto producto5 = new Producto("Toallas", "Toallas de papel", 2.2, 80, LocalDate.of(2024, 8, 20), new LinkedList<>(Arrays.asList(hogarCategoria)));
	    Producto producto6 = new Producto("Papas", "Papas fritas", 1.5, 120, LocalDate.of(2023, 12, 31), new LinkedList<>(Arrays.asList(snacksCategoria)));
	    Producto producto7 = new Producto("Cereal", "Cereal de maíz", 3.5, 90, LocalDate.of(2023, 11, 15), new LinkedList<>(Arrays.asList(comidaCategoria)));
	    Producto producto8 = new Producto("Detergente", "Detergente líquido", 4.0, 70, LocalDate.of(2023, 10, 31), new LinkedList<>(Arrays.asList(limpiezaCategoria)));
	    Producto producto9 = new Producto("Yogur", "Yogur natural", 1.2, 120, LocalDate.of(2024, 9, 30), new LinkedList<>(Arrays.asList(comidaCategoria)));
	    Producto producto10 = new Producto("Pasta de dientes", "Pasta de dientes blanqueadora", 2.8, 60, LocalDate.of(2023, 12, 31), new LinkedList<>(Arrays.asList(cuidadoPersonalCategoria)));
	    Producto producto11 = new Producto("Chips", "Chips de maíz", 2.0, 100, LocalDate.of(2023, 12, 31), new LinkedList<>(Arrays.asList(snacksCategoria)));
	    Producto producto12 = new Producto("Salsa de tomate", "Salsa de tomate natural", 2.0, 80, LocalDate.of(2024, 8, 15), new LinkedList<>(Arrays.asList(comidaCategoria)));
	    Producto producto13 = new Producto("Desodorante", "Desodorante en aerosol", 3.5, 40, LocalDate.of(2023, 9, 30), new LinkedList<>(Arrays.asList(cuidadoPersonalCategoria)));
	    Producto producto14 = new Producto("Bebida energética", "Bebida energética", 2.5, 150, LocalDate.of(2023, 11, 30), new LinkedList<>(Arrays.asList(bebidasCategoria)));
	    Producto producto15 = new Producto("Galletas", "Galletas de chocolate", 2.2, 90, LocalDate.of(2024, 7, 31), new LinkedList<>(Arrays.asList(snacksCategoria)));
	    Producto producto16 = new Producto("Jugo de naranja", "Jugo de naranja natural", 1.8, 120, LocalDate.of(2023, 12, 15), new LinkedList<>(Arrays.asList(bebidasCategoria)));

	    inventario.añadirProducto(producto1,proveedor4);
	    inventario.añadirProducto(producto2,proveedor2);
	    inventario.añadirProducto(producto3,proveedor6);
	    inventario.añadirProducto(producto4,proveedor1);
	    inventario.añadirProducto(producto5,proveedor5);
	    inventario.añadirProducto(producto6,proveedor3);
	    inventario.añadirProducto(producto7, proveedor7);
	    inventario.añadirProducto(producto8, proveedor8);
	    inventario.añadirProducto(producto9, proveedor9);
	    inventario.añadirProducto(producto10, proveedor10);
	    inventario.añadirProducto(producto11, proveedor11);
	    inventario.añadirProducto(producto12, proveedor12);
	    inventario.añadirProducto(producto13, proveedor13);
	    inventario.añadirProducto(producto14, proveedor14);
	    inventario.añadirProducto(producto15, proveedor15);
	    inventario.añadirProducto(producto16, proveedor16);
	}


}
