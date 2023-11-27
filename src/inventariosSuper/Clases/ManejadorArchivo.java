package inventariosSuper.Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ManejadorArchivo {

    public static void escribirArchivoCompras() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("compras.txt"))) {
            // Ejemplo de escritura de datos en el archivo compras.txt
            writer.write("Cliente1, Producto1, " + LocalDateTime.now() + "\n");
            writer.write("Cliente2, Producto2, " + LocalDateTime.now() + "\n");
            // Puedes seguir agregando líneas con los datos necesarios
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
