
public class Apunte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int i = 0;
        //Primero usa el valor de i en la instrucción.
        //cuando termina la línea entonces le suma 1 a i.
        System.out.println("i vale: " + (i++));
        //En esta línea, i vale 1.
        System.out.println("i vale: " + i);
        //Imprimir 2 en el sout, usando i.
        System.out.println("i vale: " + (++i));
        
    }
    
}
