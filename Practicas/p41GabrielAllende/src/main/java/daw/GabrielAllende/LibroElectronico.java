/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.GabrielAllende;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author acutuc
 */
public class LibroElectronico {

    private String identificador;
    private String titulo;
    private int numPag;
    private double tamanioMem;
    private int pagActual;

    //Constructor por defecto, con los detalles descritos en el enunciado.
    public LibroElectronico() {
        this.identificador = RandomStringUtils.randomNumeric(3).toUpperCase();
        this.titulo = "Don Quijote de la Mancha";
        this.numPag = 1435;
        this.tamanioMem = 5;
        this.pagActual = 1;

    }

    //Constructor parametrizado, con sus respectivas condiciones descritas en el enunciado.
    public LibroElectronico(String identificador, String titulo, int numPag, double tamanioMem, int pagActual) {
        this.identificador = RandomStringUtils.randomNumeric(3).toUpperCase();
        this.titulo = titulo;
        this.numPag = numPag;
        //Restricción de páginas.
        if (numPag > 9999 || numPag < 0) {
            this.numPag = 0;
        }
        
        this.tamanioMem = tamanioMem;
        //Restricción de tamaño.
        if (tamanioMem > 10 || tamanioMem < 0) {
            this.tamanioMem = 0;
        }
        
        this.pagActual = pagActual;
        if (pagActual > this.numPag) {
            this.pagActual = 0;
        }
    }

    //Getter
    public String getIdentificador() {
        return identificador;
    }

    //Setter
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    //Getter
    public String getTitulo() {
        return titulo;
    }

    //Setter
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Getter
    public int getNumPag() {
        return numPag;
    }

    //Setter
    public void setNumPag(int numPag) {
        //Restricción de páginas.
        if (numPag > 9999 || numPag < 0) {
            this.numPag = 0;
        }
    }

    //Getter
    public double getTamanioMem() {
        return tamanioMem;
    }

    //Setter
    public void setTamanioMem(double tamanioMem) {
        this.tamanioMem = tamanioMem;
        //Restricción de tamaño.
        if (tamanioMem > 10 || tamanioMem < 0) {
            this.tamanioMem = 0;
        }
    }

    //Getter
    public int getPagActual() {
        return pagActual;
    }

    //Setter
    public void setPagActual(int pagActual) {
        this.pagActual = pagActual;
        //Restricción para que la página actual no pueda ser mayor al número de páginas totales.
        if (pagActual > this.numPag) {
            this.pagActual = 0;
        }
    }

    //toString.
    @Override
    public String toString() {
        return "LibroElectronico{" + "\nIdentificador: " + identificador + "\nTítulo: " + titulo + "\nNúmero de páginas totales: "
                + numPag + "\nTamaño en MB del libro: " + tamanioMem + "\nPágina actual: " + pagActual + "\n}";
    }

    //pasarPagina(), que pasa a la siguiente página.
    public void pasarPagina() {
        this.pagActual += 1; //Se pasa a la siguiente página.
        //Condición. No puede pasarse de la última página del libro.
        if (this.pagActual > this.numPag) {
            this.pagActual = this.numPag; //Al no poder pasar de página, se quedaría en la misma (la última).
        }
    }

    //retrocederPagina(), que retrocede una página.
    public void retrocederPagina() {
        this.pagActual -= 1; //Se retrocede a la página anterior.
        //Condición. No se puede retroceder a la página -1.
        if (this.pagActual < 0) {
            this.pagActual = 0; //Al no poder retroceder a la página -1, se quedaría en la 0.
        }
    }

    /*saltar(int numero), salta hacia adelante (si el parámetro numero es positivo) o hacia atrás (si el
    parámetro numero es negativo) tantas páginas como indique el parámetro.*/
    public void saltar(int numero) {
        this.pagActual = this.pagActual + numero; //Se suma o resta tantas páginas como pasemos por parámetro.
        /*Condición para que no supere el número de páginas totales del libro (en caso de sumar),
        o que no retroceda más allá de la página 0.*/
        if (this.pagActual > this.numPag || this.pagActual < 0) {
            this.pagActual = this.pagActual - numero;
            /*Si se supera el número de páginas totales o retrocede más allá de la página
            0, no se avanza ni retrocede ninguna página.*/
        }

    }

    /*Si el modificador de acceso es public, se puede acceder (modificar) el atributo desde cualquier
    clase, más allá de si está en el mismo paquete o no, o si es de diferente proyecto.
    Si el modificador de acceso es private, los atributos solamente son accesibles desde la misma
    clase en la que se les designó dicho modificador.*/
}
