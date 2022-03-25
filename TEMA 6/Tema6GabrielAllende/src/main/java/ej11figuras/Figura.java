package ej11figuras;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public abstract class Figura {
    //Atributos de la clase
    protected double base;
    protected double altura;
    
    //Constructor parametrizado.
    public Figura(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    //Constructor con sus atributos por defecto.
    public Figura(){
        //super();
    }

    //Getters y setters.
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //toString()
    @Override
    public String toString() {
        return "Figura{" + "base=" + base + ", altura=" + altura + '}';
    }
    
    //Métodos.
//    public double calcularArea(double base, double altura){
//        double area = base*altura;
//        return area;
//    }
    
//    public String calcularArea(){
//        return "Área de la figura = " + calcularArea(base, altura);
//    }
    
    public abstract double calcularArea();
    
}
