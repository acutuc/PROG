package tarea7agabrielallende;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author acutuc
 */
public class UtilsStream {
    //A partir de una lista de empleados y un nombre, indique si hay algún empleado con ese nombre.
    public static boolean hayEmpleado(ArrayList<Empleado> listaEmpleados, String nomEmpleado) {
        boolean hayEmpleado = listaEmpleados.stream()
                .anyMatch(emp->emp.getNomEmpleado().equalsIgnoreCase(nomEmpleado));
        return hayEmpleado;
    }

    //A partir de una lista de empleados y un nombre de departamento, indique el número de empleados Coordinadores de ese departamento.
    public static long coordinadoresPorDepartamento(ArrayList<Empleado> listaEmpleados, String nomDpto) {
        long coordinadoresPorDepartamento = listaEmpleados.stream()
                .filter(dep->dep.getPuesto().equalsIgnoreCase(nomDpto))
                .filter(dep->dep.isCoordinador())
                .count();
        return coordinadoresPorDepartamento;
    }

    /*A partir de una lista de empleados y una letra del NIF (char),
    obtener una nueva lista ordenada alfabéticamente SOLO con los apellidos de los empleados cuyo NIF contenga esa letra.*/
     public static List<String> listaLetraNIF(ArrayList<Empleado> empleados, char letra) {
         List<String> listaLetraNIF = empleados.stream()
                 .filter(emp->emp.getNomEmpleado().contains(String.valueOf(letra)))
                 .map(emp->emp.getNomEmpleado())
                 .sorted()
                 .collect(Collectors.toList());
         return listaLetraNIF;
    }
    
    /*A partir de una lista de empleados y una fecha, obtener una nueva lista con los NIF
    (ordenados de forma inversa) de todos los empleados cuya toma de posesión coincida con esa fecha.*/
    public static List<String> obtenerListaFecha(ArrayList<Empleado> empleados, LocalDate fechaPosesion) {
        List<String> listaNIF = empleados.stream()
                .filter(emp->emp.getFecIniPuesto().isEqual(fechaPosesion))
                .map(emp->emp.getNumIdentificativo())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return listaNIF;
    }
}
