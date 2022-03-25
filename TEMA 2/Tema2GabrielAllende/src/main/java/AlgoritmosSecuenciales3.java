
import java.util.Scanner;


public class AlgoritmosSecuenciales3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*3.Algoritmo que lea tres notas numéricas de tipo double y calcule la
        nota media.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        //Declaro e inicializo las variables double con la entrada de teclado.
        System.out.println("Nota 1: ");
        double nota1 = entradaTeclado.nextDouble();
        System.out.println("Nota 2: ");
        double nota2 = entradaTeclado.nextDouble();
        System.out.println("Nota 3: ");
        double nota3 = entradaTeclado.nextDouble();
        
        //Declaro e inicializo la nota media.
        double notamedia = (nota1 + nota2 + nota3) / 3;
        
        System.out.println("La nota media es: " + notamedia);
        
        
        
        
        
    }
    
}
