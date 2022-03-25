package hospital;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public abstract class Empleado extends Persona{
    //Atributos de la clase.
    private String numeroSeguridadSocial;
    private double salario;
    
    //Constructor con sus atributos por defecto.
    public Empleado() {
    }
    
    //Constructor parametrizado.
    public Empleado(String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.salario = salario;
    }
    
    //Getters y setters.
    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.numeroSeguridadSocial);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
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
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.numeroSeguridadSocial, other.numeroSeguridadSocial)) {
            return false;
        }
        return true;
    }
    
    //toString()
    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "numeroSeguridadSocial=" + numeroSeguridadSocial + ", salario=" + salario + '}';
    }
    
    //Método abstracto
    public abstract double calcularIRPF();
    
}
