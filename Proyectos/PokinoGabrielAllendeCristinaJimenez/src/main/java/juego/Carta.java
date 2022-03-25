package juego;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Carta {

    //Atributos de la clase.
    private Palos palo;
    private int numero;
    private Random random;

    public Carta generarCartaAleatoria() {
        int numPalo = random.nextInt(4) + 1;
        Carta carta = new Carta();
        switch (numPalo) {
            case 1:
                carta.setPalo(Palos.BASTOS);
                carta.setNumero(random.nextInt(12) + 1);
                break;
            case 2:
                carta.setPalo(Palos.COPAS);
                carta.setNumero(random.nextInt(12) + 1);
                break;
            case 3:
                carta.setPalo(Palos.ESPADAS);
                carta.setNumero(random.nextInt(12) + 1);
                break;
            case 4:
                carta.setPalo(Palos.OROS);
                carta.setNumero(random.nextInt(12) + 1);
                break;

        }

        return carta;
    }

    //Constructor por defecto.
    public Carta() {
    }

    //Constructor parametrizado.
    public Carta(Palos palo, int numero) {
        if (numero <= 12) {
            this.numero = numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.palo);
        hash = 29 * hash + this.numero;
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
        final Carta other = (Carta) obj;
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
        return "Carta{" + "palo=" + palo + ", numero=" + numero + '}';
    }

}
