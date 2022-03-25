package recursividad;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Palindromo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca una palabra para comprobar si es palíndroma.");

        String palabra = entrada.nextLine();

        System.out.println("¿Es la palabra \"" + palabra + "\" palíndroma? --> " + comprobarPalindromo(palabra));

    }

    //Método de iterativo.
    public static boolean comprobarPalindromo(String comprobarPalabra) {
        //Creo un array en la que almacenar el String que paso por parámetro, en chars.
        char[] palabraChar = comprobarPalabra.toCharArray();
        //Creo un array auxiliar en el que iré guardando del revés, los chars obtenidos del primer array.
        char[] aux = new char[palabraChar.length];

        //Bucle que recorrerá todas las posiciones del array de la palabra introducida.
        for (int i = 0; i < palabraChar.length; i++) {
            /*Almaceno en la posición del char auxiliar, el char del length menos uno del char original,
            menos el valor de la variable de control i (así accedo a la última posición y voy bajando).*/
            aux[i] = palabraChar[palabraChar.length - 1 - i];
        }
        //Compruebo mediante el método equals de la clase Arrays, la similitud de mis dos arrays resultantes.
        if (Arrays.equals(palabraChar, aux)) {
            return true;
        } else {
            return false;
        }
    }

    //Método recursivo
    public static boolean palindromoRecursivo(String palabra, int i, int j) {
        if (i == j) {
            return true;
        } else if (i > j) {
            return palabra.charAt(i) == palabra.charAt(j);
        } else {
            return palabra.charAt(i) == palabra.charAt(j) && palindromoRecursivo(palabra, i++, j--);
        }
    }

}
