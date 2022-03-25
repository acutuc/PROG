/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import hospital.*;
import java.time.LocalDate;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Persona {

    //Atributos
    private String nombre;
    private String apellidos;
    private String nif;

    public void renovarNif(LocalDate fechaSolicitud){
        // Al renovar el DNI dan 10 años de validez
        // Añadir 10 años a la fechaSolicitud modificando la fechaCaducidad
        // del dni de la persona
    }
    
    public Persona(String nombre, String apellidos, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    public Persona(){
        this.nombre="Sin nombre";
        this.apellidos = "Sin apellidos";
        
    }
    
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

    

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + '}';
    }
   
    

}