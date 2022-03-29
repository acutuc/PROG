package ej13interfaces;

/**
 *
 * @author acutuc
 */
//Definición de la clase. Implementa la interface Identificable
public abstract class Persona implements Identificable{
    //Atributos de la clase.
    private String nombre;
    private String apellidos;
    private String nif;
    private String direccion;
    
    //Constructor con sus atributos por defecto.
    public Persona(){
    }
    
    //Constructor parametrizado.
    public Persona(String nombre, String apellidos, String nif, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
    }
    
    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //toString()
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + '}';
    }
    
    
}
