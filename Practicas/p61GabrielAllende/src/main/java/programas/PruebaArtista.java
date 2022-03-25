package programas;

import herencia.Actor;
import herencia.Artista;
import herencia.Cantante;
import herencia.Cineasta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author acutuc
 */
public class PruebaArtista {

    /**
     * @param args the command line arguments
     */
    //Jerarquía:
    //Artista --> Cineasta y Cantante.
    //Cineasta --> Actor
    public static void main(String[] args) {
        //Creo la lista de objetos en la que añadiré todas las instancias de clase.
        ArrayList<Artista> lista = new ArrayList<>();

        //Creo dos instancias de cada clase:
        Cineasta cineasta1 = new Cineasta(true, "Christopher Nolan", "Christopher", "Nolan", 51, "Británico");
        Cineasta cineasta2 = new Cineasta(true, "Columbia Pictures", "Quentin", "Tarantino", 58, "Estadounidense");

        Cantante cantante1 = new Cantante(21, "Rock", "Bon", "Jovi", 60, "Estadounidense");
        Cantante cantante2 = new Cantante(13, "Rock", "Roger", "Waters", 13, "Británico");

        Actor actor1 = new Actor(19, 4, "Camila Morrone", true, "Adam McKay", "Leonardo", "DiCaprio", 47, "Estadounidense");
        Actor actor2 = new Actor(34, 11, "Shakira Baksh", true, "Christopher Nolan", "Michael", "Caine", 89, "Británico");        
        
        //Añado a la lista de Artistas todas las instancias creadas anteriormente.
        lista.add(cineasta1);
        lista.add(cineasta2);
        lista.add(cantante1);
        lista.add(cantante2);
        lista.add(actor1);
        lista.add(actor2);
        
        //Ordenación con Comparator.
        Collections.sort(lista, (a1, a2))->a1.getNombre().compareTo(a2.getNombre());
                
        //Realizo la llamada del método de la superclase Artista en todos los objetos, con un bucle forEach.
        for (Artista artista : lista) {
            artista.retirarDelMundillo();
        }
        
        //Aplico los métodos correspondientes de cada clase con un bucle forEach.
        for (Artista artista : lista) {
            if(artista instanceof Cineasta){
                Cineasta aux = (Cineasta) artista;
                aux.haGanado10Millones();
            }
            if(artista instanceof Cantante){
                Cantante aux = (Cantante) artista;
                aux.queEsEstaPersona();
            }
            if(artista instanceof Actor){
                Actor aux = (Actor) artista;
                aux.queEsEstaPersona();
            }
        }

    }

}
