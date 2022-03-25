package arraylist;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Ej23 {

    /**
     * @param args the command line arguments
     */
    /*
    Se desea manejar dos listas (ArrayList) de Integer. La cantidad de elementos de la lista 1 debe ser un número aleatorio entre 5 y 15.
    La cantidad de elementos de la lista 2 debe ser un número aleatorio entre 10 y 20.
    El rango de los números que serán agregados a la lista DEBE estar entre 50 y 100.
    Se pide construir una aplicación en Java que permita cumplir con la siguiente funcionalidad:
    - Imprimir las listas que han sido generadas. Usa for-each.
    - Crear una tercera lista que contenga los elementos que están en la lista 1 y NO ESTÁN en la lista 2
    - Imprimir la tercera lista. 
    - Crear una cuarta lista que contenga los elementos de la lista 1 que son pares y los elementos de la lista 2 que son impares.
    - Imprimir la cuarta lista. Usa una expresión lambda.
     */
    public static void main(String[] args) {
        Random aleatorio = new Random();

        //Declaración de las dos ArrayList de tipo Integer.
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        //arrayList1 con una longitud al azar entre 5 y 15.
        //Introducimos a arrayList1 números generados entre 50 y 100.
        for (int i = 0; i < aleatorio.nextInt(15 - 5 + 1) + 5; i++) {
            //Almacenamos en un objeto tipo Integer el número generado al azar.
            Integer aux = aleatorio.nextInt(100 - 50 + 1) + 50;
            //Agregamos al arrayList1 con el método .add el número generado y almacenado en aux.
            arrayList1.add(aux);
        }

        //arrayList2 con una longitud al azar entre 10 y 20.
        //Introducimos a arrayList2 números generados entre 50 y 100.
        for (int i = 0; i < aleatorio.nextInt(20 - 10 + 1) + 10; i++) {
            //Almacenamos en un objeto tipo Integer el número generado al azar.
            Integer aux = aleatorio.nextInt(100 - 50 + 1) + 50;
            //Agregamos al arrayList1 con el método .add el número generado y almacenado en aux.
            arrayList2.add(aux);
        }

        //Imprimir las listas que han sido generadas, usando for-each.
        //arrayList1
        System.out.println("arrayList1: ");
        for (Integer tmp : arrayList1) {
            System.out.print(tmp + " - ");
        }

        //arrayList2
        System.out.println("\n\narrayList2: ");
        for (Integer tmp : arrayList2) {
            System.out.print(tmp + " - ");
        }

        //Creamos una tercera lista que contenga los elementos que están en la lista 1 y NO en la 2.
        ArrayList<Integer> elementosNoRepetidos = new ArrayList<>();
        //Recorremos arrayList1 y comparamos sus elementos con cada uno del arrayList2
        for (int i = 0; i < arrayList1.size(); i++) {
            //Variable aux que almacena la posición del arrayList1.
            Integer aux = arrayList1.get(i);
            //Boolean que me ayuda a controlar el bucle de comparación.
            boolean seRepite = false;
            //Mientras estamos en UNA posición del arrayList1, comparamos dicha posición con todas del arrayList2.
            for (int j = 0; j < arrayList2.size(); j++) {
                Integer aux2 = arrayList2.get(j);
                //Condición que encuentra valores repetidos.
                if (aux == aux2) {
                    //Si se repiten,
                    seRepite = true;
                    break;
                }
            }
            if (!(seRepite)) {
                elementosNoRepetidos.add(aux);
            }

        }
        //SEGUNDA OPCIÓN, VISTA EN CLASE
//        ArrayList<Integer> elementosNoRepetidos = new ArrayList<>();
//        for (int i = 0; i < arrayList1.size(); i++) {
//            Integer aux = arrayList1.get(i);
//            arrayList2.contains(arrayList1);
//            if(!arrayList2.contains(aux)){
//                elementosNoRepetidos.add(aux);
//            }
//            
//        }

        //Imprimimos elementosNoRepetidos
        System.out.println("\n\nelementosNoRepetidos: ");
        for (Integer tmp : elementosNoRepetidos) {
            System.out.print(tmp + " - ");
        }

        //Creamos una cuarta lista que contenga los elementos de la lista 1 que son pares y los elementos de la lista 2 que son impares.
        ArrayList<Integer> pares1Impares2 = new ArrayList<>();
        //Bucle para obtener los elementos de la lista 1 que sean pares.
        for (int i = 0; i < arrayList1.size(); i++) {
            Integer aux = arrayList1.get(i);
            if (aux % 2 == 0) {
                pares1Impares2.add(aux);
            }
        }
        //Bucle para obtener los elemnetos de la lista 2 que sean impares.
        for (int i = 0; i < arrayList2.size(); i++) {
            Integer aux = arrayList2.get(i);
            if (aux % 2 != 0) {
                pares1Impares2.add(aux);
            }

        }

        //Imprimimos pares1Impares2 usando una expresión lambda.
        System.out.println("\n\npares1Impares2: ");
        pares1Impares2.forEach(integer -> {
            System.out.print(integer + " - ");
        });

    }

    //Método que rellena un ArrayList con int aleatorios.
    public static void rellenarNumerosAleatorios(int numElementos, ArrayList<Integer> lista) {
        Random aleatorio = new Random();
        for (int i = 0; i < numElementos; i++) {
            Integer aux = aleatorio.nextInt();
            lista.add(aux);
        }
    }

    //Otro método igual que el anterior, pero devuelve un array.
    public static ArrayList<Integer> devuelveListaCreada(int numElementos) {
        Random aleatorio = new Random();
        ArrayList<Integer> arrayGenerada = new ArrayList<>();
        for (int i = 0; i < numElementos; i++) {
            Integer aux = aleatorio.nextInt();
            arrayGenerada.add(aux);
        }
        return arrayGenerada;
    }

}
