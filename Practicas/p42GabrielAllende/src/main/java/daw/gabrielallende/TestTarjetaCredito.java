package daw.gabrielallende;

/**
 *
 * @author acutuc
 */
public class TestTarjetaCredito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TarjetaCredito t1 = new TarjetaCredito();
        System.out.println(t1);
        
        TarjetaCredito t2 = new TarjetaCredito("453876201869135", "Gabriel Allende", "BBVA", "5555", 2500, 2023, 5, 450);
        System.out.println(t2);
    }

}
