package interfaces.p62gabrielallende;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase final, que extiende de Producto.
public final class Musica extends Producto{
    //Atributos de la clase.
    private String grupo;
    
    //Constructor por defecto.
    public Musica() {
        //super();
        this.grupo = "Grupo por defecto.";
    }
    
    //Constructor parametrizado
    public Musica(String grupo, String codigo, double precio, double iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.grupo = grupo;
    }
    
    //Getters y setters
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.grupo);
        return hash;
    }

    //equals
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
        final Musica other = (Musica) obj;
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return super.toString() + "Musica{" + "grupo=" + grupo + '}';
    }
    
    
    
}
