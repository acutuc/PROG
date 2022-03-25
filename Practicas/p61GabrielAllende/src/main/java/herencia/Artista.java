package herencia;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase
//CLASE PADRE.
public abstract class Artista {
    //Atributos de la clase.
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String nacionalidad;
    
    //Constructor con sus atributos por defecto.
    public Artista() {
    }
    
    //Constructor parametrizado.
    public Artista(String nombre, String apellido, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.apellido);
        hash = 19 * hash + this.edad;
        hash = 19 * hash + Objects.hashCode(this.nacionalidad);
        return hash;
    }

    //equals().
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
        final Artista other = (Artista) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return Objects.equals(this.nacionalidad, other.nacionalidad);
    }
    
    //toString()
    //Sobrescrita en las clases hija Cineasta y Cantante.
    @Override
    public String toString() {
        return "Artista{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", nacionalidad=" + nacionalidad + '}';
    }
    
    //Método abstracto.
    //Retira a un artista del mundillo del espectáculo.
    public abstract boolean retirarDelMundillo();
        
    
}
