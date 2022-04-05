package interfaces.p62gabrielallende;

/**
 *
 * @author Gabriel
 */
//Definición de la clase final, que hereda de libro e implementa SeEnvia.
public final class LibroPapel extends Libro implements SeEnvia {
    //Atributos de la clase.
    private int numPaginas;
    
    //Constructor con sus atributos por defecto.
    public LibroPapel() {
        //super();
        this.numPaginas = 150;
    }
    
    //Constructor parametrizado.
    public LibroPapel(int numPaginas, String codigo, double precio, double iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.numPaginas = numPaginas;
    }
    
    //Getters y setters.
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.numPaginas;
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroPapel other = (LibroPapel) obj;
        if (this.numPaginas != other.numPaginas) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return super.toString() + "LibroPapel{" + "numPaginas=" + numPaginas + '}';
    }
    
    //Métodos.
    public void enviar(String direccion){
        System.out.println("Se procede a enviar el artículo con el código " + this.getCodigo()
        + ", con el isbn " + this.getIsbn() + ", con la siguiente descripción: " + this.getDescripcion()
        + ", a la dirección " + direccion + ".\nÉste articulo es un Libro de papel.");
    }
    
    //Método abstracto heredado de Libro
    public void tipoLibro(){
        System.out.println("Este libro es de tipo Papel.");
    }
}
