package ej2;

import ej1.Naipe;
import ej1.Palos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<Naipe> rondas = new ArrayList<>();
        
        //Leemos el fichero.
        String idFichero = "escaleraColor.txt";

        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();
                //Quitamos todos los espacios.
                //linea = linea.replaceAll(" ", "");
                tokens = linea.split(" ");
                
                //En cada ronda habrán 4 cartas, por lo que instancio 4 cartas para ir asignándole los valores.
                Naipe nai1 = new Naipe();
                Naipe nai2 = new Naipe();
                Naipe nai3 = new Naipe();
                Naipe nai4 = new Naipe();                
                
                nai1.setNumero(tokens[0]);
                nai1.setPalo(comprobarPalo(tokens[1]));
                nai2.setNumero(tokens[2]);
                nai2.setPalo(comprobarPalo(tokens[3]));
                nai3.setNumero(tokens[4]);
                nai3.setPalo(comprobarPalo(tokens[5]));
                nai4.setNumero(tokens[6]);
                nai4.setPalo(comprobarPalo(tokens[7]));
                
                
                rondas.add(nai1);
                rondas.add(nai2);
                rondas.add(nai3);
                rondas.add(nai4);
            }
        }
        
        rondas.forEach(System.out::println);

    }
    
    private static Palos comprobarPalo (String palo){
        Palos pa = null;
        if(palo.equalsIgnoreCase("T")){
            pa = Palos.TREBOLES;
        }else if (palo.equalsIgnoreCase("C")){
            pa = Palos.CORAZONES;
        }else if (palo.equalsIgnoreCase("D")){
            pa = Palos.ROMBOS;
        }else if (palo.equalsIgnoreCase("P")){
            pa = Palos.PICAS;
        }
        return pa;
    }
}
