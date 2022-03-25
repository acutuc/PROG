package ej15legisladorabstracto;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Senador extends Legislador{
    //Atributos de la clase.
    private double complemento;
    
    //Constructor con sus valores por defecto
    public Senador() {
    }
    
    //Constructor parametrizado
    public Senador(double complemento, String provincia, String partidoPolitico, String nombre, String apellido) {
        super(provincia, partidoPolitico, nombre, apellido);
        this.complemento = complemento;
    }
    
    //Getters y setters.
    public double getComplemento() {
        return complemento;
    }

    public void setComplemento(double complemento) {
        this.complemento = complemento;
    }
    
    //toString().
    @Override
    public String toString() {
        return super.toString() + "Senador{" + "complemento=" + complemento + '}';
    }
    
    //Método sobrescrito
    @Override
    public String getCamara(){
        return "Esta persona es un Senador.";
    }
    
    
}
