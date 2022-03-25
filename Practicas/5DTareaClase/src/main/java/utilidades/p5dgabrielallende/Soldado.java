package utilidades.p5dgabrielallende;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Soldado implements Comparable<Soldado>{
    //Atributos de la clase.
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    
    //Constructor por defecto.
    public Soldado() {
    }
    
    //Constructor parametrizado.
    public Soldado(String nif, String nombre, String apellido1, String apellido2, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }
    
    //Getters
    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }
    
    //Setters
    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //toString
    @Override
    public String toString() {
        return "Soldado{" + "nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }

    //hashCode.
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.nif);
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.apellido1);
        hash = 73 * hash + Objects.hashCode(this.apellido2);
        hash = 73 * hash + this.edad;
        return hash;
    }

    //equals. Interpretamos que es el mismo soldado si se repite el NIF.
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
        final Soldado other = (Soldado) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
//        if (!Objects.equals(this.nombre, other.nombre)) {
//            return false;
//        }
//        if (!Objects.equals(this.apellido1, other.apellido1)) {
//            return false;
//        }
//        if (!Objects.equals(this.apellido2, other.apellido2)) {
//            return false;
//        }
        return true;
    }
    
    //Implementación de Comparable.
    @Override
    public int compareTo(Soldado soldado) {
        return this.nif.compareTo(soldado.nif);
    }
    
}
