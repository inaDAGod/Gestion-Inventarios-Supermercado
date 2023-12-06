package inventariosSuper.Clases;

import java.time.LocalDate;

public class Alerta {
    private String mensaje;
    private int prioridad;
    private Producto producto;

    public Alerta(Producto producto) {
        this.producto = producto;
        definirAlerta();
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    private void definirAlerta() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVencimiento = producto.getFechaVencimiento();

        if (fechaVencimiento.isBefore(fechaActual)) {
            // Producto vencido
            this.mensaje = "Producto vencido, Sacar del Stock";
            this.prioridad = 1;
        } else if (fechaVencimiento.isEqual(fechaActual) || fechaVencimiento.minusDays(2).isBefore(fechaActual)) {
            // Producto a punto de vencer
            this.mensaje = "Producto a punto de vencer";
            this.prioridad = 2;
        } else if (producto.getCantidadStock() <= 3) {
            // Producto bajo en cantidad
            this.mensaje = "Producto bajo en cantidad";
            this.prioridad = 3;
        } else {
            // Producto agotado, ordenar más
            this.mensaje = "Producto agotado, ordenar más";
            this.prioridad = 1;
        }
    }

    @Override
    public String toString() {
        return "Producto: " + producto.getNombre() +
                "  Mensaje: " + mensaje + '\'' +
                "  (prioridad: " + prioridad + ")"
                ;
    }
}
