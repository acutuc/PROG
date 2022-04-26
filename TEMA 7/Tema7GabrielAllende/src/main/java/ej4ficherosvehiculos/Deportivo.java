package ej4ficherosvehiculos;

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
    
    //Constructor con sus atributos por defecto.
    public Deportivo(){
    }

    //Getter y setters.
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    

    @Override
    public String getAtributos() {
        return super.getAtributos() + ":" + this.cilindrada;
    }
    

    
}
