package ej5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ej4.Registro;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 *
 * @author acutuc
 */
public class Ejercicio5 {

    public static void main(String[] args) throws IOException {
        //COPIO EL CÓDIGO DEL EJERCICIO 4.
        //Instancio un ArrayList de Registro
        ArrayList<Registro> listaRegistro = new ArrayList<>();

        //String de la ruta del fichero
        String idFichero = "precipitacionesBadajoz.json";
        //Procedemos a leer el fichero JSON, implantando sus datos en la clase POJO.
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        listaRegistro = mapeador.readValue(new File(idFichero),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Registro.class));
        System.out.println("---- Catálogo de Muebles ----");
        for (Registro reg : listaRegistro) {
            System.out.println(reg);
        }
        
        //APARTADO A
        System.out.println("---------------------APARTADO A--------------------------------------");
        System.out.println(precipitacionesPorEstacion(listaRegistro));
        
        //APARTADO B
        System.out.println("---------------------APARTADO B--------------------------------------");
        long apartadoB = listaRegistro.stream()
                                  .filter(apa -> (apa.getFecha().isAfter(LocalDate.of(2017, Month.OCTOBER, 9)) && apa.getFecha()
                                                .isBefore(LocalDate.of(2017, Month.OCTOBER, 21))))
                                  .map(apa -> apa.getEstacionMeteorologica())
                                  .distinct()
                                  .count();
        System.out.println("Estaciones leídas entre el 10/10/17 y el 20/10/17: " + apartadoB);
        
        //APARTADO C
        System.out.println("---------------------APARTADO C--------------------------------------");                                        

        Double mediaPrecipitaciones = listaRegistro.stream()
                               .filter(apa -> (apa.getFecha().isAfter(LocalDate.of(2017, Month.OCTOBER, 9)) && apa.getFecha()
                                                .isBefore(LocalDate.of(2017, Month.OCTOBER, 21))))
                               .mapToDouble(Registro::getPrecipitacion)
                               .average()
                               .getAsDouble();
        
        System.out.println("La media de precipitaciones es de -> " + mediaPrecipitaciones);

        
    }

    //Métodos.
    //a)
    public static Map<String, Double> precipitacionesPorEstacion(ArrayList<Registro> listaRegistro) {
        //Creo el Map vacío para hacer el return con los datos implementados.
        Map<String, Double> map = new TreeMap<>();
        //Recorro con un bucle for la lista de Registros
        for (Registro reg : listaRegistro) {
            reg.getEstacionMeteorologica();
            reg.getPrecipitacion();

            //Almaceno en el map la estación y las precipitaciones.
            map.put(reg.getEstacionMeteorologica(), reg.getPrecipitacion());
        }
        return map;
    }
}
