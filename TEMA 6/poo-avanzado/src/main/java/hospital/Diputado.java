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
public class Diputado extends Legislador{
    
    private String numeroAsiento;

    @Override
    public String getCamaraTrabaja(){
        return "Diputado";
    }
    
    public Diputado(String numeroAsiento, String provincia, String partidoPolitico, String numeroSS, double salario, String nombre, String apellidos, Nif nif) {
        super(provincia, partidoPolitico, numeroSS, salario, nombre, apellidos, nif);
        this.numeroAsiento = numeroAsiento;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    @Override
    public String toString() {
        return super.toString() + " Diputado{" + "numeroAsiento=" + numeroAsiento + '}';
    }
    
    public void metodoDiputado(){
        System.out.println("Soy un diputado de " + this.getPartidoPolitico());
    }
    
    
}
