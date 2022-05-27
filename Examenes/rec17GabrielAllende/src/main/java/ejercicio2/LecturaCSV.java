package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Definición de la clase
public class LecturaCSV {
	
	//Método de clase que devuelve una lista de objetos POJO, donde se almacenará la información contenida
	//en el fichero. Éste método recibe como parámetro el nombre/ubicación del fichero a leer.
	public static ArrayList<PorcentajeExito> listaDatos (String ubicacionFichero){
		//ArrayList en el que almacenaré los datos obtenidos del fichero:
		ArrayList<PorcentajeExito> listaDatos = new ArrayList<>();
		
		// Variables para guardar los datos que se van LEYENDO.
        String[] tokens;
        String linea;        
		
		//try-with-resources para leer el fichero "RelPerCen.csv".
        try (Scanner datosFichero = new Scanner(new File(ubicacionFichero))) {
        	
            //Omito la primera línea (encabezado de atributos en el CSV)
            datosFichero.nextLine();
            
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
            	
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                
                tokens = linea.split(";");

                //Creo un objeto de DatosPorMunicipio auxiliar en el que introduciré todos los datos mediante los setters.
                PorcentajeExito aux = new PorcentajeExito();
                
                //Almaceno en cada atributo, la posición del array de tokens
                aux.setCodMunicipio(tokens[0]);
                aux.setMunicipio(tokens[1]);
                aux.setAnio2016(String.valueOf(tokens[2]));
                aux.setAnio2015(String.valueOf(tokens[3]));
                aux.setAnio2014(String.valueOf(tokens[4]));
                aux.setAnio2013(String.valueOf(tokens[5]));
                aux.setAnio2011(String.valueOf(tokens[6]));
                aux.setAnio2010(String.valueOf(tokens[7]));
                aux.setAnio2006(String.valueOf(tokens[8]));
                aux.setAnio2001(String.valueOf(tokens[9]));
                aux.setAnio1996(String.valueOf(tokens[10]));
                
                listaDatos.add(aux);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
		return listaDatos;
	}
}
