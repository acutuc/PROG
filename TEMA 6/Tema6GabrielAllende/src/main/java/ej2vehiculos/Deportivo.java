package ej2vehiculos;

/**
 *
 * @author acutuc
 */
//Definición de la clase, heredando Vehiculo
public class Deportivo extends Vehiculo{
    private int cilindrada; // Atributo específico para Deportivo


    //Constructor parametrizado.
    public Deportivo(int cilindrada, Long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.cilindrada = cilindrada;
    }

    //Getter
    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos() + "Cilindrada: " + this.cilindrada;
    }
    

    
}
