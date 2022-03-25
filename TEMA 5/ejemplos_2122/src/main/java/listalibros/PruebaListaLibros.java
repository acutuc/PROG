/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listalibros;

import java.util.Collections;

/**
 *
 * @author profesor
 */
public class PruebaListaLibros {
    
    public static void main(String[] args) {
        
        
        
        ListaLibros catalogo = new ListaLibros();
        ListaLibros catalogo2 = new ListaLibros();
        
        catalogo.insertarLibro(new Libro("AZC", "La muerte a pellizcos", "Planeta", 10, 0.9));
        catalogo.insertarLibro(new Libro("BRR", "skldjklsdfjkl", "Planeta", 9, 0.19));
        catalogo.insertarLibro(new Libro("ACE", "La muerte a pellizcos", "Planeta", 8, 0.29));
        catalogo.insertarLibro(new Libro("ABC", "La muerte a pellizcos", "Planeta", 7, 0.9));
        
        catalogo.imprimirConsola();
        catalogo.ordenarISBN();
        catalogo.imprimirConsola();
        int posicion = catalogo.buscarISBN(new Libro("ACE", "La muerte a pellizcos", "Planeta", 10, 0.29));
        System.out.println("Está en la posicion: " + posicion);
        catalogo.ordenarComparatorNombre();
        catalogo.imprimirConsola();
        catalogo.ordenarComparatorPaginas();
        catalogo.imprimirConsola();
        catalogo.ordenarNombrePaginas();
        catalogo.imprimirConsola();
        catalogo.ordenarComparatorNombre();
        int posicion2 = catalogo.buscarBinariaNombre(new Libro("", "skldjklsdfjkl", "", 0, 0.27));
        System.out.println("Está en la posicion: " + posicion2);
        
        //catalogo2.insertarLibro(new Libro("125", "La muerte a bocados", "Planeta", 10, 0.9));
        
//        catalogo.imprimirConsola();
//        
//        System.out.println("Tamaño del catalogo: " + catalogo.getCantidadLibros());
//        
//        Libro libro = catalogo.buscarISBN("1234");
//        System.out.println("Libro buscado: " + libro);
//        
//        libro = catalogo.buscarISBNCuentaVieja("1236");
//        System.out.println("Libro buscado: " + libro);
//        
//        catalogo.borrarLibro(new Libro("1235", "", "", 0, 0));
//        
//        catalogo.imprimirConsola();
//        
//        System.out.println("Libros de precio 0.9");
//        catalogo.buscarPorPrecio(0.9).forEach(System.out::println);
    }
    
}
