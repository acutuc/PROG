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
public class Estudiante extends Persona {
    
    private String id;

    public Estudiante(String id) {
        this.id = id;
    }
    
    public Estudiante(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + '}';
    }
    
    public void estudiar(String materia){
        System.out.println("Soy " + this.getNombre() + " y estudio " + materia);
    }

    @Override
    public void identificate() {
        System.out.println("Soy un estudiante con ID: " + this.id);
        
    }
}
