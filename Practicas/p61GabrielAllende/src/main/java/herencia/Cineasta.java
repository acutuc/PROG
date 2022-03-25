package herencia;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
//ÉSTA CLASE HEREDA DE "Artista"
public class Cineasta extends Artista {
    //Atributos de la clase.
    protected boolean haDirigido; //¿Ha dirigido alguna película?
    protected String ultimaProductora; //Última productora con la que trabajó.
    
    //Constructor con sus valores por defecto.
    public Cineasta() {
    }
    
    //Constructor parametrizado.
    public Cineasta(boolean haDirigido, String ultimaProductora, String nombre, String apellido, int edad, String nacionalidad) {
        super(nombre, apellido, edad, nacionalidad);
        this.haDirigido = haDirigido;
        this.ultimaProductora = ultimaProductora;
    }
    
    //Getters y setters.
    public boolean isHaDirigido() {
        return haDirigido;
    }

    public String getUltimaProductora() {
        return ultimaProductora;
    }

    public void setHaDirigido(boolean haDirigido) {
        this.haDirigido = haDirigido;
    }

    public void setUltimaProductora(String ultimaProductora) {
        this.ultimaProductora = ultimaProductora;
    }

    //toString()
    @Override
    public String toString() {
        //Concateno el toString de la clase padre al toString de la clase hija.
        //Sobrescritura de la clase padre Artista.
        return super.toString() + "\nCineasta{" + "haDirigido=" + haDirigido + ", ultimaProductora=" + ultimaProductora + '}';
    }
    
    //Sobrescritura del método abstracto de la clase padre Artista.
    @Override
    public boolean retirarDelMundillo(){
        return true;
    }
    
    //Método que sólo se usará en esta clase..
    public boolean haGanado10Millones(){
        return true;
    }
    
    //Método B2 del ejercicio. Envejece inmediatamente 5 años al Cineasta.
    //Éste método se sobrescribirá en la clase hija Actor.
    public void envejecer5anios(){
        this.edad += 5;
    }
}
