
import java.util.Scanner;


public class AlgoritmosSecuenciales6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Leer dos números por teclado, a y b. Imprimir por pantalla el
        resultado de las siguientes operaciones:
        a/b.
        a mod b.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        //Declaro las variables a y b con la entrada de teclado
        System.out.println("Valor de a: ");
        double a = entradaTeclado.nextDouble();
        System.out.println("Valor de b: ");
        double b = entradaTeclado.nextDouble();
        
        //Imprimimos por pantalla las operaciones.
        System.out.println("a/b = " + a / b + "\na mod b = " + a % b);
        
        
        
        
        
        
    }
    
}
