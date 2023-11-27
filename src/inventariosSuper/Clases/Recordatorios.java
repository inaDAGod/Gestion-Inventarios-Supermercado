package inventariosSuper.Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recordatorios {
    private MinHeap alertas;

    public Recordatorios() {
        this.alertas = new MinHeap();
    }

    public void agregarAlerta(Alerta alerta) {
        alertas.insertar(alerta);
    }

    public void eliminarAlerta(Alerta alerta) {
        alertas.eliminar(alerta);
    }

    public void desplegarAlertas() {
        System.out.println("Alertas pendientes:");
        while (!alertas.estaVacio()) {
            System.out.println(alertas.extraerMinimo());
        }
    }

    public static void main(String[] args) {
        Recordatorios recordatorios = new Recordatorios();

        // Agregar productos de ejemplo
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto1", "Detalle1", 10.0, 5, LocalDate.now().plusDays(2)));
        productos.add(new Producto("Producto2", "Detalle2", 15.0, 8, LocalDate.now().plusDays(3)));
        productos.add(new Producto("Producto3", "Detalle3", 18.0, 3, LocalDate.now().plusDays(6)));
        productos.add(new Producto("Producto4", "Detalle4", 20.0, 2, LocalDate.now().plusDays(1)));
        productos.add(new Producto("Producto5", "Detalle5", 12.0, 15, LocalDate.now().plusDays(5)));
        productos.add(new Producto("Producto6", "Detalle6", 8.0, 3, LocalDate.now().minusDays(1)));
        productos.add(new Producto("Producto7", "Detalle7", 25.0, 2, LocalDate.now().plusDays(4)));

        // Generar alertas
        for (Producto producto : productos) {
            recordatorios.agregarAlerta(new Alerta(producto));
        }

        recordatorios.desplegarAlertas();
    }

    //Para la Interfaz
    public List<Alerta> obtenerAlertasOrdenadas() {
        List<Alerta> alertasOrdenadas = new ArrayList<>();
        while (!alertas.estaVacio()) {
            alertasOrdenadas.add(alertas.extraerMinimo());
        }
        return alertasOrdenadas;
    }
}

class MinHeap {
    private List<Alerta> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public void insertar(Alerta value) {
        heap.add(value);
        subirEnMonticulo(heap.size() - 1);
    }

    public Alerta extraerMinimo() {
        if (estaVacio()) {
            throw new IllegalStateException("Heap is empty");
        }

        Alerta min = heap.get(0);
        Alerta lastElement = heap.remove(heap.size() - 1);

        if (!estaVacio()) {
            heap.set(0, lastElement);
            bajarEnMonticulo(0);
        }

        return min;
    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }

    public void eliminar(Alerta alerta) {
        int indice = heap.indexOf(alerta);
        if (indice != -1) {
            heap.set(indice, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            subirEnMonticulo(indice);
            bajarEnMonticulo(indice);
        }
    }

    private void subirEnMonticulo(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).getPrioridad() < heap.get(parentIndex).getPrioridad()) {
                intercambiar(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bajarEnMonticulo(int index) {
        int size = heap.size();
        while (2 * index + 1 < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallestChild = leftChild;

            if (rightChild < size && heap.get(rightChild).getPrioridad() < heap.get(leftChild).getPrioridad()) {
                smallestChild = rightChild;
            }

            if (heap.get(smallestChild).getPrioridad() < heap.get(index).getPrioridad()) {
                intercambiar(index, smallestChild);
                index = smallestChild;
            } else {
                break;
            }
        }
    }

    private void intercambiar(int i, int j) {
        Alerta temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
