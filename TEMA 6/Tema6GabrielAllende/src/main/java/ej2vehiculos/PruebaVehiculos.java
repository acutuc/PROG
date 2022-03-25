package ej2vehiculos;

/**
 *
 * @author acutuc
 */
public class PruebaVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String atributosTurismo;
        String atributosDeportivo;
        String atributosFurgoneta;
        
        Turismo t1 = new Turismo(4, true, 1242352342435L, "6234JBT", "Seat","Ibiza", "Azul", 50);
        Deportivo d1 = new Deportivo(450, 1248723540352L, "1359LZZ", "Audi", "R8", "Blanco", 245);
        Furgoneta f1 = new Furgoneta(18249823947435L, "5239BTT", "Renaul", "Kangoo", "Rojo", 35, 800, 10);
        
        atributosTurismo = t1.getAtributos();
        atributosDeportivo = d1.getAtributos();
        atributosFurgoneta = f1.getAtributos();
        
        System.out.println(t1.getAtributos());
        System.out.println(d1.getAtributos());
        System.out.println(f1.getAtributos());
    }
    
}
