package utilidades.p5dgabrielallende;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Ejercito {

    //Se crea lista de soldados.    
    private Set<Soldado> ejercitoLista;

    //Constructor por defecto.
    public Ejercito() {
        this.ejercitoLista = new HashSet<>();
    }

    //Getters y setters
    public Set<Soldado> getEjercitoLista() {
        return ejercitoLista;
    }

    public void setEjercitoLista(Set<Soldado> ejercitoLista) {
        this.ejercitoLista = ejercitoLista;
    }

    //toString()
    @Override
    public String toString() {
        return "Ejercito{" + "ejercitoLista=" + ejercitoLista + '}';
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ejercitoLista);
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
        final Ejercito other = (Ejercito) obj;
        return Objects.equals(this.ejercitoLista, other.ejercitoLista);
    }

    //Métodos:
    //Numero soldados
    public int saberNumeroDeSoldados() {
        return ejercitoLista.size();
    }

    //Método alistar soldados
    public void alistarSoldado(Soldado a) {
        ejercitoLista.add(a);
    }

    //Método para sabier si un soldado está en el ejército
    public boolean estaEnElEjercito(Soldado soldadoBuscar) {
        return ejercitoLista.contains(soldadoBuscar);
    }

    //Método para sacar todos los soldados, en forma de ArrayList.
    public ArrayList sacarSoldadosEnArrayList() {
        ArrayList<Soldado> arraySoldados = new ArrayList<>();
        for (Soldado listaSoldado : ejercitoLista) {
            arraySoldados.add(listaSoldado);
        }
        //El objeto Iterator sirve para recorrer todos los elementos de una estructura de datos. Es equvalente a un for-each.
        Iterator<Soldado> iterator1 = ejercitoLista.iterator();
        while (iterator1.hasNext()) {
            Soldado aux = iterator1.next();
        }
        return arraySoldados;
    }
    
    //Método para desmatricular un soldado.
    public boolean desmatricularSoldado(Soldado soldadoBorrar){
        return ejercitoLista.remove(soldadoBorrar);
    }
    
    //Método para imprimir.
    public void imprimir(){
        ejercitoLista.forEach(System.out::println);
    }

}
