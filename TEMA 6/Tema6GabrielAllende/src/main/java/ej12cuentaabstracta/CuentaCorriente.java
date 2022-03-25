/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej12cuentaabstracta;

import ej3personas.Persona;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class CuentaCorriente extends Cuenta {
    //Atributos de la clase.
    private double interesFijo = 1.5;
    private double saldoMin;
    
    //Constructor con sus valores por defecto.
    public CuentaCorriente(){
    }
    
    //Constructor parametrizado.
    public CuentaCorriente(double saldoMin, Persona cliente, double interesFijo) {
        super(cliente);
        //Nos aseguramos de que el saldo mínimo no sea nunca negativo.
        this.saldoMin = Math.abs(saldoMin);
        this.interesFijo = interesFijo;
    }
    
    //Getters y setters.
    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getInteresFijo() {
        return interesFijo;
    }

    public void setInteresFijo(double interesFijo) {
        this.interesFijo = interesFijo;
    }
    
    
    //toString()
    @Override
    public String toString() {
        return super.toString() + "\nInterés: " + this.interesFijo + "\nSaldo mínimo: " + this.saldoMin;
    }
    
    //Métodos
    @Override
    public void retirarSaldo(double cantidad){
        if(this.getSaldo() - cantidad < this.getSaldoMin()){
            System.out.println("No tienes saldo suficiente para retirar esta cantidad.");
        }else{
            this.setSaldo(this.getSaldo() - cantidad);
        }
    }
    
    @Override
    public void actualizarSaldo(){
        if(this.getSaldo() > 1000){
            this.setSaldo(this.getSaldo() + (this.getSaldoMin() * this.interesFijo));
        }else{
            this.setSaldo(this.getSaldo() + (this.getSaldoMin() + this.interesFijo));
        }
    }
    
    
}
