package ej4ficherosvehiculos;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Turismo extends Vehiculo {
    //Atributos de la clase.
    private int puertas;
    private boolean marchaAutomatica;

    //Constructor parametrizado
    public Turismo(int puertas, boolean marchaAutomatica, Long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }
    
    //Constructor con sus atributos por defecto.
    public Turismo(){
    }
    
    //Getters y setters
    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    @Override
    public String toString() {
        return super.toString()+ ":" + this.puertas + ":" + this.marchaAutomatica;
    }
    

    

}
