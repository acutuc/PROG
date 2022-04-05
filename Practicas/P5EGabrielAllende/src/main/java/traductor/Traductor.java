package traductor;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Traductor {

    //Atributos de la clase.
    private Map<String, String> traductor;

    //Constructor con los atributos por defecto.
    public Traductor() {
        this.traductor = new TreeMap();
    }

    //Métodos:
    //Método que guarda una entrada y recibirá dos palabras
    public void guardaEntrada(String palabraIngles, String palabraEspanol) {
        traductor.put(palabraIngles, palabraEspanol);
    }

    //Método que elimina entradas
    public void eliminaEntrada(String palabraIngles) {
        traductor.remove(palabraIngles);
    }

    //Método que modifica entradas
    public void modificaEntrada(String palabraIngles, String palabraEspanol) {
        traductor.replace(palabraIngles, palabraEspanol);
    }

    //Método que traduce una palabra inglesa.
    public String traducirDelIngles(String palabraIngles) {
        return traductor.get(palabraIngles);
    }

    //Método que devuelve en un ArrayList todas las palabras inglesas.
    public ArrayList<String> listaPalabrasInglesas() {
        ArrayList<String> palabrasIngles = new ArrayList<>(traductor.keySet());
        return palabrasIngles;
    }

    //Método que devuelve en un ArrayList todas las palabras españolas
    public ArrayList<String> listaPalabrasEspanol() {
        ArrayList<String> palabrasEspanol = new ArrayList<>(traductor.values());
        return palabrasEspanol;
    }

    //Método para imprimir todo el contenido del Map.
    public void imprimirMap() {
        traductor.entrySet().forEach(aux -> {
            System.out.println(aux.getKey() + "\t\t" + aux.getValue());
        });

    }

}
