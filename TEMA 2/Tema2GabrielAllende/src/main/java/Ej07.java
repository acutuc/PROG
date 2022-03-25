
public class Ej07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*a.- Declara e inicializa tres variables int en la misma instrucción
        (a=1, b=2, c=3).*/
        //Declaración e inicialización de las variables tipo int.
        int a = 1;
        int b = 2;
        int c = 3;
        
        /*b.- Declara e inicializa tres variables double en la misma instrucción
        (d=4.5, e=5.7, f=6.9).*/
        //Declaración e inicialización de las variables tipo double.
        double d = 4.5;
        double e = 5.7;
        double f = 6.9;
        
        /*c.- Muestra las variables en dos líneas, la primera línea mostrará
        las variables tipo entero y la segunda línea mostrará las variables
        tipo double.*/
        System.out.println("VARIABLES TIPO ENTERO: " + a + - + b + - + c + 
        "\nVARIABLES TIPO DOUBLE: " + d + - + e + - + f);
        
        /*d.- Realiza los siguiente intercambios de valores: en b guarda c, en
        c guarda a, en a guarda b. Muestra por pantalla el resultado.*/
        b = c;
        c = a;
        a = b;
        System.out.println("Valor de 'a': " + a + "\nValor de 'b': " + b
        + "\nValor de 'c': " + c);
        
        /*e.- Realiza los siguiente intercambios de valores: en e guarda f,
        en f guarda d, en d guarda e. Muestra por pantalla el resultado.*/
        e = f;
        f = d;
        d = e;
        System.out.println("Valor de 'd': " + d + "\nValor de 'e': " + e 
        + "\nValor de 'f': " + f);


    }
    
}
