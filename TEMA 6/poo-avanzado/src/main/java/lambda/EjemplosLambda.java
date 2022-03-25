/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author carlos
 */
public class EjemplosLambda {
    
    public static void main(String[] args) {
        
        // Function y BiFunction
        Function<Integer,String> funcion = x->"Tu número es " + x;
        System.out.println(funcion.apply(56));
        
        BiFunction <Integer, Integer, Integer> biFuncion = (x,y) -> (x*y)+10;
        System.out.println(biFuncion.apply(10, 20));
        
         BiFunction <Integer, Double, String> biFuncion2 = 
                 (x,y) -> x + " * " + y + " es igual a "+ (x*y);
         
        System.out.println(biFuncion2.apply(2, 3.5));
        
        // Consumer y BiConsumer
        Integer[] array = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(array);
        
        Consumer<List<Integer>> listaInt = lista-> {
            for (int i = 0; i < lista.size(); i++) {
                lista.set(i, 2*lista.get(i));
                
            }
        };
        
        listaInt.accept(list);
        System.out.println(list);
        
        Consumer <String> imprimir = nombre -> System.out.println("Mi nombre es" + nombre);
        imprimir.accept("Juan CArlos");
        
        Persona sinNombre = new Persona("", "Pérez", "22222F");
         System.out.println(sinNombre);
        BiConsumer<String, Persona> biConsumer = (nombre, persona) -> persona.setNombre(nombre);
        
        biConsumer.accept("Carlos", sinNombre);
        
        System.out.println(sinNombre);
        
        // Predicate
        
        Predicate<Integer> mayorQueCinco = x->x>5;
        System.out.println("Mayor que cinco " + mayorQueCinco.test(2));
        
        BiPredicate<Persona, String> nombrePersona = (p, nombre)->p.getNombre().equals(nombre);
        System.out.println(nombrePersona.test(sinNombre, "Carlos"));
        
        // Supplier. No tienen parámetros
        Supplier<String> saludo = ()->"Ya mismo nos vamos";
        System.out.println(saludo.get());
        
        Supplier<Persona> crearPersona = ()->new Persona();
        System.out.println(crearPersona.get());
        
        Supplier<Integer> entero = ()->enteroAlea();
        System.out.println(entero.get());
        
    }
    
    public static Integer enteroAlea(){
        Random x = new Random();
        return x.nextInt();
    }
    
}
