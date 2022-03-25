package practicaclase;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Calcetin {

    //Atributos de la clase.
    private Color color;
    private int talla;

    //Constructor por defecto.
    public Calcetin() {
        //Genero un número al azar entre 1 y 3, para asignar el color, llamando al método.
        this.color = generarColorAleatorio();

        //Genero un número al azar entre 43 y 40, para asignar la talla, llamando al método.
        this.talla = generarTallaCalcetines();
    }

    //Getters y setters.
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    //toString
    @Override
    public String toString() {
        return "Calcetin. " + "\tColor: " + color + "\tTalla: " + talla;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.color);
        hash = 97 * hash + this.talla;
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
        final Calcetin other = (Calcetin) obj;
        if (this.talla != other.talla) {
            return false;
        }
        return (this.color == other.color) && (this.talla == other.talla);
    }

    //Método que genera colo aleatorio del calcetín
    public Color generarColorAleatorio() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(3) + 1;
        if (numero == 1) {
            return Color.NEGRO;
        }
        if (numero == 2) {
            return Color.GRIS_CLARO;
        }
        if (numero == 3) {
            return Color.GRIS_OSCURO;
        }
        return null;
    }

    //Método que genera talla aleatoria del calcetín.
    public int generarTallaCalcetines() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(43 - 40 + 1) + 40;
        return numero;
    }

}
