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

public class Senador extends Legislador implements Natacion {
    
    private double salarioExtra;

    public Senador(double salarioExtra, String provincia, String partidoPolitico, String numeroSS, double salario, String nombre, String apellidos, Nif nif) {
        super(provincia, partidoPolitico, numeroSS, salario, nombre, apellidos, nif);
        this.salarioExtra = salarioExtra;
    }

    public double getSalarioExtra() {
        return salarioExtra;
    }

    public void setSalarioExtra(double salarioExtra) {
        this.salarioExtra = salarioExtra;
    }

    @Override
    public String toString() {
        return super.toString() + " Senador{" + "salarioExtra=" + salarioExtra + '}';
    }

    @Override
    public String getCamaraTrabaja() {
        return "Senador";
    }
    
    public void metodoSenador(){
        System.out.println("Soy un senador y mi salario extra es " + this.salarioExtra);
    }

    @Override
    public void nadar() {
    }

    @Override
    public void bucear() {
        System.out.println("Soy un senador buceador");
    }
}
