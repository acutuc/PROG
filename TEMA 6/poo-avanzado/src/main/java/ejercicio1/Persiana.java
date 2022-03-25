/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author carlos
 */
public class Persiana {
    
    private boolean estado;

    public Persiana(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persiana{" + "estado=" + estado + '}';
    }
    
    public void subir(){
        this.estado = true;
    }
    
    public void bajar(){
        this.estado = false;
    }
    
}
