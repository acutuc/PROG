package ej14y18interfaces;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class TestElectrodomesticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancio un objeto de cada tipo.
        Frigorifico f1 = new Frigorifico();
        Microondas m1 = new Microondas();
        CampanaExtractora c1 = new CampanaExtractora();
        
        //Creo una lista de tipo Silencioso
        ArrayList<Silencioso> listaSilencioso = new ArrayList<>();
        
        //Añado los objetos instanciados a la lista.
        listaSilencioso.add(f1);
        listaSilencioso.add(m1);
        //listaSilencioso.add(c1); Error. CampanaExtractora no puede ser Silencioso, 
        //Pues no implementa el interface Silencioso en la denominación de la clase.
    }
    
}
