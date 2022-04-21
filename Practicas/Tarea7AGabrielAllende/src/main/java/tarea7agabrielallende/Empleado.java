package tarea7agabrielallende;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Empleado {
    //Atributos de la clase.
    private String nomEmpleado;
    private String numIdentificativo;
    private String puesto;
    private LocalDate fecIniPuesto;
    private LocalDate fecCesePuesto;
    private String telefono;
    private boolean evaluador;
    private boolean coordinador;
    
    //Constructor con sus atributos por defecto
    public Empleado(){
    }
    
    //Constructor parametrizado
//    public Empleado(String nomEmpleado, String numIdentificativo, String puesto, LocalDate fecIniPuesto, LocalDate fecCesePuesto, String telefono, boolean evaluador, boolean coordinador) {
//        this.nomEmpleado = nomEmpleado;
//        this.numIdentificativo = numIdentificativo;
//        this.puesto = puesto;
//        this.fecIniPuesto = fecIniPuesto;
//        this.fecCesePuesto = fecCesePuesto;
//        this.telefono = telefono;
//        this.evaluador = evaluador;
//        this.coordinador = coordinador;
//    }
    
    //En las clases POJO no es obligatorio implementar los constructores parametrizados,
    //aunque si es de total obligación implementar los atributos encapsulados, getters, setters y toString.
    
    
    
    //Getters y setters
    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getNumIdentificativo() {
        return numIdentificativo;
    }

    public void setNumIdentificativo(String numIdentificativo) {
        this.numIdentificativo = numIdentificativo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFecIniPuesto() {
        return fecIniPuesto;
    }

    public void setFecIniPuesto(LocalDate fecIniPuesto) {
        this.fecIniPuesto = fecIniPuesto;
    }

    public LocalDate getFecCesePuesto() {
        return fecCesePuesto;
    }

    public void setFecCesePuesto(LocalDate fecCesePuesto) {
        this.fecCesePuesto = fecCesePuesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nomEmpleado);
        hash = 79 * hash + Objects.hashCode(this.numIdentificativo);
        hash = 79 * hash + Objects.hashCode(this.puesto);
        hash = 79 * hash + Objects.hashCode(this.fecIniPuesto);
        hash = 79 * hash + Objects.hashCode(this.fecCesePuesto);
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + (this.evaluador ? 1 : 0);
        hash = 79 * hash + (this.coordinador ? 1 : 0);
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
        final Empleado other = (Empleado) obj;
        if (this.evaluador != other.evaluador) {
            return false;
        }
        if (this.coordinador != other.coordinador) {
            return false;
        }
        if (!Objects.equals(this.nomEmpleado, other.nomEmpleado)) {
            return false;
        }
        if (!Objects.equals(this.numIdentificativo, other.numIdentificativo)) {
            return false;
        }
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fecIniPuesto, other.fecIniPuesto)) {
            return false;
        }
        if (!Objects.equals(this.fecCesePuesto, other.fecCesePuesto)) {
            return false;
        }
        return true;
    }
    
    //toString()
    @Override
    public String toString() {
        return nomEmpleado + "\t" + numIdentificativo + "\t" + puesto + "\t" + fecIniPuesto + "\t" + fecCesePuesto + "\t" + telefono + "\t" + evaluador + "\t" + coordinador;
    }
    
    
    
    
}
