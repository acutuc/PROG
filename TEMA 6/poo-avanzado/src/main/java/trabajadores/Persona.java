/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajadores;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Persona {

    //Atributos
    private String nombre;
    private String nif;
    private int edad;

   
    public Persona() {
        this.nombre = "María Jesús";
        this.nif = "77469321D";
        this.edad = 29;
    }

   
    public Persona(String nombre, String nif, int edad) {
        this.nombre = nombre;
        this.nif = nif;
        this.edad = edad;
    }

   
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

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", nif=" + nif + ", edad=" + edad + '}';
    }
    
    public void comer(){
        System.out.println("Soy una persona y estoy comiendo");
    }
}
