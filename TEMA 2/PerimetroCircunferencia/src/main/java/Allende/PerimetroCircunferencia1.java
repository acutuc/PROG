
package Allende;

/**
 *
 * @author acutuc
 */

// Aquí estarían los import
// Comentarios de línea
// Declaración de la clase:
public class PerimetroCircunferencia1 {
    
    /*
        Comentario de varias líneas.
        En esta sección van los atributos y métodos.
        El método main es el que busca el JRE para iniciar
        la ejecución de cualquier programa.
    */
    
    public static void main(String[] args) {
        
        // Instrucción básica para imprimir por consola.
        System.out.println("Programa para calcular el perímetro "
                + "de una circunferencia");
        
        // perímetro = 2 * PI * r
        // Declaración e inicialización de una variable
        // primitiva de tipo int que se llama radio y vale 23:
        int radio = 20;
        double pi;
        pi = 3.14;
        
        System.out.println("El radio vale: " + radio);
        double perimetro; 
        perimetro = 2 * pi * radio;
        
        System.out.println("El perímetro es; " + perimetro);
    }
}
