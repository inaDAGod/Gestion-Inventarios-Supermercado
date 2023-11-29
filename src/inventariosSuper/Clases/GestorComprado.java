package inventariosSuper.Clases;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import inventariosSuper.Comprado;

public class GestorComprado {
    private List<Comprado> listaComp;

    public GestorComprado() {
        listaComp = new ArrayList<>();
        cargarCompradoDesdeArchivo("compras.txt");
    }

    private void cargarCompradoDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(",");
                // Crear el cliente a partir de los datos del archivo // Esto es un ejemplo, deberías obtener el cliente de alguna manera
                LocalDateTime fechaActual = LocalDateTime.now(); // Obtiene la fecha actual

                Comprado comp = new Comprado();
                listaComp.add(comp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Comprado> getListaComp() {
        return listaComp;
    }
}


