package hospital;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Paciente extends Persona{
    //Atributos de la clase.
    private String numeroHistoria;
    
    //Constructor con sus atributos por defecto.
    public Paciente() {
    }
    
    
    //Constructor parametrizado.
    public Paciente(String numeroHistoria, String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.numeroHistoria = numeroHistoria;
    }
    
    //Getters y setters.
    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.numeroHistoria);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.numeroHistoria, other.numeroHistoria)) {
            return false;
        }
        return true;
    }
    
    //toString()
    @Override
    public String toString() {
        return super.toString() + "Paciente{" + "numeroHistoria=" + numeroHistoria + '}';
    }
    
    //Método para que el paciente tome su medicina
    public void tomarMedicina(String medicina){
        Random aleatorio = new Random();
        if(aleatorio.nextBoolean()){
            System.out.println("El paciente se ha curado con la medicina " + medicina);            
        }else{
            System.out.println("El paciente no se ha curado con la medicina " + medicina);
        }
    }
}
