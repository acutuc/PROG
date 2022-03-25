
package Random;
import java.util.Random;
/**
 *
 * @author acutuc
 */
public class MathRandom {

   
    public static void main(String[] args) {
        Random numAleatorio = new Random();
        //Número aleatorio entre 25 y 75.
        int n = numAleatorio.nextInt(75-25+1)+25;
        //(Mayor - Menor + 1) + Menor;
        
        //0 a 100 --> nextInt(101);
        //20 a 45 --> nextInt(45-20+1) + 20;
        System.out.println("Número aleatorio: " + n);
    }
    
}
