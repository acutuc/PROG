package actividadclasevuelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author acutuc
 */
/*Tenemos la clase Vuelo con 5 atributos (codigo de vuelo, ciudad origen, ciudad destino, duración del vuelo y 
lista de pasajeros).
En el main se genera una lista de vuelos, un método estático que genere un Map que contenga para cada destino
el número de pasajeros que llegan a ese desino de todos los vuelos, otro método donde repetimos el método
anterior pero ordenando alfabéticamente por destino y el tercer método debe permitir saber por código de vuelo
los pasajeros que hay*/
//Definición de la clase
public class Vuelo {
    //Atributos de la clase
    private String codVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int duracionVueloMin;
    private ArrayList<Pasajero> listaPasajeros;
    
    //Constructor con sus atributos por defecto.
    public Vuelo() {
        this.codVuelo = "46824";
        this.ciudadOrigen = "Málaga";
        this.ciudadDestino = "París";
        this.duracionVueloMin = 185;
        this.listaPasajeros = new ArrayList<>();
    }
    
    //Constructor paramtrizado
    public Vuelo(String codVuelo, String ciudadOrigen, String ciudadDestino, int duracionVueloMin, ArrayList<Pasajero> listaPasajeros) {
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

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
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
//        if (this.duracionVueloMin != other.duracionVueloMin) {
//            return false;
//        }
        if (!Objects.equals(this.codVuelo, other.codVuelo)) {
            return false;
//        }
//        if (!Objects.equals(this.ciudadOrigen, other.ciudadOrigen)) {
//            return false;
//        }
//        if (!Objects.equals(this.ciudadDestino, other.ciudadDestino)) {
//            return false;
//        }
//        return Objects.equals(this.listaPasajeros, other.listaPasajeros);
    }
    
    
    
    
}
