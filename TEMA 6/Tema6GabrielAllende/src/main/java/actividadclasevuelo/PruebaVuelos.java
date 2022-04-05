package actividadclasevuelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author acutuc
 */
public class PruebaVuelos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancio 12 NIFs
        NIF n1 = new NIF("49845687", LocalDate.of(2024, Month.MARCH, 15));
        NIF n2 = new NIF("93546494", LocalDate.of(2025, Month.OCTOBER, 7));
        NIF n3 = new NIF("79246046", LocalDate.of(2030, Month.JANUARY, 29));
        NIF n4 = new NIF("02849649", LocalDate.of(2028, Month.JUNE, 30));
        NIF n5 = new NIF("09464982", LocalDate.of(2027, Month.MAY, 2));
        NIF n6 = new NIF("18942797", LocalDate.of(2026, Month.SEPTEMBER, 28));
        NIF n7 = new NIF("84601647", LocalDate.of(2022, Month.DECEMBER, 24));
        NIF n8 = new NIF("34620189", LocalDate.of(2024, Month.JULY, 25));
        NIF n9 = new NIF("84661905", LocalDate.of(2023, Month.FEBRUARY, 15));
        NIF n10 = new NIF("22145814", LocalDate.of(2026, Month.AUGUST, 16));
        NIF n11 = new NIF("84926548", LocalDate.of(2029, Month.APRIL, 19));
        NIF n12 = new NIF("54692084", LocalDate.of(2028, Month.MAY, 9));

        //Instancio 12 pasajeros.
        Pasajero p1 = new Pasajero("NomPasajero1", "ApePasajero1", n1);
        Pasajero p2 = new Pasajero("NomPasajero2", "ApePasajero2", n2);
        Pasajero p3 = new Pasajero("NomPasajero3", "ApePasajero3", n3);
        Pasajero p4 = new Pasajero("NomPasajero4", "ApePasajero4", n4);
        Pasajero p5 = new Pasajero("NomPasajero5", "ApePasajero5", n5);
        Pasajero p6 = new Pasajero("NomPasajero6", "ApePasajero6", n6);
        Pasajero p7 = new Pasajero("NomPasajero7", "ApePasajero7", n7);
        Pasajero p8 = new Pasajero("NomPasajero8", "ApePasajero8", n8);
        Pasajero p9 = new Pasajero("NomPasajero9", "ApePasajero9", n9);
        Pasajero p10 = new Pasajero("NomPasajero10", "ApePasajero10", n10);
        Pasajero p11 = new Pasajero("NomPasajero11", "ApePasajero11", n11);
        Pasajero p12 = new Pasajero("NomPasajero12", "ApePasajero12", n12);

        //Creo listaPasajeros en la que añadiré los pasajeros creados anteriormente.
        Set<Pasajero> listaPasajeros = new TreeSet<>();
        Set<Pasajero> listaPasajeros2 = new TreeSet<>();
        Set<Pasajero> listaPasajeros3 = new TreeSet<>();
        Set<Pasajero> listaPasajeros4 = new TreeSet<>();

        //Añado tres pasajeros a cada lista
        listaPasajeros.add(p1);
        listaPasajeros.add(p2);
        listaPasajeros.add(p3);

        listaPasajeros2.add(p4);
        listaPasajeros2.add(p5);
        listaPasajeros2.add(p6);

        listaPasajeros3.add(p7);
        listaPasajeros3.add(p8);
        listaPasajeros3.add(p9);

        listaPasajeros4.add(p10);
        listaPasajeros4.add(p11);
        listaPasajeros4.add(p12);

        //Creo cuatro vuelos.
        Vuelo vuelo1 = new Vuelo("04586", CiudadOrigen.MALAGA, CiudadDestino.MADRID, 45, listaPasajeros);
        Vuelo vuelo2 = new Vuelo("23954", CiudadOrigen.PARIS, CiudadDestino.EL_CAIRO, 210, listaPasajeros2);
        Vuelo vuelo3 = new Vuelo("94602", CiudadOrigen.LONDRES, CiudadDestino.BARCELONA, 130, listaPasajeros3);
        Vuelo vuelo4 = new Vuelo("64295", CiudadOrigen.BUDAPEST, CiudadDestino.NEW_YORK, 540, listaPasajeros4);
        
        //Creo una listaVuelos en el que meteré todos los vuelos.
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();
        listaVuelos.add(vuelo1);
        listaVuelos.add(vuelo2);
        listaVuelos.add(vuelo3);
        listaVuelos.add(vuelo4);

        //Añado a cada vuelo, su clave que lo identifica.
        Map<String, Vuelo> claveValorVuelo = new TreeMap<>();
        claveValorVuelo.put("04586", vuelo1);

        Map<String, Vuelo> claveValorVuelo2 = new TreeMap<>();
        claveValorVuelo2.put("23954", vuelo2);

        Map<String, Vuelo> claveValorVuelo3 = new TreeMap<>();
        claveValorVuelo3.put("94602", vuelo3);

        Map<String, Vuelo> claveValorVuelo4 = new TreeMap<>();
        claveValorVuelo4.put("64295", vuelo4);

    }

    //Métodos
    //Método que devuelve un map donde para cada ciudad de destino se indique el número de pasajeros que vuelan a ese destino, de entre todos los vuelos.
    public Map<Vuelo, Pasajero> cantidadPasajeros() {
        Map<Vuelo, Pasajero> map = new TreeMap<>();
        int cantidadPasajeros;

    }
