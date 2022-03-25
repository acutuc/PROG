package juego;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public enum Premios {
    ESQUINAS,
    POKER,
    FULL,
    ESTAMPA,
    CENTRO,
    POKINO;
    
    //Atributos de la clase.
    private int premioCentimos;
    
    //Constructor parametrizado.
    private Premios(int premioCentimos){
        this.premioCentimos = premioCentimos;
    }
    
    //Constructor con sus valores por defecto.
    private Premios() {
    }    
    
    //Getter
    public int getPremioCentimos() {
        return premioCentimos;
    }
    
    
    
}
