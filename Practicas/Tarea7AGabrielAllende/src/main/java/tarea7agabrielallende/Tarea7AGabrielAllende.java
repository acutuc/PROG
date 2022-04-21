package tarea7agabrielallende;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author acutuc
 */
public class Tarea7AGabrielAllende {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Nombre del fichero        
        String idFichero = "RelPerCen.csv";
        //Nombre del fichero en el que volcaré los datos del Map.
        String profesoresPorDepartamento = "profesoresPorDepartamento.csv";
        //Nombre del fichero en el que volcaré los profesores que hayan trabajado más de 100 días.
        String profesoresCienDiasTrabajados = "profesoresCienDiasTrabajados.csv";

        // Variables para guardar los datos que se van LEYENDO.
        String[] tokens;
        String linea;
        //Variable que utilizaré para ESCRIBIR en los ficheros.
        String tmp;
        
        //Lista de Empleados inicializada.
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        System.out.println("Leyendo el fichero: " + idFichero);
        
        //try-with-resources para leer el fichero "RelPerCen.csv".
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            //Omito la primera línea (encabezado de atributos en el CSV)
            datosFichero.nextLine();
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                //Con el valor '1', suprimo las comillas dobles de la primera posición de la línea.
                //Con el valor 'linea.length()-1' suprimo las comillas dobles de la última posición de la línea.
                tokens = linea.substring(1, linea.length() - 1).split("\",\"");

                //Creo un Empleado auxiliar en el que introduciré todos los datos mediante los setters.
                Empleado aux = new Empleado();
                //Almaceno en cada atributo, la posición del array de tokens
                aux.setNomEmpleado(tokens[0]);
                aux.setNumIdentificativo(tokens[1]);
                aux.setPuesto(tokens[2]);
                if (!tokens[3].equals("")) {
                    aux.setFecIniPuesto(LocalDate.parse(tokens[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                if (!tokens[4].equals("")) {
                    aux.setFecCesePuesto(LocalDate.parse(tokens[4], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                aux.setTelefono(tokens[5]);
                aux.setEvaluador(Boolean.getBoolean(tokens[6]));
                aux.setCoordinador(Boolean.getBoolean(tokens[7]));
                listaEmpleados.add(aux);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
        //Imprimo el ArrayList de Empleados
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------"
                + "\nIMPRIMIENDO LISTA DE EMPLEADOS:\n------------------------------------------------------------------------------------------------------------------------------");
        for (Empleado emp : listaEmpleados) {
            System.out.println(emp.toString());
        }
        
        //Cantidad de profesores, utilizando el método size de la clase ArrayList.
        System.out.println("\nCANTIDAD DE PROFESORES: " + listaEmpleados.size());

        //Imprimo el Map con la cantidad de profesores por departamento.
        System.out.println("\n----------------------------------------------------------"
                + "\nIMPRIMIENDO EL MAP: ");
        imprimirMap(profesoresPorDepartamento(listaEmpleados));

        //try-with-resources para crear/escribir en el fichero "profesoresPorDepartamento.csv".
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(profesoresPorDepartamento))) {
            //Bucle en el que por cada iteración de puestos, asigno el keyset correspondiente de cada empleado
            //(en este caso es la cantidad de empleados).
            for (String puesto : profesoresPorDepartamento(listaEmpleados).keySet()) {
                //Vuelco los datos escritos en el fichero.
                flujo.write(puesto + "\t" + profesoresPorDepartamento(listaEmpleados).get(puesto));
                //Salto de línea.
                flujo.newLine();
            }
            //Almaceno los datos.
            flujo.flush();
            System.out.println("\nFichero " + profesoresPorDepartamento + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        //try-with-resources para crear/escribir en el fichero "profesoresCienDiasTrabajados.csv".
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(profesoresCienDiasTrabajados))) {
            //Bucle en el que por cada empleado de la lista, que haya trabajado más de 100 horas, 
            //se vuelque en el fichero.
            for (Empleado emp : listaEmpleados) {
                //
                if(emp.getFecCesePuesto() != null && ChronoUnit.DAYS.between(emp.getFecIniPuesto(), emp.getFecCesePuesto()) > 100 ||
                        (emp.getFecCesePuesto() == null && ChronoUnit.DAYS.between(emp.getFecIniPuesto(), LocalDate.now()) > 100)){
                    //Escribo en el fichero.
                    flujo.write(emp.toString());
                    //Salto de línea.
                    flujo.newLine();
                }
            }
            //Almaceno los datos
            flujo.flush();
            System.out.println("\nFichero " + profesoresCienDiasTrabajados + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Método que devuelve un Map.
    public static Map<String, Integer> profesoresPorDepartamento(ArrayList<Empleado> listaEmpleados) {
        //Creo el Map vacío para hacer el return con los datos implementados.
        Map<String, Integer> map = new TreeMap<>();
        //Recorro con un bucle for la lista de Empleados
        for (Empleado emp : listaEmpleados) {
            //Declaro un int en el que almacenaré los datos.
            int cantidadEmpleados = 1;
            for (Empleado empleado : listaEmpleados) {
                if (emp.getPuesto().equals(empleado.getPuesto()) && emp != empleado) {
                    cantidadEmpleados++;
                }
            }
            //Almaceno en el map el puest (String) y la cantidad de empleados (Integer).
            map.put(emp.getPuesto(), cantidadEmpleados);
        }
        return map;
    }

    public static void imprimirMap(Map<String, Integer> map) {
        map.forEach((clave, valor) -> System.out.println(clave + " ----- " + valor));
    }
}

