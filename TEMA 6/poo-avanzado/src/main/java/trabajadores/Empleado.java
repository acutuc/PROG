/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajadores;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Empleado extends Persona{
    
    private double salario;

    public Empleado() {
        // Implícitamente llama a super()
        this.salario = 2000.0;
    }
    
    public Empleado(double salario, String nombre, String nif, int edad) {
        super(nombre, nif, edad);
        this.salario = salario;
    }

    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Sobrescribe el método toString() de la clase padre, 
    // añadiendo además de los atributos de persona los propios de empleado.
    @Override
    public String toString() {
        return super.toString() + " salario=" + this.salario + '}';
    }

    // Aumenta el salario según el plus que se pasa 
    public void aumentarSalario(double plus) {
        this.salario += Math.abs(plus);
    }
    
    @Override
    // Sobrescribe el método comer() de la clase padre
    public void comer(){
        System.out.println("Soy un empleado y estoy comiendo");
    }
    
    public void cotizar(){
        System.out.println("Cotizando como empleado");
    }
    
}
