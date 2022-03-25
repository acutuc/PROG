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
public class Perro extends Mascota implements Identificable, Comparable<Perro>{
    
    private String chip;
    private String raza;

    public Perro(String chip, String raza, String nombre, String nombreDueno, LocalDate fechaNac) {
        super(nombre, nombreDueno, fechaNac);
        this.chip = chip;
        this.raza = raza;
    }

    public Perro(String chip, String raza) {
        this.chip = chip;
        this.raza = raza;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro{" + "chip=" + chip + ", raza=" + raza + '}';
    }
    
    public void comer(String comida, int numeroGramos){
        System.out.println("Soy un perro y estoy comiendo " + numeroGramos + " gramos de " + comida);
    }

    @Override
    public void identificate() {
         System.out.println("Soy un perro con chip: " + this.chip);
    }

    @Override
    public int compareTo(Perro t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
