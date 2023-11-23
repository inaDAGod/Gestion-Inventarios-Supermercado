package inventariosSuper.Clases;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Recordatorios {
    private PriorityQueue<Alerta> alertas;

    private final Comparator<Alerta> comparadorAlertas = Comparator.comparingInt(Alerta::getPrioridad);

    public Recordatorios() {
        this.alertas = new PriorityQueue<>(comparadorAlertas);
    }

    public void agregarAlerta(Alerta alerta) {
        alertas.offer(alerta);
    }

    public void eliminarAlerta(Alerta alerta) {
        alertas.remove(alerta);
    }

    public void desplegarAlertas() {
        System.out.println("Alertas pendientes:");
        while (!alertas.isEmpty()) {
            Alerta alerta = alertas.poll();
            System.out.println("Tipo: " + alerta.getTipo() +
                    ", Mensaje: " + alerta.getMensaje() +
                    ", Producto: " + alerta.getProducto().getNombre());
        }
    }
}
