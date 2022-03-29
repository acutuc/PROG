package ej14y18interfaces;

/**
 *
 * @author Gabriel
 */
//Definición de la clase. Clase abstracta
public abstract class Electrodomestico {
    //Atributos de la clase
    private double consumo;
    private String modelo;

    //Constructor por defecto
    public Electrodomestico(){
    }
    
    //Constructor parametrizado.
    public Electrodomestico(double consumo, String modelo) {
        this.consumo = consumo;
        this.modelo = modelo;
    }

}
