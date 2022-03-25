
import java.util.Scanner;


public class AlgoritmosSecuenciales11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*11. Realiza un programa para calcular la distancia entre dos puntos
        en un plano cartesiano, a partir de las coordenadas de los mismos.
        Utiliza el teorema de Pitágoras.*/
        
        //Utilizo la clase Scanner.
        Scanner entradaTeclado = new Scanner(System.in);
        
        /*Mediante entrada por teclado, asigno coordenadas a los puntos A y B.
        en una variable constante.*/
        System.out.println("Coordenada X del punto A: ");
        int xA = entradaTeclado.nextInt();
        System.out.println("Coordenada Y del punto A: ");
        int yA = entradaTeclado.nextInt();
        System.out.println("Coordenada X del punto B: ");
        int xB = entradaTeclado.nextInt();
        System.out.println("Coordenada Y del punto B: ");
        int yB = entradaTeclado.nextInt();
        
        //Declaro e inicializo la variable constante asignada a la distancia recorrida
        double distancia = Math.sqrt((Math.pow((xB-xA),2)) + Math.pow((yB-yA),2));
        System.out.println("La distancia entre el punto A y el punto B es: "
        + distancia);

    }
    
}
