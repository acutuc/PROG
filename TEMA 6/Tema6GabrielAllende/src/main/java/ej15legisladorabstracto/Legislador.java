package ej15legisladorabstracto;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public abstract class Legislador extends Persona {

    //Atributos de la clase.
    private String provincia;
    private String partidoPolitico;

    //Constructor con sus valores por defecto.
    public Legislador() {
    }

    //Constructor parametrizado.
    public Legislador(String provincia, String partidoPolitico, String nombre, String apellido) {
        super(nombre, apellido);
        this.provincia = provincia;
        this.partidoPolitico = partidoPolitico;
    }
    
    //Getters y setters.
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
    
    //toString()
    @Override
    public String toString() {
        return super.toString() + "Legislador{" + "provincia=" + provincia + ", partidoPolitico=" + partidoPolitico + '}';
    }
    
    //Método abstracto.
    public abstract String getCamara();
}
