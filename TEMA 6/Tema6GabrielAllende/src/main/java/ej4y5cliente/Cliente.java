package ej4y5cliente;

import java.util.Objects;

/**
 *
 * @author acutuc
 */
/*4.- ¿Qué diferencia existe entre sobrecargar un método y sobrescribir un método?
Sobrecargar un método es, asignarle el mismo nombre al propio método, aunque uno tenga
que tener por por paámetro variables diferentes.
Sobrescribir un método implica que un método es heredado de una clase padre, y éste
toma sus valores propios.*/
//Definición de la clase.
public class Cliente {

    //Atributos de la clase
    private String nombre;
    private String dni;
    private int edad;

    //Constructor parametrizado
    public Cliente(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    //Constructor con sus valores por defecto.
    public Cliente() {
    }
    
    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.dni);
        hash = 59 * hash + this.edad;
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
        Cliente other = (Cliente) obj;

    // Se comparan los estados de los objetos
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

}
