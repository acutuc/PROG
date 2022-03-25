package ej12cuentaabstracta;

import org.apache.commons.lang3.RandomStringUtils;
import ej3personas.Persona;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public abstract class Cuenta {
    //Atributos de la clase.
    protected String numeroCuenta;
    protected double saldo;
    protected Persona cliente;
    
    /*Constructor parametrizado que sólo recibe un cliente. El saldo inicial será 0 y el número
    de cuenta se asignará automáticamente en función de algún algoritmo o criterio que tú desarrolles.
    Es evidente que no puede haber números de cuenta duplicados. Ten en cuenta que un número de cuenta
    tiene 20 dígitos.*/
    public Cuenta(Persona cliente) {
        this.cliente = cliente;
        this.saldo = 0;
        this.numeroCuenta = RandomStringUtils.randomNumeric(20);
    }
    
    //Constructor por defecto.
    public Cuenta() {
        this.numeroCuenta = RandomStringUtils.randomNumeric(20);
    }
    
    //Getters y setters.
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    //toString()
    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", cliente=" + cliente + '}';
    }
    
    //Métodos abstractos
    public abstract void actualizarSaldo();
    
    public abstract void retirarSaldo(double saldo);
    
}
