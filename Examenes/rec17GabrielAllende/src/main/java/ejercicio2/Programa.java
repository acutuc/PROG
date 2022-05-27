package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Definición de la clase.
public class Programa {

	public static void main(String[] args) {
		// String con la ubicación del fichero
		String ubicacionFichero = "indicator.csv";

		// Imprimimos la lista de edades media con el método de clase creado
		// anteriormente.
		for (PorcentajeExito pe : LecturaCSV.listaDatos(ubicacionFichero)) {
			System.out.println(pe.toString());
		}

		// Llamamos al apartado D.
		//generaFichero(LecturaCSV.listaDatos(ubicacionFichero));
	}

	// Método de clase que a partir de la lista de objetos, genere un fichero CSV
	// con el mismo formato que el de entrada
	// de forma que aparezcan...(seguir en el folio)
	public static void generaFichero(ArrayList<PorcentajeExito> listaEdades) {
		String fichero = "ficheroGenerado.csv";
		try (BufferedWriter flujo = new BufferedWriter(new FileWriter(fichero))) {
			//Cabecera
			flujo.write("Nombre del municipio;Porcentaje 1996;Porcentaje 2001;Porcentaje 2006;Porcentaje 2010;"
					+ "Porcentaje 2011;Porcentaje 2013;Porcentaje 2014;Porcentaje 2015;Porcentaje 2016");
			for (PorcentajeExito por : LecturaCSV.listaDatos("indicator.csv")) {
				double suma;
				double promedio;
				suma = Double.parseDouble(por.getAnio1996() + por.getAnio2001() + por.getAnio2006() + por.getAnio2010()
						+ por.getAnio2011() + por.getAnio2013() + por.getAnio2014()
						+ por.getAnio2015() + por.getAnio2016());

				promedio = suma / 9;

				if (promedio > 50) {
					flujo.write(por.getMunicipio() + ";" + por.getAnio1996() + ";" + por.getAnio2001() + ";"
							+ por.getAnio2006() + ";" + por.getAnio2010() + ";" + por.getAnio2011() + ";"
							+ por.getAnio2013() + ";" + por.getAnio2014() + ";" + por.getAnio2015() + ";"
							+ por.getAnio2016() + ";" + promedio);
					flujo.newLine();
				}
			}
			// Metodo flush() guarda cambios en disco
			flujo.flush();
			System.out.println("Fichero " + fichero + " creado correctamente.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
