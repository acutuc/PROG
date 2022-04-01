package interfaces.p62gabrielallende;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Gabriel
 */
//Definición de la clase
public class MiTienda {

    //Atributos static de la clase.
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static ArrayList<Libro> listaLibros = new ArrayList<>();

    public static void main(String[] args) {
        //1. Crea una lista de productos y añade dos objetos de cada tipo de producto distinto (de los posibles) a la misma.
        //Añado dos instancias de cada objeto distinto, de los posibles (los objetos de clase abstracta no se pueden instanciar).
        //LibroDigital y LibroPapel pueden ser añadidos a ambas listas.
        //listaProductos :
        LibroDigital libro1 = new LibroDigital(1550, "46885", 12.50, 21, "AQUI VA UNA DESCRIPCIÓN");
        listaProductos.add(libro1);
        listaProductos.add(new LibroDigital(2460, "62894", 40, 20, "AQUI VA UNA DESCRIPCIÓN"));

        listaProductos.add(new LibroPapel(450, "46297", 25, 21, "AQUI VA UNA DESCRIPCIÓN"));
        listaProductos.add(new LibroPapel(120, "49513", 12, 21, "AQUI VA UNA DESCRIPCIÓN"));

        listaProductos.add(new Pantalon("L", "MarcaA", "26059", 25, 21, "AQUI VA UNA DESCRIPCIÓN"));
        listaProductos.add(new Pantalon("XXL", "MarcaB", "01954", 120, 21, "AQUI VA UNA DESCRIPCIÓN"));

        listaProductos.add(new Musica("GrupoA", "30418", 13.55, 21, "AQUI VA UNA DESCRIPCIÓN"));
        listaProductos.add(new Musica("GrupoB", "84756", 155, 21, "AQUI VA UNA DESCRIPCIÓN"));


        /*2. Muestra los datos de los productos usando un foreach y el método toString().
        Contesta usando un comentario en el código: ¿es toString() un método polimórfico? Justifica la respuesta.*/
        System.out.println("Mostrando los productos SIN ORDENAR:");
        for (Producto obj : listaProductos) {
            if (obj instanceof LibroDigital) {
                LibroDigital aux = (LibroDigital) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof LibroPapel) {
                LibroPapel aux = (LibroPapel) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof Pantalon) {
                Pantalon aux = (Pantalon) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof Musica) {
                Musica aux = (Musica) obj; //Conversión explícita
                System.out.println(aux.toString());
            }

            /*toString es un método polimórfico. Es un método que hereda de una clase padre a una hija,
            sobrescribiendo (modificando) el comportamiento de dicho método.*/
        }

        //3. Ordena la lista de productos según el precio, haciendo uso de <<Comparator>> y una expresión lambda.
        //Creo el criterio con el que ordenamos, en este caso usando el atributo precio.
        Comparator<Producto> criterioPrecio = (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio());
        //Utilizo el método sort de la clase Collections, pasando por parámentro la lista a ordenar y el criterio.
        Collections.sort(listaProductos, criterioPrecio);

        //4. Muestra la lista de productos ordenados por precio.
        System.out.println("\nMostrando los productos ORDENADOS POR PRECIO:");
        for (Producto obj : listaProductos) {
            if (obj instanceof LibroDigital) {
                LibroDigital aux = (LibroDigital) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof LibroPapel) {
                LibroPapel aux = (LibroPapel) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof Pantalon) {
                Pantalon aux = (Pantalon) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof Musica) {
                Musica aux = (Musica) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
        }

        /*5. Ordena la lista de productos según el código, haciendo uso de <<Comparator>> y una expresión lambda.*/
        //Creo el criterio con el que ordenamos, en este caso usando el atributo codigo.
        Comparator<Producto> criterioCodigo = (p1, p2) -> p1.getCodigo().compareTo(p2.getCodigo());
        //Utilizo el método sort de la clase Collections, pasando por parámetro la lista a ordenar y el criterio.
        Collections.sort(listaProductos, criterioCodigo);

        //6. Muestra la lista de productos ordenados por código.
        System.out.println("\nMostrando los productos ORDENADOS POR CÓDIGO:");
        for (Producto obj : listaProductos) {
            if (obj instanceof LibroDigital) {
                LibroDigital aux = (LibroDigital) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof LibroPapel) {
                LibroPapel aux = (LibroPapel) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof Pantalon) {
                Pantalon aux = (Pantalon) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof Musica) {
                Musica aux = (Musica) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
        }

        /*7. Realiza la búsqueda binaria según su código de algún producto que exista dentro de la lista y otro que no exista,
        mostrando la posición que ocupa en la lista.*/
        //Búsqueda de un objeto existente.
        System.out.println("Búsqueda de un objeto EXISTENTE:");
        int posicion = Collections.binarySearch(listaProductos, libro1, criterioCodigo);
        System.out.println("Está en la posición " + posicion);

        //Búsqueda de un objeto inexistente.
        //Elimino libro1 de la lista de productos.
        listaProductos.remove(libro1);
        System.out.println("Búsqueda de un objeto INEXISTENTE:");
        posicion = Collections.binarySearch(listaProductos, libro1, criterioCodigo); //Conversión implícita de posicion.
        System.out.println("Está en la posición " + posicion);

        //7. Recorre la lista de productos y guarda todos los libros en una lista de libros.
        for (Producto obj : listaProductos) {
            if (obj instanceof LibroDigital) {
                LibroDigital aux = (LibroDigital) obj; //Conversión explícita
                listaLibros.add(aux);
            }
            if (obj instanceof LibroPapel) {
                LibroPapel aux = (LibroPapel) obj; //Conversión explícita
                listaLibros.add(aux);
            }

        }

        //8. Muestra los datos de la lista de libros usando un foreach y el método toString()
        System.out.println("\nMostrando los libros almacenados en listaLibros: ");
        for (Libro libro : listaLibros) {
            System.out.println(libro.toString());
        }

        //10. Ordena los libros según ISBN, haciendo uso de <<Comparable>>
        //Creo el criterio con el que ordenaremos, en este caso por ISBN.
        Comparator<Libro> criterioISBN = (l1, l2) -> l1.getIsbn().compareTo(l2.getIsbn());
        //Utilizo el método sort de la clase Collections, pasando por parámetro la lista a ordenar y el criterio.
        Collections.sort(listaLibros, criterioISBN);

        //11. Muestra la lista de libros ordenada. 
        System.out.println("\nMostrando la lista de libros ordenados por ISBN:");
        for (Producto obj : listaLibros) {
            if (obj instanceof LibroDigital) {
                LibroDigital aux = (LibroDigital) obj; //Conversión explícita
                System.out.println(aux.toString());
            }
            if (obj instanceof LibroPapel) {
                LibroPapel aux = (LibroPapel) obj; //Conversión explícita
                System.out.println(aux.toString());
            }

        }

        //12. Recorre de nuevo la lista de libros y en cada iteración, ejecuta enviar() o descargar() en función del tipo de libro.
        System.out.println("\nMostrando listaLibros ejecutando los métodos enviar() o descargar(): ");
        for (Producto obj : listaLibros) {
            if (obj instanceof LibroDigital) {
                LibroDigital aux = (LibroDigital) obj; //Conversión explícita
                aux.descargar();
            }
            if (obj instanceof LibroPapel) {
                LibroPapel aux = (LibroPapel) obj; //Conversión explícita
                aux.enviar("Calle Falsa 123");
            }

        }

        /*13. Indica las líneas de código donde se realizan conversiones implícitas y/o explícitas,
        así como los métodos polimórficos que hay en la jerarquía.*/
        //Conversiones descritas en sus respectivas líneas.
        //Los métodos polimórficos que tenemos son: toString(), equals(), hashCode(),
        //enviar() y descargar().
        //14. Utiliza el método contains(Object) sobre la lista de libros para comprobar si existe un libro o no existe.
        System.out.println("Comprobando si libro1 existe o no:");
        System.out.println(listaLibros.contains(libro1));

        //15. Usando la lista de productos inicial, crea una nueva lista con todos los objetos del tipo <<SeEnvía>>.
        //Instancio la nueva lista en la que meteré los objetos.
        ArrayList<SeEnvia> listaTipoSeEnvia = new ArrayList<>();

        for (Producto obj : listaProductos) {
            if (obj instanceof SeEnvia) {
                SeEnvia aux = (SeEnvia) obj; //Conversión explícita.
                listaTipoSeEnvia.add(aux);
            }
        }

        //16. Recorre la lista de objetos <<SeEnvía>> y llama al método de la interfaz.
        System.out.println("\nRecorriendo la lista de objetos SeEnvia, llamando al método de la interfaz: ");
        for (SeEnvia see : listaTipoSeEnvia) {
            see.enviar("Calle del éxito");
        }

        //17. Inventa un método abstracto en Libro que tenga comportamientos diferentes en las subclases. Implementa los métodos en las clases hijas.
        //Llamo al método implementado.
        System.out.println("\nLlamando al método abstracto heredado de la clase padre Libro: ");
        for (Libro libro : listaLibros) {
            libro.tipoLibro();
        }
    }
}
