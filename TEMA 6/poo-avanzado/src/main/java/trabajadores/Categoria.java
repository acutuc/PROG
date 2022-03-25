
package trabajadores;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public enum Categoria {
    
    ANALISTA("Analista"),
    SENIOR("Senior"),
    JUNIOR("Junior");

    //Atributos
    private String tipo;
    
    //Constructor parametrizado
    private Categoria(String tipo) {
        this.tipo = tipo;
    }
    
    //Método get
    public String getTipo() {
        return tipo;
    }
    
    //Método toString
    @Override
    public String toString() {
        return "Categoria{" + "tipo=" + tipo + '}';
    }
}
