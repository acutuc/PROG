package daw.poo.complejo;

/**
 *
 * @author Gabriel
 */

/*1.Crea una clase Complejo que permita trabajar con números complejos (parte real y parte imaginaria). Se define cada número complejo z como un par ordenado de números reales: z = (a, b). A su vez el primer elemento a se define como parte real de z,
se denota a=Re(z); el segundo elemento b se define como parte imaginaria de z, se denota b=Im(z). Incluye los siguientes métodos: constructores (por defecto y parametrizado) y métodos get, set y toString. 

2. Incluye en la clase Complejo los métodos de clase: suma, resta, multiplicación, división e igualdad. Echa un vistazo en Wikipedia. Incluye un contador de instancias para la clase. En una nueva clase, que incluya el método main(), crea un par de objetos de tipo Complejo.
muestra sus datos por consola, comprueba que el contador de instancias muestra los datos correctamente y ejecuta las operaciones definidas en la clase (suma, resta, …).*/
public class Complejo {

    private double parteReal;
    private double parteImaginaria;
    private static int contadorDeInstancias;

    //Constructor por defecto
    public Complejo() {
        this.parteReal = 5.0;
        this.parteImaginaria = 4.5;
        contadorDeInstancias++;
    }

    //Constructor parametrizado
    public Complejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
        contadorDeInstancias++;
    }

    //Métodos getters y setters.
    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    //toString
    @Override
    public String toString() {
        return "z= (" + parteReal + ", " + parteImaginaria + "). Contador de instancias: " + contadorDeInstancias;
    }

    //Método suma
    public Complejo suma(Complejo suma) {
        Complejo sumar = new Complejo();
        sumar.parteReal = this.parteReal + suma.parteReal;
        sumar.parteImaginaria = this.parteImaginaria + suma.parteImaginaria;
        return sumar;
    }

    //Método resta
    public Complejo resta(Complejo resta) {
        Complejo restar = new Complejo();
        restar.parteReal = this.parteReal - resta.parteReal;
        restar.parteImaginaria = this.parteImaginaria - resta.parteImaginaria;
        return restar;
    }
    
    //Método multiplicación
    public Complejo multiplica(Complejo multiplica){
        Complejo multiplicar = new Complejo();
        multiplicar.parteReal = (this.parteReal * multiplica.parteReal) - (this.parteImaginaria * multiplica.parteImaginaria);
        multiplicar.parteImaginaria = (this.parteImaginaria * multiplica.parteImaginaria) + (this.parteImaginaria * multiplica.parteReal);
        return multiplicar;
    }
    
    //Método división
    public Complejo divide(Complejo divide){
        Complejo dividir = new Complejo();
        dividir.parteReal = ((this.parteReal * divide.parteReal) + (this.parteImaginaria * divide.parteImaginaria)) / (Math.pow(divide.parteReal, 2) + Math.pow(divide.parteImaginaria, 2));
        dividir.parteImaginaria = ((this.parteImaginaria * divide.parteReal) - (this.parteReal * divide.parteImaginaria)) / (Math.pow(divide.parteReal, 2) + Math.pow(divide.parteImaginaria, 2));
        return dividir;
    }
    
}
