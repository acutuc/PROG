package ej3personas;

/**
 *
 * @author Gabriel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    /*Realiza una clase Prueba, para probar las clases anteriores.
    Usa los constructores para crear un par de objetos de cada clase y comprueba como un objeto de una clase hija puede llamar a métodos de la clase padre,
    pero no al contrario. Ejecuta los métodos toString() de cada uno de los objetos y comprueba el resultado.*/
    public static void main(String[] args) {
        //Creo dos objetos de cada tipo (Persona, Empleado, Programador).
        Persona p1 = new Persona("Persona1", "64654626N", 35);
        Persona p2 = new Persona("Persona2", "127348073B", 51);
        
        Empleado e1 = new Empleado(1500, "Empleado1", "78375235J", 25);
        Empleado e2 = new Empleado(2500, "Empleado2", "18478123J", 50);
        
        Programador pro1 = new Programador(Categoria.JUNIOR, 1600, "Programador1", "17485358J", 40);
        Programador pro2 = new Programador(Categoria.ANALISTA, 3000, "Programador2", "92147123S", 46);
        
        
        //Los objetos creados de Persona, solamente tienen acceso al método toString().
        System.out.println("Información de Persona1:");
        
        System.out.println(p1.toString());
        
        System.out.println("--------------------------");
        
        System.out.println("Información de Persona2:");
       
        System.out.println(p2.toString());
        
        System.out.println("--------------------------");
        
        //Los objetos creados de Empleado, tienen acceso al toString() de clase, concatenando los atributos de la superclase (Persona).
        System.out.println("Información de Empleado1:");
        
        System.out.println(e1.toString());
        e1.aumentarSalario(1500);
        
        System.out.println("Le aumentamos el salario a Empleado1 en 1500 \n Información de Empleado1:");
        System.out.println(e1.toString());
        
        System.out.println("--------------------------");
        
        System.out.println("Información de Empleado2:");
        
        System.out.println(e2.toString());
        
        System.out.println("--------------------------");
        
        //Los objetos creados de Programador, tienen acceso al toString() de clase, concatenando los atributos de la superclase (Empleado).
        //Además pueden acceder de igual forma al método aumentarSalario() de la clase padre (Empleado).
        System.out.println("Información de Programador1");
        
        System.out.println(pro1.toString());
        pro1.aumentarSalario(1500);
        
        System.out.println("Aumentamos el salario a Programador1 en 1500 \n Información de Programador1: ");
        System.out.println(pro1.toString());
        
        
    }
    
}
