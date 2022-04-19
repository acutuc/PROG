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
    
    //Getters 
    public int getPuertas() {
        return puertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }
    

    @Override
    public String getAtributos() {
    // Llamada al método getAtributos() de la clase Vehiculo y
    // concateno los atributos de la superclase con los de la subclase
        return super.getAtributos() + " Puertas: " + this.puertas + " Marcha automática: " + this.marchaAutomatica;
    }

}
