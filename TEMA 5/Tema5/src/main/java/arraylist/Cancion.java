package arraylist;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
/*Desarrolla una clase ListaReproduccion con los siguientes atributos y métodos. Es necesario implementar la clase Cancion:

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
//Definición de la clase.
public class Cancion implements Comparable<Cancion> {

    //Atributos de la clase
    private String tituloCancion;
    private int anioLanzamiento;
    private String autorCancion;

    //Constructor con sus valores por defecto.
    public Cancion() {
    }

    //Constructor parametrizado.
    public Cancion(String tituloCancion, int anioLanzamiento, String autorCancion) {
        this.tituloCancion = tituloCancion;
        this.anioLanzamiento = anioLanzamiento;
        this.autorCancion = autorCancion;
    }

    //Getters y setters.
    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getAutorCancion() {
        return autorCancion;
    }

    public void setAutorCancion(String autorCancion) {
        this.autorCancion = autorCancion;
    }

    //toString
    @Override
    public String toString() {
        return "Cancion{" + "tituloCancion=" + tituloCancion + ", anioLanzamiento=" + anioLanzamiento + ", autorCancion=" + autorCancion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        if (this.anioLanzamiento != other.anioLanzamiento) {
            return false;
        }
        if (!Objects.equals(this.autorCancion, other.autorCancion)) {
            return false;
        }
        return Objects.equals(this.tituloCancion, other.tituloCancion);
    }

    @Override
    public int compareTo(Cancion c) {
        return this.tituloCancion.compareTo(c.tituloCancion);
    }

}
