package arraylist;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author acutuc
 */
/*
Implementa una Pila de ‘char’. Una pila es un almacén de datos en el que se sigue una política específica a la hora de introducir y sacar los elementos.
Una pila sigue una política LIFO (Last In First Out), es decir, el último elemento en entrar (apilar) es el primero en salir (desapilar).
La pila tiene un tamaño máximo, de forma que no se pueden guardar más elementos que los indicados en ese tamaño.
En este ejercicio se pide implementar una clase que modele el comportamiento de una pila de  ‘char’ mediante un ArrayList, ofreciendo la siguiente funcionalidad:
a) La pila siempre se creará vacía.
b) apilar elemento (en inglés push), lo inserta donde proceda.
c) desapilar (en inglés pop), que saca el elemento que toque.
d) Saber si la pila está vacía.
e) Saber si la pila está llena.
f) Saber el número de elementos actual de la pila.
g) Mostrar los elementos de la pila.
h) rellenar (char[] array), que recibe un array de letras y almacena en la pila los char que hay en el array.
La pila se ajusta su tamaño según el número de elementos que tenga el array.
i) char[] sacarElementos(), saca los elementos de la pila y los devuelva en un array de char. La pila queda vacía.
 */
//Definición de la clase
public class Character {

    //Atributos de la clase.
    private ArrayList<Character> lista;

    //Constructor por defecto
    public Character() {
        ArrayList<Character> lista = new ArrayList<>(5);
    }

    //Getters y setters.
    public ArrayList<Character> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Character> lista) {
        this.lista = lista;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.lista);
        return hash;
    }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Character other = (Character) obj;
        return Objects.equals(this.lista, other.lista);
    }

    //Método push (apilar).
    public void push(Character introducir) {
        //Pondremos como límite máximo de la pila como 5 elementos.
        if (lista.size() < 5) {
            lista.add(introducir);
        }
    }

    //Método pop (desapiliar).
    public void pop() {
        Character aux = new Character();
        lista.lastIndexOf(aux);
        lista.remove(aux);
    }

    //Saber si la pila está vacía.
    public void isPilaVacia() {
        lista.isEmpty();
    }

    //Saber si la pila está llena.
    public boolean isPilaLlena() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.size() == lista.lastIndexOf(i)) {
                return true;
            }
        }
        return false;
    }

    //Saber el número de elementos actual de la pila.
    public void elementosActuales() {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i);
        }
    }
    
    //Mostrar los elementos de la pila.
    public void imprimirPila(){
        lista.forEach(System.out::println);
    }
    
    //rellenar (char[] array), que recibe un array de letras y almacena en la pila los char que hay en el array.
    //La pila se ajusta su tamaño según el número de elementos que tenga el array.
    public void rellenarPila(char[] array){
        
    }
}
