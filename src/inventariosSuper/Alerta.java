package inventariosSuper;

import java.time.LocalDate;

public class Alerta {
    private String mensaje;
    private int prioridad;
    private TipoAlerta tipo;
    private Producto producto;

    public enum TipoAlerta {
        PRONTO_A_VENCER, STOCK_BAJO
    }

    public Alerta(String mensaje, int prioridad, TipoAlerta tipo, Producto producto) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.producto = producto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public TipoAlerta getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlerta tipo) {
        this.tipo = tipo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
