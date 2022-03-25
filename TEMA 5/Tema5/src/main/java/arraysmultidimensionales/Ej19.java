package arraysmultidimensionales;

import javax.swing.JOptionPane;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Ej19 {
    /*Crear un programa que mediante un menú permita reservar o cancelar asientos de un avión,
    así como mostrar qué asientos están ocupados y libres actualmente. El avión tendrá 25 filas de 4 asientos cada una.*/
    public static void main(String[] args) {
        boolean[][] asientos = new boolean[25][4];
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = false;
                System.out.print("Asiento " + i + "" + (j+1) + ": " + asientos[i][j] + "\t");
                
            }
            System.out.println("");
        }

    }
    
}
