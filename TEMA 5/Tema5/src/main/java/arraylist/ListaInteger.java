package arraylist;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author acutuc
 */
public class ListaInteger {
    
    private ArrayList<Integer> lista;

    public ListaInteger() {
        lista = new ArrayList<>();
    }
    
    //Crea una lista y la rellena con tantos elementos como indique tam
    public ListaInteger(int tam){
        Random r = new Random();
        lista = new ArrayList<>();
        for (int i = 0; i < tam; i++) {
            Integer aux = r.nextInt(91)+10;
            lista.add(aux);
            
        }
        
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }
    
    
}
