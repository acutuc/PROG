package ej8dadoabstracto;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Dado extends Azar {

    static Random random;

    //Constructor por defecto.
    public Dado() {
        random = new Random();
        this.posibilidades = 6;
    }

    //Método sobrescrito que simula el lanzamiento de un dado.
    @Override
    public int lanzar() {
        return random.nextInt(6) + 1;
    }
}
