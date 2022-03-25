package ej15legisladorabstracto;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Persona {
    //Atributos de la clase.
    private String nombre;
    private String apellido;
    
    //Constructor con sus valores por defecto.
    public Persona() {
    }
    
    //Constructor parametrizado.
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
}
