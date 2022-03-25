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
public class Puerta {
    
    private boolean estado;

    public Puerta(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void abrir(){
        this.estado = true;
        
    }
    
    public void cerrar(){
        this.estado = false;
    }
}
