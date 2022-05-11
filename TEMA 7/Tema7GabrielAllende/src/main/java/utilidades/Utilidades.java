package utilidades;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Gabriel
 */

//MODULARIZACIÓN DE CÓDIGO PARA EXÁMEN DEL T7.
public class Utilidades {
    
    //Método para crear un directorio.
    public static void crearDirectorio(String rutaDirectorio) {
        Path directorio = Paths.get(rutaDirectorio); //Ruta del directorio.
        try {
            Files.createDirectory(directorio);
            System.out.println("Directorio creado correctamente.");
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }
    }
    
    //Método para copiar ficheros de una ruta a otra.
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        try {
            Files.copy(origen, destino);
            System.out.println("Archivo copiado correctamente.");
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());
        }
    }
    
    //Método para escribir un CSV con un List de objetos
    public static <T> void escribirCSV(String nombreCSV, List<T> datos){
         try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nombreCSV))) {
            //TODO: modificar segun sea conveniente
            for (T dato : datos) {
                flujo.write(dato.toString());
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
     //Metodo para escribir un csv con un objeto cualquiera
    public static <T> void escribirCsv(String nombreCSV, T fichero) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nombreCSV))) {
            //TODO: modificar segun sea conveniente
            flujo.write(fichero.toString());
            flujo.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    
    //Metodo generico para leer cualquier archivo csv, recibe el nombre del archivo y el separador de campos ";",","...
    //Retorna una lista de objetos de cualquier tipo
    //---Asegurarse de modificar la parte de creacion de objetos
    //Ejemplo de uso: List<Persona> listaPersonas = Lectura.leerArchivo("./personas.csv",";");
    public static <T> List<T> leerCsv(String nombre, String separador) {
        List<T> datos = new ArrayList<>();

        try (Scanner datosFichero = new Scanner(new File(nombre))) {
            while (datosFichero.hasNextLine()) {
                String linea = datosFichero.nextLine();
                linea = linea.replaceAll(" ", "");
                linea = linea.replaceAll("\"", "");

                String[] datosLinea = linea.split(separador);

                //TODO: implementar segun el uso
                //Ej:
                // Persona p1 = new Persona() ;
                // p1.setNombre(datosLinea[0]);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return datos;
    }
    
    //Metodo para escribir un json con un array de cualquier tipo de objetos
    //---Asegurar de tener correctamente las dependecias--
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310 --> (por si hay fechas)
    public static <T> void escribirJSON(String nombre, List<T> datos) {
        ObjectMapper mappeador = new ObjectMapper();

        mappeador.registerModule(new JavaTimeModule()); //Formato fechas

        mappeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            mappeador.writeValue(new File(nombre), datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo generico para leer cualquier json, recibe el nombre del archivo y la clase del objeto, y devuelve una lista de objetos de cualquier tipo
    //Ejemplo de uso: List<Persona> listaPersonas = Lectura.leerJson("./personas.json",Persona.class);
    //---Asegurar de tener correctamente las dependecias--
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310 --> (por si hay fechas)
    //JSON: como este --> "https://github.com/yisusturtle/JAVA_PROJECTS/blob/main/CRUD_FILES/Tarea7C-JesusNarbona/JFV.json"
    public static <T> List<T> leerArchivoJSON1(String nombre, Class<T> clase) {
        List<T> datos = new ArrayList<>();
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule()); //para poder manejar fechas

        try {
            datos.addAll(mapeador.readValue(new File(nombre),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, clase)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return datos;
    }
    
    //Metodo para leer un archivo JSON contruido por solo un objeto, recibe el nombre del archivo y la clase del objeto, y devuelve un objeto de cualquier tipo
    //Ejemplo de uso: Persona persona = Lectura.leerArchivoJSON2("./persona.json",Persona.class);
    //---Asegurar de tener correctamente las dependecias--
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310 --> (por si hay fechas)
    //JSON: como este --> "" //TODO: cambiar por el url json
    public static <T> T leerArchivoJSON2(String nombre, Class<T> clase) {
        T datos = null;
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule()); //para poder manejar fechas

        try {
            datos = mapeador.readValue(new File(nombre),
                    mapeador.getTypeFactory().constructType(clase));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datos;
    }
    
    
    //Método que devuelve un Map.
    public static Map<String, Integer> profesoresPorDepartamento(ArrayList<Object> listaEmpleados) {
        //Creo el Map vacío para hacer el return con los datos implementados.
        Map<String, Integer> map = new TreeMap<>();
        //Recorro con un bucle for la lista de Empleados
        for (Empleado emp : listaEmpleados) {
            //Declaro un int en el que almacenaré los datos.
            int cantidadEmpleados = 1;
            for (Empleado empleado : listaEmpleados) {
                if (emp.getPuesto().equals(empleado.getPuesto()) && emp != empleado) {
                    cantidadEmpleados++;
                }
            }
            //Almaceno en el map el puest (String) y la cantidad de empleados (Integer).
            map.put(emp.getPuesto(), cantidadEmpleados);
        }
        return map;
    }

    public static void imprimirMap(Map<String, Integer> map) {
        map.forEach((clave, valor) -> System.out.println(clave + " ----- " + valor));
    }
    

}
