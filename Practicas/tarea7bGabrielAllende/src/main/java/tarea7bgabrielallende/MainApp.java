package tarea7bgabrielallende;

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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Gabriel
 */
public class MainApp {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, JAXBException {
        //Crea 50 aplicaciones usando el constructor por defecto, guárdalas en una lista y muéstralas por pantalla. 
        //Instancio un ArrayList de App
        ArrayList<App> listaApps = new ArrayList<>();
        //Bucle para crear 50 App y seguidamente almacenarlas en el ArrayList anterior.
        for (int i = 0; i < 50; i++) {
            App app = new App();
            listaApps.add(app);
        }
        //Imprimo la lista.
        listaApps.forEach(System.out::println);

        //Guarda los datos de todas las App de la lista, en un fichero de texto llamado aplicacionestxt.txt, dentro del directorio “./appstxt”.
        //Creo el directorio.
        crearDirectorio("./appstxt/");

        //ID del fichero .txt a escribir. Escribo la ruta del directorio creada anteriormente.
        String idFicheroTxt = "./appstxt/aplicacionestxt.txt";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroTxt))) {
            //Recorremos la lista y vamos escribiendo en el fichero los datos de cada objeto.
            for (App app : listaApps) {
                flujo.write(app.getCOD() + ";" + app.getNombre() + ";" + app.getDescripcion() + ";" + app.getTamanio() + ";"
                        + app.getNumDescargas());
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + idFicheroTxt + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Guarda los datos de todas las App de la lista, en un fichero XML llamado aplicacionesxml.xml, dentro del directorio “./appsxml”.
        //Creo el directorio.
        crearDirectorio("./appsxml/");
        //ID del fichero .xml a escribir. Escribo la ruta del directorio creada anteriormente.
        String idFicheroXml = "./appsxml/aplicacionesxml.xml";
        
        // Se preparan los objetos a utilizar
        CatalogoApps catalogo = new CatalogoApps();
        catalogo.setLista(listaApps);
        catalogo.setDescripcion("Tarea7BGabrielAllende");
        
        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoApps
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
        
        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoApps) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();
        
        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        
        // Serialización y salida por consola
        serializador.marshal(catalogo, System.out);

        // Volcado al fichero xml
        serializador.marshal(catalogo, new File(idFicheroXml));

        //Guarda los datos de todas las App de la lista, en un fichero JSON llamado aplicacionesxml.json, dentro del directorio “./appsjson”.
        //Creo el directorio.
        crearDirectorio("./appsjson/");
        //ID del fichero .json a escribir. Escribo la ruta del directorio creada anteriormente.
        String idFicheroJson = "./appsjson/aplicacionesxml.json";
        
        ObjectMapper mapeador = new ObjectMapper();

        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idFicheroJson), listaApps);
        

        //Crea una carpeta “./copias” y realiza una copia de los ficheros anteriores dentro de ella.
        //Creo el directorio "copias"
        crearDirectorio("./copias");
        //Copio los tres ficheros en la ruta creada anteriormente.
        copiarFicheros(idFicheroJson, "copias/aplicacionesxml.json");
        copiarFicheros(idFicheroTxt, "copias/aplicacionestxt.txt");
        copiarFicheros(idFicheroXml, "copias/aplicacionesxml.xml");

        //En una carpeta “./aplicaciones” crea un archivo de texto por cada aplicación que haya en la lista. El archivo se llamará igual que la app y contendrá los datos de la aplicación, separando los campos por el carácter (;).
        //Creo el directorio "aplicaciones"
        crearDirectorio("./aplicaciones");

        for (int i = 0; i < listaApps.size(); i++) {
            App aux = listaApps.get(i);
            try (BufferedWriter flujo = new BufferedWriter(new FileWriter("./aplicaciones/" + aux.getNombre() + ".txt"))) {
                //Recorremos la lista y vamos escribiendo en el fichero los datos de cada objeto.
                flujo.write(aux.getCOD() + ";" + aux.getNombre() + ";" + aux.getDescripcion() + ";" + aux.getTamanio() + ";"
                        + aux.getNumDescargas());
                flujo.flush();
                System.out.println("Fichero " + aux.getNombre() + " creado correctamente.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

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

}
