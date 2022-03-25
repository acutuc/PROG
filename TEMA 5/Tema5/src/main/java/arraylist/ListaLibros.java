package arraylist;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
/*Desarrollar una lista de Libros. La funcionalidad de la lista será la habitual:
  conocer el número de libros que hay en la lista, insertar un nuevo libro (en la posición que le corresponda),
  eliminar el libro de una determinada posición y obtener el libro de una determinada posición
  También incluirá un método para buscar de forma secuencial un libro a partir de su título (no se diferencian entre mayúsculas y minúsculas);
  el método devolverá la posición en la que se encuentra el libro (–1 si no se encuentra)
  Se debe crear la clase Libro con un par de atributos, constructores, getters y setters.
  De forma opcional se pueden implementar los método equals() y la interfaz <<Comparable>> en Libro y usar los métodos sort() y binarySearch().*/
public class ListaLibros {

    //Atributo encapsulado de tipo lista
    private ArrayList<Libro> lista;

    //Constructor por defecto, solo instancia la estructura lista sin incluir ningún objeto
    public ListaLibros() {
        this.lista = new ArrayList<>();
    }

    //Guarda un libro al final de la lista, si no es nulo
    public void insertarLibro(Libro libro) {
        if (libro != null) {
            lista.add(libro);
        }
    }

    public void imprimirConsola() {
        System.out.println("Imprimiendo lista de libros...");
        lista.forEach(System.out::println);
    }

    public int getCantidadLibros() {
        return lista.size();
    }

    //Eliminar un libro
    public boolean eliminarLibro(Libro libro) {
        return lista.remove(libro);
    }

    //Buscar un libro
    public Libro buscarISBNCuentaVieja(String isbn) {
        Libro aux = null;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.get(i);
            if (aux.getIsbn().equals(isbn)) {
                return aux;
            }
        }
        return aux;
    }

    //SEGUNDA OPCION DE BUSCAR LIBRO
    public Libro buscarISBN(String isbn) {
        Libro aux = new Libro(isbn, "", "", 0, 0);
        int indice = lista.indexOf(aux);
        if (indice >= 0) {
            return lista.get(indice);
        }
        return null;
    }

    //Buscar por precio.
    public ArrayList<Libro> buscarPorPrecio(double precio) {
        ArrayList<Libro> lista = new ArrayList();
        for (Libro libro : this.lista) {
            if (libro.getPrecio() == precio) {
                lista.add(libro);
            }
        }
        return lista;
    }
}
