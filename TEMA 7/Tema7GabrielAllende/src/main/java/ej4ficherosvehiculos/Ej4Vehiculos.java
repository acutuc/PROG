package ej4ficherosvehiculos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Ej4Vehiculos {

    /*4.- Usando la clase Vehículo, implementa un programa que realice lo siguiente:
    Crea 30 vehículos (10 Turismos, 10 Deportivos y 10 Furgonetas) con valores de tu elección y guárdalos en una lista de objetos tipo Vehiculo.
    Guarda los vehículos en un fichero de texto llamado “vehículos.txt”, haciendo uso del método polimórfico toString(),
    teniendo en cuenta que el string devuelto lleve separados los campos del objeto por el carácter dos puntos (:).
    Cada línea del fichero estará compuesta por un número, un espacio, un guión, un espacio y los datos del vehículo en cuestión.
    El número de cada línea será 0, 1 o 2 si el objeto es un Turismo, un Deportivo o una Furgoneta, respectivamente. 
    Cada vehículo irá en una línea distinta del fichero.
    Ejemplos de líneas, los campos no tienen porqué coincidir con los de tus clases:

    0 – 4534JTK:Seat:Ibiza:Blanco:… (Este vehículo sería un Turismo)
    1 – 3322FFF:Ford:Kuga:Rojo:… (Este vehículo sería un Deportivo)
     */
    public static void main(String[] args) {
        //Instancio diez objetos tipo Furgoneta.
        Furgoneta f1 = new Furgoneta(155243512313485L, "8738 NLJ", "Renault", "Kangoo", "Rojo", 1000, 3000, 300);
        Furgoneta f2 = new Furgoneta(255243512313485L, "8869 JWL", "Renault", "Kangoo", "Amarillo", 1000, 3000, 300);
        Furgoneta f3 = new Furgoneta(355243512313485L, "7153 KGU", "Renault", "Kangoo", "Azul", 1000, 3000, 300);
        Furgoneta f4 = new Furgoneta(455243512313485L, "8389 EJD", "Renault", "Kangoo", "Morado", 1000, 3000, 300);
        Furgoneta f5 = new Furgoneta(555243512313485L, "7624 MSX", "Renault", "Kangoo", "Marrón", 1000, 3000, 300);
        Furgoneta f6 = new Furgoneta(655243512313485L, "2597 SAR", "Renault", "Kangoo", "Blanco", 1000, 3000, 300);
        Furgoneta f7 = new Furgoneta(755243512313485L, "5476 WNV", "Renault", "Kangoo", "Negro", 1000, 3000, 300);
        Furgoneta f8 = new Furgoneta(855243512313485L, "6182 KKE", "Renault", "Kangoo", "Verde", 1000, 3000, 300);
        Furgoneta f9 = new Furgoneta(955243512313485L, "4057 HHR", "Renault", "Kangoo", "Celeste", 1000, 3000, 300);
        Furgoneta f10 = new Furgoneta(101235512313485L, "7705 WZX", "Renault", "Kangoo", "Rosa", 1000, 3000, 300);

        //Instancio diez objetos tipo Turismo.
        Turismo t1 = new Turismo(5, false, 183548920102546L, "8194 NAU", "Seat", "Ibiza", "Rojo", 150);
        Turismo t2 = new Turismo(5, false, 283548920102546L, "9267 NRH", "Seat", "Ibiza", "Amarillo", 150);
        Turismo t3 = new Turismo(5, false, 383548920102546L, "2269 AXU", "Seat", "Ibiza", "Azul", 150);
        Turismo t4 = new Turismo(5, false, 483548920102546L, "4647 FQB", "Seat", "Ibiza", "Morado", 150);
        Turismo t5 = new Turismo(5, false, 583548920102546L, "4848 GYG", "Seat", "Ibiza", "Marrón", 150);
        Turismo t6 = new Turismo(5, false, 683548920102546L, "4736 JZT", "Seat", "Ibiza", "Blanco", 150);
        Turismo t7 = new Turismo(5, false, 783548920102546L, "1170 JTC", "Seat", "Ibiza", "Negro", 150);
        Turismo t8 = new Turismo(5, false, 883548920102546L, "8815 MYL", "Seat", "Ibiza", "Verde", 150);
        Turismo t9 = new Turismo(5, false, 983548920102546L, "2569 THB", "Seat", "Ibiza", "Celeste", 150);
        Turismo t10 = new Turismo(5, false, 109548920102546L, "9338 UNZ", "Seat", "Ibiza", "Rosa", 150);

        //Instancio diez objetos tipo Deportivo.
        Deportivo d1 = new Deportivo(350, 165489750231504L, "5492 JDV", "Ferrari", "LaFerrari", "Rojo", 900);
        Deportivo d2 = new Deportivo(350, 265489750231504L, "4681 LSO", "Ferrari", "LaFerrari", "Amarillo", 900);
        Deportivo d3 = new Deportivo(350, 365489750231504L, "0646 BLS", "Ferrari", "LaFerrari", "Azul", 900);
        Deportivo d4 = new Deportivo(350, 465489750231504L, "5920 WQS", "Ferrari", "LaFerrari", "Morado", 900);
        Deportivo d5 = new Deportivo(350, 565489750231504L, "2697 ACB", "Ferrari", "LaFerrari", "Marrón", 900);
        Deportivo d6 = new Deportivo(350, 665489750231504L, "7950 BMN", "Ferrari", "LaFerrari", "Blanco", 900);
        Deportivo d7 = new Deportivo(350, 765489750231504L, "8750 SAW", "Ferrari", "LaFerrari", "Negro", 900);
        Deportivo d8 = new Deportivo(350, 865489750231504L, "9840 SFH", "Ferrari", "LaFerrari", "Verde", 900);
        Deportivo d9 = new Deportivo(350, 965489750231504L, "2397 TYR", "Ferrari", "LaFerrari", "Celeste", 900);
        Deportivo d10 = new Deportivo(350, 102489750231504L, "6112 JBT", "Ferrari", "LaFerrari", "Rosa", 900);

        //Instancio una ArrayList en la que guardaré los Vehículos.
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        //Añado los Turismos a la listaVehiculos.
        listaVehiculos.add(t1);
        listaVehiculos.add(t2);
        listaVehiculos.add(t3);
        listaVehiculos.add(t4);
        listaVehiculos.add(t5);
        listaVehiculos.add(t6);
        listaVehiculos.add(t7);
        listaVehiculos.add(t8);
        listaVehiculos.add(t9);
        listaVehiculos.add(t10);

        //Añado los Deportivos a la listaVehiculos.
        listaVehiculos.add(d1);
        listaVehiculos.add(d2);
        listaVehiculos.add(d3);
        listaVehiculos.add(d4);
        listaVehiculos.add(d5);
        listaVehiculos.add(d6);
        listaVehiculos.add(d7);
        listaVehiculos.add(d8);
        listaVehiculos.add(d9);
        listaVehiculos.add(d10);

        //Añado las Furgonetas a la listaVehiculos.
        listaVehiculos.add(f1);
        listaVehiculos.add(f2);
        listaVehiculos.add(f3);
        listaVehiculos.add(f4);
        listaVehiculos.add(f5);
        listaVehiculos.add(f6);
        listaVehiculos.add(f7);
        listaVehiculos.add(f8);
        listaVehiculos.add(f9);
        listaVehiculos.add(f10);

        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "vehiculos.txt";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Vehiculo veh : listaVehiculos) {
                if (veh instanceof Turismo) {
                    flujo.write("0 - " + veh.getAtributos());
                    flujo.newLine();
                } else if (veh instanceof Deportivo) {
                    flujo.write("1 - " + veh.getAtributos());
                    flujo.newLine();
                } else {
                    flujo.write("2 - " + veh.getAtributos());
                    flujo.newLine();
                }
            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
