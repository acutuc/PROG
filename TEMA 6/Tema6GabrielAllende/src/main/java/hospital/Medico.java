
package hospital;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase
public class Medico extends Empleado{
    //Atributos de la clase.
    private String especialidad;
    
    //Constructor con sus atributos por defecto.
    public Medico() {
        this.especialidad = "Enfermero";
    }
    
    //Constructor parametrizado.
    public Medico(String especialidad, String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        super(numeroSeguridadSocial, salario, nombre, apellidos, nif);
        this.especialidad = especialidad;
    }
    
    //Getters y setters.
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.especialidad);
        return hash;
    }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.especialidad, other.especialidad)) {
            return false;
        }
        return true;
    }

    //toString()
    @Override
    public String toString() {
        return super.toString() + "Medico{" + "especialidad=" + especialidad + '}';
    }
    
    //Método abstracto sobrescrito de la clase padre.
    @Override
    public double calcularIRPF(){
        if(this.especialidad.equalsIgnoreCase("cirugia") || this.especialidad.equalsIgnoreCase("cirugía")){
            return super.getSalario() * 0.25;
        }
        else{
            return super.getSalario() * 0.235;
        }
    }
    
    //Método que utiliza el médico al tratar a un paciente.
    public void tratar(Paciente paciente, String medicina){
        System.out.println("El médico " + this.getNombre() + " " + this.getApellidos() + " trata a " + paciente.getNombre() + 
                " " + paciente.getApellidos() + ", con la medicina " + medicina);
        paciente.tomarMedicina(medicina);
    }
}
