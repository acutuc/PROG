package ejerciciosbucle;

/**
 *
 * @author acutuc
 */
public class Ej03bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*3.- Realizar un programa que imprima 25 términos de la serie
        15 - 30 - 60 - 120, etc. No se introducen valores por teclado.*/
        final int VALOR_INICIAL = 15;
        final int FACTOR_MULTIPLICATIVO = 2;
        final int TOTAL_TERMINOS = 25;
        
        int aux = VALOR_INICIAL;
        
        for (int i = 0; i < TOTAL_TERMINOS; i++) {
            
            System.out.print("Iteración número " + (i+1));
            System.out.println(" Término: " + aux);
            aux*=FACTOR_MULTIPLICATIVO;
        }
        
    }
            
    
}
