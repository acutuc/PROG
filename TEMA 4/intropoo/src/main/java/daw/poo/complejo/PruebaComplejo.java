
package daw.poo.complejo;

/**
 *
 * @author Gabriel
 */
public class PruebaComplejo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Prueba de constructor por defecto
        Complejo c1 = new Complejo();
        System.out.println(c1);
        
        //Prueba de constructor parametrizado
        Complejo c2 = new Complejo(7.1, 8.4);
        System.out.println(c2);
        
        //Prueba de suma de complejos
        Complejo c3;
        c3 = c1.suma(c2);
        System.out.println(c3);
        
        //Prueba de resta de complejos
        Complejo c4;
        c4 = c1.resta(c2);
        System.out.println(c4);
        
        //Prueba de multiplicación de complejos
        Complejo c5;
        c5 = c1.multiplica(c2);
        System.out.println(c5);
        
        //Prueba de división de complejos
        Complejo c6;
        c6 = c1.divide(c2);
        System.out.println(c6);
    }
    
}
