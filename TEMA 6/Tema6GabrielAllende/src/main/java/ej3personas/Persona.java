package ej3personas;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Persona {
    //Atributos de la clase.
    private String nombre;
    private String nif;
    private int edad;

    //Constructor con sus valores por defecto.
    public Persona() {
    }
    
    //Constructor parametrizado.
    public Persona(String nombre, String nif, int edad) {
        this.nombre = nombre;
        this.nif = nif;
        this.edad = edad;
    }
    
    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //toString().
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", nif=" + nif + ", edad=" + edad + '}';
    }
    
    
    
    
}
