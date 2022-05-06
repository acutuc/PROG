package tarea7cgabrielallende;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Gabriel
 */
public class Main {

    /*Abre el fichero CSV adjunto y estudia su contenido. Este fichero ha sido generado con un programa específico que genera horarios del profesorado de un centro educativo. Como puedes comprobar, este archivo tiene los campos separados por punto y coma.

Las columnas son:

 - número identificativo de la fila (no es significativo, se puede ignorar),

 - curso implicado (1ESOA, ..., 1DAW, 2DAW, etc),

 - iniciales del profesor,

 - asignatura que se imparte,

 - aula, si esa hora no tiene aula queda entre comillas vacías

 - día de la semana (1 Lunes, 2 Martes, 3 Miércoles, etc.) y

 - la hora del día asignada:
        - 1 es 1ª hora, 
        - 2 es 2ª hora, 
        - 3 es 3ª hora, 
        - 5 es la 4ª hora,
        - 6 es la 5ª hora,
        - 7 es la 6ª hora,
La hora 4 no existe por ser el recreo y el resto de horas (de 8 en adelante) se pueden ignorar por ser el horario de tarde, que en nuestro caso no vamos a tener en cuenta.

Cada registro del fichero representa una hora de clase semanal en el instituto, de forma que, por ejemplo, la fila
13;"2ESOB";"IBR ";"AMBLS";"408 ";1;1 representa la primera hora (1) del lunes (1) de 2ESOB que tiene el profesor IBR en el aula 408 y la asignatura impartida es AMBLS.

Presta atención a las dobles comillas que hay en los campos de texto, que deben ser quitadas a la hora de ir guardando los distintos datos en los objetos. Si hay espacios en blanco en los campos de texto también se deben quitar. Todos los datos se pueden guardar en modo texto, excepto los números de día y hora. 

Crea un nuevo proyecto Maven, llamado tarea7c+tunombre. Implementa una aplicación que permita consultar el horario semanal de cualquier unidad (1ESOA, 1ESOB, etc) o de cualquier profesor/a. Para ello, una vez leído el fichero desde la carpeta raíz del proyecto, se procederá a almacenar la información de la siguiente forma:
1. Todos los registros se guardarán en una lista de objetos POJO, cuya clase se ha de crear para tal efecto. El nombre de la clase lo decides tú, pero debe ser significativo. Una vez guardados los objetos en la lista, ésta debe quedar ordenada primero por día y luego por hora.

2. El conjunto de grupos y de iniciales de profesores se guardarán en dos estructuras SET, ya que no debe haber duplicados. Estas estructuras deben estar ordenadas siguiendo el orden alfabético. 
3. Otras estructuras de datos auxiliares que estimes convenientes, siempre y cuando esté debidamente justificado su uso.


A PARTIR DE ESTE PUNTO, EN NINGÚN CASO SE DEBE LEER DE NUEVO EL FICHERO CSV, PUESTO QUE LA INFORMACIÓN YA ESTÁ EN LAS ESTRUCTURAS DE DATOS.
PARTE A
Cuando toda la información esté en las estructuras de datos, la aplicación proporciona dos opciones:
a) Consultar horarios por profesor/a.
b) Consultar horarios por grupo.


Si el usuario selecciona a), el programa mostrará las iniciales del profesorado, para que el usuario elija una. Una vez proporcionada la inicial por parte del usuario, el programa guardará en un fichero json, en la raíz del proyecto, el horario seleccionado, si existe, volcando el objeto POJO en el archivo, al igual que hicimos con el ejercicio de las app. El nombre del fichero estará compuesto por las iniciales del profesor en cuestión y la extensión del archivo. Por ejemplo, para el profesor JCF, el archivo se llamará JCF.json. 

Si el usuario selecciona b), el programa mostrará los grupos que hay en el instituto, para que el usuario elija uno. Una vez proporcionado el grupo, el programa guardará en un fichero csv, en la raíz del proyecto, el horario seleccionado, si existe. El nombre del fichero estará compuesto por las iniciales del grupo en cuestión y la extensión del archivo. Por ejemplo, para el grupo 1DAW, el archivo se llamará 1DAW.csv.

PARTE B

Además, en otra clase que contenga otro método main y aplicando API Stream, realiza las siguientes acciones sobre la lista de objetos leídos desde el fichero:
a) Obtener todos los registros de 1ESOA que no son de la asignatura MUS.
b) Contar las horas que se imparten de la asignatura PROGR
c) Obtener una lista con las iniciales del profesorado que imparte la asignatura REL, ordenadas en orden inverso al orden alfabético.
d) Obtener en una lista las aulas donde imparte clase el profesor "JFV"
e) Contar el número de asignaturas distintas que hay
f) Contar el total de horas que se imparten a última hora de la mañana.
g) Mostrar por consola los profesores que tienen clase a primera hora de la mañana.*/
    public static void main(String[] args) throws FileNotFoundException, IOException {
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

        //Imprimimos la lista por pantalla.
        System.out.println("IMPRIMIENDO LISTA ORIGINAL:");
        listaHorario.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");

        //Ordenamos la lista por día y luego por hora.
        Collections.sort(listaHorario, Comparator.comparing(Horario::getDiaSemana).thenComparing(Horario::getHora));
        System.out.println("IMPRIMIENDO LISTA ORDENADA POR LOS CRITERIOS ESTABLECIDOS EN EL ENUNCIADO:");
        listaHorario.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");

        //Guardo los grupos en una estructura Set. Con TreeSet los ordeno alfabéticamente por orden natural.
        Set<String> gruposSet = new TreeSet<>();
        for (Horario hor : listaHorario) {
            gruposSet.add(hor.getCurso());
        }
        //Imprimimos la estructura de almacenamiento Set.
        System.out.println("IMPRIMIENDO LOS GRUPOS EN LA ESTRUCTURA SET:");
        gruposSet.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");

        //Hacemos lo mismo pero con las iniciales de los profesores:
        Set<String> inicialesSet = new TreeSet<>();
        for (Horario hor : listaHorario) {
            inicialesSet.add(hor.getInicialesProf());
        }

        System.out.println("IMPRIMIENDO LAS INICIALES DE PROFESORES EN LA ESTRUCTURA SET:");
        inicialesSet.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");

        //PROCEDEMOS CON LA PARTE A:
        //Array para utilizar en el JOptionPane.
        String[] arrayOpciones = {"Consultar horarios por profesor/a", "Consultar horarios por grupo", "Salir"};

        //Variable auxiliar para salir del bucle.
        boolean aux = true;

        //Copio los Set en un Array de Strings, para proseguir con el ejercicio, utilizando JOptionPane.
        //Array de iniciales de profesor
        String[] arrayInicialesProfesor = Arrays.copyOf(inicialesSet.toArray(), inicialesSet.size(), String[].class);
        //Array de aulas
        String[] arrayGrupo = Arrays.copyOf(gruposSet.toArray(), gruposSet.size(), String[].class);
        //Variable que utilizaré dentro del bucle do-while.
        String opcion = "";
        do {
            int opcionesInt = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "ELEGIR", 0, 1, null, arrayOpciones, null);
            if (opcionesInt == 0) {
                //Conversión explícita de Object a String.
                opcion = (String) JOptionPane.showInputDialog(null, "Elija a un profesor: ", "ELEGIR", JOptionPane.QUESTION_MESSAGE, null, arrayInicialesProfesor, null);
                System.out.println("El profesor elegido es: " + opcion);
                //Declaro la variable en la que almacenaré la ruta del fichero JSON, con las iniciales del profesor.
                String idFicheroJson = opcion + ".json";
                //Instancio nuevo ArrayList en el que almacenaré todos los objetos
                ArrayList<Horario> guardarEnJSON = new ArrayList<>();
                //En un bucle for, recorro la estructura ArrayList en la que tengo almacenado los
                //profesores con sus atributos, comparando el atributo inicialesProf con el String devuelto tras haber
                //hecho una elección en el JOptionPane.
                for (Horario hor : listaHorario) {
                    if (hor.getInicialesProf().equals(opcion)) {
                        guardarEnJSON.add(hor);
                    }
                    ObjectMapper mapeador = new ObjectMapper();

                    // Permite a mapeador usar fechas según java time
                    mapeador.registerModule(new JavaTimeModule());

                    // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
                    mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

                    // Escribe en un fichero JSON el objeto String.
                    mapeador.writeValue(new File(idFicheroJson), guardarEnJSON);
                }
                //Salimos del bucle.
                aux = false;
                

            } else if (opcionesInt == 1) {
                opcion = (String) JOptionPane.showInputDialog(null, "Elija un grupo: ", "ELEGIR", JOptionPane.QUESTION_MESSAGE, null, arrayGrupo, null);
                System.out.println("El grupo elegido es: " + opcion);
                //Declaro la variable en la que almacenaré la ruta del fichero csv, con el dato del aula seleccionada.
                String idFicheroCSV = opcion + ".csv";
                //Instancio nuevo ArrayList en el que almacenaré todos los objetos
                ArrayList<Horario> guardarEnCSV = new ArrayList<>();
                //En un bucle for, recorro la estructura ArrayList en la que tengo almacenado los
                //objetos tipo Horario, comparando el String del atributo curso, con el devuelto tras haber
                //hecho una elección en el JOptionPane.
                for (Horario hor : listaHorario) {
                    if (hor.getCurso().equals(opcion)) {
                        guardarEnCSV.add(hor);
                    }
                }
                //Escribimos en un fichero CSV el objeto String seleccionado en el JOptionPane
                try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroCSV))) {
                    for (Horario h : guardarEnCSV) {
                        flujo.write(h.toString());
                        flujo.newLine();
                    }
                    // Metodo flush() guarda cambios en disco 
                    flujo.flush();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Fichero " + idFicheroCSV + " creado correctamente.");
                //Salimos del bucle.
                aux = false;
                

            } else { //Si elegimos salir en el JOptionPane.
                //Salimos del bucle.
                aux = false;
            }
        } while (aux);

    }

}
