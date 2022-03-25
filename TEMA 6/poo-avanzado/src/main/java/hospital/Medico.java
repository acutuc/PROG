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
public class Medico extends Empleado {
    
    private String especialidad; // Pediatría, Cirugía, etc

    public Medico(String especialidad, String numeroSS, double salario, String nombre, String apellidos, Nif nif) {
        super(numeroSS, salario, nombre, apellidos, nif);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void tratarPaciente(Paciente p, String medicina){
        System.out.println("El médico " + this.getNombre() + " trata al paciente "
                + p.getNombre() + " con la medicina " + medicina);
        
        p.tomarMedicina(medicina);
       
    }
    
    @Override
    public double calcularIRPF(){
        return this.getSalario()*0.21;
    }
    
    // Método dar de alta a un paciente
    // Lo quita de la lista del hospital donde trabaja ese médico
}
