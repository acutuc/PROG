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
public class Pez extends Mascota{
    
    private String tipoAgua;

    public Pez(String nombre, String nombreDueno, LocalDate fechaNac) {
        super(nombre, nombreDueno, fechaNac);
        tipoAgua = "Dulce";
    }

    public Pez() {
    }

    public String getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    @Override
    public String toString() {
        return "Pez{" + "tipoAgua=" + tipoAgua + '}';
    }

    @Override
    public void comer(String comida, int numeroGramos) {
        System.out.println("Soy un pez y estoy a dieta");
    }
    
    
    
}
