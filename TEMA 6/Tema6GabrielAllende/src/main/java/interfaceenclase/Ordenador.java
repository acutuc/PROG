package interfaceenclase;

/**
 *
 * @author acutuc
 */
public class Ordenador implements SeArranca, SePara {
    
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Ordenador{" + "precio=" + precio + '}';
    }
    
    public boolean arrancar(){
        System.out.println("El ordenador está arrancado.");
        return true;
    }
    
    public boolean parar(){
        System.out.println("Parando el ordenador");
        return false;
    }
    
}
