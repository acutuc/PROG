package hospital;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Gabriel
 */
//Definición de la clase.
public class Hospital {
    //Atributos de la clase.
    private String nombre;
    private String direccion;
    private int numeroCamas;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Paciente> listaPacientes;
    
    //Constructor con sus atributos por defecto.
    public Hospital() {
    }
    
    //Constructor parametrizado
    public Hospital(String nombre, String direccion, int numeroCamas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroCamas = numeroCamas;
        this.listaEmpleados = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
    }
    
    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.direccion);
        hash = 41 * hash + this.numeroCamas;
        hash = 41 * hash + Objects.hashCode(this.listaEmpleados);
        hash = 41 * hash + Objects.hashCode(this.listaPacientes);
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
        final Hospital other = (Hospital) obj;
        if (this.numeroCamas != other.numeroCamas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.listaEmpleados, other.listaEmpleados)) {
            return false;
        }
        if (!Objects.equals(this.listaPacientes, other.listaPacientes)) {
            return false;
        }
        return true;
    }
    
    //toString()

    @Override
    public String toString() {
        return "Hospital{" + "nombre=" + nombre + ", direccion=" + direccion + ", numeroCamas=" + numeroCamas + ", listaEmpleados=" + listaEmpleados + ", listaPacientes=" + listaPacientes + '}';
    }
    
    //Métodos.
    public void contratarEmpleados(Empleado emp){
        this.listaEmpleados.add(emp);
    }
    
    public void ingresarPaciente(Paciente paciente){
        this.listaPacientes.add(paciente);
    }
    
    
}
