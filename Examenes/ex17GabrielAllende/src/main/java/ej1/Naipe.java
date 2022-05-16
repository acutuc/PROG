package ej1;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Naipe {

    //Atributos de la clase.
    private Palos palo;
    private String numero;

    //Constructor por defecto.
    public Naipe() {
    }

    //Constructor parametrizado.
    public Naipe(Palos palo, String numero) {
        this.numero = numero;
        if (this.numero.equalsIgnoreCase("11")) {
            this.numero = "J";
        } else if (this.numero.equalsIgnoreCase("12")) {
            this.numero = "Q";
        } else if (this.numero.equalsIgnoreCase("13")) {
            this.numero = "K";
        } else if (this.numero.equalsIgnoreCase("14")) {
            this.numero = "A";
        }
        this.palo = palo;
    }

    //Getters y setters.
    public Palos getPalo() {
        return palo;
    }

    public void setPalo(Palos palo) {
        this.palo = palo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
        if (this.numero.equalsIgnoreCase("11")) {
            this.numero = "J";
        } else if (this.numero.equalsIgnoreCase("12")) {
            this.numero = "Q";
        } else if (this.numero.equalsIgnoreCase("13")) {
            this.numero = "K";
        } else if (this.numero.equalsIgnoreCase("14")) {
            this.numero = "A";
        }
    }

    //hashCode()
    @Override    
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.palo);
        hash = 29 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    //equals().
    //Una carta será igual a otra si son iguales en PALO y NÚMERO.
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
        final Naipe other = (Naipe) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.palo != other.palo) {
            return false;
        }
        return true;
    }

    //toString().
    @Override
    public String toString() {
        return "Naipe{" + "palo=" + palo + ", numero=" + numero + "\n";
    }
}
