package ej13interfaces;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Profesor extends Persona{
    //Atributos de la clase.
    private String especialidad;
    
    //Constructor con sus atributos por defecto
    public Profesor(){
        //super();
    }
    
    //Constructor parametrizado.
    public Profesor(String especialidad, String nombre, String apellidos, String nif, String direccion) {
        super(nombre, apellidos, nif, direccion);
        this.especialidad = especialidad;
    }
    
    //Getters y setters.
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Profesor{" + "especialidad=" + especialidad + '}';
    }
    
    /*Métodos heredados de la superclase Persona, que a su vez hereda 
    del interface Identificate*/
    @Override
    public void identificate(){
        System.out.println("Esta persona es un Profesor.");
    }
    
}
