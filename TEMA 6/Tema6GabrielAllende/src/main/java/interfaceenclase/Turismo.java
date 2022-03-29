package interfaceenclase;

/**
 *
 * @author acutuc
 */
public class Turismo extends Vehiculo {
    
    private int numPuertas;

    //Getters y setters
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTurismo{" + "numPuertas=" + numPuertas + '}';
    }
    
    @Override
    public void repostar(String tipoCombustible){
        System.out.println("El turismo está repostando " + tipoCombustible);
    }
    
    
}
