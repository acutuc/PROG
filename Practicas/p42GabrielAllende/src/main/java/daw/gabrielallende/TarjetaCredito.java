package daw.gabrielallende;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class TarjetaCredito {

    //Atributos de la clase
    private String numeroTarjeta;
    private String nombreTitular;
    private YearMonth fechaCaducidad;
    private String entidadEmisora;
    private boolean estadoTarjeta; //AÑADO ESTADO DE TARJETA PARA SIMPLICIDAD DEL EJERCICIO.
    private String pinTarjeta; //AÑADO PIN D ETARJETA PARA SIMPLICIDAD DEL EJERCICIO.
    private double limiteMaximo;
    private double creditoActual;

    //Constructor parametrizado
    public TarjetaCredito(String numeroTarjeta, String nombreTitular, String entidadEmisora, String pinTarjeta, double limiteMaximo, YearMonth fechaCaducidad, double creditoActual) {
        this.numeroTarjeta = RandomStringUtils.randomNumeric(16).toUpperCase();
        this.nombreTitular = nombreTitular;
        this.fechaCaducidad = fechaCaducidad;
        this.entidadEmisora = entidadEmisora;
        this.estadoTarjeta = false; //Todas las tarjetas deben estar desactivadas al crearlas.
        this.pinTarjeta = pinTarjeta;
        if (pinTarjeta.length() < 4 || pinTarjeta.length() > 4) {
            pinTarjeta = "4444";
        }
        this.limiteMaximo = limiteMaximo;
        if (limiteMaximo < 500 || limiteMaximo > 3000) {
            limiteMaximo = 1000;
        }
        this.creditoActual = creditoActual;

    }

    /*Constructor con sus valores predeterminados, de los cuales obtendrá la información el constructor parametrizado si 
    no se cumple alguna restricción. */
    public TarjetaCredito() {
        this.numeroTarjeta = RandomStringUtils.randomNumeric(16).toUpperCase();
        this.nombreTitular = "Nombre de persona";
        this.fechaCaducidad = YearMonth.of(2023, 10);
        this.entidadEmisora = "Entidad emisora";
        this.estadoTarjeta = false; //Todas las tarjetas deben estar desactivadas al crearlas.
        this.pinTarjeta = "4444";
        this.limiteMaximo = 1000;
        this.creditoActual = 0;
    }

    //Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public YearMonth getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getEntidadEmisora() {
        return entidadEmisora;
    }

    public boolean isEstadoTarjeta() {
        return estadoTarjeta;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public double getLimiteMaximo() {
        return limiteMaximo;
    }

    public double getCreditoActual() {
        return creditoActual;
    }
    

    //Setters. Solamente implantamos los setters de los atributos que pueden ser modificados.
    public void setEstadoTarjeta(boolean estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
        if (pinTarjeta.length() < 4 || pinTarjeta.length() > 4) {
            pinTarjeta = "4444";
        }
    }

    public void setLimiteMaximo(double limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
        if (limiteMaximo < 500 || limiteMaximo > 3000) {
            limiteMaximo = 1000;
        }
    }

    @Override
    public String toString() {
        return "\t Nombre titular: " + nombreTitular + "\t Banco Emisor: " + entidadEmisora + "\n\t Mes/año caducidad: " + fechaCaducidad.format(DateTimeFormatter.ofPattern("MM yyyy")) + "\t Crédito: " + creditoActual + "\n\t Número de tarjeta: " + numeroTarjeta + "\n";
    }

    
    
    public boolean comprobarSiActivada(){
            return estadoTarjeta;
        }
    
    public void pagar(int cantidad) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Indtroduzca PIN: ");
        s1.nextInt();
        if (s1.equals(pinTarjeta)) {
            this.creditoActual = this.creditoActual - cantidad;
        }
        else{
            System.out.println("No se ha podido realizar la operación. PIN incorrecto.");
        }
    }
    
    public static TarjetaCredito copiar(TarjetaCredito t){
        TarjetaCredito aux = new TarjetaCredito(t.getNumeroTarjeta(), t.getNombreTitular(), t.getEntidadEmisora(), t.getPinTarjeta(), t.getLimiteMaximo(), t.getFechaCaducidad(), t.getCreditoActual());
        return aux;
    }
}