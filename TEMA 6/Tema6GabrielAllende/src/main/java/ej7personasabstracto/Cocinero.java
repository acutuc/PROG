package ej7personasabstracto;

/**
 *
 * @author acutuc
 */
public class Cocinero extends Trabajador{
    //Atributos
    private String partida;

    //Constructor parametrizado.
    public Cocinero(String partida, String nombre, String apellido, String nif) {
        super(nombre, apellido, nif);
        this.partida = partida;
    }
    
    //Constructor por defecto.
    public Cocinero(){
        
    }
    
    /*Constructor con parámetro de entrada de atributo de la clase y constructor por defecto
    de la clase padre*/
    public Cocinero(String partida){
        //super();
        this.partida = partida;
    }

    //Getters y setters
    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Cocinero{" + "partida=" + partida + '}';
    }
    
    //Método cotizar()
    @Override
    public void cotizar(){
        System.out.println("Cotizando com cocinero.");
    }
    
    public void preparPlato(String plato){
        System.out.println("Cocinero preparando " + plato);
    }
    
}
