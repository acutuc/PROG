
import java.util.Scanner;


public class AlgoritmosSecuenciales8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Programa que pida el precio de un artículo y calcule su valor
        aplicando un 16% de IVA. Realiza un programa para calcular el valor de
        cualquier artículo aplicando cualquier IVA.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner y declaro la variable constante del IVA.*/
        Scanner entradaTeclado = new Scanner(System.in);
        final double IVA = 1.16;
        
        //Ingreso mediante la entrada de teclado el precio de un producto sin IVA.
        System.out.println("Precio del producto sin IVA: " + "€");
        double precioSinIva = entradaTeclado.nextDouble();
        
        //Aplico el IVA al producto e imprimo en pantalla.
        double precioConIva = precioSinIva * IVA;
        System.out.println("Precio del producto con IVA: " + precioConIva + "€");
        
    }
    
}
