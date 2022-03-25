package ej3personas;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Programador extends Empleado{
    //Atributos de la clase.
    private Categoria categoria;
    
    //Constructor con sus atributos por defecto.
    public Programador() {
    }
    
    //Constructor parametrizado.
    public Programador(Categoria categoria, double salario, String nombre, String nif, int edad) {
        super(salario, nombre, nif, edad);
        this.categoria = categoria;
    }
    
    //Getters y setters.
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    //toString() que sobrescribe el método toString() de la superclase (Empleado).
    @Override
    public String toString() {
        return super.toString() + "Categoría: " + this.categoria;
    }
    
    
}
