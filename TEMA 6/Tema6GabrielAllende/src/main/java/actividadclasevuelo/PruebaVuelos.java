package actividadclasevuelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class PruebaVuelos {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //Creo 4 NIFs
        NIF n1 = new NIF("49845687", LocalDate.of(2024, Month.MARCH, 15));
        NIF n2 = new NIF("93546494", LocalDate.of(7, Month.OCTOBER, 2023));
        NIF n3 = new NIF("79246046", LocalDate.of(2030, Month.JANUARY, 29));
        NIF n4 = new NIF("02849649", LocalDate.of(18, Month.JUNE, 30));
        
        //Creo 4 pasajeros.
        Pasajero p1 = new Pasajero("NomPasajero1", "ApePasajero1", n1);
        Pasajero p2 = new Pasajero("NomPasajero2", "ApePasajero2", n2);
        Pasajero p3 = new Pasajero("NomPasajero3", "ApePasajero3", n3);
        Pasajero p4 = new Pasajero("NomPasajero4", "ApePasajero4", n4);
        
        //Creo listaPasajeros en la que añadiré los pasajeros creados anteriormente.
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
        
        listaPasajeros.add(p1);
        listaPasajeros.add(p2);
        listaPasajeros.add(p3);
        listaPasajeros.add(p4);
        
        //Creo un vuelo.
        Vuelo vuelo = new Vuelo("04586", CiudadOrigen.MALAGA, CiudadDestino.MADRID, 45, listaPasajeros);
        
        
        
        
        
    }
    //Métodos.
        //Método que devuelve un map donde para cada ciudad de destino se indique el número de pasajeros que vuelan a ese destino, de entre todos los vuelos.
}
