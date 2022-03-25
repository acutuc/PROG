/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces_estudiante_profesor;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Prueba {
    
    public static void main(String[] args) {
        
        ArrayList<Identificable> lista = new ArrayList<>();
        
        lista.add(new Estudiante("22"));
        lista.add(new Profesor("Matemáticas"));
        lista.add(new Perro("33443", "Pastor Alemán"));
        
        for (Identificable objeto : lista) {
            objeto.identificate();
            
            if (objeto instanceof Profesor){
                ((Profesor) objeto).investigar("Sociales");
            }
        }
        
    }
    
}
