
import java.util.Scanner;
import javax.swing.JOptionPane;


public class repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DECLARACIÓN DE VARIABLES
        int var1, var2;
        //camelCase
        double estaturaPersona;
        //INICIALIZACIÓN DE VARIABLES
        var1 = 12;
        var2 = 14;
        
        //DECLARACIÓN E INICIALIZACIÓN
        float pesoPersona = 67.6f;
        long millonesQueMeVaisAPagar = 23_000_000_000l;
        
        //CONSTANTES
        final boolean SIEMPRE_SI = true;
        //Al ser constante no puede cambiar su valor
        //SIEMPRE_SI = false;
        
        //LOS VALORES CONCRETOS DE UN TIPO DE DATOS SON LITERALES.
        long numero1 = 23; // int-->long (conversión implícita)
        long numero2= (long)23; //Conversión epxlícita
        
        double expresion = var1/(double)var2;
        expresion = Math.ceil(3.4); //ceil redondea hacia arriba.
        expresion = Math.floor(4.9); //floor redondea hacia abajo.
        expresion = Math.round(4.2); //redondeo normal
        /*
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el peso de la persona: ");
        pesoPersona = teclado.nextFloat();
        System.out.println("Introduce la estatura de la persona: ");
        estaturaPersona = teclado.nextDouble();
        // Con Scanner, despues de leer números hay que limpiar la variable
        teclado.nextLine();
        System.out.println("Introduce tu nombre: ");
        String nombrePersona = teclado.nextLine();
        
        System.out.println("Peso: " + pesoPersona + "Estatura: " + estaturaPersona);
        double indiceMasaCorporal = pesoPersona / Math.pow(estaturaPersona, 2);
        //IMC = peso (kg) / estatura (m2)
        System.out.println("Tu IMC es: " + indiceMasaCorporal);
        System.out.printf("%s Tu IMC es: %.2f", nombrePersona, indiceMasaCorporal);
        */
        //LECTURA CON JOptionPane
        String apellido = JOptionPane.showInputDialog("Introduce tu apellido: ");
        System.out.println(apellido);
        String dinerosTexto = JOptionPane.showInputDialog("Introduce el dinero para sobornar al de programación: ");
        double dineros = Double.parseDouble(dinerosTexto);
        System.out.println("El profe va a recibir " + (12*dineros) + " al año");
        JOptionPane.showMessageDialog(null, "El profe va a recibir " + (12*dineros) + " al año");
        
        
    }
    
}
