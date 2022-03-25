package hospital;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
//Clase abstracta
public abstract class Persona {
    //Atributos de la clase. 
    private String nombre;
    private String apellidos;
    private NIF nif;
    
    //Constructor con sus atributos por defecto
    public Persona() {
    }
    
    //Constructor parametrizado.
    public Persona(String nombre, String apellidos, NIF nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public NIF getNif() {
        return nif;
    }

    public void setNif(NIF nif) {
        this.nif = nif;
    }
    
    //hashCode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.apellidos);
        hash = 29 * hash + Objects.hashCode(this.nif);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return Objects.equals(this.nif, other.nif);
    }
    
    //toString()
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + '}';
    }
    
    //Método.
    public final void renovarNIF(LocalDate fechaSolicitud){
        this.nif.renovar(fechaSolicitud);
    }
    
}
