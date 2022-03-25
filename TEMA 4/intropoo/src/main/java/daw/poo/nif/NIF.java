package daw.poo.nif;

/**
 *
 * @author acutuc
 */

/*9.  Crea una clase NIF que se usará para asignar el número de DNI con su correspondiente letra.
Los atributos serán dos: el número de DNI (String) y la letra que le corresponde a ese número de DNI (char).*/
/*La clase dispondrá de los siguientes métodos:
Constructor que recibe como parámetro un String con el DNI. El atributo letraDNI se establece mediante un método método privado
según el siguiente algoritmo: se obtiene el resto de la división entera del número de DNI entre 23 y se usa la siguiente tabla para
obtener la letra que corresponde.
0 – T
1 – R
2 – W
3 – A
4 – G
5 – M
6 – Y
7 – F
8 – P
9 – D
10 – X
11 – B
12 – N
13 – J
14 – Z
15 – S
16 – Q
17 – V
18 – H
19 – L
20 – C
21 – K
22 – E
Métodos getters. No hay setters.
Método toString(). Devuelve un String  con el siguiente formato: ocho caracteres, un guión y la letra en mayúscula; por ejemplo:00395469-F
Implementa un contador de instancias en la clase NIF. Incluye un método de clase getContador() para consultar el número de objetos
creados en el programa.
Incluye una clase con el método main() y prueba la clase NIF, de forma que se generen correctamente las letras en función del número de
DNI. Además prueba el contador de instancias.*/
public class NIF {
    private String numeroDNI;
    private char letraDNI;
    private static int contadorDeInstancias;

    public NIF(String numeroDNI) {
        this.numeroDNI = numeroDNI;
        this.letraDNI = generarLetraDNI();
        contadorDeInstancias++;
    }
    
    private char generarLetraDNI() {
        char letraGenerada = 0;
        String cadenaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int intNumeroDNI = Integer.parseInt(this.numeroDNI);
        letraGenerada = cadenaLetras.charAt(intNumeroDNI % 23);
        return letraGenerada;
    }

    public String getNumeroDNI() {
        return numeroDNI;
    }

    public char getLetraDNI() {
        return letraDNI;
    }


    public int getContador() {
        return this.contadorDeInstancias;
        
       
    }

    @Override
    public String toString() {
        return (numeroDNI + "-" + letraDNI + "\n" + "Contador: " + contadorDeInstancias);
    }
    
    
    
}

