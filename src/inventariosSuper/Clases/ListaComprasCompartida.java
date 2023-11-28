package inventariosSuper.Clases;

import java.util.ArrayList;
import java.util.List;

public class ListaComprasCompartida {
    private static List<Compras> listaCompras = new ArrayList<>();

    public static List<Compras> getListaCompras() {
        return listaCompras;
    }

    public static void setListaCompras(List<Compras> lista) {
        listaCompras = lista;
    }
}

