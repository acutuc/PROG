package ej4y5cliente;

/**
 *
 * @author Gabriel
 */
public class PruebaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Objeto con constructor por defecto.
        Cliente cli1 = new Cliente();
        
        //Objetos con constructor parametrizado.
        Cliente cli2 = new Cliente("Cliente2", "48217834J", 30);
        
        //Éstos tres objetos tendrán los mismos estados.
        Cliente cli3 = new Cliente("Repetido", "27348959Q", 24);
        Cliente cli4 = new Cliente("Repetido", "27348959Q", 24);
        Cliente cli5 = new Cliente("Repetido", "27348959Q", 24);
        
        System.out.println("hashCode() de cli1: " + cli1.hashCode());
        System.out.println("hashCode() de cli2: " + cli2.hashCode());
        System.out.println("hashCode() de cli3: " + cli3.hashCode());
        System.out.println("hashCode() de cli4: " + cli4.hashCode());
        System.out.println("hashCode() de cli5: " + cli5.hashCode());
        
        System.out.println("*----------------------------*");
        
        //Reflexiva: cualquier objeto que se compare con si mismo debe de devolver siempre verdadero. ( obj.equals(obj) ) 
        System.out.println("Comprobación reflexiva de las propiedades: " + "\n" + cli3.equals(cli4));
        System.out.println("*----------------------------*");
        
        //Transitiva: como su nombre indica para tres objetos a, b y c si se cumple que a.equals(b) y b.equals(c) debe de cumplirse también que a.equals(c). 
        System.out.println("Comprobación transitiva de las propiedades: " + "\n" + "a.equals(b) = " + cli3.equals(cli4) + "\n" + "b.equals(c) = " + cli4.equals(cli5)
        + "\n" + "a.equals(c) = " + cli3.equals(cli5));
        System.out.println("*----------------------------*");
        
        //Simétrica: si tenemos dos objetos a y b, y se cumple a.equals(b) entonces se debe de cumplir b.equals(a).
        System.out.println("Comprobación simétrica de las propiedades: \na.equals(b) = " + cli3.equals(cli4) + "\nb.equals(a) = " + cli4.equals(cli3));
        System.out.println("*----------------------------*");
        
        //Nula: siempre que comparemos cualquier objeto con null el resultado debe de ser falso.
        System.out.print("Comprobación nula de las propiedades: \nobj == null = ");
        System.out.println(cli1 == null);
    }
    
}
