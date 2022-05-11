package exament7anterior;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class LecturaJSON {
    
    //Método
    public static ArrayList<RegistroJSON> leerJSON(String nombreJSON) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        
        mapeador.registerModule(new JavaTimeModule()); //Formato fechas

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        ArrayList<RegistroJSON> lista = mapeador.readValue(new File(nombreJSON),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, RegistroJSON.class));
        for (RegistroJSON reg : lista) {
            System.out.println(reg);
        }
        return lista;
    }
}
