/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculoAbstractFinal;

import jerarquiaVehiculos.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author carlos
 */
public class Prueba {

    public static void main(String[] args) {

        ArrayList<Vehiculo> lista = crearCatalogoVehiculos();

        ComparadorBastidor compBast = new ComparadorBastidor();
        // compBast es de tipo ComparadorBastidor? Si
        // compBast es de tipo Comparator? Si

        if (compBast instanceof ComparadorBastidor) {
            System.out.println("Es de tipo ComparadorBastidor");
        }

        if (compBast instanceof Comparator) {
            System.out.println("Es de tipo Comparator");
        }

        // Sort ordena según el criterio que se pasa en el objeto Comparator
        Collections.sort(lista, compBast);
        lista.forEach(System.out::println);

        System.out.println("------------POR COLOR-------------------");

        Collections.sort(lista, new ComparadorColor());
        lista.forEach(System.out::println);

        System.out.println("------------POR MATRICULA-------------------");

        Collections.sort(lista, new ComparadorMatricula());
        lista.forEach(System.out::println);

        System.out.println("------------POR MARCA-------------------");

        Collections.sort(lista, new Comparator<Vehiculo>() {
            @Override
            public int compare(vehiculoAbstractFinal.Vehiculo t, vehiculoAbstractFinal.Vehiculo t1) {
                return t.getMarca().compareTo(t1.getMarca());
            }

        });
        lista.forEach(System.out::println);

        // Expresión lambda
        System.out.println("------------POR MODELO-------------------");
        Collections.sort(lista, (Vehiculo t, Vehiculo t1) -> t.getModelo().compareTo(t1.getModelo()));
        lista.forEach(System.out::println);
        
        // Expresión lambda con inferencia de tipos
        Comparator<Vehiculo> compModelo = (x, x1) -> x.getModelo().compareTo(x1.getModelo());
        Collections.sort(lista, compModelo);
        // Siempre que se busque por un criterio X la lista debe estar
        // ordenada según ese criterio X
        Vehiculo aux = new Turismo();
        aux.setModelo("Partner");
        System.out.println("Posicion: " + Collections.binarySearch(lista, aux, compModelo));

        
//        for (Vehiculo v : lista) {
//            // Llamada método polimórfico toString()
//            System.out.println(v);
//            System.out.println("");
//            v.metodoVehiculo();
//            System.out.println("");
//            
//            // Conversiones explícitas
//            if (v instanceof Deportivo){
//                ((Deportivo) v).metodoDeportivo();
//            } else if(v instanceof Furgoneta){
//                ((Furgoneta) v).metodoFurgoneta();
//            } else if (v instanceof Turismo){
//                ((Turismo) v).metodoTurismo();
//            }
//            System.out.println("--------------------------------");
//        }
    }

    public static ArrayList<Vehiculo> crearCatalogoVehiculos() {

        ArrayList<Vehiculo> lista = new ArrayList<>();

//        lista.add(new Vehiculo());
//        lista.add(new Vehiculo(2345334543L, "0944 TTF", "Seat", "León", "Rojo", 12.3, true));
        // Conversiones implícitas
        lista.add(new Turismo());
        lista.add(new Turismo(3, 6645334543L, "0933 TTF", "Seat", "León", "Azul", 2.3, true));
        lista.add(new Turismo(5, 1345334543L, "0955 TTF", "Peugeot", "308", "Verde", 2.3, true));
        lista.add(new Deportivo());
        lista.add(new Deportivo(3, 5545334543L, "2355 DRG", "Ford", "Mustang", "Negro", 1.3, true));
        lista.add(new Furgoneta());
        lista.add(new Furgoneta(1200, 12, 4444434543L, "1111 TTF", "Peugeot", "Partner", "Rojo", 14.8, true));

        return lista;
    }

}
