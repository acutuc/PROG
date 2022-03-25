/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Casa {

    // Atributos propios de la casa
    private Puerta puerta;
    private ArrayList<Ventana> ventanas;
    private ArrayList<Calefactor> calefactores;

    public Casa(Puerta p, Ventana v) {
        puerta = p;
        ventanas = new ArrayList<>();
        ventanas.add(v);
        calefactores = new ArrayList<>();
    }
    
    public Casa(Puerta p, Ventana v, ArrayList<Calefactor> lista ) {
        puerta = p;
        ventanas = new ArrayList<>();
        ventanas.add(v);
        calefactores = lista;

    }
    
    public void ponerCalefactor(Calefactor c){
        calefactores.add(c);
    }
    

}
