package loteria;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Decimos {
    //Atributos de la clase.
    private String numero;
    static Random random = new Random();

    //Constructor por defecto.
    public Decimos() {
        this.numero = generarDecimo();
    }

    //Constructor parametrizado.
    public Decimos(String numero) {
        this.numero = numero;
    }

    //Getter y setter
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    //toString().
    @Override
    public String toString() {
        return numero;
    }
    
    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.numero);
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
        final Decimos other = (Decimos) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
        //Dos Décimos serán iguales si concuerdan en número.
    }

    //Método que genera un décimo
    private static String generarDecimo() {
        Integer numero = random.nextInt(100000);
        return String.format("%05d", numero);
        //Creo aleatoriamente el número del décimo con un Integer.
    }
}
