package ej11figuras;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Rectangulo extends Figura{
    //Atributos de la clase.
    //LOS ATRIBUTOS SERÁN HEREDADOS.
    
    //Constructor parametrizado
    public Rectangulo(double base, double altura){
        super(base, altura);
    }

    //Constructor con sus valores por defecto.
    public Rectangulo() {
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
