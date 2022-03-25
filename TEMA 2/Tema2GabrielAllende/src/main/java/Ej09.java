
public class Ej09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*9.- Crea una nueva clase llamada Ej09, que contenga una llamada al
        método public static void main(String[] args). La aplicación Java
        contendrá comentarios descriptivos del código y realizará lo siguiente:
	
        a.- Declara e inicializa dos variables int (a=10,  b=20).*/
        int a = 10;
        int b = 20;
        
        //b.- Declara cuatro variables booleanas.
        boolean b1;
        boolean b2; 
        boolean b3; 
        boolean b4;
        
        /*c.- Guarda, en las variables booleanas, el resultado de realizar las
        siguientes operaciones relacionales: a<b, a>b, a==b, a!=b.*/
        b1 = a<b;
        b2 = a>b;
        b3 = a==b;
        b4 = a!=b;
        
        /*d.- Muestra en pantalla el resultado de las operaciones, usando las
        variables booleanas.*/
        System.out.println("Booleana 1: " + b1 + "\nBooleana 2: " + b2 + 
                "\nBooleana 3: " + b3 + "\nBooleana 4: " + b4);

	

    }
    
}
