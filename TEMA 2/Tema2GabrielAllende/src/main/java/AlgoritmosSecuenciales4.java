
import java.util.Scanner;


public class AlgoritmosSecuenciales4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*4.Realiza un programa que lea una cantidad de gramos y obtenga su
        equivalencia en libras.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        //Declaro e inicializo las variables double de gramos y libras
        double gramos = 1;
        double libras = 0.0022;
        
        System.out.println("Cantidad de gramos: ");
        gramos = entradaTeclado.nextDouble();
        System.out.println("Son " + gramos * libras + " libras");

    }
    
}
