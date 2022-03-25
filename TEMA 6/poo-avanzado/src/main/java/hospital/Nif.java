/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.time.LocalDate;

/**
 *
 * @author carlos
 */
public class Nif {
    
    private long numero;
    private char letra;
    private LocalDate fechaCaducidad;

    public Nif(long numero, LocalDate fechaCaducidad){
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.letra = calcularLetra(numero);
    }
    
    public Nif(){
        this.numero = 0l;
        this.letra = 'a';
        this.fechaCaducidad = LocalDate.now();
    }
    private char calcularLetra(long numero){
        char letra = ' ';
        // Cálculo de la letra en función del número
        
        return letra;
    }
    
    public long getNumero() {
        return numero;
    }


    public char getLetra() {
        return letra;
    }


    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
    
}
