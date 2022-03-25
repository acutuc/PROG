
import java.util.Scanner;


public class AlgoritmosSecuenciales10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*10. Realiza un programa que calcule el espacio recorrido, en metros, por
        un cuerpo que se deplaza a 200 km/h si está en movimiento 20 minutos.
        Realiza otro programa para calcular el espacio recorrido del cuerpo en
        función de su velocidad y tiempo de movimiento.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        //Declaro e inicializo las constantes, pasando Km a m y min a seg.
        final double KM_TOTALES = 200;
        final double CANTIDAD_TOTAL_EN_SEGUNDOS = 1200;
        final double KM_M = 1000;
        final double MIN_SEG = 3600;
        final double M_SEG = KM_M / MIN_SEG;
        
        //Imprimo en pantalla
        System.out.println("Cantidad de metros recorridos yendo a 200Km/h"
        + " durante 20min: " + (M_SEG * KM_TOTALES) * CANTIDAD_TOTAL_EN_SEGUNDOS
        + "m"); 
        
        /*Realiza otro programa para calcular el espacio recorrido del cuerpo en
        función de su velocidad y tiempo de movimiento.*/
        System.out.println("Velocidad del cuerpo en Km/h: ");
        double VELOCIDAD = entradaTeclado.nextDouble();
        System.out.println("Tiempo del recorrido en min: ");
        double TIEMPO = entradaTeclado.nextDouble();
        double tiempoEnSegundos = TIEMPO * 60;
        System.out.println("Espacio recorrido por el cuerpo en metros: " + 
        (M_SEG * VELOCIDAD) * tiempoEnSegundos + "m");
    }
    
}
