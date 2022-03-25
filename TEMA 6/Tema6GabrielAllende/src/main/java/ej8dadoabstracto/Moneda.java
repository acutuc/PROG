package ej8dadoabstracto;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
//Definición de la clase
public class Moneda extends Azar{
    static Random random;
    
    //Constructor por defecto.
    public Moneda(){
        random = new Random();
        this.posibilidades = 2;
    }
    
    //Método sobrescrito que simula el lanzamiento de una moneda
    @Override
    public int lanzar(){
        return random.nextInt(2)+1;
    }
    
}
