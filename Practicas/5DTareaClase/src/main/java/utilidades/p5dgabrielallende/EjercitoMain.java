package utilidades.p5dgabrielallende;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author acutuc
 */
public class EjercitoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creo el ejército.
        Ejercito ejercito = new Ejercito();

        //Creo los soldados.
        Soldado s1 = new Soldado("00001", "Juan Carlos", "Fernández", "Vico", 31);
        Soldado s2 = new Soldado("00002", "Edgardo Gabriel", "Allende", "Palacio", 27);
        Soldado s3 = new Soldado("00003", "Javier", "Parodi", "Piñero", 25);
        Soldado s4 = new Soldado("00004", "Eduardo", "Orellana", "Pomares", 23);

        //Añado los soldados al ejército.
        ejercito.alistarSoldado(s1);
        ejercito.alistarSoldado(s2);
        ejercito.alistarSoldado(s3);
        ejercito.alistarSoldado(s4);
        
        //Imprimo.
        ejercito.imprimir();
        
        //Desmatriculo un soldado.
        ejercito.desmatricularSoldado(s4);
        
        //Compruebo si un soldado está en el ejército.
        System.out.println(ejercito.estaEnElEjercito(s4));
        
        //Saber cuántos soldados hay en el ejército.
        System.out.println("Hay " + ejercito.saberNumeroDeSoldados() + " soldados matriculados");
        
        //Sacar el Set en un ArrayList.
        ejercito.sacarSoldadosEnArrayList();
        
        

        
    }

}
