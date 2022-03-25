package practicaclase;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author acutuc
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random aleatorio = new Random();

        //Genero entre 10 y 20 calcetines.
        int cantidadCalcetines = aleatorio.nextInt(20 - 10 + 1) + 10;
        System.out.println("Calcetines creados al azar: " + cantidadCalcetines);

        ArrayList<Calcetin> cajonCalcetines = new ArrayList<>();

        //Bucle que genera entre 10 y 20 calcetines en el cajón.
        for (int i = 0; i < cantidadCalcetines; i++) {
            Calcetin calcetin = new Calcetin();
            //Almaceno los calcetines en ambos arraylists, para luego poder hacer comparaciones.
            cajonCalcetines.add(calcetin);

        }
        //ArrayList auxiliar en el que iré almacenando los calcetines no emparejados.
        ArrayList<Calcetin> arrayAux = new ArrayList<>();
        
        //Comparo una posición con todas las demás, buscando los objetos iguales.
        for (int i = 0; i < cajonCalcetines.size(); i++) {
            Calcetin aux = cajonCalcetines.get(i);
            for (int j = 0; j < cajonCalcetines.size(); j++) {
                //Condición para que nunca compare un objeto consigo mismo.
                if (i != j) {
                    Calcetin aux2 = cajonCalcetines.get(j);
                    //Comparación de un objeto con otro
                    if (aux2.equals(aux)) {
                        //try-catch para parar el programa en cuanto lance la excepción IOOBE.
                        try {
                            System.out.println("EMPAREJADOS\t" + aux2.toString() + " " + aux.toString());
                            //Elimino ambos calcetines del ArrayList inicial.
                            cajonCalcetines.remove(j);
                            cajonCalcetines.remove(i);
                            //Agrego ambos calcetines a un ArrayList secundario.
                            arrayAux.add(aux);
                            arrayAux.add(aux2);
                        } catch (IndexOutOfBoundsException IOOBE) {
                            //Excepción que se lanza a raíz del bucle de la línea 37.
                            //Al borrar un elemento que ocupe la posición "j", el ArrayList quedaría fuera
                            //de índice, lanzando la excepción. La única opción que interpreté fue la de poner un mensaje
                            //que pidiera repetir el programa.
                            System.out.println("Excepción lanzada. REPETIR PROGRAMA.");
                            break;
                        }
                    }
                }
            }
        }
        
        
        System.out.println("\n\n\nCalcetines sin pareja: \n");
        //Utilizo el método calcetinesSinPareja() para imprimir por pantalla los calcetines sin pareja.
        calcetinesSinPareja(cajonCalcetines);

    }
    
    public static Calcetin[] calcetinesSinPareja(ArrayList<Calcetin> arrayList){
        //Creo array auxiliar en el que almacenaré los calcetines pasados por parámetro, a través de un ArrayList.
        Calcetin[] array = new Calcetin[arrayList.size()];
        //Bucle en el que almaceno en el array, los objetos de la misma posición del ArrayList.
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
            //Imprimo array.
            System.out.println(array[i]);
        }
        return array;
    }

}
