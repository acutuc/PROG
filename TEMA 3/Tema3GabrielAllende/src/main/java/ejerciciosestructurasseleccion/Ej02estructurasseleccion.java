package ejerciciosestructurasseleccion;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej02estructurasseleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*2.- Utilizando el operador ternario ?: de Java, implementa las siguientes
        sentencias:
        a) Si el número “x” es mayor o igual que 135 se devolverá “mayor”, si es menor
        se devolverá “menor”. Las cadenas que se devuelven se guardarán en una
        variable llamada resultado.
        b) Si el número “x” es menor o igual que cero se imprimirá en pantalla “Menor
        que cero”, si no se imprimirá “Mayor que cero”.
        c) Guardar el valor absoluto de un número entero en una variable entera (sin
        usar la función Math.abs())*/
        
        //a)
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introducir número:");
        int numero = entrada.nextInt();
        
        String resultado = (numero >= 135) ? "mayor" : "menor";
        System.out.println(resultado);
        
        //b)
        String resultado2 = (numero <= 0) ? "menor que cero" : "Mayor que cero";
        System.out.println(resultado2);
        
        //c)
        int valorAbsoluto = entrada.nextInt();
        int valorAbsoluto2 = (valorAbsoluto < 0) ? (valorAbsoluto * (-1)) : valorAbsoluto;
        System.out.println("Valor absoluto: " + valorAbsoluto2);
    }
    
}
