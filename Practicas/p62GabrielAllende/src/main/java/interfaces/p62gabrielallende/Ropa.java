
package interfaces.p62gabrielallende;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase abstracta, que extiende de Producto e implementa SeEnvia
public abstract class Ropa extends Producto implements SeEnvia{
    //Atributos de la clase
    private String marca;
    
    //Constructor con sus atributos por defecto
    public Ropa() {
        //super();
        this.marca = "Marca genérica.";
    }
    
    //Constructor parametrizado
    public Ropa(String marca, String codigo, double precio, double iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.marca = marca;
    }
    
    //Getters y setters.
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.marca);
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
        final Ropa other = (Ropa) obj;
        return Objects.equals(this.marca, other.marca);
    }
    
    //toString
    @Override
    public String toString() {
        return super.toString() + "Ropa{" + "marca=" + marca + '}';
    }
    
    //Métodos.
    @Override
    public void enviar(String direccion){
        System.out.println("Se procede a enviar el artículo con el código " + this.getCodigo()
        + ", de la marca " + this.getMarca() + ", con la siguiente descripción: " + this.getDescripcion()
        + ", a la dirección " + direccion + ".\nÉste articulo es Ropa.");
    }
    
}
