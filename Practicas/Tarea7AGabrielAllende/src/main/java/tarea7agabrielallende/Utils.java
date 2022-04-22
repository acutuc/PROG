package tarea7agabrielallende;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author acutuc
 */
public class Utils {

    //A partir de una lista de empleados y un nombre, indique si hay algún empleado con ese nombre.
    public static boolean hayEmpleado(ArrayList<Empleado> listaEmpleados, String nomEmpleado) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getNomEmpleado().equals(nomEmpleado)) {
                return true;
            }
        }
        return false;
    }

    //A partir de una lista de empleados y un nombre de departamento, indique el número de empleados Coordinadores de ese departamento.
//    public int coordinadoresPorDepartamento(ArrayList<Empleado> listaEmpleados, String nomDpto) {
//        int contadorCoordinadores = 0;
//        Map<String, Integer> coordinadoresPorDpto = new TreeMap<>();
//        for (Empleado emp : listaEmpleados) {
//            if (emp.getPuesto().equals(nomDpto)) {
//
//            }
//        }
//    }

    /*A partir de una lista de empleados y una letra del NIF (char),
    obtener una nueva lista ordenada alfabéticamente SOLO con los apellidos de los empleados cuyo NIF contenga esa letra.*/
    public static ArrayList<String> listaLetraNIF(ArrayList<Empleado> listaEmpleados, char letra) {
        //Array de char en la que almacenaré los toCharArray.
        char[] arrayLetras;
        //Instanciación de la nueva lista que devolverá el método.
        ArrayList<String> apellidoLetraNIF = new ArrayList<>();
        int num = 0;
        int num2 = 0;
        letra = (char) num;
                

        /*Bucle que recorre la lista pasada por parámetro, de la cual coge el número identificativo
        (DNI/Pasaporte) de cada empleado y las almacena en el array de char.
        Hace lo mismo con 
         */
        for (Empleado emp : listaEmpleados) {
            arrayLetras = emp.getNumIdentificativo().toCharArray();
            for (int i = 0; i < arrayLetras.length; i++) {
                arrayLetras[i] = (char) num2;
                if(num == num2){
                    apellidoLetraNIF.add(emp.getNomEmpleado());
                }
            }
        }
        //Ordeno por apellidos (nombre en mi caso, no los tengo separados).
        Comparator<String> criterioApellido = (e1, e2) -> e1.compareTo(e2);
        Collections.sort(apellidoLetraNIF, criterioApellido);
        
        return apellidoLetraNIF;
    }
    
    /*A partir de una lista de empleados y una fecha, obtener una nueva lista con los NIF
    (ordenados de forma inversa) de todos los empleados cuya toma de posesión coincida con esa fecha.*/
    
}
