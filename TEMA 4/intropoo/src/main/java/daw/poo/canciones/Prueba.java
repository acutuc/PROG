
package daw.poo.canciones;

/**
 *
 * @author Gabriel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cancion prueba1 = new Cancion("The Unforgiven", "Metallica");
        Cancion prueba2 = new Cancion("Smells Like Teen Spirit", "Nirvana");
        
        System.out.println("Cancion 1 con toString --> " + prueba1.toString());
        System.out.println("Cancion 2 con toString --> " + prueba2.toString());
        System.out.println("Cancion 1 con métodos set --> " + prueba1.getAutor() + ". " + prueba1.getTitulo());
        System.out.println("Cancion 1 con métodos set --> " + prueba2.getAutor() + ". " + prueba2.getTitulo());
    }
    
}
