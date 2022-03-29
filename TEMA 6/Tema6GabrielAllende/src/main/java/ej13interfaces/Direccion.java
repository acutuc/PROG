package ej13interfaces;

/**
 *
 * @author acutuc
 */
public class Direccion {
    //Atributos de la clase
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String pais;
    
    //Constructor con sus atributos por defecto.
    public Direccion(){
    }
    
    //Constructor parametrizado.
    public Direccion(String calle, String ciudad, String codigoPostal, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }
    
    //Getters y setters.
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    //toString().

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", pais=" + pais + '}';
    }
    
}
