package arraylist;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Libro {

    //Atributos de la clase
    private String isbn;
    private String nombre;
    private String editorial;
    private int numeroPaginas;
    private double precio;

    //Constructor con los valores por defecto.
    public Libro() {
    }

    //Constructor parametrizado.
    public Libro(String isbn, String nombre, String editorial, int numeroPaginas, double precio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
    }

    //Getters y Setters.
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", nombre=" + nombre + ", editorial=" + editorial + ", numeroPaginas=" + numeroPaginas + ", precio=" + precio + '}';
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.isbn);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.editorial);
        hash = 79 * hash + this.numeroPaginas;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
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
        final Libro other = (Libro) obj;
//        if (this.numeroPaginas != other.numeroPaginas) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
//            return false;
//        }
//        if (!Objects.equals(this.isbn, other.isbn)) {
//            return false;
//        }
//        if (!Objects.equals(this.nombre, other.nombre)) {
//            return false;
//        }
        return Objects.equals(this.isbn, other.isbn);
    }
    
}