
package daw.poo;

/**
 *
 * @author acutuc
 */
public class TestCajaCarton {
    
    public static void main(String[] args) {
        
        CajaCarton cajaGrande = new CajaCarton(250, 400, 500, 200);
        CajaCarton cajaChica = new CajaCarton(25, 30, 15, 17);
        
        System.out.println("Caja Grande con toString --> " + cajaGrande.toString());
        System.out.println("Caja Chica con toString--> " + cajaChica.toString());
        System.out.println("Caja Grande con get -->" + "Alto: " + cajaGrande.getAlto() + "mm " + "Ancho: " + cajaGrande.getAncho() + "mm " + "Largo: " + cajaGrande.getLargo() + "mm " + "Peso: " + cajaGrande.getPeso() + "gr.");
        System.out.println("Caja Crande con get -->" + "Alto: " + cajaChica.getAlto() + "mm " + "Ancho: " + cajaChica.getAncho() + "mm " + "Largo: " + cajaChica.getLargo() + "mm " + "Peso: " + cajaChica.getPeso() + "gr.");
        
        
    }
    
}
