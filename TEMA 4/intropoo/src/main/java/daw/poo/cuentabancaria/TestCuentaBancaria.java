
package daw.poo.cuentabancaria;

/**
 *
 * @author acutuc
 */
public class TestCuentaBancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        CuentaBancaria cuenta2 = new CuentaBancaria("01723932J", "Jose Alberto Núñez", 1450.50, 1.5);
        
        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());
    }
    
}
