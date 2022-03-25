/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listalibros;

import java.util.Objects;

/**
 *
 * @author profesor
 */
// La interfaz comparable implementa orden natural según equals
// Obliga a implementar el método compareTo
public class Libro implements Comparable<Libro>{
    
    private String isbn;
    private String nombre;
    private String editorial;
    private int numeroPags;
    private double precio;

    public Libro(String isbn, String nombre, String editorial, int numeroPags, double precio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.editorial = editorial;
        this.numeroPags = numeroPags;
        this.precio = precio;
    }

    public Libro() {
    }

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

    public int getNumeroPags() {
        return numeroPags;
    }

    public void setNumeroPags(int numeroPags) {
        this.numeroPags = numeroPags;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", nombre=" + nombre + ", editorial=" + editorial + ", numeroPags=" + numeroPags + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.isbn);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.editorial);
        hash = 89 * hash + this.numeroPags;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    @Override
    // Consideramos dos libros iguales cuando su isbn coincide
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
      
        return Objects.equals(this.isbn, other.isbn);
    }

    // El método compareTo devuelve <0 si this es anterior
    // =0 si this y libro t son iguales
    // >0 si this es posterior
    @Override
    public int compareTo(Libro t) {
        return this.isbn.compareTo(t.isbn);
    }
    
    
    
}
