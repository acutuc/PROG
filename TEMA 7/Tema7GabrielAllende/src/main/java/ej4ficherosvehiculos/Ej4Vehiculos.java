
package ej4ficherosvehiculos;

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
        Deportivo d1 = new Deportivo(350, 165489750231504L, "5449 QSK", "Ferrari", "LaFerrari", "Rojo", 900);
    }
    
}
