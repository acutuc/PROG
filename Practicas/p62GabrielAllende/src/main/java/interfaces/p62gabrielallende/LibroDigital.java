package interfaces.p62gabrielallende;

/**
 *
 * @author Gabriel
 */
//Definición de la clase final, que hereda de libro e implementa SeDescarga.
public final class LibroDigital extends Libro implements SeDescarga{
    //Atributos de la clase
    private int numKBytes;
    
    //Constructor con sus atributos por defecto.
    public LibroDigital() {
        //super();
        this.numKBytes = 1530;
    }
    
    //Constructor parametrizado.
    public LibroDigital(int numKBytes, String codigo, double precio, double iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.numKBytes = numKBytes;
    }
    
    //Getters y setters.
    public int getNumKBytes() {
        return numKBytes;
    }

    public void setNumKBytes(int numKBytes) {
        this.numKBytes = numKBytes;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.numKBytes;
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
        final LibroDigital other = (LibroDigital) obj;
        if (this.numKBytes != other.numKBytes) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return super.toString() + "LibroDigital{" + "numKBytes=" + numKBytes + '}';
    }
    
    
    //Métodos.
    public void descargar(){
        System.out.println("htt://gabrielallende.daw/" + this.hashCode());
    }
    
    //Método heredado de Libro.
    public void tipoLibro(){
        System.out.println("Éste libro es de tipo Digital.");
    }
    
    
}
