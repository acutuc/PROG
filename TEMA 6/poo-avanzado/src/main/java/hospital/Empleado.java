/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author carlos
 */
public class Empleado extends Persona{
    
    private String numeroSS;
    private double salario;

    public Empleado(String numeroSS, double salario, String nombre, String apellidos, Nif nif) {
        super(nombre, apellidos, nif);
        this.numeroSS = numeroSS;
        this.salario = salario;
    }
    
    public Empleado(){
        super();
        this.numeroSS = "000023sdd";
        this.salario = 0.0;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double calcularIRPF(){
        return salario*0.12;
    }

    @Override
    public String toString() {
        return super.toString() + " Empleado{" + "numeroSS=" + numeroSS + ", salario=" + salario + '}';
    }
    
    
}
