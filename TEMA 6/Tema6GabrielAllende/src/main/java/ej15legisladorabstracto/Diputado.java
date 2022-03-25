package ej15legisladorabstracto;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Diputado extends Legislador{
    //Atributos de la clase.
    private int numeroAsiento;
    
    //Constructor con sus valores por defecto.
    public Diputado() {
    }
    
    //Constructor parametrizado
    public Diputado(int numeroAsiento, String provincia, String partidoPolitico, String nombre, String apellido) {
        super(provincia, partidoPolitico, nombre, apellido);
        this.numeroAsiento = numeroAsiento;
    }
    
    //Getters y setters.
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    
    //toString()
    @Override
    public String toString() {
        return super.toString() + "Diputado{" + "numeroAsiento=" + numeroAsiento + '}';
    }
    
    //Método sobrescrito
    @Override
    public String getCamara(){
        return "Esta persona es un Diputado.";
    }
    
    
}
