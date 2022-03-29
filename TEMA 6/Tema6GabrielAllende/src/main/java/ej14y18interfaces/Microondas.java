package ej14y18interfaces;

/**
 *
 * @author Gabriel
 */
//Definición de la clase, extiende de Electrodomestico e implementa Silencioso
public class Microondas extends Electrodomestico implements Silencioso, Comparable<Microondas>{
    //Atributos de la clase.
    private double potenciaMax;
    
    //Constructor por defecto.
    public Microondas(){
        //super();
    }
    
    //Cosntructor parametrizado.
    public Microondas(double potenciaMax, double consumo, String modelo) {
        super(consumo, modelo);
        this.potenciaMax = potenciaMax;
    }
    
    //Getters y setters.
    public double getPotenciaMax() {
        return potenciaMax;
    }

    public void setPotenciaMax(double potenciaMax) {
        this.potenciaMax = potenciaMax;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Microondas{" + "potenciaMax=" + potenciaMax + '}';
    }
    
    //Método sobrescrito que implementa de Silencioso
    @Override
    public void silencio(){
        System.out.println("El microondas de consumo " + getPotenciaMax() + "w, empite 40dB.");
    }
    
    //compareTo con casting explícito
    public int compareTo(Microondas m){
        return (int) (this.potenciaMax - m.getPotenciaMax());
    }
}
