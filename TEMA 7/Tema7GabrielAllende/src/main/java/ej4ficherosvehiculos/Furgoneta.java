package ej4ficherosvehiculos;

/**
 *
 * @author acutuc
 */
public class Furgoneta extends Vehiculo {

    // Atributos específicos
    private int carga;
    private int volumen;

    //Constructor parametrizado
    public Furgoneta(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, int carga, int volumen) {
        super(bastidor, matricula, marca, modelo, color, tarifa); // Constructor padre
        this.carga = carga;
        this.volumen = volumen;
    }
    
    //Constructor con sus atributos por defecto
    public Furgoneta(){
    }

    //Getters y setters.
    public int getCarga() {
        return this.carga;
    }

    public int getVolumen() {
        return this.volumen;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    
    

    @Override
    public String getAtributos() {
        return super.getAtributos() + ":" + this.carga + ":" + this.volumen;
    }

}
