
import java.util.Scanner;


public class AlgoritmosSecuenciales9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*9.Una empresa de juguetes se dedica a realizar cometas como las que
        figuran en la imagen de la derecha. Necesitan saber el área de tela a
        emplear según las medidas de las diagonales que hay entre los puntos
        A y C, y entre B y D.*/
        
        /*Para leer por teclado estándar usamos
        la clase Scanner.*/
        Scanner entradaTeclado = new Scanner(System.in);
        
        /*Introducimos medidas de las diagonales AC y BD y guardamos las
        variables constantes tipo double.*/
        System.out.println("Introduzca medida de la diagonal AC: ");
        double diagonalAc = entradaTeclado.nextDouble();
        System.out.println("Introduzca medida de la diagonal BD: ");
        double diagonalBd = entradaTeclado.nextDouble();
        
        //Almacenamos la fórmula del área en una constante.
        double areaCometa = (diagonalAc * diagonalBd) / 2;
        
        System.out.println("El área de tela de la cometa son: " + areaCometa 
        + "cm²");
        
        
    }
    
}
