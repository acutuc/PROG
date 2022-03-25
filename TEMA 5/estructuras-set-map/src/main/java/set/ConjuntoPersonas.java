package set;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class ConjuntoPersonas {
    
    public static void main(String[] args) {
	
        // Una HashSet no permite duplicados
        // Es necesario que Persona tenga los métodos equals y hashcode implementados
        Set<Persona> juntaDirectiva = new HashSet<>();

        juntaDirectiva.add(new Persona("12345678A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
        juntaDirectiva.add(new Persona("23456789B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
        juntaDirectiva.add(new Persona("34567890C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
        juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        //Si tratamos de añadir un elemento repetido...
        //El set queda como estaba y el método devuelve false
        juntaDirectiva.add(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));

        //Comprobamos que al listarlos todos, no aparece duplicado
        //No hay orden aparante, ni siquiera el orden de inserción
        for (Persona p : juntaDirectiva) {
            System.out.println(p);
        }
        
        juntaDirectiva.add(new Persona("33678551D", "Lucas", "Vázquez", LocalDate.of(1988, Month.DECEMBER, 5)));
        
        System.out.printf("Ahora el set contiene %d elementos", juntaDirectiva.size());
        System.out.println("------------------");
        
        juntaDirectiva.forEach(System.out::println);
        
        juntaDirectiva.remove(new Persona("45678901D", "María", "López", LocalDate.of(1993, 4, 5)));
        
        System.out.println("----- Después del borrado de María López ------------");
        juntaDirectiva.forEach(System.out::println);

    }
}
