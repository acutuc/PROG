package traductor;

/**
 *
 * @author Gabriel
 */
public class TraductorMain {

    /**
     * @param args the command line arguments
     */
    //Realiza una clase conteniendo el main() y 10 registros en tu traductor. Prueba los métodos realizados.
    public static void main(String[] args) {
        //Inicializo el traductor.
        Traductor traductor = new Traductor();
        
        //Añado 10 registros al traductor.
        traductor.guardaEntrada("Beer", "Cerveza");
        traductor.guardaEntrada("Bike", "Bicicleta");
        traductor.guardaEntrada("Boat", "Barco");
        traductor.guardaEntrada("Car", "Coche");
        traductor.guardaEntrada("Danger", "Peligro");
        traductor.guardaEntrada("Fork", "Tenedor");
        traductor.guardaEntrada("Glass", "Cristal");
        traductor.guardaEntrada("Ham", "Jamón");
        traductor.guardaEntrada("Schedule", "Calendario");
        traductor.guardaEntrada("Spoon", "Cuchara");
        
        //Probando métodos:
        //Imprimo el Map.
        traductor.imprimirMap();
        
        //Elimino entrada y vuelvo a imprimir
        System.out.println("\nElimino entrada y vuelvo a imprimir: ");
        traductor.eliminaEntrada("Glass");
        traductor.imprimirMap();
        
        //Modifico entrada y vuelvo a imprimir.
        System.out.println("\nModifico entrada y vuelvo a imprimir: ");
        traductor.modificaEntrada("Spoon", "ESTA PALABRA HA SIDO MODIFICADA");
        traductor.imprimirMap();
        
        //Traduzco una palabra inglesa.
        System.out.println("\nTraduzco Schedule: " + traductor.traducirDelIngles("Schedule"));
        
        //Devuelvo todas las palabras inglesas en un ArrayList.
        System.out.println("\nObtengo todas las palabras inglesas en un ArrayList: ");
        traductor.listaPalabrasInglesas().forEach(System.out::println);
        
        //Devuelvo todas las palabras españolas en un ArrayList.
        System.out.println("\nObtengo todas las palabras españolas en un ArrayList: ");
        traductor.listaPalabrasEspanol().forEach(System.out::println);
        //TENGAMOS EN CUENTA QUE "Spoon" HA SIDO MODIFICADA, Y POR TANTO LA IMPRIME CON LA MODIFICACIÓN PERTINENTE.
    }
    
}
