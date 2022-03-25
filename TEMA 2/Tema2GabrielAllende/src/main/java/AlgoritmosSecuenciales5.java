
import java.util.Scanner;


public class AlgoritmosSecuenciales5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //HAY QUE DECLARAR LAS CONSTANTES.  
       
        /*Una empresa de autocares cobra 150 euros fijos por servicio y además
        15.3 céntimos por Km recorrido. Elabora un programa que lea el número
        de km a recorrer y proporcione el presupuesto.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        System.out.println("Km recorridos: ");
        double km = entradaTeclado.nextDouble();
        double total = km * 0.153 + 150;
        System.out.println("El precio a pagar son: " + total + "€");
    }
    
}
