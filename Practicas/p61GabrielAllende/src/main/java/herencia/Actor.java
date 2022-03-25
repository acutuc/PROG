package herencia;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
//ÉSTA CLASE HEREDA DE "Cineasta"
public class Actor extends Cineasta {
    //Atributos de la clase.
    private int peliculasActorPrincipal; //Número de películas que actuó como actor principal.
    private int peliculasActorSecundario; //Número de películas que actuó como actor secundario.
    private String nombreDeLaParienta; //¿Cómo se llama la chica con la que sale?
    
    //Constructor con sus atributos por defecto.
    public Actor() {
    }
    
    //Constructor parametrizado.
    public Actor(int peliculasActorPrincipal, int peliculasActorSecundario, String nombreDeLaParienta, boolean haDirigido, String ultimaProductora, String nombre, String apellido, int edad, String nacionalidad) {
        super(haDirigido, ultimaProductora, nombre, apellido, edad, nacionalidad);
        this.peliculasActorPrincipal = peliculasActorPrincipal;
        this.peliculasActorSecundario = peliculasActorSecundario;
        this.nombreDeLaParienta = nombreDeLaParienta;
    }
    
    //Getters y setters.
    public int getPeliculasActorPrincipal() {
        return peliculasActorPrincipal;
    }

    public void setPeliculasActorPrincipal(int peliculasActorPrincipal) {
        this.peliculasActorPrincipal = peliculasActorPrincipal;
    }

    public int getPeliculasActorSecundario() {
        return peliculasActorSecundario;
    }

    public void setPeliculasActorSecundario(int peliculasActorSecundario) {
        this.peliculasActorSecundario = peliculasActorSecundario;
    }

    public String getNombreDeLaParienta() {
        return nombreDeLaParienta;
    }

    public void setNombreDeLaParienta(String nombreDeLaParienta) {
        this.nombreDeLaParienta = nombreDeLaParienta;
    }

    //toString() sobrescrito de la clase padre Cineasta.
    @Override
    public String toString() {
        //Concateno el toString() de la clase padre Cineasta con el toString() de la clase hija Actor (clase actual)
        return super.toString() + "\nActor{" + "peliculasActorPrincipal=" + peliculasActorPrincipal + ", peliculasActorSecundario=" + peliculasActorSecundario + ", nombreDeLaParienta=" + nombreDeLaParienta + '}';
    }
    
    //Método sobrescrito de la clase padre Cineasta.
    @Override
    public void envejecer5anios(){
        super.edad += 5;
    }
    
    //Método que sólo se usará en esta clase.
    public void queEsEstaPersona(){
        System.out.println("Ésta persona es un ACTOR.");
    }
    
    
}
