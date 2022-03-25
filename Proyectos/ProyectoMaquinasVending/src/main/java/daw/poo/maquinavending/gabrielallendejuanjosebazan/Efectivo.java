package daw.poo.maquinavending.gabrielallendejuanjosebazan;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Efectivo {

    //Atributos de la clase. Los inicializamos con el valor en céntimos.
    private final int[] valorDinero = {10, 20, 50, 100, 200, 500, 1000, 2000};
    //Array para contar la cantidad de monedas. Índice [0] para 0,10€, índice [1] para 0,20€, etc.
    private int[] cantidadMonedas = new int[8];

    //Constructor con sus valores predeterminados. Obligaremos a cada máquina a empezar con una unidad de cada moneda/billete.
    public Efectivo() {
        this.cantidadMonedas[0] = 1; //1 moneda de 0,10€
        this.cantidadMonedas[1] = 1; //1 moneda de 0,20€
        this.cantidadMonedas[2] = 1; //1 moneda de 0,50€
        this.cantidadMonedas[3] = 1; //1 moneda de 1€
        this.cantidadMonedas[4] = 1; //1 moneda de 2€
        this.cantidadMonedas[5] = 1; //1 billete de 5€
        this.cantidadMonedas[6] = 1; //1 billete de 10€
        this.cantidadMonedas[7] = 1; //1 billete de 20€
    }

    public int[] getCantidadMonedas() {
        return cantidadMonedas;
    }

    public void setCantidadMonedas(int[] cantidadMonedas) {
        this.cantidadMonedas = cantidadMonedas;
    }

    //Método que almacena monedas.
    public void agregarMoneda(int monedaAgregada, int cantidadMonedas) {
        this.cantidadMonedas[monedaAgregada] = cantidadMonedas;
    }

    //Método que retira monedas.
    public void retirarMoneda(int monedaRetirada, int cantidadMonedas) {
        this.cantidadMonedas[monedaRetirada] = cantidadMonedas;
    }

    public Efectivo(int moneda10Int, int moneda20Int, int moneda50Int, int moneda1Int, int moneda2Int, int billete5Int, int billete10Int, int billete20Int) {

        this.cantidadMonedas[0] = moneda10Int; //1 moneda de 0,10€
        this.cantidadMonedas[1] = moneda20Int; //1 moneda de 0,20€
        this.cantidadMonedas[2] = moneda50Int; //1 moneda de 0,50€
        this.cantidadMonedas[3] = moneda1Int; //1 moneda de 1€
        this.cantidadMonedas[4] = moneda2Int; //1 moneda de 2€
        this.cantidadMonedas[5] = billete5Int; //1 billete de 5€
        this.cantidadMonedas[6] = billete10Int; //1 billete de 10€
        this.cantidadMonedas[7] = billete20Int; //1 billete de 20€

    }

    @Override
    public String toString() {
        return "Efectivo{" + "valorDinero=" + Arrays.toString(valorDinero) + ", cantidadMonedas=" + Arrays.toString(cantidadMonedas) + '}';
    }

}
