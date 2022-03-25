package daw.poo.ej11;

/**
 *
 * @author acutuc
 */
public class PruebaEj11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Motor m = new Motor(2.0, false);
        
        Ventana v1 = new Ventana(true, true);
        Ventana v2 = new Ventana(true, true);
        Ventana v3 = v2;
        
        Puerta puertaPiloto = new Puerta(false, v1);
        Puerta puertaCopiloto = new Puerta(false, v2);
        
        Rueda ruedaDelIzq = new Rueda(45, true);
        Rueda ruedaDelDer = new Rueda(45, true);
        Rueda ruedaTraIzq = new Rueda(45, true);
        Rueda ruedaTraDer = new Rueda(45, true);
        
        Coche auto = new Coche(m, ruedaDelIzq, ruedaDelDer, ruedaTraIzq, ruedaTraDer, puertaPiloto, puertaCopiloto);
        
        Coche auto2 = new Coche(
                new Motor(2.0, false),
                new Rueda(45, true),
                new Rueda(45, true),
                new Rueda(45, true),
                new Rueda(45, true),
                new Puerta(false, new Ventana(true, true)),
                new Puerta(false, new Ventana(true, true)));
        
        
        System.out.println(auto);
        
        ruedaTraDer.desinflar();
        System.out.println(auto);
        
        System.out.println("Auto2------");
        System.out.println(auto2);
        System.out.println("Poner la ventana puerta piloto auto2 sin tintar:");
        auto2.getPuertaCopiloto().getVentana().setTintada(false);
        System.out.println(auto2);
        System.out.println("Diámetro de la rueda delantera izquierda:");
        System.out.println(auto2.getRuedaDelIzq().getDiametro());
        System.out.println("Arrancar el motor de auto2");
        auto2.getMotor().arrancar();
        
    }
    
}
