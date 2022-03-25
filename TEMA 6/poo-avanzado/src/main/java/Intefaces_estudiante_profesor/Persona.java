/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces_estudiante_profesor;

/**
 *
 * @author jcarlosvico@maralboran.es
 */

// Una clase abstracta que implementa una interfaz puede darle código
// a los métodos abstractos de la interfaz o bien delegar el código a sus
// subclases

public abstract class Persona implements Identificable {

    //Atributos
    private String nombre;
    private String apellidos;
    private String nif;
    private Direccion direccion;

    public Persona(String nombre, String apellidos,String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = new Direccion();
    }

    public Persona(){
        this.nombre="Sin nombre";
        this.apellidos = "Sin apellidos";
        this.nif = "";
        this.direccion = new Direccion();
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + '}';
    }
    
    

}