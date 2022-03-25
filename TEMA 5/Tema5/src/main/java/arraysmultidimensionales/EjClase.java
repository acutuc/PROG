package arraysmultidimensionales;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class EjClase {
    /*
    Dada una matriz [i][j], construir los siguientes métodos que impriman:
    - recorrerFila(int x, matriz)
    - recorrerColumna(int x, matriz)
    - recorrerVecinas(int i, int j, matriz)
     */
    public static void main(String[] args) {
        //Inicialización de la matriz.
        char[][] matriz = {{'a', 'b', 'c', 'd'},
        {'e', 'f', 'g', 'h'},
        {'i', 'j', 'k', 'l'},
        {'m', 'n', 'o', 'p'},
        {'q', 'r', 's', 't'}};

        //Imprimo la matriz.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " - ");
            }
            System.out.println("");
        }

        System.out.println("\nElementos de la fila: ");
        recorrerFila(1, matriz);
        System.out.println("\nElementos de la columna: ");
        recorrerColumna(3, matriz);
        System.out.println("Elementos vecinos: ");
        recorrerVecinas(0, 0, matriz);
    }

    //Método que recorra e imprima una fila de la matriz.
    public static void recorrerFila(int fila, char[][] matriz) {
        try {
            for (int i = 0; i < matriz[i].length; i++) {
                if (fila == i) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print(matriz[i][j] + " - ");
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException AIOOBE) {
            System.out.println("Fila inexistente. Cambiar valor.");
        }
    }

    //Método que recorra e imprima una columna de la matriz.
    public static void recorrerColumna(int columna, char[][] matriz) {
        try {
            for (int i = 0; i < matriz[i].length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (j == columna) {
                        System.out.println(matriz[i][j]);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException AIOOBE) {
            System.out.println("Columna inexistente. Cambiar valor.");
        }
    }

    //Método que recorra e imprima todas las casillas vecinas dado un elemento de la matriz.
    public static void recorrerVecinas(int fila, int columna, char[][] matriz) {
        if(fila < matriz.length && fila >= 0){
            if(columna < matriz[0].length && columna >= 0){
                for (int i = fila - 1; i <= fila + 1; i++) {
                    if(i < matriz.length && i >= 0){
                        for (int j = columna - 1; j <= columna + 1; j++){
                            if(j < matriz[i].length && j >=0){
                                System.out.println("La vecina es: " + matriz[i][j]);
                            }
                            
                        }
                    }
                    
                }
            }
        }
     
    }
}

