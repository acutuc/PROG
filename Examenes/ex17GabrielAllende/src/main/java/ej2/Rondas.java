package ej2;

import ej1.Naipe;
import ej1.Palos;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Rondas {
    //Atributos de la clase.
    ArrayList<Naipe> ronda;
    
    public Rondas(){
        this.ronda = new ArrayList<>();
        rellenarBaraja();
    }
    public void rellenarBaraja() {
        int contador = 2;
        do {
            //RELLENO LA BARAJA CON PICAS
            Naipe pic = new Naipe();
            pic.setPalo(Palos.PICAS);
            pic.setNumero(contador);
            ronda.add(pic);

            //RELLENO LA BARAJA CON ROMBOS
            Naipe rom = new Naipe();
            rom.setPalo(Palos.ROMBOS);
            rom.setNumero(contador);
            ronda.add(rom);

            //RELLENO LA BARAJA CON TRÉBOLES
            Naipe tre = new Naipe();
            tre.setPalo(Palos.TREBOLES);
            tre.setNumero(contador);
            ronda.add(tre);

            //RELLENO LA BARAJA CON CORAZONES
            Naipe cor = new Naipe();
            cor.setPalo(Palos.CORAZONES);
            cor.setNumero(contador);
            ronda.add(cor);

            contador++;

        } while (contador != 15);

    }
    
    //toString()
    @Override
    public String toString() {
        return "Rondas{" + "ronda=" + ronda + '}';
    }
    
}
   
