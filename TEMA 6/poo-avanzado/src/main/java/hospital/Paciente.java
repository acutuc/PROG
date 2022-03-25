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
public class Paciente extends Persona {
    
    private String numeroHistoria;

    public Paciente(String numeroHistoria, String nombre, String apellidos, Nif nif) {
        super(nombre, apellidos, nif);
        this.numeroHistoria = numeroHistoria;
    }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public void tomarMedicina(String medicamento){
        System.out.println("Soy " + this.getNombre() + " y estoy tomando " + medicamento);
    }
    
}
