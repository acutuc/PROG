/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listalibros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author profesor
 */
public class ListaLibros {

    // Atributo encapsulado de tipo lista
    private ArrayList<Libro> lista;

    // Constructor por defecto, solo instancia la estructura list
    // sin incluir ningún objeto
    public ListaLibros() {
        this.lista = new ArrayList<>();
    }

    // Guarda un libro al final de la lista, si no es null
    public void insertarLibro(Libro libro) {
        if (libro != null) {
            lista.add(libro);
        }
    }

    public void imprimirConsola(){
        System.out.println("Imprimiendo lista de libros...");
        lista.forEach(System.out::println);
    }
    
    public int getCantidadLibros(){
        return lista.size();
    }
    
    // Eliminar
    public boolean borrarLibro(Libro libro){
        return lista.remove(libro);
    }
    
    public Libro buscarISBNCuentaVieja(String isbn){
        Libro aux = null;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.get(i);
            if (aux.getIsbn().equals(isbn)){
                return aux;
            }
        }
        return aux;
    }
    
    public Libro buscarISBN(String isbn){
        Libro aux = new Libro(isbn, "", "", 0, 0);
        
        int indice = lista.indexOf(aux);
        
        if (indice>=0){
            return lista.get(indice);
        }
        
        return null;
    }
    
    public ArrayList<Libro> buscarPorPrecio(double precio){
        ArrayList<Libro> aux = new ArrayList<>();
        for (Libro libro : this.lista) {
            if (libro.getPrecio() == precio){
                aux.add(libro);
            }
        }
        return aux;
        
    }
    
    // Collections.sort(lista) lista debe contener objetos que implementan
    // comparable
    public void ordenarISBN(){
        Collections.sort(this.lista);
    }
    
    // Búsqueda binaria de un objeto según la ordenación natural
    // binarySearch no funciona si la lista está desordenada
    public int buscarISBN(Libro l){
        
        return Collections.binarySearch(lista, l);
    }
    
    public void ordenarComparatorNombre(){
        Collections.sort(lista, (Libro l1,Libro l2)->l1.getNombre().compareTo(l2.getNombre()));
    }
    
    public int buscarBinariaNombre(Libro l){
        // lista debe estar ordenada según el criterio que se pasa a este método (nombre)
        return Collections.binarySearch(lista, l, (Libro l1,Libro l2)->l1.getNombre().compareTo(l2.getNombre()));
    }
    
    public void ordenarComparatorPaginas(){
        //Collections.sort(lista, (Libro l1,Libro l2)->l1.getNumeroPags() - l2.getNumeroPags());
        Collections.sort(lista, (l1, l2)->Integer.compare(l1.getNumeroPags(), l2.getNumeroPags()));
    }
    
    public void ordenarNombrePaginas(){
        Comparator<Libro> criterioNombre = (l1, l2)->l1.getNombre().compareTo(l2.getNombre());
        Comparator<Libro> criterioPaginas = (l1, l2)->Integer.compare(l1.getNumeroPags(), l2.getNumeroPags());
        Comparator<Libro> criterioNombrePaginas = criterioNombre.thenComparing(criterioPaginas);
        Collections.sort(lista, criterioNombrePaginas);
    }
}
