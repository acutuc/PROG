
public class Ej08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*8.- Crea una nueva clase llamada Ej08, que contenga una llamada al método
    public static void main(String[] args). La aplicación Java contendrá
    comentarios descriptivos del código y realice lo siguiente:
    a.- Declara e inicializa tres variables int (a=10,  b=5, i=0)*/
    
    //Declaro e inicializo las variables.
    int a = 10;
    int b = 5;
    int i = 0;
    
    //*b.- Declara e inicializa dos variables double (c=71.3 y d=4.8)
    
    //Declaro e inicializo las variables.
    double c = 71.3;
    double d = 4.8;
    
    /*c.- Realiza las siguiente operaciones aritméticas a+b, a-b, a*b, a/b, c+d,
    c-d, c*d, c/d. El resultado de cada operación se almacena en una nuevas
    variables que se crearán para tal efecto.*/
    
    /*Declaro e inicializo las nuevas variables con el resultado de las
    operaciones anteriores.*/
    int amasb = a + b;
    int amenosb = a - b;
    int aporb = a * b;
    int aentreb = a / b;
    double cmasd = c + d;
    double cmenosd = c - d;
    double cpord = c * d;
    double centred = c / d;
    
    /*d.- Muestra el resultado de cada operación, usando las variables creadas
    en el paso c).*/
    
    System.out.println("a+b= " + amasb + "\na-b= " + amenosb + "\na*b= " + aporb
    + "\na/b= " + aentreb + "\nc+d= " + cmasd + "\nc-d= " + cmenosd
    + "\nc*d= " + cpord + "\nc/d= " + centred);

    /*e.- También muestra en pantalla los resultados de las siguientes
    operaciones: a*=3, b-=1, a/=b, c+=d.*/
    
    System.out.println("");


    }
    
}
