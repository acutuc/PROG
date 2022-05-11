package tarea7cgabrielallende;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Gabriel
 */
public class MainParteB {

    /*PARTE B

    Además, en otra clase que contenga otro método main y aplicando API Stream, realiza las siguientes acciones sobre la lista de objetos leídos desde el fichero:
    a) Obtener todos los registros de 1ESOA que no son de la asignatura MUS.
    b) Contar las horas que se imparten de la asignatura PROGR
    c) Obtener una lista con las iniciales del profesorado que imparte la asignatura REL, ordenadas en orden inverso al orden alfabético.
    d) Obtener en una lista las aulas donde imparte clase el profesor "JFV"
    e) Contar el número de asignaturas distintas que hay
    f) Contar el total de horas que se imparten a última hora de la mañana.
    g) Mostrar por consola los profesores que tienen clase a primera hora de la mañana.*/
    public static void main(String[] args) {
        //LEEMOS EL FICHERO, CÓDIGO COPIADO DEL MAIN PRINCIPAL
        //El fichero "horario.csv" estará en la  carpeta raíz del proyecto.
        String idFichero = "horario.csv";

        //Instancio nuevo ArrayList de Horario en la que iré almacenando todos los objetos generados.
        ArrayList<Horario> listaHorario = new ArrayList<>();

        //Variables que utilizaré en el try-with-resources
        String[] tokens;
        String linea;

        //Estructura try-with-resources para leer el fichero.
        try (Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(";");

                //Creo un Horario auxiliar en el que introduciré todos los datos mediante los setters.
                Horario aux = new Horario();

                //Introduzco los valores en el objeto. Con el método "replaceAll", paso por parámetro
                //el String que quiero reemplazar (primer valor), por el String que reemplaza (segundo valor).
                //En este caso el String resultante es una cadena vacía en todos los casos.
                aux.setNumIdentificativo(Integer.valueOf(tokens[0].replaceAll("\"", "")));
                aux.setCurso(tokens[1].replaceAll("\"", "").replaceAll(" ", ""));
                aux.setInicialesProf(tokens[2].replaceAll(" ", "").replaceAll("\"", ""));
                aux.setAsignatura(tokens[3].replaceAll(" ", "").replaceAll("\"", ""));
                //Si no hay aula, asignamos al objeto el valor de: ""
                if (tokens[4].replaceAll("\"", "").replaceAll(" ", "").equals("")) {
                    aux.setAula("\"\"");
                } else {
                    aux.setAula(tokens[4].replaceAll("\"", "").replaceAll(" ", ""));
                }
                aux.setDiaSemana(Integer.valueOf(tokens[5]));
                aux.setHora(Integer.valueOf(tokens[6].replaceAll("\"", "")));

                //Añadimos los objetos a la lista.
                listaHorario.add(aux);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //a) Obtener todos los registros de 1ESOA que no son de la asignatura MUS.
        List<Horario> a = listaHorario.stream()
                .filter(hor -> hor.getCurso().equals("1ESOA"))//se pueden poner en un filter() ambos filtrados.
                .filter(hor -> !hor.getAsignatura().equals("MUS"))
                .collect(Collectors.toList());
        System.out.println("a) Obtener todos los registros de 1ESOA que no son de la asignatura MUS");
        a.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");

        //b) Contar las horas que se imparten de la asignatura PROGR
        long b = listaHorario.stream()
                .filter(hor -> hor.getAsignatura().equals("PROGR"))
                .count();
        System.out.println("b) Contar las horas que se imparten de la asignatura PROGR");
        System.out.println(b);
        System.out.println("---------------------------------------------------------------------------");

        //c) Obtener una lista con las iniciales del profesorado que imparte la asignatura REL, ordenadas en orden inverso al orden alfabético.
        List<String> c = listaHorario.stream()
                        .filter(hor->hor.getAsignatura().equals("REL"))
                        .map(hor->hor.getInicialesProf())
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        System.out.println("c) Obtener una lista con las iniciales del profesorado que imparte la asignatura REL, ordenadas en orden inverso al orden alfabético");
        c.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");
        
        //d) Obtener en una lista las aulas donde imparte clase el profesor "JFV"
        List<String> d = listaHorario.stream()
                          .filter(hor->hor.getInicialesProf().equals("JFV"))
                          .map(hor->hor.getAula())
                          .distinct()
                          .collect(Collectors.toList());
        System.out.println("d) Obtener en una lista las aulas donde imparte clase el profesor \"JFV\"");
        d.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------");
        
        //e) Contar el número de asignaturas distintas que hay
        long e = listaHorario.stream()
                          .map(hor->hor.getAsignatura())
                          .distinct()
                          .count();
        System.out.println("e) Contar el número de asignaturas distintas que hay");
        System.out.println(e);
        System.out.println("---------------------------------------------------------------------------");
        
        //f) Contar el total de horas que se imparten a última hora de la mañana.
        long f = listaHorario.stream()
                .filter(hor->hor.getHora() == 7)
                .count();
        System.out.println("f) Contar el total de horas que se imparten a última hora de la mañana.");
        System.out.println(f);
        System.out.println("---------------------------------------------------------------------------");
        
        //g) Mostrar por consola los profesores que tienen clase a primera hora de la mañana.
        List<String> g = listaHorario.stream()
                         .filter(hor->hor.getHora() == 1)
                         .map(hor->hor.getInicialesProf())
                         .distinct()
                         .collect(Collectors.toList());
        System.out.println("g) Mostrar por consola los profesores que tienen clase a primera hora de la mañana.");
        g.forEach(System.out::println);
        
        
    }

}
