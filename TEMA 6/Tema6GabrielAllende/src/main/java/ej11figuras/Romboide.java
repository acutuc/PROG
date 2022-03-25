package ej11figuras;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Romboide extends Figura{
    //Atributos de la clase.
    //LOS ATRIBUTOS SERÁN HEREDADOS.
    
    //Constructor parametrizado
    public Romboide(double base, double altura){
        super(base, altura);
    }

    //Constructor con sus valores por defecto.
    public Romboide() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public double calcularArea(){
        return base*altura;
    }
}
