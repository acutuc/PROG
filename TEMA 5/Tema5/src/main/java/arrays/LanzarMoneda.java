package arrays;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
    /*Escribe una clase LanzarMoneda que tenga como único atributo un array de booleanos de tamaño 1000. La clase tendrá los siguientes métodos: 
    a) Un método para rellenar el array, de forma que simule 1000 lanzamientos de una moneda. El método debe almacenar el resultado de cada tirada en el array. 
    b) Un método para saber cuántas “caras” salieron después de los lanzamientos.
    c) Un método para saber cuántas “cruces” salieron después de los lanzamientos.
    d) Un método para imprimir el resultado de los 1000 lanzamientos, de forma que aparezca el número de lanzamiento y el resultado (cara o cruz)*/
public class LanzarMoneda {
    //Atributo de la clase.
    private boolean[] arrayBooleanos = new boolean[1000];
    
    //Constructor
    public LanzarMoneda() {
    }

    
    //Método para rellenar el array.
    public void rellenarArray(){
        Random aleatorio = new Random();
        for (int i = 0; i < arrayBooleanos.length; i++) {
            arrayBooleanos[i] = aleatorio.nextBoolean();            
        }
        
    }
    
    
    //Método para saber cuántas caras salieron después de los lanzamientos.
    public void contadorCaras(){
        int contadorCaras = 0;
        for (int i = 0; i < arrayBooleanos.length; i++) {
            //Si es true, interpretamos que es "cara".
            if(arrayBooleanos[i] == true){
                contadorCaras++;
            }
        }
    }
    
    
    //Método para saber cuántas cruces salieron después de los lanzamientos.
    public void contadorCruces(){
        int contadorCruces = 0;
        for (int i = 0; i < arrayBooleanos.length; i++) {
            if(arrayBooleanos[i] == false){
                contadorCruces++;
            }            
        }
    }
    
    
    //Método para imprimir el resultado de los 1000 lanzamientos, de forma que aparezca el número de lanzamiento y el resultado.
    public void imprimirResultados(){
        for (int i = 0; i < arrayBooleanos.length; i++) {
            System.out.println("Lanzamiento " + (i+1) + ": " + (arrayBooleanos[i] ? "Cara" : "Cruz"));
        }
    }
}
