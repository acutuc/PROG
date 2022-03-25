package ejerciciodos;

import ejerciciouno.Trabajador;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Empresa {
    //Atributos de la clase.
    private ArrayList<Trabajador> lista;
    private String nombreEmpresa;
    private String cif;

    public Empresa(String nombreEmpresa, String cif) {
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.lista = new ArrayList<>();
    }
    
    
    //Métodos
    public void imprimir(){
        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("CIF de la empresa: " + cif);
        System.out.println("----------------");
        lista.forEach(System.out::println);
    }
    
    public void contratar(Trabajador t){
        lista.add(t);
    }
    
    public boolean despedir(Trabajador t){
        return lista.remove(t);
    }
    
//    public int[] buscarTodosNombre(String nombre){
//        int []array;
//        for (int i = 0; i < lista.size(); i++) {
//            Trabajador get = lista.get(i);
//                    get.getNombre();
//        }
//    }
    
    public Trabajador buscarNombre(Trabajador t) {
        Trabajador aux = null;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.get(i);
            if (aux.getNombre().equals(t.getNombre())) {
                return aux;
            }
        }
        return aux;
    }
    
    
    
}
