package ej7personasabstracto;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class PruebaTrabajadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creo dos objetos de tipo Camarero.
        Camarero ca1 = new Camarero("Rango 1", "Camarero1", "Apellido1", "98273587B");
        Camarero ca2 = new Camarero("Rango 2", "Camarero2", "Apellido2", "24354355K");

        //Creo dos objetos de tipo Cocinero
        Cocinero co1 = new Cocinero("Frío", "Cocinero1", "Apellido1", "12498635Q");
        Cocinero co2 = new Cocinero("Plancha", "Cocinero2", "Apellido2", "53934580B");

        //Creo lista de Trabajador.
        ArrayList<Trabajador> lista = new ArrayList<>();

        //Agrego los objetos hijos creados de Trabajador al ArrayList.
        lista.add(ca1);
        lista.add(ca2);
        lista.add(co1);
        lista.add(co2);

        //Imprimo el método abstracto en la clase padre, sobreescrito en las clases hijas cotizar()
        for (Trabajador trabajador : lista) {
            trabajador.cotizar();
        }

        //Casting
        Camarero c = (Camarero) lista.get(0);
        
        if(lista.get(0) instanceof Camarero){
            lista.get(0).cotizar();
        }

    }

}
