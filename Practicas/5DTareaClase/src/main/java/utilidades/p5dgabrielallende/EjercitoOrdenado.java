package utilidades.p5dgabrielallende;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class EjercitoOrdenado {
    //Atributos de la clase.
    private Set<Soldado> ejercito;

    //Contructor por defecto.
    public EjercitoOrdenado() {
        this.ejercito = new TreeSet<>();
    }

    //Getters y setters
    public Set<Soldado> getEjercito() {
        return ejercito;
    }

    public void setEjercito(Set<Soldado> ejercito) {
        this.ejercito = ejercito;
    }
    
    //toString
    @Override
    public String toString() {
        return "EjercitoOrdenado{" + "ejercito=" + ejercito + '}';
    }
    
    //hashCode()
    @Override    
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.ejercito);
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
        final EjercitoOrdenado other = (EjercitoOrdenado) obj;
        return Objects.equals(this.ejercito, other.ejercito);
    }

    //Métodos:
    //Numero soldados
    public int saberNumeroDeSoldados() {
        return ejercito.size();
    }

    //Método alistar soldados
    public void alistarSoldado(Soldado a) {
        ejercito.add(a);
    }

    //Método para sabier si un soldado está en el ejército
    public boolean estaEnElEjercito(Soldado soldadoBuscar) {
        return ejercito.contains(soldadoBuscar);
    }

    //Método para sacar todos los soldados, en forma de ArrayList.
    public ArrayList sacarSoldadosEnArrayList() {
        ArrayList<Soldado> arraySoldados = new ArrayList<>();
        for (Soldado listaSoldado : ejercito) {
            arraySoldados.add(listaSoldado);
        }
        //El objeto Iterator sirve para recorrer todos los elementos de una estructura de datos. Es equvalente a un for-each.
        Iterator<Soldado> iterator1 = ejercito.iterator();
        while (iterator1.hasNext()) {
            Soldado aux = iterator1.next();
        }
        return arraySoldados;
    }
    
    //Método para desmatricular un soldado.
    public boolean desmatricularSoldado(Soldado soldadoBorrar){
        return ejercito.remove(soldadoBorrar);
    }
    
    //Método para imprimir.
    public void imprimir(){
        ejercito.forEach(System.out::println);
    }
    
}
