package ej8dadoabstracto;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class PruebaAzar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Azar> lista = new ArrayList<>();
        lista.add(new Dado());
        lista.add(new Dado());
        lista.add(new Dado());
        lista.add(new Moneda());
        lista.add(new Moneda());
        lista.add(new Moneda());
        
        for (Azar azar : lista) {
            System.out.println("Lanzar " + azar.lanzar());
        }
    }
    
}
