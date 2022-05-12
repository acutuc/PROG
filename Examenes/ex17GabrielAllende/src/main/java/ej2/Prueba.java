package ej2;

import ej1.Naipe;
import ej1.Palos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    private static Rondas ronda;

    public static void main(String[] args) throws FileNotFoundException {
        //Instancio un nuevo objeto de tipo Ronda
        ronda = new Rondas();
        
        ArrayList<Naipe> rondas = new ArrayList<>();
        
        //Leemos el fichero.
        String idFichero = "escaleraColor.txt";

        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();
                //Quitamos todos los espacios.
                linea = linea.replaceAll(" ", "").substring(0, 2);

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(";");

                Naipe nai = new Naipe();
                nai.setNumero(Integer.parseInt(tokens[0].substring(0, 2)));
                if (tokens[1].equalsIgnoreCase("d")) {
                    nai.setPalo(Palos.ROMBOS);
                } else if (tokens[1].equalsIgnoreCase("t")) {
                    nai.setPalo(Palos.TREBOLES);
                } else if (tokens[1].equalsIgnoreCase("c")) {
                    nai.setPalo(Palos.CORAZONES);
                } else {
                    nai.setPalo(Palos.PICAS);
                }
                
                rondas.add(nai);

            }
        }
        
        rondas.forEach(System.out::println);

    }
}
