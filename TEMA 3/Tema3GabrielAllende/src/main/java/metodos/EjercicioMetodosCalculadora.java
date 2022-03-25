
package metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author acutuc
 */
public class EjercicioMetodosCalculadora {

    private static void mostrarMenu() {
        System.out.println("Opciones del programa");
        System.out.println("1 - Sumar");
        System.out.println("2 - Restar");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("5 - Salir");
    }
    private static int sumar(int n1, int n2) {
        int suma = n1 + n2;
        return suma;
    }
    private static int restar(int n1, int n2) {
        int resta = n1 - n2;
        return resta;
    }
    private static int multiplicar (int n1, int n2){
        int multiplicacion = n1 * n2;
        return multiplicacion;
    }
    private static int dividir (int n1, int n2){
        int division = n1 / n2;
        return division;
    }
    
                
    
    public static void main(String[] args) {
        /* 1. Adaptar el programa para multiplicar y dividir.
           2. Crear los métodos para multiplicar y dividir.
           3. Método para pedir por teclado un int con Scanner y devuelva el int.*/
        
        //1.
        //Declaro método Scanner que utilizaré a lo largo del programa.
        Scanner sc = new Scanner(System.in);
        int operando1 = 1, operando2 = 1;
        boolean solicitarDatos = true;
        int opcion;
        double division = 0;

        System.out.println("SEA USTED BIENVENIDO AL CALCULATOR");
        //Bucle que me permitirá repetir el programa hasta que se pulse la tecla de finalizar.
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            //Switch para que el programa realice todas las funciones hasta que se decida finalizar.
            switch (opcion) {
                //Opción 1 para sumar.
                case 1:
                    System.out.println("Ha elegido sumar dos números.");
                    do {
                        System.out.println("Introduce dos operandos (entre -100 y 100)");
                        do {
                            try {
                               solicitarDatos = true;
                                // Bloque de código candidato a lanzar la excepción
                                System.out.println("Introduce operando 1: ");
                                operando1 = sc.nextInt();
                                System.out.println("Introduce operando 2: ");
                                operando2 = sc.nextInt();
                                solicitarDatos = false;
                            } catch (InputMismatchException ime) {
                                // Código para tratar el error
                                System.out.println("Se ha introducido texto en lugar de números. "
                                        + "Vuelva a introducir los datos.");
                                sc.nextLine();
                            }
                        } while (solicitarDatos); // Bucle que controla la excepción
                    } while (!((operando1 > -100 && operando1 < 100)
                            && (operando2 > -100 && operando2 < 100)));
                    System.out.println("El resultado de la suma es " + sumar(operando1, operando2));
                    break;
                //Opción 2 para restar.
                case 2:
                    System.out.println("Ha elegido restar dos números.");
                    System.out.println("Introduce dos operandos.");
                    do {
                        try {
                            // Bloque de código candidato a lanzar la excepción
                            System.out.println("Introduce operando 1: ");
                            operando1 = sc.nextInt();
                            System.out.println("Introduce operando 2: ");
                            operando2 = sc.nextInt();
                            solicitarDatos = false;
                        } catch (InputMismatchException ime) {
                            // Código para tratar el error
                            System.out.println("Se ha introducido texto en lugar de números. "
                                    + "Vuelva a introducir los datos.");
                            sc.nextLine();
                        }
                    } while (solicitarDatos);
                    System.out.println("El resultado de la resta es " + restar(operando1, operando2));
                    break;
                //Opción 3 para multiplicar.
                case 3:
                    System.out.println("Ha elegido multiplicar dos números.");
                    System.out.println("Introduce dos operandos.");
                    do {
                        try {
                            // Bloque de código candidato a lanzar la excepción
                            System.out.println("Introduce operando 1: ");
                            operando1 = sc.nextInt();
                            System.out.println("Introduce operando 2: ");
                            operando2 = sc.nextInt();
                            solicitarDatos = false;
                        } catch (InputMismatchException ime) {
                            // Código para tratar el error
                            System.out.println("Se ha introducido texto en lugar de números. "
                                    + "Vuelva a introducir los datos.");
                            sc.nextLine();
                        }
                    } while (solicitarDatos);
                    System.out.println("El resultado de la multiplicación es " + multiplicar(operando1, operando2));
                    break;
                case 4:
                    System.out.println("Ha elegido dividir dos números.");
                    System.out.println("Introduce dos operandos.");
                    do {
                        try {
                            // Bloque de código candidato a lanzar la excepción
                            System.out.println("Introduce operando 1: ");
                            operando1 = sc.nextInt();
                            System.out.println("Introduce operando 2: ");
                            operando2 = sc.nextInt();
                            division = operando1 / operando2;
                            solicitarDatos = false;
                        } catch (InputMismatchException ime) {
                            // Código para tratar el error
                            System.out.println("Se ha introducido texto en lugar de números. "
                                    + "Vuelva a introducir los datos.");
                            sc.nextLine();
                            // Código para tratar el error generado al dividir entre 0.
                        } catch (ArithmeticException eme) { 
                            System.out.println("No puede dividir un número entre cero. "
                                    + "Vuelva a introducir los datos.");
                        }
                    } while (solicitarDatos);
                    System.out.println("El resultado de la división es " + dividir(operando1, operando2));
                    break;
                case 5:
                    System.out.println("Ha elegido finalizar el programa.");
                    break;
                    //Default para que vuelva a preguntar por las opciones si se teclea una incorrecta.
                default:
                    System.out.println("Elija una de las opciones del menú de opciones.");
            }
        } while (opcion != 5);
    }

}

