
package metodoequals;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Prueba {

    public static void main(String[] args) {

        // Creación de objetos Cliente
        Cliente cli1 = new Cliente();

        Cliente cli2 = new Cliente("Paco", "77569842U", 25);
        Cliente cli3 = new Cliente("Pepe", "12345678L", 30);
        Cliente cli4 = new Cliente("Pepe", "12345678L", 30);
        Cliente cli5 = new Cliente("Pepe", "12345678L", 30);

        //Imprime los hashCode de cada instancia, y comprueba cuáles son iguales y cuáles distintos.
        System.out.println("HashCode cli1: " + cli1.hashCode());
        System.out.println("HashCode cli2: " + cli2.hashCode());
        System.out.println("HashCode cli3: " + cli3.hashCode());
        System.out.println("HashCode cli4: " + cli4.hashCode());
        System.out.println("HashCode cli5: " + cli5.hashCode());

        //Comprobaciones de las propiedades
        
        //Reflexiva: cualquier objeto que se compare con si mismo 
        // debe de devolver siempre verdadero.( obj.equals(obj) )
        System.out.println("Reflexiva --------------");
        System.out.println("Cliente 1 consigo mismo " + cli1.equals(cli1));

        // Simétrica: si hay dos objetos a y b, y se cumple que a.equals(b) 
        // entonces se debe de cumplir b.equals(a).
        System.out.println("Simétrica ---------------");
        System.out.println("Cliente 3 y 4 " + cli3.equals(cli4));
        System.out.println("Cliente 4 y 3 " + cli4.equals(cli3));

        // Transitiva: para tres objetos a, b y c si se cumple que 
        // a.equals(b) y b.equals(c) debe de cumplirse también que a.equals(c). 
        System.out.println("Transitiva -------------");
        System.out.println("Cliente 3 y 4 " + cli3.equals(cli4));
        System.out.println("Cliente 4 y 5 " + cli4.equals(cli5));
        System.out.println("Cliente 3 y 5 " + cli3.equals(cli5));

        //Nula: cualquier objeto comparado con null el resultado es falso. 
        Cliente nulo = null;
        System.out.println("Nula -------------- ");
        System.out.println("Cliente 1 con null " + cli1.equals(nulo));
    }

}
