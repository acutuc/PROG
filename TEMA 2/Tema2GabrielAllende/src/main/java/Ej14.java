
import java.util.Scanner;


public class Ej14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*14.- Crea una nueva clase llamada Ej14, que contenga una llamada al
        método public static void main(String[] args). El programa tendrá una
        variable entera tiempo inicializada con un valor leído por teclado, en
        segundos, y queremos conocer este tiempo pero expresado en horas,
        minutos y segundos, mostrando los resultados por pantalla.*/
        
        //Para leer por teclado, utilizo la clase Scanner.
        Scanner teclado = new Scanner(System.in);
        
        //Pido cantidad de segundos y lo guardo en la constante mediante el teclado.
        System.out.println("Segundos: ");
        int tiempo = teclado.nextInt();
        
        /*Realizo las conversiones a minutos, horas y segundos, para mostrarlos
        en pantalla*/
        int minutos = tiempo / 60;
        int segundosRestantes = tiempo % 60;
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        
        System.out.println("Horas: " + horas + "\nMinutos: " + minutosRestantes + "\nSegundos: " + segundosRestantes);
        
    }
    
}
