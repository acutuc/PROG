/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces_estudiante_profesor;

import java.time.LocalDate;

/**
 *
 * @author carlos
 */
public abstract class Mascota  {
    
    private String nombre;
    private String nombreDueno;
    private LocalDate fechaNac;

    public Mascota(String nombre, String nombreDueno, LocalDate fechaNac) {
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.fechaNac = fechaNac;
    }
    
    public Mascota(){
        
    }
    
    public abstract void comer(String comida, int numeroGramos);
    
    public void dormir(){
        System.out.println("Soy la mascota " + this.nombre + " y estoy durmiendo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", nombreDueno=" + nombreDueno + ", fechaNac=" + fechaNac + '}';
    }
   
    
}
