
package gabrielAllende;

import javax.swing.JOptionPane;



/**
 *
 * @author acutuc
 */
public class parteB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Importo e inicializo la clase JOptionPane y guardo en variable String*/
        String numeroMastersTexto = JOptionPane.showInputDialog("Cantidad de másters: ");
        
        //Convierto lo almacenado en la variable String anterior en "double"
        double numeroMasters = Double.parseDouble(numeroMastersTexto);
        System.out.println(numeroMasters);
        //Declaro las variables.
        final double HORAS_PROFESOR = 150;
        final double HORAS_POR_MASTER = 975;
        //Realizo la operación de horas por master / horas por profesor.
        double profesores = (HORAS_POR_MASTER / HORAS_PROFESOR);
               
        //Realizo la operación correspondiente a nº de másters por cantidad de profesores.
        double cifraFinal = (numeroMasters * profesores);
        
        //Hago redondeo con casting explícito.
        int redondeo = (int) Math.ceil(cifraFinal);

        //Imprimo en pantalla el resultado final.
        System.out.println("La cantidad de profesores a contratar es de: " + redondeo);
    }
    
}
