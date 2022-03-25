package daw.poo.cafetera;

//Partes de una clase
//Definición (public class Nombre)
public class Cafetera {
//(Utilidad que tienen public o private en la definición de una clase).
//Encapsulamiento, qué es.

    //Atributos encapsulados, campos o propiedades
    private double capacidadMaxima;
    private double cantidadActual;

    //Métodos:
    //Constructores sobrecargados (igual nombre, distintos parámetros) o no
    //Getters y Setters
    //toString
    /*Constructor predeterminado, sin parámetros: establece la capacidad máxima en 1000 (c.c.) y la cantidad actual
    en cero (cafetera vacía).*/
    public Cafetera() {
        this.capacidadMaxima = 1000;
        this.cantidadActual = 0;
    }

    /*Constructor, que recibe sólo la capacidad máxima de la cafetera; inicializa la cantidad actual de café
    igual a la capacidad máxima (cafetera llena).*/
    public Cafetera(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        if (capacidadMaxima < 10) {
            this.capacidadMaxima = 10;
        }
        this.cantidadActual = this.capacidadMaxima;
    }

    /*Constructor, que recibe la capacidad máxima y la cantidad actual. Si la cantidad actual que se pasa es mayor
    que la capacidad máxima de la cafetera, se ajustará la cantidad actual a la capacidad máxima.*/
    public Cafetera(double capacidadMaxima, double cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = Math.abs(cantidadActual);

        if (capacidadMaxima < 10) {
            this.capacidadMaxima = 10;
        }

        if (this.cantidadActual > this.capacidadMaxima) {
            this.cantidadActual = this.capacidadMaxima;
        }
    }

    //llenarCafetera(): hace que la cantidad actual sea igual a la capacidad.
    public void llenarCafetera() {
        this.cantidadActual = this.capacidadMaxima;
    }

    /*servirTaza(double cantidadAServir): simula la acción de servir una taza con la capacidad indicada.
    Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede.*/
    public void servirTaza(double cantidadAServir) {
        double cantidadPositiva = Math.abs(cantidadAServir);
        this.cantidadActual -= cantidadPositiva;
        if (this.cantidadActual < 0) {
            this.cantidadActual = 0;
        }
    }

    //vaciarCafetera(): pone la cantidad de café actual en cero.
    public void vaciarCafetera() {
        this.cantidadActual = 0;
    }

    /*agregarCafe(double cantidadAgregar): añade a la cafetera la cantidad de café indicada, teniendo en
    cuenta que la cafetera no puede rebosar.*/
    public void agregarCafe(double cantidadAgregar) {
        if ((cantidadAgregar + this.cantidadActual) > this.capacidadMaxima) {
            cantidadAgregar = 0;
        } else {
            cantidadAgregar = cantidadAgregar + this.cantidadActual;
        }
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
}
