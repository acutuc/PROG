/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajadores;

/**
 *
 * @author carlos
 */
public class Camarero extends Empleado{
    
    private String rango;

    public Camarero(String rango) {
        // super();
        this.rango = rango;
    }

    public Camarero(String rango, double salario, String nombre, String nif, int edad) {
        super(salario, nombre, nif, edad);
        this.rango = rango;
    }

    public Camarero(double salario, String nombre, String nif, int edad) {
        super(salario, nombre, nif, edad);
        this.rango = "Sumellier";
    }
    
    
    
    
    public void servirMesa(String comida){
        System.out.println("El camarero " + this.getNombre() + " está sirviendo "
         + comida);
    }
   
    
    // Método polimórfico
    @Override
    public void cotizar(){
    
        System.out.println("Cotizando como camarero");
        
    }
    
}
