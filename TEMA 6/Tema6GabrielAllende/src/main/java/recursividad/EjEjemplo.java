package recursividad;

/**
 *
 * @author acutuc
 */
public class EjEjemplo {

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int numero) {
        numero = Math.abs(numero);
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * factorial(--numero);
        }
    }
}
