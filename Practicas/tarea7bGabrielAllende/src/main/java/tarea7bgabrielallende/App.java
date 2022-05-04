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
public class App{

    //Atributos de la clase
    private int COD;
    private String nombre;
    private String descripcion;
    private double tamanio; //en Kb
    private int numDescargas;
    private static int contadorInstancias = 1;

    //A continuación declararé e instanciaré algunas variables y objetos que me ayudarán
    //a elaborar el ejercicio.
    private static final Random aleatorio = new Random();
    //Array de tipo String, en la que almacenaré 10 descripciones que haya elegido yo.
    private static final String[] DESCRIPCIONES = {"Con esta app puedes dominar el mundo", "App en fase de desarrollo",
        "Esta app puede ser perjudicial para su salud", "¿Esto es una app?",
        "Con esta app tiene aprobado el FP", "Con esta app te voy a hackear el ordenador, Vico",
        "Desinstale esta app", "Gabriel Allende ha creado esta app",
        "Hola", "¡Ha gandado 10.000.000€ gracias a esta app!"};

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
    public int getCOD() {
        return COD;
    }

    public void setCOD(int COD) {
        this.COD = COD;
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

}
