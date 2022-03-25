package herencia;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
//ÉSTA CLASE HEREDA DE ARTISTA.
public class Cantante extends Artista {

    //Atributos de la clase
    private int cdsLanzados; //¿Cuántos CD's ha sacado el Cantante a lo largo de su carrera?
    private String generoMusical; //Género musical atribuido a su último CD.

    //Constructor con sus valores por defecto.
    public Cantante() {
    }

    //Constructor parametrizado.
    public Cantante(int cdsLanzados, String generoMusical, String nombre, String apellido, int edad, String nacionalidad) {
        super(nombre, apellido, edad, nacionalidad);
        this.cdsLanzados = cdsLanzados;
        this.generoMusical = generoMusical;
    }

    //Getters y setters.
    public int getCdsLanzados() {
        return cdsLanzados;
    }

    public void setCdsLanzados(int cdsLanzados) {
        this.cdsLanzados = cdsLanzados;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    //hashCode() sobrescrito de la clase padre Artista.
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.cdsLanzados;
        hash = 29 * hash + Objects.hashCode(this.generoMusical);
        return hash;
    }

    //equals() sobrescrito de la clase padre Artista.
    @Override
    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        //LO DE ARRIBA QUEDA YA COMPARADO CON LA LÍNEA DE ABAJO.
        //Coge el equals del padre y compara primero la superclase.
        if (!super.equals(obj)) {
            return false;
        }
        final Cantante other = (Cantante) obj;
        if (this.cdsLanzados != other.cdsLanzados) {
            return false;
        }
        return Objects.equals(this.generoMusical, other.generoMusical);
    }

    //toString() sobrescrito de la clase padre artista.
    @Override
    public String toString() {
        //Concateno el toString de la clase padre al toString de la clase hija (actual)
        return super.toString() + "\nCantante{" + "cdsLanzados=" + cdsLanzados + ", generoMusical=" + generoMusical + '}';
    }

    //Método que solo existe en esta clase.
    public String repercusionMundial() {
        if (this.cdsLanzados > 10) {
            return "Éste cantante tiene repercusión mundial.";
        } else {
            return "Sólo es conocido en su barrio.";
        }
    }

    //Sobrescritura del método abstracto de la clase padre Artista.
    @Override
    public boolean retirarDelMundillo() {
        return true;
    }

    //Método que sólo se usará en esta clase.
    public void queEsEstaPersona() {
        System.out.println("Ésta persona es un CANTANTE.");
    }

}
