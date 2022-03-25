/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Cris
 */
public class Carton {

    private Baraja baraja;//trabajaremos con las posiciones de la baraja
    private int[][] carton; //Matriz la cual usaremos como cartón

    public Carton() {
        //Inicializamos valores
        this.baraja = new Baraja();
        this.carton = new int[5][5];
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public int[][] getCarton() {
        return carton;
    }

    public void setCarton(int[][] carton) {
        this.carton = carton;
    }

    public void mostrarCarton() {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                System.out.print(carton[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }

}
