
package trabajadores;

import java.util.ArrayList;

/**
 *
 * @author nao
 */

public class Prueba {

    public static void main(String[] args) {
        
        Programador programador = new Programador(Categoria.ANALISTA, 2500.96, "Matías", "89632541L", 39);
        Empleado empleado = new Empleado(1500.21, "Carla", "76321458P", 27);
        Persona persona = new Persona("Miguel", "79856423K", 31);    
        Camarero camarero = new Camarero("Jefe de Sala");
        
        
        
        ArrayList<Empleado> lista = new ArrayList<>();
        // Conversión implícita. Supone guardar un objeto hijo en una referencia
        // padre. Guardar un objeto de una subclase en una referencia de la
        // superclase.
        Persona p1 = new Camarero("Soldao raso");
        Empleado e = new Camarero("Soldao raso");
        //Camarero c = (Camarero) new Persona(); // Conversión explícita
        lista.add(programador);
        lista.add(empleado);
        lista.add(camarero);
        // Cuando se guarda un objeto en una referencia de la superclase,
        // esa referencia sólo tiene acceso a los métodos de su propia clase 
        // Si estoy guardando objetos de clases hijas en la referencia de
        // Persona, esa referencia sólo tiene acceso a los métodos de persona
        // Sí hay acceso a los métodos sobrescritos en las clases hijas
        e.cotizar(); // Se ejecuta el del camarero
        e = new Programador();
        
        e.cotizar(); // Se ejecuta el de empleado
        
        // Recorro la lista de persona
        for (Empleado persona1 : lista) {
            persona1.cotizar();
            // Si persona1 es un programador, entonces que programe
           
            // Esto me sirve para acceder a los métodos propios de cada clase
            // No sobrescritos
            if(persona1 instanceof Programador){
                // Conversión explícita
                System.out.println("Programando.....");
                Programador p = (Programador) persona1;
                p.programar("Javascript");
                
            }
            if (persona1 instanceof Camarero){
                // Conversión explícita
                System.out.println("Sirviendo una mesa.....");
                Camarero c = (Camarero) persona1;
                c.servirMesa("Sopa");
            }
        }
                
        
        //Comprueba como un objeto de una clase hija puede llamar a métodos de 
        //la clase padre, pero no al contrario
        System.out.println(programador.toString());

        //Accedemos al método aumentarSalario desde la misma clase que lo contiene (Empleado)
        empleado.aumentarSalario(230);
        programador.setEdad(25);
        programador.aumentarSalario(23);
        
        //Acceso a los métodos de la misma clase Persona
        persona.setEdad(24);
        System.out.println(persona.toString());

        //Desde la clase hija programador podemos acceder a métodos de las clases
        //padres, Empleado y Persona, pero no podría hacerse al contrario
        programador.aumentarSalario(160); //Aumentamos el salario
        programador.setEdad(37); //Cambiamos la edad
        System.out.println(programador.toString());

        //Igual con la clase Empleado con respecto a la clase padre Persona
        System.out.println(empleado.getNombre()); //Imprimo el nombre
        empleado.setNif("85632589G"); //Cambio el nif
        System.out.println(empleado.toString());
        
        persona.comer();
        empleado.comer();
        programador.comer();
        programador.comer("hola");
    }
}
