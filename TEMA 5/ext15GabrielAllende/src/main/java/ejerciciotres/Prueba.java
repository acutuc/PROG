
package ejerciciotres;

import ejerciciodos.Empresa;
import ejerciciouno.CategoriaEmpleado;
import ejerciciouno.Trabajador;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author acutuc
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa empresaA = new Empresa("Empresa1", "CIF201");
        Empresa empresaB = new Empresa("Emresa2", "CIF202");
        
        Trabajador t1 = new Trabajador("Juan", "Pérez", LocalDate.of(1994, Month.MARCH, 3), CategoriaEmpleado.MEDIA);
        Trabajador t2 = new Trabajador("Pepe", "Gutiérrez", LocalDate.of(1995, Month.JULY, 10), CategoriaEmpleado.AVANZADA);
        Trabajador t3 = new Trabajador("Obi-Wan", "Kenobi", LocalDate.of(1989, Month.JANUARY, 29), CategoriaEmpleado.INICIAL);
        Trabajador t4 = new Trabajador("Pedro", "Sánchez", LocalDate.of(1999, Month.OCTOBER, 7), CategoriaEmpleado.AVANZADA);
        Trabajador t5 = new Trabajador("Gabriel", "Jerruz", LocalDate.of(1994, Month.JUNE, 6), CategoriaEmpleado.MEDIA);
        
        
        
        empresaA.contratar(t1);
        empresaA.contratar(t2);
        empresaA.contratar(t3);
        
        empresaB.contratar(t4);
        empresaB.contratar(t5);
        
        Trabajador.fechaJubilacion(t3);
        
    }
    
}
