
package ejercicio1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class LecturaJSON {
    
    //Método de clase que devuelve una lista de objetos POJO.
    public static ArrayList<Crucero> listaCruceros (String ubicacionArchivo) throws IOException{
        ArrayList<Crucero> listaCruceros = new ArrayList<>();
         //Procedemos a leer el fichero JSON, implantando sus datos en la clase POJO.
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        listaCruceros = mapeador.readValue(new File(ubicacionArchivo),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Crucero.class));
        return listaCruceros;
        }
    }
