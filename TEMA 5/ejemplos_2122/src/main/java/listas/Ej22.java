/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author profesor
 */
public class Ej22 {

    public static void main(String[] args) {
        Random r = new Random();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        for (int i = 0; i < 2; i++) {
            Integer aux = r.nextInt(91) + 10;
            list.add(aux);
        }

        for (Integer tmp : list) {
            System.out.print(tmp + " - ");
        }
        
        int sumaPares = 0;
        // Bucle para recorrer la lista completa
        for (int i = 0; i < list.size(); i++) {
            // Método get (posicion) para obtener cada elemento de la lista
            int numero = list.get(i); // unboxing
            if(numero%2 == 0){
                sumaPares+=numero;
            }
        }
        
        int contador = 0;
        
        for (int i = 0; i < list.size(); i++) {
            // Método get (posicion) para obtener cada elemento de la lista
            int numero = list.get(i);
            if(numero%2 != 0){
                contador++;
            }
        }
        
        // Buscar el mayor
        int mayor = Integer.MIN_VALUE;
        for (Integer num : list) {
            if(num>mayor){
                mayor = num;
            }
        }
        
        
        
        System.out.println("\nSuma de pares: " + sumaPares);
        System.out.println("Total de impares: " + contador);
        System.out.println("El mayor es: " + mayor);
        
        System.out.println("Borrado del elemento de la posición 3");
        
        // Borra lo que haya en esa posición
        list.remove(3);
        
        list.forEach(e->System.out.print(e + " - "));
        
        // Cambia el elemento de la posición cero con el nuevo valor
        list.set(0, 200);
        
        System.out.println("");
        
        list.forEach(e->System.out.print(e + " - "));
        
        list.add(2, 500);
        
        System.out.println("");
        
        list.forEach(e->System.out.print(e + " - "));
        
        int indice = list.indexOf(500);
        
        System.out.println("\nEl 500 está en: " + indice);
        
        
    }

}
