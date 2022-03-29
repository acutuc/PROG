package ej13interfaces;

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
        //Instancio dos objetos de cada tipo.
        Estudiante e1 = new Estudiante();
        Estudiante e2 = new Estudiante();
        Profesor p1 = new Profesor();
        Profesor p2 = new Profesor();
        
        //Creo una lista de personas
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        
        //Añado los Estudiantes y Profesores a la lista.
        listaPersonas.add(e1);
        listaPersonas.add(e2);
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        
        //Recorro la lista y llamo al método identificate() de cada objeto.
        for (Persona obj : listaPersonas) {
            if(obj instanceof Estudiante){
                Estudiante aux = (Estudiante) obj;
                aux.identificate();
            }
            if(obj instanceof Profesor){
                Profesor aux = (Profesor) obj;
                aux.identificate();
            }
        }
    }
    
}
