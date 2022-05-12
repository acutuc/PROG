package ej4;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
//CLASE POJO
//Definición de la clase.
public class Registro {
    //Atributos de la clase.
    private LocalDate fecha;
    private String estacionMeteorologica;
    private String provincia;
    private double precipitacion; //En mm.
    
    //Constructor con sus atributos por defecto.
    public Registro(){
    }
    
    //Constructor parametrizado
    public Registro(LocalDate fecha, String estacionMeteorologica, String provincia, double precipitacion) {
        this.fecha = fecha;
        this.estacionMeteorologica = estacionMeteorologica;
        this.provincia = provincia;
        this.precipitacion = precipitacion;
    }
    

    //Getters y setters.
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstacionMeteorologica() {
        return estacionMeteorologica;
    }

    public void setEstacionMeteorologica(String estacion) {
        this.estacionMeteorologica = estacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(double precipitacion) {
        this.precipitacion = precipitacion;
    }
    
    
    //toString();
    @Override
    public String toString() {
        return "Registro{" + "fecha=" + fecha + ", estacion=" + estacionMeteorologica + ", provincia=" + provincia + ", precipitacion=" + precipitacion + '}';
    }
    
    
    
    
    
}
