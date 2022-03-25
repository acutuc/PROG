package ej7personasabstracto;

/**
 *
 * @author acutuc
 *///Definición de la clase.
public class Camarero extends Trabajador {
    //Atributos de la clase.
    private String rango;

    //Constructor parametrizado.
    public Camarero(String rango, String nombre, String apellido, String nif) {
        super(nombre, apellido, nif);
        this.rango = rango;
    }

    //Constructor por defecto.
    public Camarero() {
    }

    public Camarero(String rango) {
        super();
        this.rango = rango;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Camarero{" + "rango=" + rango + '}';
    }

    @Override
    public void cotizar() {
        System.out.println("Cotizando como un camarero");
    }

    public void servitMesa(String id) {
        System.out.println("Camarero sirviendo la mesa " + id);
    }

}
