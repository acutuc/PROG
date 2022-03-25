
package ejerciciouno;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public enum CategoriaEmpleado {
    INICIAL("Categoría Básica", 50),
    MEDIA("Categoría Media", 70),
    AVANZADA("Categoría Avanzada", 100);
    
    //Atributos de la clase.
    private String nombre;
    private int complemento;

    //Constructor parametrizado.
    private CategoriaEmpleado(String nombre, int complemento) {
        this.nombre = nombre;
        this.complemento = complemento;
    
    }

    //Getters
    public static CategoriaEmpleado getINICIAL() {
        return INICIAL;
    }

    public static CategoriaEmpleado getMEDIA() {
        return MEDIA;
    }

    public static CategoriaEmpleado getAVANZADA() {
        return AVANZADA;
    }

    public String getNombre() {
        return nombre;
    }

    public int getComplemento() {
        return complemento;
    }
}
