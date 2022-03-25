
import java.util.Scanner;


public class AlgoritmosSecuentiales2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //*2.Algoritmo que lea el valor del radio y calcule el área del círculo.
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        //*Imprimo y guardo las variables.
        System.out.println("Radio del círculo: ");
        double radio = entradaTeclado.nextDouble();
        double area = radio * radio * Math.PI;
        System.out.println("El área del círculo es: " + area);
        
    }
    
}
