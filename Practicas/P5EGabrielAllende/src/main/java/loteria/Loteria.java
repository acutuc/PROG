package loteria;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Loteria {
    //Atributos de la clase.
    private Map<Decimos, Premios> loteria;

    //Constructor por defecto.
    public Loteria() {
        this.loteria = new HashMap<>();
    }

    //Método que añade un premio a un cédimo.
    public void addPremio(Decimos decimo, Premios premio) {
        this.loteria.put(decimo, premio);
    }

    //Método que consulta si un décimo es premiado.
    public Premios consulta(Decimos decimo) {
        return this.loteria.get(decimo);
    }

    //Método que nos devuelve el Map.
    public Map<Decimos, Premios> getLoteria() {
        return this.loteria;
    }
}
