package hospital;

import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Administrativo extends Empleado{
    //Atributos de la clase
    private Grupo grupo;
    
    //Constructor por defecto.
    public Administrativo() {
        this.grupo = Grupo.C;
    }
    
    //Constructor parametrizado
    public Administrativo(Grupo grupo, String numeroSeguridadSocial, double salario, String nombre, String apellidos, NIF nif) {
        super(numeroSeguridadSocial, salario, nombre, apellidos, nif);
        this.grupo = grupo;
    }
    
    //Getters y setters
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.grupo);
        return hash;
    }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrativo other = (Administrativo) obj;
        if (this.grupo != other.grupo) {
            return false;
        }
        return true;
    }
    
    //toString()
    @Override
    public String toString() {
        return super.toString() + "Administrativo{" + "grupo=" + grupo + '}';
    }
    
    //Método sobrescrito de la clase padre.
    @Override
    public double calcularIRPF(){
        return super.getSalario() * this.grupo.getIrpf();
    }
    
    //Método para que el administrativo registre un documento
    public void registrarDocumento(String nombreDoc){
        System.out.println("El administrativo " + this.getNombre() + " " + this.getApellidos() +
                ", reigistra el documento " + nombreDoc + " con el hashCode " + nombreDoc.hashCode());
    }
    
    
    
}
