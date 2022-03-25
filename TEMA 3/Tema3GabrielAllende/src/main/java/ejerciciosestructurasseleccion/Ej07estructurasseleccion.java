
package ejerciciosestructurasseleccion;

import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Ej07estructurasseleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //6.- Reescribe el programa anterior utilizando estructuras if-else if.

        Scanner entrada = new Scanner(System.in);

        int opcion;

        System.out.println("Menú de opciones");
        System.out.println("-------------------");
        System.out.println("1. Calcular el área de un cuadrado.");
        System.out.println("2. Calcular el área de un triángulo");
        System.out.println("3. Calcular el área de un círculo");
        System.out.println("4. Finalizar");
        System.out.println("Elija una opción");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ha seleccionado calcular el área de un cuadrado");
                System.out.println("Indique la medida del lado");
                int ladoCuadrado = entrada.nextInt();
                int areaCuadrado = (int)Math.pow(ladoCuadrado, 2);
                System.out.println("El área del cuadrado es de " + areaCuadrado + "cm²");
                break;
            case 2:
                System.out.println("Ha seleccionado calcular el área de un triángulo");
                System.out.println("Indique la medida de la base");
                int baseTriangulo = entrada.nextInt();
                System.out.println("Indique la medida de la altura");
                int alturaTriangulo = entrada.nextInt();
                double resultadoTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                System.out.println("El área del triángulo es de " + resultadoTriangulo + "cm²");
                break;
            case 3:
                System.out.println("Ha seleccionado calcular el área de un círculo");
                System.out.println("Indique el radio del círculo");
                int radioCirculo = entrada.nextInt();
                double resultadoCirculo = (2 * Math.PI * radioCirculo);
                System.out.println("El área del circulo es de " + radioCirculo + "cm²");
                break;
            case 4:
                System.out.println("Ha seleccionado finalizar el programa");
        }
    }

}
