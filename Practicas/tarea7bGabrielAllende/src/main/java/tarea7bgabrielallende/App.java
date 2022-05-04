package tarea7bgabrielallende;
import java.util.Random;
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
    private static final String[] DESCRIPCIONES = {"Descripción genérica número 1", "Descripción genérica número 2", 
                                                    "Descripción genérica número 3", "Descripción genérica número 4",
                                                    "Descripción genérica número 5", "Descripción genérica número 6",
                                                    "Descripción genérica número 7", "Descripción genérica número 8",
                                                    "Descripción genérica número 9", "Descripción genérica número 10"};
    
    //Constructor con sus atributos por defecto
    public App(){
        this.COD = contadorInstancias;
        contadorInstancias++;
        this.nombre = "app" + this.COD + RandomStringUtils.randomAlphabetic(1).toLowerCase();
        this.descripcion = generarDescripcion();
    }
    
    //Constructor parametrizado
    public App(int cod, String nombre, String descripcion, double tamanio, int numDescargas) {
        this.COD = cod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.numDescargas = numDescargas;
    }
    
    //Método que genera una descripción aleatoria
    public static String generarDescripcion(){
        return DESCRIPCIONES[aleatorio.nextInt(DESCRIPCIONES.length)];
    }
    
    
}
