package interfaces.p62gabrielallende;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase, que hereda de Ropa
public final class Pantalon extends Ropa{
    //Atributos de la clase.
    private String talla;
    
    //Constructor con sus atributos por defecto.
    public Pantalon() {
        //super();
        this.talla = "L";
    }
    
    //Constructor parametrizado.
    public Pantalon(String talla, String marca, String codigo, double precio, double iva, String descripcion) {
        super(marca, codigo, precio, iva, descripcion);
        this.talla = talla;
    }
    
    //Getters y setters.
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.talla);
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pantalon other = (Pantalon) obj;
        return Objects.equals(this.talla, other.talla);
    }
    
    //toString
    @Override
    public String toString() {
        return super.toString() + "Pantalon{" + "talla=" + talla + '}';
    }
    
    
    
}
