
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class EntradaDeDatosPorTeclado {

    public static void main(String args[]) {

        // Inicialización de la instancia de Scanner con el flujo de
        // entrada del teclado
        Scanner entradaTeclado = new Scanner(System.in);
        System.out.println("¿Cómo te llamas?");
        String nombre = entradaTeclado.nextLine();

        System.out.println("¿Qué día naciste?");
        int diaNacimiento = entradaTeclado.nextInt();
        //Si quisiera guardar un String después de un número (da igual qué tipo de dato que sea)
        //limpio el buffer poniendo entradaTeclado.nextLine();

        System.out.println("¿En qué mes?");
        int mesNacimiento = entradaTeclado.nextInt();

        System.out.println("¿En qué año?");
        int anioNacimiento = entradaTeclado.nextInt();

        System.out.println("Hola " + nombre + ", naciste el "
                + diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento);

        //Uso del JOption
        String texto;

        //Para meter datos por teclado
        texto = JOptionPane.showInputDialog(null, "Introduce algo por teclado");

        //Para mostrar un mensaje mediante ventana emergente
        JOptionPane.showMessageDialog(null, texto);

    }

}
