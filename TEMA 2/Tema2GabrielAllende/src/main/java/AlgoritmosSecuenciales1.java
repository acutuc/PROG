
import java.util.Scanner;


public class AlgoritmosSecuenciales1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*1.Algoritmo que lea una cantidad de euros y los pase a rupias
        indias.*/
        
        /*Partiendo de que 1€ equivale a 86,79 rupias indias, declaro e 
        inicializo variables tipo double.*/        
        double euros = 1;
        double rupiasIndias = 86.79;
        
        /*Inicializo la instancia de Scanner con el flujo de entrada del
        teclado*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        System.out.println("Cantidad de euros: ");
        euros = entradaTeclado.nextDouble();
        System.out.println("Son " + euros * rupiasIndias + " rupias indias");
        
        
        
    }
    
}
