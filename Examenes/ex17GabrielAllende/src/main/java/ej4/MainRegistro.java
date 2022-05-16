package ej4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class MainRegistro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Instancio un ArrayList de Registro
        ArrayList<Registro> listaRegistro = new ArrayList<>();

        //String de la ruta del fichero
        String idFichero = "precipitacionesBadajoz.json";
        //Procedemos a leer el fichero JSON, implantando sus datos en la clase POJO.
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        listaRegistro = mapeador.readValue(new File(idFichero),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Registro.class));
        System.out.println("---- Registros de lluvias ----");
        for (Registro reg : listaRegistro) {
            System.out.println(reg);
        }

    }
}
