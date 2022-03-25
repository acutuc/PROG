/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author carlos
 */
public class GestionHospital {

    private Hospital hospital;

    public GestionHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public static void main(String[] args) {

        ArrayList<Empleado> lista = crearListaEmpleados();
        
        for (Empleado empleado : lista) {
            if (empleado instanceof Natacion){
                ((Natacion) empleado).bucear();
            }
        }
        
        System.out.println("--------------- ORDEN DE INSERCIÓN ----------------");
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR Nº SEG. SOCIAL ----------------");
        lista.sort((e1, e2) -> e1.getNumeroSS().compareTo(e2.getNumeroSS()));
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR NOMBRE (A - Z) ----------------");
        lista.sort((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR APELLIDOS (A -Z) ----------------");
        lista.sort(criterioEmpleado("apellidos"));
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR DEFECTO SALARIO, DE MENOR A MAYOR ----------------");
        lista.sort(criterioEmpleado(""));
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR NOMBRE (Z - A) ----------------");
        lista.sort(criterioEmpleado("nombre").reversed());
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR SALARIO, DE MAYOR A MENOR ----------------");
        lista.sort(criterioEmpleado("").reversed());
        lista.forEach(System.out::println);

        System.out.println("--------------- ORDENACIÓN POR Nº SEG. SOCIAL ----------------");
        lista.sort(criterioEmpleado("numeross"));
        lista.forEach(System.out::println);

        System.out.println("--------------- BÚSQUEDA BINARIA POR Nº SEG. SOCIAL ----------------");
        Empleado aBuscar = new Empleado();
        aBuscar.setNumeroSS("39854");

        int posicion = Collections.binarySearch(lista, aBuscar, criterioEmpleado("numeross"));
        System.out.println("Posición en la lista: " + posicion);
        try{
            aBuscar = lista.get(posicion);
            System.out.println("Datos del empleado encontrado: \n" + aBuscar);
        } catch (IndexOutOfBoundsException ioobe){
            System.out.println("No existe ningún empleado con ese NºSS");
        }
        

        System.out.println("--------------- ORDENACIÓN POR DEFECTO (SALARIO, DE MENOR A MAYOR) ----------------");
        lista.sort(CompEmp.SALARIO.getComp());
        lista.forEach(System.out::println);
        
        
        System.out.println("--------------- ORDENACIÓN POR DEFECTO (SALARIO) Y POR NOMBRE A-Z ----------------");
        lista.sort(CompEmp.SALARIO.getComp().thenComparing(CompEmp.NUMEROSS.getComp()));
        lista.forEach(System.out::println);
        
        System.out.println("--------------- ORDENACIÓN POR DEFECTO (SALARIO) Y POR NOMBRE Z-A ----------------");
        lista.sort(CompEmp.SALARIO.getComp().thenComparing(CompEmp.NOMBRE.getComp().reversed()));
        lista.forEach(System.out::println);
        // Se crea el hospital
        // Se da la opción de crear pacientes, crear médicos o administrativos
        // Ingresar pacientes y añadir administrativos, médicos al hospital
        // Recorremos la lista completa de empleados
        //  Llamamos a calcularIRPF de cada empleado
        // Si es un médico trate a un paciente y si es un administrativo registre un documento
        // Indicar donde hay conversiones explícitas e implícitas de tipos de datos
//        
    }

    public static ArrayList<Empleado> crearListaEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        // Conversiones implícitas
        lista.add(new Senador(0, "Málaga", "Los verdes", "4112233", 100, "Luis", "Molina", new Nif()));
        lista.add(new Senador(1, "Sevilla", "Los azules", "1223311", 100, "Lucas", "Barroso", new Nif()));
        lista.add(new Diputado("A1", "Málaga", "Los verdes", "3332233", 100, "María", "Hernández", new Nif()));
        lista.add(new Diputado("A2", "Málaga", "Los verdes", "0512233", 100, "Virginia", "Pérez", new Nif()));
        lista.add(new Medico("Cardiología", "9998887", 2500, "Héctor", "Casas", new Nif()));
        lista.add(new Medico("Pediatría", "7998887", 2200, "Cristina", "López", new Nif()));
        lista.add(new Administrativo("B", "0987654", 1200, "Antonio", "Morales", new Nif()));
        lista.add(new Administrativo("C", "3987654", 1100, "Inma", "Luján", new Nif()));
        return lista;
    }

    public static Comparator<Empleado> criterioEmpleado(String criterio) {
        criterio = criterio.toUpperCase();

        switch (criterio) {
            case "NOMBRE":
                return (Empleado e1, Empleado e2) -> e1.getNombre().compareTo(e2.getNombre());
            case "NUMEROSS":
                return (Empleado e1, Empleado e2) -> e1.getNumeroSS().compareTo(e2.getNumeroSS());
            case "APELLIDOS":
                return (Empleado e1, Empleado e2) -> e1.getApellidos().compareTo(e2.getApellidos());
            default:
                return (Empleado e1, Empleado e2) -> (int) (e1.getSalario() - e2.getSalario());
        }
    }
}
