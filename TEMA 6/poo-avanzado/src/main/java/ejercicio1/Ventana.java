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
public class Ventana {
    
    // A parte de los atributos de ventana
    private Persiana persiana;
    
    public Ventana(Persiana p){
        
        this.persiana = p;
    }
    
    public void metodo(){
        this.persiana.bajar();
    }
}
