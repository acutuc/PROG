package arraysmultidimensionales;

import java.util.Random;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Ej14 {

    /*
    Escribe un programa que dada una matriz de 3x3 enteros y realice las siguientes funciones:

    Rellenar aleatoriamente todas las casillas de la matriz con números enteros entre 1 y 100
    Calcular la media de todos los valores
    Calcular el valor mínimo y el máximo de todos los valores
     */
    public static void main(String[] args) {
        //Declaro matriz 3x3 de enteros.
        int[][] matrizEnteros = new int[3][3];
        Random aleatorio = new Random();

        //Relleno la matriz con números aleatorios entre 1 y 100.
        for (int i = 0; i < matrizEnteros.length; i++) {
            for (int j = 0; j < matrizEnteros[i].length; j++) {
                matrizEnteros[i][j] = aleatorio.nextInt(100) + 1;

            }

        }

        //Calculo la media de todos los valores, con una variable que vaya almacenando dicha información y otra que sume la cantidad de elementos.
        int media = 0;
        int cantidadElementos = 0;
        //Declaro las variables que almacenarán el valor máximo y mínimo.
        /*El mínimo estará inicializado a cualquier posición de la matriz, para que obtenga algún entero, 
        pues si lo inicializo a 0 no se actualizará nunca (0 sería siempre el valor mínimo).*/ 
        int minimo =  matrizEnteros[0][0];
        int maximo = 0;
        for (int i = 0; i < matrizEnteros.length; i++) {

            for (int j = 0; j < matrizEnteros[i].length; j++) {
                //Sumo 1 por cada iteración a la variable.
                cantidadElementos++;
                //Voy almacenando la suma de cada posición de la matriz en la variable.
                media += matrizEnteros[i][j];
                //Condiciones para actualizar los valores mínimo y máximo.
                if (minimo > matrizEnteros[i][j]) {
                    minimo = matrizEnteros[i][j];
                }
                if (maximo <= matrizEnteros[i][j]) {
                    maximo = matrizEnteros[i][j];
                }
            }
        }
        //Actualizo la variable media, dando su resultado final.
        media = media / cantidadElementos;

        //Imprimo la matriz.
        for (int i = 0; i < matrizEnteros.length; i++) {
            for (int j = 0; j < matrizEnteros.length; j++) {
                System.out.print(matrizEnteros[i][j] + "\t");

            }
            System.out.println("");
        }

        //Imprimo la cantidad de elementos de la matriz.
        System.out.println("\nHay " + cantidadElementos + " elementos.");

        //Imprimo la media.
        System.out.println("\nLa media es: " + media);

        //Imprimo el valor mínimo.
        System.out.println("\nEl valor mínimo es: " + minimo);
        
        //Imprimo el valor máximo.
        System.out.println("\nEl valor máximo es: " + maximo);

    }

}
