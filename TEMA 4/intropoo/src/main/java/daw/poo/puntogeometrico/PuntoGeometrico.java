/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.poo.puntogeometrico;

/**
 *
 * @author acutuc
 */

/*Crea la clase PuntoGeometrico que permita gestionar coordenadas (x,y) en un plano de dos dimensiones.
Esas coordenadas serán números reales. Incluye los siguientes métodos: constructores (por defecto y parametrizado) y métodos
get y set. En una clase de prueba, con el método main(), crea un par de objetos y prueba los métodos get y set.*/
public class PuntoGeometrico {
    private double coordenadaY;
    private double coordenadaX;
    
    public PuntoGeometrico(){
        this.coordenadaX = 0;
        this.coordenadaY = 0;
    }
    
    public PuntoGeometrico(double x, double y){
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    @Override
    public String toString() {
        return "PuntoGeometrico{" + "coordenadaY=" + coordenadaY + ", coordenadaX=" + coordenadaX + '}';
    }
    
    
}
