
package ejerciciosbucle;

/**
 *
 * @author acutuc
 */
public class Ej04bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*4.- Intenta averiguar qué realiza el siguiente programa, sin implementarlo.
        Implementa el programa en el entorno y compara tus resultados con la ejecución.*/
        
        int numero = 1;
         
          while (numero < 11)
          {
               System.out.println("Número: " + numero);
               numero++;
          }
          do {
               System.out.println("Número: " + --numero);
          } while(numero > 1);
   	  }
	}

