package actividadclasevuelo;


import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author acutuc
 */
/*

-- Enunciado de Vico --
Esta tarea sirve para hacer un repaso de las estructuras Map estudiadas. El ejercicio consiste en, a partir de una lista de vuelos, obtener en distintos métodos la siguiente información:
Método que devuelve un map donde para cada ciudad de destino se indique el número de pasajeros que vuelan a ese destino, de entre todos los vuelos.
Método que devuelva la misma información que el anterior pero garantizando que las ciudades contenidas en el map están ordenadas alfabéticamente.
Método que genere un map donde a partir del código de vuelo se puedan obtener todos los pasajeros de ese vuelo.
La clase Vuelo tiene como atributos: código vuelo, origen, destino, duración y la lista de pasajeros.*/

//Definición de la clase
public class Vuelo {

    //Atributos de la clase
    private String codVuelo;
    private CiudadOrigen ciudadOrigen;
    private CiudadDestino ciudadDestino;
    private int duracionVueloMin;
    private ArrayList<Pasajero> listaPasajeros;

    //Constructor con sus atributos por defecto.
    public Vuelo() {
        this.codVuelo = "46824";
        this.ciudadOrigen = CiudadOrigen.MALAGA;
        this.ciudadDestino = CiudadDestino.ROMA;
        this.duracionVueloMin = 185;
        this.listaPasajeros = new ArrayList<>();
    }

    //Constructor paramtrizado
    public Vuelo(String codVuelo, CiudadOrigen ciudadOrigen, CiudadDestino ciudadDestino, int duracionVueloMin, ArrayList<Pasajero> listaPasajeros) {
        this.codVuelo = codVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.duracionVueloMin = duracionVueloMin;
        this.listaPasajeros = listaPasajeros;
    }

    //Getters y setters
    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public CiudadOrigen getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(CiudadOrigen ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public CiudadDestino getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(CiudadDestino ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getDuracionVueloMin() {
        return duracionVueloMin;
    }

    public void setDuracionVueloMin(int duracionVueloMin) {
        this.duracionVueloMin = duracionVueloMin;
    }

    public ArrayList<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }

    //toString()
    @Override
    public String toString() {
        return "Vuelo{" + "codVuelo=" + codVuelo + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", duracionVueloMin=" + duracionVueloMin + ", listaPasajeros=" + listaPasajeros + '}';
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codVuelo);
        hash = 17 * hash + Objects.hashCode(this.ciudadOrigen);
        hash = 17 * hash + Objects.hashCode(this.ciudadDestino);
        hash = 17 * hash + this.duracionVueloMin;
        hash = 17 * hash + Objects.hashCode(this.listaPasajeros);
        return hash;
    }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vuelo other = (Vuelo) obj;
        if (this.duracionVueloMin != other.duracionVueloMin) {
            return false;
        }
        if (!Objects.equals(this.codVuelo, other.codVuelo)) {
            return false;
        }
        if (!Objects.equals(this.ciudadOrigen, other.ciudadOrigen)) {
            return false;
        }
        if (!Objects.equals(this.ciudadDestino, other.ciudadDestino)) {
            return false;
        }
        return Objects.equals(this.codVuelo, other.codVuelo);
    }
    
}
