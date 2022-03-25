
import java.util.Scanner;


public class AlgoritmosSecuenciales7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*7.Un productor de leche lleva el registro de lo que produce en litros,
        pero cuando entrega la leche en la distribuidora le pagan según los
        galones entregados (1 galón son 3,78 litros). Escribe un programa que
        ayude al productor a saber cuánto recibirá por la entrega de su
        producción de un día, sabiendo que el precio del galón es 1.20€.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        //Declaro variables y constantes.
        final double LITROS_GALONES = 3.78;
        final double PRECIO_GALON = 1.20;
        
        /*Imprimo en pantalla la cantidad de litros a entregar y convierto a 
        galones*/
        System.out.println("Cantidad de litros a entregar: ");
        double litros = entradaTeclado.nextDouble();
        double conversion = litros / LITROS_GALONES;
        System.out.println("Los litros introducidos son: " + conversion + "gal");
        
        //Convierto los galones en euros.
        double precioFinal = conversion * PRECIO_GALON;
        System.out.println("La cantidad a pagar son: " + precioFinal + "€");
        
      
        
    }
    
}
