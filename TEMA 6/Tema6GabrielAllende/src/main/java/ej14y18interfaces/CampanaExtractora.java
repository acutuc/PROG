package ej14y18interfaces;

/**
 *
 * @author Gabriel
 */
//Definición de la clase, extiende de Electrodomestico.
public class CampanaExtractora extends Electrodomestico {

    //Atributos de la clase.
    private double decibelios;

    //Constructor por defecto.
    public CampanaExtractora() {
        //super();
        if (decibelios < 50) {
            this.decibelios = 50;
        }
    }

    //Constructor parametrizado.
    public CampanaExtractora(double decibelios, double consumo, String modelo) {
        super(consumo, modelo);
        this.decibelios = decibelios;
        if (decibelios < 50) {
            this.decibelios = 50;
        }
    }
    
    //Getters y setters.
    public double getDecibelios() {
        return decibelios;
    }

    public void setDecibelios(double decibelios) {
        this.decibelios = decibelios;
        if(decibelios < 50){
            this.decibelios = 50;
        }
    }
    
    //toString()
    @Override
    public String toString() {
        return "CampanaExtractora{" + "decibelios=" + decibelios + '}';
    }
    
}
