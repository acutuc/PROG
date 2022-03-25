package recursividad;

/**
 *
 * @author acutuc
 */
public class EjEjemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] numeros = {7, 1, 2, 3, 4};
        System.out.println(sumar(numeros, numeros.length));
    }
    
    //Método sumar.
    public static int sumar(int[] array, int tamanio){
        if (tamanio ==1){ //Caso base
            return array[0]; //Inicia el ciclo pasivo
        } else{
            return array[tamanio-1] + sumar(array, tamanio-1); //Ciclo activo
        }
    }
    
}
