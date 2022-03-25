package viendoenclase;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Camarero c1 = new Camarero("jefe de sección", "Manuel", "Fernández", "784985B");
        System.out.println(c1);
        
        Camarero c2 = new Camarero("Sumiller");
        System.out.println(c2);
        
        Cocinero co1 = new Cocinero("Postres", "Luis", "Pérez", "8237508J");
        Trabajador t1 = new Trabajador("Paco", "El chocolatero", "23957435P");
        
//        System.out.println(co1);
//        System.out.println(t1);
//        
//        c1.cotizar();
//        co1.cotizar();
//        t1.cotizar();
        
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        
        listaTrabajadores.add(t1); //Conversión implícita
        listaTrabajadores.add(c1); //Conversión implícita
        listaTrabajadores.add(co1); //Conversión implícita
        
        for (Trabajador t : listaTrabajadores) {
            System.out.println(t);
            t.cotizar();
            
            //Si t es una instancia de Camarero
            if(t instanceof Camarero){
                Camarero aux = (Camarero) t; //Conversión explícita
                aux.servitMesa("4");
            }
            if(t instanceof Cocinero){
                ((Cocinero) t).preparPlato("Pushhero");
            }
        }
    }
    
}
