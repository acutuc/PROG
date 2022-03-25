/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Cris
 */
public class Baraja {

    private Set<Carta> baraja;

    public Baraja() {
        this.baraja = new TreeSet<>();
    }

    public void rellenarBaraja() {
        Carta carta = new Carta();
        for (int i = 0; i < 200; i++) {
            baraja.add(carta.generarCartaAleatoria());
        }

    }

}
