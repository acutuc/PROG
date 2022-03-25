
public class Ej06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*6.- Crea una nueva clase llamada Ej06, que contenga una llamada al
              método public static void main(String[] args). La aplicación Java
              contendrá comentarios descriptivos del código e intercambiará los 
              valores de dos variables de tipo entero, haciendo uso de una 
              tercera variable auxiliar. Antes de intercambiar los valores,
              debes declarar e inicializar las variables con los valores que tú
              quieras. Muestra los valores de las variables antes de
              intercambiar sus valores y después del intercambio.*/
        
        //Declaración e inicialización de las variables.
        int entero1 = 0;
        int entero2 = 2;
        int aux = 3;
        
        
        System.out.println("Los valores de las variables son= " + entero1 + "/"
                + entero2 + "/" + aux);
        
        //Realizo el intercambio de valores.
        aux=entero1;
        entero1=entero2;
        entero2=aux;
        
        System.out.println("Las valores de las variables tras el intercambio= "
        + entero1 + "/" + entero2 + "/" + aux);  
        

    }
    
}
