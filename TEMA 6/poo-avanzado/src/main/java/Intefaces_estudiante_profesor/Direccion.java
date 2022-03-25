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
public class Direccion {
    
    private int cpostal;
    private String calle;
    private String poblacion;

    public Direccion(int cpostal, String calle, String poblacion) {
        this.cpostal = cpostal;
        this.calle = calle;
        this.poblacion = poblacion;
    }
    
    public Direccion(){
        
    }

    public int getCpostal() {
        return cpostal;
    }

    public void setCpostal(int cpostal) {
        this.cpostal = cpostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Direccion{" + "cpostal=" + cpostal + ", calle=" + calle + ", poblacion=" + poblacion + '}';
    }
    
    
    
}
