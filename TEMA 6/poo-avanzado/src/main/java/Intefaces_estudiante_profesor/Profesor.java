/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces_estudiante_profesor;

/**
 *
 * @author carlos
 */
public class Profesor extends Persona{
    
    private String especialidad;

    public Profesor(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public Profesor(){
        
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor{" + "especialidad=" + especialidad + '}';
    }
     
    public void investigar(String materia){
        System.out.println("Soy " + this.getNombre() + " y estoy investigando " + materia);
    }
    
    public void identificate(){
        System.out.println("Soy un profesor de la especialidad: " + this.especialidad);
    }
}
