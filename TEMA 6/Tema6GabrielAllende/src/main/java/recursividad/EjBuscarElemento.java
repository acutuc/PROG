package recursividad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acutuc
 */
public class EjBuscarElemento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String cadena = "Esta es una cadena de texto a modo de ejemplo para un ejercicio de programacion.";
        ArrayList<Character> lista = new ArrayList<Character>();
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            lista.add(caracter);
        }
        System.out.println("The String is: " + cadena);
        System.out.print("The ArrayList is: " + lista);
        
        cadMayor(lista, 0, cadena);
    }

    public static int cuentaMinusculas(String cadena) {
        Integer i = cadena.length() - 1;
        int cont = 0;

        while (i >= 0) {
            char a = cadena.charAt(i);
            if (Character.isLowerCase(a)) {
                cont++;
            }
            i--;
        }
        return cont;
    }

    public static String cadMayor(List<String> lista, int pos, String strMayor) {
        //- la funcion no valida si la lista es nula,
        //no valida si solo tiene un item y ese item esta en mayuscula cerrada.
        //- lo mejor es que crees otra funcion que envuelva a la primera,
        //de este modo la funcion que expones al cliente no nesecita parsarle el strMayor

        String res = "";

        if (lista.size() == 1) {
            res = lista.get(pos);
        } else if (pos <= -1) {
            res = strMayor;
        } else {
            if (cuentaMinusculas(strMayor) > cuentaMinusculas(lista.get(pos))) {
                res = cadMayor(lista, pos - 1, strMayor);
            } else {
                res = cadMayor(lista, pos - 1, lista.get(pos));
            }
        }

        return res;
    }
}
