package ejercicioclase;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class ListaMoviles {

    //Atributos de la clase.
    ArrayList<Movil> lista = new ArrayList<>();

    //Constructor por defecto.
    public ListaMoviles() {
    }

    //Guarda un móvil al final de la lista, si el valor no es nulo.
    public void insertarMovil(Movil movil) {
        if (movil != null) {
            lista.add(movil);
        }

    }

    //Imprimir la lista
    public void imprimirConsola() {
        System.out.println("Imprimiendo lista de móviles...");
        lista.forEach(System.out::println);
    }

    //getCatidadMoviles
    public int getCantidadMoviles() {
        return lista.size();
    }

    //Eliminar un móvil.
    public boolean eliminarMovil(Movil movil) {
        return lista.remove(movil);
    }

    //Buscar un móvil. Lo haremos mediante el modelo.
    public Movil buscarModeloCuentaVieja(String modelo) {
        Movil aux = null;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.get(i);
            if (aux.getModelo().equals(modelo)) {
                return aux;
            }
        }
        return aux;
    }

    //SEGUNDA OPCIÓN DE BUSCAR MODELO
    public Movil buscarModelo(String modelo) {
        Movil aux = new Movil("", modelo, false, 0);
        int indice = lista.indexOf(aux);
        if (indice >= 0) {
            return lista.get(indice);
        }
        return null;
    }

    //Buscar por precio.
    public ArrayList<Movil> buscarPorPrecio(double precio) {
        ArrayList<Movil> lista = new ArrayList();
        for (Movil movil : this.lista) { //Utilizamos this. para diferenciar el atributo de clase, de la variable declarada en el método.
            if (movil.getPrecio() == precio) {
                lista.add(movil);
            }
        }
        return lista;
    }

}
