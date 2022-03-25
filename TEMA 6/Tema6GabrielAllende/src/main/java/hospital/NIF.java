package hospital;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class NIF {
    //Atributos de la clase.
    private String numeroDNI;
    private char letraDNI;
    private LocalDate fechaCaducidad;

    //Constructor con sus atributos por defecto.
    public NIF() {
        this.letraDNI = calcularLetra();
    }
    
    //Constructor parametrizado
    public NIF(String numeroDNI, LocalDate fechaCaducidad) {    
        this.numeroDNI = numeroDNI;
        this.letraDNI = calcularLetra();
        this.fechaCaducidad = fechaCaducidad;
    }
    
    //Getters y setters.
    public String getNumeroDNI() {
        return numeroDNI;
    }

    public void setNumeroDNI(String numeroDNI) {
        this.numeroDNI = numeroDNI;
    }

    public char getLetraDNI() {
        return letraDNI;
    }

    public void setLetraDNI(char letraDNI) {
        this.letraDNI = letraDNI;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.numeroDNI);
        hash = 31 * hash + this.letraDNI;
        hash = 31 * hash + Objects.hashCode(this.fechaCaducidad);
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
        final NIF other = (NIF) obj;
        if (this.letraDNI != other.letraDNI) {
            return false;
        }
        if (!Objects.equals(this.numeroDNI, other.numeroDNI)) {
            return false;
        }
        return Objects.equals(this.fechaCaducidad, other.fechaCaducidad);
    }
    
    //Métodos:
    //Método que genera letra aleatoria.
    private char calcularLetra() {
        char letraGenerada = 0;
        String cadenaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int intNumeroDNI = Integer.parseInt(this.numeroDNI);
        letraGenerada = cadenaLetras.charAt(intNumeroDNI % 23);
        return letraGenerada;
    }
    
    //Método que suma 10 años al NIF al renovarlo.
    public LocalDate renovar(LocalDate fechaSolicitudRenovacion){
        return this.fechaCaducidad = fechaSolicitudRenovacion.plusYears(10);
    }
    
    
}

