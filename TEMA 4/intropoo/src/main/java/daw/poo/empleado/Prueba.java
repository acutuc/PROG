
package daw.poo.empleado;

/**
 *
 * @author Gabriel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Javier Fernando", "Parodi Piñero", "5789034J", 1050, 6.5, 4, 10, false, 1);
        Empleado empleado2 = new Empleado();
        
        System.out.println(empleado1.retencionTotalIRPF());
        empleado1.escribirAllInfo();
    }
    
}
