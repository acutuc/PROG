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
public class Administrativo extends Empleado implements Natacion{
    
    private String grupo; // A, B

    public Administrativo(String grupo, String numeroSS, double salario, String nombre, String apellidos, Nif nif) {
        super(numeroSS, salario, nombre, apellidos, nif);
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    
    public void registrarDocumento(){
        System.out.println("Soy el administrativo " + this.getNombre() +" y estoy registrando un doc");
    }
    
    @Override
    public double calcularIRPF(){
        if (this.grupo.equals("A")){
            return this.getSalario()*0.18;
        } else{
            return this.getSalario()*0.16;
        }
    }

    @Override
    public void nadar() {
        // Código X
    }

    
}
