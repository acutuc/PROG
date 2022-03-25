package ej12cuentaabstracta;

import ej3personas.Persona;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class CuentaAhorro extends Cuenta{
    //Atributos de la clase
    private double interes;
    private double comisionAnual;

    //Construcctor con sus atributos por defecto.
    public CuentaAhorro() {
        super();
    }

    //Constructor parametrizado
    public CuentaAhorro(double interes, double comisionAnual, Persona cliente) {
        super(cliente);
        this.interes = interes;
        this.comisionAnual = comisionAnual;
    }

    //Getters y setters.
    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getComisionAnual() {
        return comisionAnual;
    }

    public void setComisionAnual(double comisionAnual) {
        this.comisionAnual = comisionAnual;
    }

    //toString()
    @Override
    public String toString() {
        return "CuentaAhorro{" + "interes=" + interes + ", comisionAnual=" + comisionAnual + '}';
    }

    //Métodos
    @Override
    public void retirarSaldo(double dinero) {
        if ((getSaldo() - dinero) > 0 && getSaldo() > 0) {
            setSaldo(getSaldo() - dinero);

        }
    }

    @Override
    public void actualizarSaldo() {
        setSaldo((getSaldo() + (getSaldo() * interes)) - comisionAnual);

    }
}
