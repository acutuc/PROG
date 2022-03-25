
package ejerciciosestructurasseleccion;

import java.util.Scanner;

/**
 *
 * @author acu_t
 */
public class EjEjemplo2estructurasseleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*B. Saber si un carácter es un dígito, una letra mayúscula o una letra minúscula
	UNICODE:
		dígito: 48 – 57
		letra mayúscula: 65 – 90
		letra minúscula: 97 – 122*/
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca un caracter: "); 
        char letra = teclado.nextLine().charAt(0);
        
        // Usamos unint para guardar el unicode de ese char
        if (letra >= 48 && letra <=57){
            System.out.println("Es un dígito");
        }
        else if (letra >= 65 && letra <=90){
            System.out.println("Es una letra mayúscula");
        }
        else if (letra >= 97 && letra <=122){
            System.out.println("Es una letra minúscula");
        }
        else{
            System.out.println("No es ninguna de las peticiones solicitadas");
        }
        
        
    }
    
}
