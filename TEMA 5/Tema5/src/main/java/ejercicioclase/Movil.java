package ejercicioclase;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Movil {

    //Atributos de la clase.
    private String marca;
    private String modelo;
    private boolean NFC;
    private double precio;

    //Constructor con los atributos predeterminados.
    public Movil() {
    }

    //Constructor parametrizado.
    public Movil(String marca, String modelo, boolean NFC, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.NFC = NFC;
        this.precio = precio;
    }

    //Getters y Setters.
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isNFC() {
        return NFC;
    }

    public void setNFC(boolean NFC) {
        this.NFC = NFC;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Movil. " + "\tMarca: " + marca + "\tModelo: " + modelo + "\tNFC: " + NFC + "\tPrecio: " + precio + '€';
    }

    //hashCode.
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.marca);
        hash = 83 * hash + Objects.hashCode(this.modelo);
        hash = 83 * hash + (this.NFC ? 1 : 0);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    //equals
    //Solamente un objeto será igual a otro si en sus atributos tenemos marca y modelo iguales.
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
        final Movil other = (Movil) obj;
//        if (this.NFC != other.NFC) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
//            return false;
//        }
//        if (!Objects.equals(this.marca, other.marca)) {
//            return false;
//        }
        return Objects.equals(this.modelo, other.modelo);
    }

}
