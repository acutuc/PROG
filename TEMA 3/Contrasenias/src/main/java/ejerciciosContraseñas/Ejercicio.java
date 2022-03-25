package ejerciciosContraseñas;

import java.util.Random;

public class Ejercicio {

    public static void main(String args[]) {
        //4 números (0...9) distintos.
        //La suma de los dígitos 1º y 4º = impar.
        //La multiplicación de los dígitos 2º y 3º = par.
        //Letra aleatoria enfre F-X.

        /*Declaro e inicializo las variables de los distintos números y letra que se generarán
        al azar, así como una boolean para controlar el bucle. */
        int numero1 = 0, numero2 = 0, numero3 = 0, numero4 = 0;
        char letra;
        boolean continuar;

        Random aleatorio = new Random();

        //Inicio bucle que generará claves hasta cumplir con la condición propuesta en el enunciado.
        do {
            numero1 = aleatorio.nextInt(10); //Se genera primer número (0-9)
            numero2 = aleatorio.nextInt(10); //Se genera segundo número (0-9)
            numero3 = aleatorio.nextInt(10); //Se genera tercer número (0-9)
            numero4 = aleatorio.nextInt(10); //Se genera cuarto número (0-9)
            letra = (char) (aleatorio.nextInt(88 - 70 + 1) + 70);
            /*Se genera letra
            aleatoria comprendida entre F y X, cogiendo su valor de la tabla ASCII del 70 (F)
            al 88 (X).
             */

            //Declaro e inicializo los dos filtros a cumplir.
            //Primer filtro. Que la suma resultante entre los números 1º y 4º sea IMPAR.
            int filtroSuma = numero1 + numero4;

            //Segundo filtro. Que la multiplicación resultante entre los números 2º y 3º sea PAR.             
            int filtroMultiplicacion = numero2 * numero3;
            System.out.println(numero1 + "" + numero2 + "" + numero3 + "" + numero4 + "" + letra);

            //Condición que cumpla ambos filtros anteriormente descritos.
            continuar = (filtroSuma % 2 != 0) && (filtroMultiplicacion % 2 == 0);
        } while (!continuar);

        //Impresión de los caracteres de manera continuada, emulando una contraseña.
    }

}
