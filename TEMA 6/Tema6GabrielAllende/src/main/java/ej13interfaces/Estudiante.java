package ej13interfaces;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Estudiante extends Persona{
    //Atributos de la clase.
    private String id;
    
    //Constructor con sus atributos por defecto.
    public Estudiante(){
        //super();
    }
    
    //Constructor parametrizado.
    public Estudiante(String id, String nombre, String apellidos, String nif, Direccion direccion) {
        super(nombre, apellidos, nif, direccion);
        this.id = id;
    }
    
    //Getters y setters.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + '}';
    }
    
    /*Métodos heredados de la superclase Persona, que a su vez hereda 
    del interface Identificate*/
    @Override
    public void identificate(){
        System.out.println("Esta persona es un Estudiante.");
    }
    
}
