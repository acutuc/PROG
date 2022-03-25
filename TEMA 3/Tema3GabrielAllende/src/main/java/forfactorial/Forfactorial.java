
package forfactorial;

import java.util.Scanner;

public class Forfactorial {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca un numero para calcular su factorial:");
        int factorial=1;
        int numeroAcalcular= entrada.nextInt();        
        for(int i=1; i<=numeroAcalcular;i++){
        factorial=i*factorial;
        }
        System.out.println("El factorial de "+numeroAcalcular+" es --> "+factorial);
    }
}