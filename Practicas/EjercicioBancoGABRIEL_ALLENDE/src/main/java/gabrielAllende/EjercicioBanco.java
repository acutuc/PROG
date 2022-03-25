package gabrielAllende;

import javax.swing.JOptionPane;

/**
 *
 * @author acu_t
 */
public class EjercicioBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*El Banco Tetimo quiere desarrollar un programa de estudio de viabilidad
        hipotecaria para potenciales clientes de la entidad. Este programa debe
        decidir si un cliente es "apto" para ser timado por el banco o por el
        contrario, según los datos aportados por el cliente, el banco lo rechaza
        y lo declara "no apto" por no ser rentable.
        - Según los gerentes de Tetimo, cuando un cliente aterriza en su web para
        solicitar una hipoteca, lo primero que deben saber es su edad y su sueldo
        bruto mensual. Hay que tener en cuenta que no se conceden préstamos a menores
        de edad y a mayores de 65 años.
        - Si la edad es válida, el programa solicita al cliente la cantidad total
        de pasta que necesita para su hipoteca. Si esa cantidad que se solicita
        supera la cantidad resultante de multiplicar el sueldo bruto anual del
        cliente por el factor multiplicativo, entonces la hipoteca se rechaza.
        En Tetimo el factor multiplicativo es de 5,85. Por ejemplo, si un cliente
        gana al año 30000 pavos, no podría pedir más de 30000*5,85.
        - Si el cliente ha pasado el filtro de edad y el filtro de la cantidad a
        solicitar, el programa le solicita el número de años en los que quiere devolver
        la hipoteca. Tetimo no concede hipotecas a más de 30 años y a menos de cinco.
        Además, si la edad de la persona sumada a los años a devolver el préstamo
        supera los 75 años, el préstamo se rechaza.*/

        //Lectura de edad y sueldo bruto mensual mediante JOptionPane.
        String edadString = JOptionPane.showInputDialog("Introduzca su edad: ");
        String sueldoBrutoString = JOptionPane.showInputDialog("Introduzca su sueldo bruto mensual: ");

        //Convierto los String edad en int y sueldoBruto en double.
        int edad = Integer.parseInt(edadString);
        double sueldoBruto = Double.parseDouble(sueldoBrutoString);

        /*Una vez sabido los datos del cliente, proseguimos con las condiciones,
        utilizando if/else*/
        //Primer filtro. Que el cliente no sea mayor de 65 años o menor de 18 años.
        if (edad > 65 || edad < 18) {
            System.out.println("No es apto para ser timado (no llame a la policía, por favor)");
        } //Segundo filtro. Que el cliente no supere el sueldo bruto anual por el factor multiplicativo.
        else {
            //Solicito al cliente la cantidad a hipotecar, mediante JOptionPane y convierto el valor a double.
            String hipotecaString = JOptionPane.showInputDialog("Introduzca la cantidad que solicita para hipotecar: ");
            int hipoteca = Integer.parseInt(hipotecaString);
            /*Inicializo las variables tipo double del sueldo bruto anual y también
        la multiplico por el factor multiplicativo.*/
            double sueldoBrutoAnual = sueldoBruto * 12;
            double factorMultiplicativo = sueldoBrutoAnual * 5.85;
            if (hipoteca > factorMultiplicativo) {
                System.out.println("No es apto para ser timado (no llame a la policía, por favor)");
            } //Tercer filtro. Que la hipoteca del cliente sea devuelta entre 5 y 30 años.
            else{
                /*Pregunto al cliente mediante JOptionPane en cuántos años quiere devolver la hipoteca
                convierto el String a int.*/
                String añosTotalesString = JOptionPane.showInputDialog("Años totales a devolver la hipoteca: ");
                int añosTotales = Integer.parseInt(añosTotalesString);
                if (añosTotales > 30 || añosTotales < 5){
                    System.out.println("No es apto para ser timado (no llame a la policía, por favor)");
                }
                else{
                    /*Declaro la variable resultante de la suma de la edad del cliente y
                    la cantidad de años de hipoteca.*/
                    int sumaedadhipoteca = añosTotales + edad;
                    if (sumaedadhipoteca > 75){
                        System.out.println("No es apto para ser timado (no llame a la policía, por favor)");
                    }
                    else{
                        System.out.println("Bienvenido al sistema hipotecario de Tetimo, el banco que "
                                + "defiende todos los derechos e intereses de sus clientes. "
                                + "Sus credenciales encajan en nuestro selecto sistema de selección, "
                                + "¡Siéntase afortunado! \nSus datos introducidos han sido los siguientes: "
                                + "\n\tEdad: " + edad + " años.\n\tSueldo bruto mensual: " + sueldoBruto + "€\n"
                                + "\tCantidad total de dinero a hipotecar: " + hipoteca + "€\n"
                                + "\tCantidad de años a devolver la hipoteca: " + añosTotales + " años.");
                    }
                }
            }
        }

    }
}
