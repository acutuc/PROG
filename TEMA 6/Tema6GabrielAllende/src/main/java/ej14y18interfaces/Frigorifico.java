package ej14y18interfaces;

/**
 *
 * @author Gabriel
 */
//Definición de la clase. Extiende de Electrodomestico e implementa Silencioso
public class Frigorifico extends Electrodomestico implements Silencioso, Comparable<Frigorifico>{
    //Atributos de la clase.
    private double litros;
    
    //Constructor con sus atributos por defecto.
    public Frigorifico(){
        //super();
    }
    
    //Constructor parametrizado
    public Frigorifico(double litros, double consumo, String modelo) {
        super(consumo, modelo);
        this.litros = litros;
    }

    //Getters y setters.
    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Frigorifico{" + "litros=" + litros + '}';
    }
    
    //Método sobrescrito que implementa de Silencioso
    @Override
    public void silencio(){
        System.out.println("El frigorífico de " + getLitros() + "L, emite 50dB.");
    }
    
    //compareTo con casting explícito
    public int compareTo(Frigorifico f){
        return (int) (this.litros - f.getLitros());
    }
    
}
