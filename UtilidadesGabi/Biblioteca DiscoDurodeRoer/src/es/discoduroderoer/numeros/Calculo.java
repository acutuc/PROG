package es.discoduroderoer.numeros;

import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Calculo {

    /**
     * Devuelve el factorial de un número
     *
     * @param num Número
     * @return Factorial del número
     */
    public static int factorial(int num) {

        int producto = num;
        for (int i = num - 1; i > 0; i--) {
            producto *= i;
        }

        return producto;
    }

    /**
     * Devuelve el factorial de un número de forma recursiva
     *
     * @param num Numero a calcular
     * @return Factorial del numero indicado
     */
    public static int factorialRec(int num) {

        int res;

        if (num == 1) {
            //Se termina la recursión
            return 1;
        } else {
            //Se llama asi misma la funcion, con el valor del numero menos 1
            res = num * factorialRec(num - 1);
        }

        //Devolvemos el valor
        return res;

    }

    /**
     * Devuelve la suma de un numero a 1
     *
     * @param numero Numero donde empieza la suma
     * @return Suma de 1 a ese numero
     */
    public static int sumaRec(int numero) {

        int res;

        if (numero == 1) {
            //Se termina la recursion
            return 1;
        } else {
            //Se llama a si misma la función con el parametro numero menos 1
            res = numero + sumaRec(numero - 1);
        }

        //Devuelve el resultado
        return res;
    }

    /**
     * Devuelve la suma los pares desde el numero pasado a 1
     *
     * @param numero Numero donde comienza
     * @return La suma del numero que comienza al 1, solo pares
     */
    public static int sumaParesRec(int numero) {

        int res;

        if (numero <= 0) {
            //Se termina la recursion
            return 0;
        } else {
            //Se llama a si misma la función con el parametro numero menos 1

            if (numero % 2 == 0) {
                res = numero + sumaParesRec(numero - 2);
            } else {
                res = sumaParesRec(numero - 1);
            }

        }

        //Devuelve el resultado
        return res;
    }

    /**
     * Suma los digitos de un numero
     *
     * @param numero Suma los digitos
     * @return Suma de los digitos
     */
    public static int sumaDigitosRec(int numero) {

        if (numero < 10) { //caso base
            return numero; //devuelvo el numero
        } else {
            return (numero % 10) + sumaDigitosRec(numero / 10); //Cojo el digito y llamo a la funcion
        }

    }

    /**
     * Resuelve una ecuación de 2º grado
     *
     * @param a Valor de A
     * @param b Valor de B
     * @param c Valor de C
     * @return Resultado de la ecuación
     */
    public static double[] ecuacion2Grado(int a, int b, int c) {

        if ((Math.pow(b, 2) - (4 * a * c)) >= 0) {

            double soluciones[] = new double[2];

            soluciones[0] = ((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);

            soluciones[1] = ((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);

            return soluciones;
        } else {
            JOptionPane.showMessageDialog(null, "La ecuacion no se puede resolver");
            return null;
        }

    }

    /**
     * Indica si un numero es potencia de otro
     *
     * @param numero Número que queremos saber si es el resultado de una
     * potencia
     * @param potencia Potencia
     * @return True = el número es potencia del parámetro potencia
     */
    public static boolean esPotenciaDe(int numero, int potencia) {

        if (potencia > 1) {

            int contador = -1;
            int aux = numero;

            for (int i = aux; i > 0; i = (int) Math.floor(i) / potencia) {
                contador++;
            }

            return numero == Math.pow(potencia, contador);

        } else {
            return potencia >= 0;

        }

    }

    /**
     * Devuelve la potencia de un numero recursivamente
     * 
     * @param base Base del numero
     * @param exponente Exponente a elevar
     * @return Base elevado al exponente
     */
    public static double potenciaRec(int base, int exponente) {

        if (exponente == 0) { //caso base
            return 1; //10^0 = 1

        } else {  //Exponente positivo
            return base * potenciaRec(base, exponente - 1);
        }

    }

    /**
     * Devuelve el exponente de un número, dado su base y potencia final Si
     * devuelve -1, el numero introducido es erroneo
     *
     * @param numeroFinal Resultado de la potencia
     * @param base Número que ha sido elevado a una potencia
     * @return Exponente del parámetro numeroFinal
     */
    public static int exponenteDe(int numeroFinal, int base) {

        if (base > 1) {

            int contador = -1;
            int aux = numeroFinal;

            for (int i = aux; i > 0; i = (int) Math.floor(i) / base) {
                contador++;
            }

            if (numeroFinal == Math.pow(base, contador)) {
                return contador;
            } else {
                return -1;
            }

        } else if (numeroFinal == 1 || numeroFinal == 0) {
            return numeroFinal;
        } else {
            return -1;
        }
    }

    /**
     * Devuelve el menor divisor de un numero, sea negativo o positivo Si es
     * primo devuelve 1, segun el signo puede ser -1 o 1
     *
     * @param num Número inicial
     * @return Número que es el menor divisor del parámetro num
     */
    public static int menorDivisor(int num) {

        if (esPrimo(num)) {

            if (num >= 0) {
                return 1;
            } else {
                return -1;
            }

        } else {

            int divisores[] = rellenaDivisores(num);

            return divisores[0];

        }

    }

    /**
     * Indica el mayor divisor de un numero, sin incluir el numero como tal. Si
     * es primo devuelve 1, segun el signo puede ser -1 o 1
     *
     * @param num Número inicial
     * @return Número que es el mayor divisor del parámetro num
     */
    public static int mayorDivisor(int num) {

        if (esPrimo(num)) {

            if (num >= 0) {
                return 1;
            } else {
                return -1;
            }

        } else {

            int divisores[] = rellenaDivisores(num);

            return divisores[divisores.length - 1];

        }

    }

    /**
     * Rellena un array con los divisores de un numero, sin incluir el 1 y el
     * propio numero
     *
     * @param num Número inicial
     * @return Array con todos los divisores
     */
    public static int[] rellenaDivisores(int num) {

        int divisor[] = new int[cuentaDivisores(num)];

        if (num >= 0) {
            for (int i = 2, j = 0; i < num && j < divisor.length; i++) {

                if (num % i == 0) {
                    divisor[j] = i;
                    j++;
                }

            }
        } else {
            for (int i = -2, j = 0; i > num && j < divisor.length; i--) {

                if (num % i == 0) {
                    divisor[j] = i;
                    j++;
                }

            }
        }

        return divisor;
    }

    /**
     * Devuelve el numero de divisores de un numero, sea negativo o positivo
     *
     * @param num Número inicial
     * @return Número de divisores
     */
    public static int cuentaDivisores(int num) {

        int contador = 0;
        if (num >= 0) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    contador++;
                }
            }
        } else {
            for (int i = -2; i > num; i--) {
                if (num % i == 0) {
                    contador++;
                }
            }
        }

        return contador;
    }

    /**
     * Indica si un numero es primo
     *
     * @param numero Número que queremos saber si es primo o no
     * @return True = es primo
     */
    public static boolean esPrimo(int numero) {

        if (numero <= 1) {
            return false;
        }

        int contador = 0;

        //bucle que cuenta los numeros divisibles
        for (int i = (int) Math.sqrt(numero); i > 1; i--) {
            if (numero % i == 0) {
                contador++;
            }
        }

        return contador < 1;
    }

    /**
     * Cuenta el numero de primo que hay entre el minimo y el maximo incluidos
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return numero de primos entre el minimo y el maximo
     */
    public static int cuentaPrimosEntre(int minimo, int maximo) {

        if (maximo < minimo) {

            int aux = minimo;
            minimo = maximo;
            maximo = aux;

        }

        int contador = 0;

        for (int i = minimo; i <= maximo; i++) {
            if (esPrimo(i)) {
                contador++;
            }
        }

        return contador;
    }

}
