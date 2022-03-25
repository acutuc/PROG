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
public interface Identificable {
    
    // Todos los atributos serían public,static,final
    int CONSTANTE = 4;
    
    // Todos los métodos son abstract y public
    void identificate();
    
    default void metodo(){
        System.out.println("Método default");
    }
    
}
