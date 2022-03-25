
package daw.GabrielAllende;

import javax.swing.JOptionPane;

/**
 *
 * @author acutuc
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos dos objetos con el constructor por defecto:
        LibroElectronico libro1 = new LibroElectronico();
        LibroElectronico libro2 = new LibroElectronico();
        
        //Mostramos por consola los datos de los dos libros creados anteriormente, con el método toString.
        System.out.println(libro1.toString());//Datos impresos por consola del Libro 1.
        System.out.println(libro2.toString());//Datos impresos por consola del Libro 2.
        
        //Creamos dos objetos con el constructor parametrizado:00
        LibroElectronico libro3 = new LibroElectronico("459", "Las grandes aventuras de Gabriel", 7690, 9.9, 450);
        LibroElectronico libro4 = new LibroElectronico("745", "¿Cómo ordeñar a una vaca?", 8, 1.2, 2);
        
        //Mostramos los datos mediante JOption y toString.
        JOptionPane.showMessageDialog(null, libro3);//Datos mostrados mediante JOption del Libro 3.
        JOptionPane.showMessageDialog(null, libro4);//Datos mostrados mediante JOption del Libro 4.
        System.out.println(libro3.toString());//Datos impresos por consola del Libro 3.
        System.out.println(libro4.toString());//Datos impresos por consola del Libro 4.
        
        //Establecemos 13000 páginas al Libro 1.
        libro1.setNumPag(13000);
        //Imprimimos por consola los detalles del Libro 1.
        System.out.println(libro1);
        //Imprimimos usando toString los detalles del Libro 1.
        System.out.println(libro1.toString());
        
        //Establecemos como tamaño 15MB al Libro 2.
        libro2.setTamanioMem(15);
        //Imprimimos por consola los detalles del Libro 2.
        System.out.println(libro2);
        //Imprimimos usando toString los detalles del Libro 2.
        System.out.println(libro2.toString());
        
        
        /*Prueba los métodos pasarPagina(), retrocederPagina() y saltar(int) con cualquiera de los libros creados y
        muestra los datos por consola para comprobar su funcionamiento.*/
        
        //Pasamos página al Libro 3.
        libro3.pasarPagina();
        //Mostramos los datos actualizados del Libro 3.
        System.out.println(libro3);
        
        //Retrocedemos página al Libro 4.
        libro4.retrocederPagina();
        //Mostramos los datos actualizados del Libro 4.
        System.out.println(libro4);
        
        //Saltamos 420 páginas al Libro 1.
        libro1.saltar(420);
        //Mostramos los datos actualizados del Libro 1.
        System.out.println(libro1);
        
        
        //PRUEBA PARA COMPROBAR LAS CONDICIONES
        libro3.saltar(8100);
        System.out.println(libro3);
    }
    
}
