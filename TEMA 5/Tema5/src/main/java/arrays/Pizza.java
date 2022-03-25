/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package arrays;

/**
 *
 * @author acutuc
 */
//Es una clase especial que contiene objetos constantes.
//Constructor en privado.
//No hay setter.
//Recomendable atributos final.
//Se definen los objetos al principio del enum.
public enum Pizza {
    
    BARBACOA(30, "Barbacoa", new String[] {"jamon", "queso"}, 13.0);
    
    private final int tamanio;
    private final String nombre;
    private final String[] ingredientes;
    private final double precio;

    private Pizza(int tamanio, String nombre, String[] ingredientes, double precio) {
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
    }
    
        
}
