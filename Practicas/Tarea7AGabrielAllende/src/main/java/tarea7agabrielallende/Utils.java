package tarea7agabrielallende;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author acutuc
 */
public class Utils {

    //A partir de una lista de empleados y un nombre, indique si hay algún empleado con ese nombre.
    public static boolean hayEmpleado(ArrayList<Empleado> listaEmpleados, String nomEmpleado) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getNomEmpleado().equalsIgnoreCase(nomEmpleado)) {
                return true;
            }
        }
        return false;
    }

    //A partir de una lista de empleados y un nombre de departamento, indique el número de empleados Coordinadores de ese departamento.
    public int coordinadoresPorDepartamento(ArrayList<Empleado> listaEmpleados, String nomDpto) {
        int contadorCoordinadores = 0;
        for (Empleado emp : listaEmpleados) {
            if(emp.getPuesto().equalsIgnoreCase(nomDpto) && emp.isCoordinador()){
                contadorCoordinadores++;
            }
        }
        return contadorCoordinadores;
    }

    /*A partir de una lista de empleados y una letra del NIF (char),
    obtener una nueva lista ordenada alfabéticamente SOLO con los apellidos de los empleados cuyo NIF contenga esa letra.*/
     public static ArrayList<String> listaLetraNIF(ArrayList<Empleado> empleados, char letra) {
        ArrayList<String> listaNombres = new ArrayList<>();

        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNumIdentificativo().contains(String.valueOf(letra)) || empleados.get(i).getNumIdentificativo().contains(String.valueOf(letra).toUpperCase())) {
                listaNombres.add(empleados.get(i).getNomEmpleado());
            }
        }

        Collections.sort(listaNombres);
        return listaNombres;
    }
    
    /*A partir de una lista de empleados y una fecha, obtener una nueva lista con los NIF
    (ordenados de forma inversa) de todos los empleados cuya toma de posesión coincida con esa fecha.*/
    public static ArrayList<String> obtenerListaFecha(ArrayList<Empleado> empleados, LocalDate fechaPosesion) {
        ArrayList<String> listaDni = new ArrayList<>();

        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getFecIniPuesto().equals(fechaPosesion)) {
                listaDni.add(empleados.get(i).getNumIdentificativo());
            }
        }

        Collections.sort(listaDni);
        Collections.reverse(listaDni);
        return listaDni;
    }
}
