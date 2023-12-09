package inventariosSuper.Ventanas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import inventariosSuper.Clases.*;

public class Main2 {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		try {
			 List<Cliente> listaClientes = cargarClientesDesdeArchivo("clientescomp.txt");
		        Comprado historialCompras = cargarComprasDesdeArchivo("compras.txt", listaClientes);
			Inventario inventario = new Inventario();
			Auditoria auditoria = new Auditoria();
			
			llenadoInventario(inventario);
			llenadoAuditoria(auditoria);
			VentanaInicio ventanaInicio = new VentanaInicio(inventario,auditoria, listaClientes, historialCompras);//se manda el inventario como parametro
			ventanaInicio.setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}
	
	
	public static void llenadoInventario(Inventario inventario) {

	    CategoriaProducto comidaCategoria = new CategoriaProducto("COMIDA");
	    CategoriaProducto cuidadoPersonalCategoria = new CategoriaProducto("CUIDADO PERSONAL");
	    CategoriaProducto limpiezaCategoria = new CategoriaProducto("LIMPIEZA");
	    CategoriaProducto bebidasCategoria = new CategoriaProducto("BEBIDAS");
	    CategoriaProducto hogarCategoria = new CategoriaProducto("HOGAR");
	    CategoriaProducto snacksCategoria = new CategoriaProducto("SNACKS");

	    
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
	    inventario.añadirProducto(producto2,proveedor4);
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
	    inventario.añadirProducto(producto14, proveedor1);
	    inventario.añadirProducto(producto15, proveedor15);
	    inventario.añadirProducto(producto16, proveedor16);
	
	}
	
	public static void llenadoAuditoria(Auditoria auditoria) {
        auditoria.agregarCompra(new Cliente("Natalia Dávalos", 3234364, 78754635,"Chasquipampa"), new Producto("Tomate", "Fruta o verdura", 2.50, 5, LocalDate.now().plusDays(5)), 2, LocalDateTime.now());
		auditoria.agregarCompra(new Cliente("Emili Poroso", 3234, 78743635,"Bolonia"), new Producto("Arroz", "Arroz Blanco", 1.8, 199, LocalDate.now().minusMonths(5)), 4, LocalDateTime.of(2003,8,11, 15, 30, 0));
		auditoria.agregarCompra(new Cliente("Gabriel Zaballa", 423, 7878764,"Cota cota"),new Producto("Papas", "Papas fritas", 1.5, 119, LocalDate.of(2017, 01, 14)), 7, LocalDateTime.of(2004,7,03, 9, 15, 55));
		auditoria.agregarCompra(new Cliente("Marco Mares", 624, 7898735,"San Pedro"),new Producto("Refresco", "Refresco de cola", 12.5, 149, LocalDate.of(2003, 8, 11)), 9, LocalDateTime.of(2016,1,14, 21, 45, 21));
		auditoria.agregarCompra(new Cliente("Rodrigo Rodriguez", 420, 7895535,"Cala coto"), new Producto("Jabon y detergente", "Elementos de limpieza", 35.89, 149, LocalDate.of(2000, 1, 21)), 3, LocalDateTime.of(2017,12,20, 14, 36, 21));
		auditoria.agregarCompra(new Cliente("Diego Duran", 120, 7876735,"Miraflores"), new Producto("Chips de maiz", "Snack", 5.89, 49, LocalDate.of(2012, 9, 21)), 2, LocalDateTime.of(2012,4,2, 16, 36, 21));
		auditoria.agregarCompra(new Cliente("Alejandra Albania", 3223, 7344735,"Satelite"), new Producto("Maruchan", "Snack", 10.5, 10, LocalDate.of(2016, 6, 1)), 4, LocalDateTime.of(2014,9,17, 3, 33, 33));
		auditoria.agregarCompra(new Cliente("Joaquin Jauregui ", 121, 7324435,"Obrajes"), new Producto("Cereal", "Cereal de maiz", 25.89, 149, LocalDate.of(2013, 2, 13)), 2, LocalDateTime.of(2013,2,4, 5, 12, 32));
		auditoria.agregarCompra(new Cliente("Dafne Valenzuela", 232, 7123435,"Ovejullo"), new Producto("Jabon", "Jabon de manos", 15.5, 8, LocalDate.of(2014, 3, 16)), 1, LocalDateTime.of(2015,3,11, 8, 19, 6));
		auditoria.agregarCompra(new Cliente("Nicole Quiroga", 433, 7322135,"Sopocachi"), new Producto("Fideos", "Fideos Integrales", 8.89, 129, LocalDate.of(2015, 5, 20)), 3, LocalDateTime.of(2018,5,21, 15, 26, 12));
		auditoria.agregarCompra(new Cliente("Alan Plaza", 883, 7654325,"Vita"), new Producto("Carne Fria", "Comida", 10.5, 10, LocalDate.of(2017, 8, 21)), 7, LocalDateTime.of(2019,9,8, 22, 15, 20));
		auditoria.agregarCompra(new Cliente("Esteban Flores", 765, 7556735,"Armentia"), new Producto("Detergente", "Detergente liquido", 45.99, 49, LocalDate.of(2018, 10, 23)), 2, LocalDateTime.of(2020,10,10, 21, 7, 25));
		auditoria.agregarCompra(new Cliente("Belen Escobar", 356, 7654735,"Llojeta"), new Producto("Hamburguesa", "Hamburguesas veganas", 12.25, 15, LocalDate.of(2019, 11, 4)), 3, LocalDateTime.of(2021,11,17, 19, 18, 18));
	}
	
	private static Comprado cargarComprasDesdeArchivo(String rutaArchivo, List<Cliente> listaClientes) {
        Comprado historialCompras = new Comprado(null, null);
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCompra = linea.split(",");
                String nombreCliente = datosCompra[0];
                // Buscar por nombre
                Cliente cliente = buscarClientePorNombre(nombreCliente, listaClientes);
                if (cliente != null) {
                    LocalDateTime fechaCompra = LocalDateTime.parse(datosCompra[1], formatter);
                    historialCompras.agregarCompra(cliente, fechaCompra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return historialCompras;
    }
	private static Cliente buscarClientePorNombre(String nombreCliente, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }
	
	private static List<Cliente> cargarClientesDesdeArchivo(String rutaArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                Cliente cliente = new Cliente(datosCliente[0], Integer.parseInt(datosCliente[1]),
                        Integer.parseInt(datosCliente[2]), datosCliente[3], null);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }


}
