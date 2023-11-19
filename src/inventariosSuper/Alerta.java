package inventariosSuper;
public class Alerta implements Comparable<Alerta> {
    private String mensaje;
    private int prioridad;

    public Alerta(String mensaje, int prioridad) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
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

    @Override
    public int compareTo(Alerta otra) {
        // Ordena las alertas por prioridad, de mayor a menor
        return Integer.compare(otra.prioridad, this.prioridad);
    }

}

