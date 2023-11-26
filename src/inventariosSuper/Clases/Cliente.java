package inventariosSuper.Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int id;
    private int numero;
    private String direccion;
    private List<Compras> compra;
    
    

    public Cliente(String nombre, int id, int numero, String direccion) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.numero = numero;
		this.direccion = direccion;
        this.compra = new ArrayList<>();
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



	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Compras> getCompras() {
        return compra;
    }


    public void realizarcompras(Producto producto, int cant) {
        Compras nuevaCompra = new Compras(producto, cant);
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



