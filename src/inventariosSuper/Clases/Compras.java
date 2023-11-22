package inventariosSuper.Clases;


public class Compras {
    private Producto prod;
    private int cant;
    private double costoTotal;

    public Compras(Producto prod, int cant) {
        this.prod = prod;
        this.cant = cant;
        this.costoTotal = calcularCostoTotal();
    }
//ghj
    
    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
        this.costoTotal = calcularCostoTotal();
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    private double calcularCostoTotal() {
        return this.prod.getPrecio() * this.cant;
    }
}

