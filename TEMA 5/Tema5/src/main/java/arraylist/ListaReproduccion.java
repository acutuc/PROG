package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author acutuc
 */
/*
Desarrolla una clase ListaReproduccion con los siguientes atributos y métodos. Es necesario implementar la clase Cancion:

Atributos:
- canciones: una lista de objetos de la clase Cancion.

Métodos (recuerda implementar equals y hashcode en Cancion)
- constructor predeterminado (creará e inicializará la lista).
- numeroCanciones(): devuelve el número de canciones de la lista.
- estaVacia(): devuelve si la lista de reproducción está vacía.
- escucharCancion(int): devuelve la Cancion que se encuentra en la posición indicada.
- cambiarCancion(int, Cancion): cambia la Cancion de la posición indicada por la nueva Cancion proporcionada.
- grabarCancion(Cancion): agrega al final de la lista la Cancion proporcionada.
- eliminaCancion(int): elimina la Cancion que se encuentra en la posición indicada.
- eliminaCancion(Cancion c), elimina el objeto c si se encuentra en la lista de reproducción. Usa el método remove(Cancion)
- imprimirLista (ListaReproduccion tmp). Método de clase que imprime los nombres de las canciones contenidas en tmp.
- buscarCancion(Cancion c), busca la canción c en la lista de reproducción y devuelve la posición en la que se encuentra. Usa el método indexOf.
- Incluye un par de método de ordenación (por ejemplo, por título y por cantante) usando el método Collections.sort(lista, criterioComparator)
- Añade también métodos para buscar, usando Collections.binarySearch(lista, objeto, criterioComparator)
 */
public class ListaReproduccion {

    private ArrayList<Cancion> lista;

    //Constructor por defecto, solo instancia la estructura lista sin incluir ningún objeto.
    public ListaReproduccion() {
        this.lista = new ArrayList<>();
    }

    //Método numeroCanciones(). Devuelve el número de canciones en la lista.
    public int numeroCanciones() {
        return lista.size();
    }

    //Método estaVacia(). Devuelve si la lista de reproducción está vacía.
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    //Método escucharCancion(int). Devuelve la Cancion que se encuentra en la posición indicada.
    public Cancion escucharCancion(int posicion) {
        Cancion aux = new Cancion();
        for (int i = 0; i < lista.size(); i++) {
            lista.get(posicion);
            return aux;
        }
        return aux;
    }

    //Método cambiarCancion(int, Cancion). Cambia la Cancion de la posición indicada por la nueva Cancion proporcionada.
    public void cambiarCancion(int cancionACambiar, Cancion nuevaCancion) {
        lista.set(cancionACambiar, nuevaCancion);
    }

    //Método grabarCancion(Cancion). Agrega al final de la lista la Cancion proporcionada.
    public void grabarCancion(Cancion cancionAgregada) {
        lista.add(cancionAgregada);
    }

    //Método eliminaCancion(int). Elimina la Cancion que se encuentra en la posición indicada.
    public void eliminaCancion(int puestoCancion){
        lista.remove(puestoCancion);
    }
    
    //Método eliminaCancion(Cancion c). Elimina el objeto c si se encuentra en la lista de reproducción. Usa el método remove(Cancion)
    public void eliminaCancion(Cancion cancionAEliminar){
        lista.remove(cancionAEliminar);
    }
    
    //Método imprimirLista (ListaReproduccion tmp). Método de clase que imprime los nombres de las canciones contenidas en tmp.
    public static void imprimirLista (ListaReproduccion tmp){
        for (Cancion cancion : tmp.lista) {
            System.out.println(cancion.getTituloCancion());
        }
    }
    
    //Método buscarCancion(Cancion c). Busca la Cancion c en la lista de reproducción y devuelve la posición en la que se encuentra. Usa el método indexOf.
    public void buscarCancion(Cancion c){
        lista.indexOf(c);
    }
    
    //Incluye un par de método de ordenación (por ejemplo, por título y por cantante) usando el método Collections.sort(lista, criterioComparator)
    public void ordenarLista(){
        Comparator<Cancion> criterioTitulo = (c1, c2)->c1.getTituloCancion().compareTo(c2.getTituloCancion());
        Comparator<Cancion> criterioCantante = (c1, c2)->c1.getAutorCancion().compareTo(c2.getAutorCancion());
        Comparator<Cancion> criterioTituloCantante = criterioTitulo.thenComparing(criterioCantante);
        Collections.sort(lista, criterioTituloCantante);
    }
}
