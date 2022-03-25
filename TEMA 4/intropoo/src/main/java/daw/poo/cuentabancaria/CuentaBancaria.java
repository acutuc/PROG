package daw.poo.cuentabancaria;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author acutuc
 */
public class CuentaBancaria {

    private String numeroDeCuenta;
    private String NIF;
    private String nombreCliente;
    private double saldoActual;
    private double interesAnual;
    
    
    /*Constructor por defecto, con los valores que tú consideres oportunos. El número de cuenta debe tener 20
    dígitos y se debe generar usando la clase RandomStringUtils de la librería Apache Commons*/
    public CuentaBancaria() {
        this.numeroDeCuenta = RandomStringUtils.randomNumeric(15).toUpperCase();
        this.NIF = "48821654Z";
        this.nombreCliente = "Dimitri Vorobei";
        this.saldoActual = 134473.23;
        this.interesAnual = 1.2;
    }

    /*Constructor parametrizado con NIF, nombre, saldo e interés. Genera el número de cuenta de igual forma
    que en el constructor por defecto.*/
    public CuentaBancaria(String NIF, String nombreCliente, double saldoActual, double interesAnual) {
        this.numeroDeCuenta = RandomStringUtils.randomNumeric(15).toUpperCase();
        this.NIF = NIF;
        this.nombreCliente = nombreCliente;
        this.saldoActual = saldoActual;
        this.interesAnual = interesAnual;
        if (interesAnual > 3) {
            this.interesAnual = 3;
        }
        if (interesAnual < 0.1) {
            this.interesAnual = 0.1;
        }
    }

    /*Métodos get y set. Para el número de cuenta no hay método set, suponemos que un número de
    cuenta no se puede cambiar una vez la cuenta está creada.*/
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
        if (interesAnual > 3) {
            this.interesAnual = 3;
        }
        if (interesAnual < 0.1) {
            this.interesAnual = 0.1;
        }
    }

    /*ingresarIntereses(): aumenta el saldo de la cuenta, aplicando el interés anual
    [saldo = saldo + (interés * saldo)].*/
    public void ingresarIntereses() {
        this.saldoActual += (this.interesAnual * this.saldoActual) / 100;
    }

    //ingresarDinero(double cantidad): permite ingresar una cantidad en la cuenta.
    public void ingresarDinero(double cantidad) {
        if (cantidad > 0) {
            this.saldoActual = this.saldoActual + cantidad;
        } else {
            this.saldoActual = this.saldoActual;
        }
    }

    /*retirarEfectivo(double cantidad): permite sacar una cantidad de la cuenta (si hay saldo). Si no hay
    saldo suficiente no se realiza la operación.*/
    public void retirarEfectivo(double cantidad) {
        this.saldoActual = this.saldoActual - cantidad;
    }

    //toString()
    @Override
    public String toString() {
        return "{" + "\nNúmero de cuenta: " + numeroDeCuenta + "\nNIF: " + NIF + "\nNombre de Cliente: " + nombreCliente
                + "\nSaldo actual: " + saldoActual + "\nInterés anual: " + interesAnual + "\n}";
    }

}
