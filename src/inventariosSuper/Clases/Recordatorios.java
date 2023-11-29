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
        if (alerta.getPrioridad() != 10)
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
