/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author carlos
 */
public interface Natacion {
    
    void nadar();
    
    default void bucear(){
        System.out.println("Código genérico");
    }
    
}
