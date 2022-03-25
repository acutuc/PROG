package ej12cuentaabstracta;

import ej3personas.Persona;

/**
 *
 * @author acutuc
 */
public class PruebaCuentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creo dos Objetos de tipo Persona y Cuenta (CuentaCorriente y CuentaAhorro).
        Persona p1 = new Persona("Antonio", "09117854P", 18);
        Persona p2 = new Persona("Antonia", "09117857K", 20);
        Cuenta cc1 = new CuentaCorriente();
        Cuenta ca1 = new CuentaAhorro();

        System.out.println("Cuenta Corriente:");
        System.out.println(cc1.getSaldo());
        //Ponemos 480 de saldo en cc1
        cc1.setSaldo(480);
        //Imprimimos saldo de cc1.
        System.out.println(cc1.getSaldo());
        //Retiramos saldo de cc1.
        cc1.retirarSaldo(50000);
        cc1.actualizarSaldo();
        System.out.println(cc1.getSaldo());

        System.out.println("\nCuenta Ahorro:");
        System.out.println(ca1.getSaldo());
        ca1.setSaldo(8000);
        System.out.println(ca1.getSaldo());
        ca1.retirarSaldo(15000);
        ca1.actualizarSaldo();
        System.out.println(ca1.getSaldo());
    }

}
