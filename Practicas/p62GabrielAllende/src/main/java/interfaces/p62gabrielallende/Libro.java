package interfaces.p62gabrielallende;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Gabriel
 */
//Definición de la clase abstracta, que implementa Comparable
public abstract class Libro extends Producto implements Comparable<Libro>{
    //Atributos de la clase.
    private String isbn;
    
    //Constructor con sus atributos por defecto.
    public Libro() {
        //super();
        //Implemento la clase RandomStringUtils para generar un ISBN aleatorio de 10 dígitos.
        this.isbn = RandomStringUtils.randomNumeric(10);
    }
    
    //Constructor parametrizado
    public Libro(String codigo, double precio, double iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.isbn = RandomStringUtils.randomNumeric(10);
    }
    
    //Getters y setters.
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return super.toString() + "Libro{" + "isbn=" + isbn + '}';
    }
    
    //Método compareTo.
    //Compara el atributo isbn de los libros.
    public int compareTo(Libro libro){
        return this.isbn.compareTo(libro.isbn);
    }
    
    /*17. Inventa un método abstracto en Libro que tenga comportamientos diferentes en las subclases.
    Implementa los métodos en las clases hijas.*/
    public abstract void tipoLibro();
}
