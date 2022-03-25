/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.poo.puntogeometrico;

/**
 *
 * @author acutuc
 */

/*Define una clase Linea con dos atributos de la clase PuntoGeométrico: puntoA y puntoB. Estos puntos representarán el
inicio y el fin de la línea en un plano. La clase dispondrá de los siguientes métodos: */
public class Linea {
    
    private PuntoGeometrico puntoA;
    private PuntoGeometrico puntoB;
    
    /*Linea() - Constructor por defecto
    Constructor predeterminado que crea una línea con sus dos puntos como (0,0) y (1,1).*/
    public Linea(){
        this.puntoA = new PuntoGeometrico (0,0);
        this.puntoB = new PuntoGeometrico (1,1);
    }
    
    /*Linea(Punto A, Punto B) - Constructor parametrizado
    Constructor que recibe como parámetros dos objetos de la clase PuntoGeometrico, que son utilizados para inicializar los atributos.*/
    public Linea(double a, double b){
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public PuntoGeometrico getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(PuntoGeometrico puntoA) {
        this.puntoA = puntoA;
    }

    public PuntoGeometrico getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(PuntoGeometrico puntoB) {
        this.puntoB = puntoB;
    }
    
    //mueveDerecha(double x)
    //Desplaza la línea a la derecha a la distancia que se indique.
    public void mueveDerecha (double x){
        this.puntoA.setCoordenadaX(this.puntoA.getCoordenadaX()+x);
        
    }


}
