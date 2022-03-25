package ejerciciosbucle;

/**
 *
 * @author acutuc
 */
public class Ej01bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 2;
        //Este bucle se repite mientras x sea menor o igual que 100
        //Cuando x sea 101 se para el bucle
        while (x <= 100) {
            System.out.print(x);
            System.out.print(" - ");
            x = x + 1; // x++; ++x; x+=1
        }
    }

}
