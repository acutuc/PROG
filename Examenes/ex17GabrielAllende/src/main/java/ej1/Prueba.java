package ej1;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    private static Baraja baraja;

    public static void main(String[] args) {
        //Instancio un nuevo objeto de tipo Baraja
        baraja = new Baraja();

        //Relleno la baraja con el método.
        baraja.rellenarBaraja();
        
        //Imprimo la baraja
        System.out.println(baraja.toString());
    }
}
