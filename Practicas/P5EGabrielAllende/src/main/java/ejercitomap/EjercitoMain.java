package ejercitomap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class EjercitoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicializo nueva estructura map y lista de ejercitos
        Map<String, Ejercito> map = new HashMap();
        Ejercito lista = new Ejercito();

        //Añadimos objetos a la lista 1
        lista.alistarSoldado(new Soldado("00001", "Juan Carlos", "Fernández", "Vico", 31));
        lista.alistarSoldado(new Soldado("00002", "Edgardo Gabriel", "Allende", "Palacio", 27));
        lista.alistarSoldado(new Soldado("00003", "Javier", "Parodi", "Piñero", 25));
        lista.alistarSoldado(new Soldado("00004", "Eduardo", "Orellana", "Pomares", 23));
        map.put("1", lista);
        
        
        Ejercito lista2 = new Ejercito();

        //Añadimos objetos a la lista 2
        lista2.alistarSoldado(new Soldado("00001", "Juan Carlos", "Fernández", "Vico", 31));
        lista2.alistarSoldado(new Soldado("00002", "Edgardo Gabriel", "Allende", "Palacio", 27));
        lista2.alistarSoldado(new Soldado("00003", "Javier", "Parodi", "Piñero", 25));
        lista2.alistarSoldado(new Soldado("00004", "Eduardo", "Orellana", "Pomares", 23));
        map.put("2", lista2);

        boolean containsKey = map.containsKey("2");
        System.out.println("¿Map contiene la lista con número 2?: " + containsKey);
        System.out.println("¿Map contiene la lista número 1?: " + map.containsValue(lista) + "\n");

        System.out.println("\nLista 1: ");
        lista.mostrarLista();
        System.out.println("\nLista 2: ");
        lista2.mostrarLista();
    }
}
