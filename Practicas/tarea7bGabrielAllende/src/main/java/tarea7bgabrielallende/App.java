package tarea7bgabrielallende;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author acutuc
 */
/*11.- Crea la clase App, con los siguientes atributos: código único (int), nombre (String), descripción (String), tamaño en Kb (double) y número de descargas (int).
Crea un constructor por defecto y otro parametrizado para la clase.
El constructor por defecto inicializa los atributos de la app de forma aleatoria, siguiendo los siguientes criterios:
- El código único se implementará con un contador de instancias.
- El nombre será un String con el formato: “app+codigo único+letra aleatoria (a-z)”. Por ejemplo: app1x, app2y, app3a, etc.
- La descripción será un String aleatorio de un conjunto de 10 descripciones que tú decidas.
- El tamaño de las aplicaciones estará entre 100.0 kb y 1024.0 kb. Para asignar el tamaño a cada aplicación debes generar un DoubleStream de tamaño 1 usando el método doubles(int tamañoStream, double valorInicial, double valorFinal) de la clase Random.
- Para el número de descargas se debe operar igual que para las descargas, usando un IntStream de tamaño 1, con valor inicial 0 y valor final 50000.

Además, incluye getters,  setters y el método toString(), de forma que devuelva los atributos de la aplicación separados por el carácter (;). En el método main() de una clase de prueba realiza lo siguiente:
- Crea 50 aplicaciones usando el constructor por defecto, guárdalas en una lista y muéstralas por pantalla. 
- Guarda los datos de todas las App de la lista, en un fichero de texto llamado aplicacionestxt.txt, dentro del directorio “./appstxt”.
- Guarda los datos de todas las App de la lista, en un fichero XML llamado aplicacionesxml.xml, dentro del directorio “./appsxml”.
- Guarda los datos de todas las App de la lista, en un fichero JSON llamado aplicacionesxml.json, dentro del directorio “./appsjson”.
- Crea una carpeta “./copias” y realiza una copia de los ficheros anteriores dentro de ella.
- En una carpeta “./aplicaciones” crea un archivo de texto por cada aplicación que haya en la lista. El archivo se llamará igual que la app y contendrá los datos de la aplicación, separando los campos por el carácter (;).
 */
//Definición de la clase
public class App {

    //Atributos de la clase
    private final int COD;
    private String nombre;
    private String descripcion;
    private double tamanio; //en Kb
    private int numDescargas;
    private static int contadorInstancias = 1;

    //A continuación declararé e instanciaré algunas variables y objetos que me ayudarán
    //a elaborar el ejercicio.
    private static final Random aleatorio = new Random();
    //Array de tipo String, en la que almacenaré 10 descripciones que haya elegido yo.
    private static final String[] DESCRIPCIONES = {"Esto es una demo 1", "Esto es una demo 2",
        "Esto es una demo 3", "Esto es una demo 4",
        "Esto es una demo 5", "Esto es una demo 6",
        "Esto es una demo 7", "Esto es una demo 8",
        "Esto es una demo 9", "Esto es una demo 10"};

    //Constructor con sus atributos por defecto
    public App() {
        this.COD = contadorInstancias;
        contadorInstancias++;
        this.nombre = "app" + this.COD + RandomStringUtils.randomAlphabetic(1).toLowerCase();
        this.descripcion = generarDescripcion();
        //El último parámetro del método double será 1024.1, pues éste valor es excluído, 
        //estando de ésta manera el 1024.0 incluído en el rango.
        //Utilizo el método sum() para que me devuelva directamente un dato primitivo tipo double.
        this.tamanio = aleatorio.doubles(1, 100.0, 1024.1).sum();
        //Con numDescargas aplico la misma lógica que en tamanio.
        this.numDescargas = aleatorio.ints(1, 0, 50001).sum();
    }

    //Constructor parametrizado
    public App(int cod, String nombre, String descripcion, double tamanio, int numDescargas) {
        this.COD = cod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.numDescargas = numDescargas;
    }

    //Getters y setters
    //COD tendrá solo getter.
    public int getCOD() {
        return COD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    public static void setContadorInstancias(int contadorInstancias) {
        App.contadorInstancias = contadorInstancias;
    }

    //toString(), aplicando el criterio del enunciado del ejercicio.
    @Override
    public String toString() {
        return COD + ";" + nombre + ";" + descripcion + ";" + tamanio + ";" + numDescargas;
    }

    //Método que genera una descripción aleatoria
    public static String generarDescripcion() {
        return DESCRIPCIONES[aleatorio.nextInt(DESCRIPCIONES.length)];
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

    //MAIN DE LA APLICACIÓN
    public static void main(String[] args) throws FileNotFoundException {
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

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroXml))) {
            //Recorremos la lista y vamos escribiendo en el fichero los datos de cada objeto.
            for (App app : listaApps) {
                flujo.write(app.getCOD() + ";" + app.getNombre() + ";" + app.getDescripcion() + ";" + app.getTamanio() + ";"
                        + app.getNumDescargas());
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + idFicheroXml + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Guarda los datos de todas las App de la lista, en un fichero JSON llamado aplicacionesxml.json, dentro del directorio “./appsjson”.
        //Creo el directorio.
        crearDirectorio("./appsjson/");
        //ID del fichero .json a escribir. Escribo la ruta del directorio creada anteriormente.
        String idFicheroJson = "./appsjson/aplicacionesxml.json";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroJson))) {
            //Recorremos la lista y vamos escribiendo en el fichero los datos de cada objeto.
            for (App app : listaApps) {
                flujo.write(app.getCOD() + ";" + app.getNombre() + ";" + app.getDescripcion() + ";" + app.getTamanio() + ";"
                        + app.getNumDescargas());
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + idFicheroJson + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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

}
