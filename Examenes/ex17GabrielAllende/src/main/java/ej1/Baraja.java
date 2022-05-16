package ej1;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class Baraja {

    private ArrayList<Naipe> baraja;

    public Baraja() {
        this.baraja = new ArrayList<>();
        rellenarBaraja();
    }

    public void rellenarBaraja() {
        int contador = 2;
        do {
            //RELLENO LA BARAJA CON PICAS
            Naipe pic = new Naipe();
            pic.setPalo(Palos.PICAS);
            pic.setNumero(String.valueOf(contador));
            baraja.add(pic);

            //RELLENO LA BARAJA CON ROMBOS
            Naipe rom = new Naipe();
            rom.setPalo(Palos.ROMBOS);
            rom.setNumero(String.valueOf(contador));
            baraja.add(rom);

            //RELLENO LA BARAJA CON TRÉBOLES
            Naipe tre = new Naipe();
            tre.setPalo(Palos.TREBOLES);
            tre.setNumero(String.valueOf(contador));
            baraja.add(tre);

            //RELLENO LA BARAJA CON CORAZONES
            Naipe cor = new Naipe();
            cor.setPalo(Palos.CORAZONES);
            cor.setNumero(String.valueOf(contador));
            baraja.add(cor);

            contador++;

        } while (contador != 15);

    }
    
    //toString()

    @Override
    public String toString() {
        return "Baraja{" + "baraja=" + baraja + '}';
    }
    

}
