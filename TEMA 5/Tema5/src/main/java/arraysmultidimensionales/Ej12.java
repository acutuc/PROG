package arraysmultidimensionales;

/**
 *
 * @author acutuc
 */
/*12. Declara e inicializa una matriz de caracteres de 2x3, con los valores que tú quieras.
Implementa un método, en la misma clase que el método main(), que reciba una matriz de caracteres y la imprima por consola.*/
//Definición de la clase.
public class Ej12 {

    public static void main(String[] args) {
        //Matriz de caracteres 2x3.
        char[][] matriz = {{'7', '8', '9'}, {'a', 'b', 'c'}};

        imprimirMatriz(matriz);
    }

    //Método que recibe por parámetro una matriz de char y la imprime.
    public static void imprimirMatriz(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");

            }
            System.out.println("");
        }
    }
}
