package viendoenclase;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Trabajador {
    //Atributos de la clase
    private String nombre;
    private String apellido;
    protected String nif;

    //Constructor parametrizado
    public Trabajador(String nombre, String apellido, String nif) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
    }
    
    //Constructor con sus atributos por defecto.
    public Trabajador(){
        
    }
    
    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.apellido);
        hash = 23 * hash + Objects.hashCode(this.nif);
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
        final Trabajador other = (Trabajador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return Objects.equals(this.nif, other.nif);
    }

    //toString()
    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellido=" + apellido + ", nif=" + nif + '}';
    }
    
    //Métodos
    public void cotizar(){
        System.out.println("Cotizando como un trabajador.");
    }
}
