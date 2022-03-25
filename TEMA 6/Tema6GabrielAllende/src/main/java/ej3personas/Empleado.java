package ej3personas;

/**
 *
 * @author Gabriel
 */
//Definición de la clase
public class Empleado extends Persona{
    //Atributos de la clase.
    private double salario;
    
    //Constructor con sus valores por defecto.
    public Empleado() {
    }

    //Constructor parametrizado.
    public Empleado(double salario, String nombre, String nif, int edad) {
        super(nombre, nif, edad);
        this.salario = salario;
    }
    
    //Getter
    public double getSalario() {
        return salario;
    }
    
    //toString() que sobrescribe el método toString() de la superclase (Persona).
    @Override
    public String toString() {
        return super.toString() + "Salario: " + this.salario;
    }
    
    
    //Métodos.
    //Método que permita aumentar el salario en una cantidad que sería pasada como parámetro.
    public void aumentarSalario(double salarioAumentado){
        if(salarioAumentado > 0){
            this.salario = salario + salarioAumentado;
        }
    }
    
}
