package interfaceenclase;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //No se pueden instanciar objetos de interface ni de clases abstractas.
        
        Vehiculo v1 = new Turismo(); //Conversión implícita
        Ordenador o1 = new Ordenador();
        SeArranca i1 = new Ordenador();
        SeArranca i2 = v1;
        
        System.out.println(i1.arrancar());
        
        ArrayList<SeArranca> listaArrancables = new ArrayList<>();
        
        listaArrancables.add(v1);
        listaArrancables.add(o1);
        listaArrancables.add(i1);
        listaArrancables.add(new Turismo());
        listaArrancables.add(new Ordenador());
        
        for (SeArranca obj : listaArrancables) {
            obj.arrancar();
            if(obj instanceof Ordenador){
                System.out.println(((Ordenador) obj).getPrecio());
            }
        }
        
    }
    
}
