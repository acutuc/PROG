
package gabrielAllende;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class parteA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        //Declaro las variables.
        final double HORAS_PROFESOR = 150;
        final double HORAS_POR_MASTER = 975;
        //Realizo la operación de horas por master / horas por profesor.
        double profesores = (HORAS_POR_MASTER / HORAS_PROFESOR);
        
        //Pido cantidad de másters y lo guardo por método Scanner.
        System.out.println("Cantidad de másters: ");
        int cantidadMasters = entradaTeclado.nextInt();
        
        //Realizo la operación correspondiente a nº de másters por cantidad de profesores.
        double cifraFinal = (cantidadMasters * profesores);
        
        //Hago redondeo con casting explícito.
        int redondeo = (int) Math.ceil(cifraFinal);

        //Imprimo en pantalla el resultado final.
        System.out.println("La cantidad de profesores a contratar es de: " + redondeo);
    }
    
}
