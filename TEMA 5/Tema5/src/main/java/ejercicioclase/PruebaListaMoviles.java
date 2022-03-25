package ejercicioclase;

/**
 *
 * @author acutuc
 */
public class PruebaListaMoviles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaMoviles moviles = new ListaMoviles();
        
        moviles.insertarMovil(new Movil("Samsung", "Galaxy S20+", true, 1100));
        moviles.insertarMovil(new Movil("Realme", "X2 Pro", true, 499));
        moviles.insertarMovil(new Movil("Xiaomi", "Mi 11 Pro", true, 800));
        moviles.insertarMovil(new Movil("Iphone", "13 Pro", true, 50000));
        
        moviles.imprimirConsola();
                
        System.out.println("Cantidad de móviles: " + moviles.getCantidadMoviles());
        
        Movil movil = moviles.buscarModelo("X2 Pro");
        System.out.println("Móvil buscado: " + movil);
        
        movil = moviles.buscarModeloCuentaVieja("Galaxy S20+");
        System.out.println("Móvil buscado: " + movil);
        
        moviles.eliminarMovil(new Movil("", "", true, 0));
        
        System.out.println("Móviles de precio 50.000€");
        moviles.buscarPorPrecio(50000).forEach(System.out::println);
    }
    
}
