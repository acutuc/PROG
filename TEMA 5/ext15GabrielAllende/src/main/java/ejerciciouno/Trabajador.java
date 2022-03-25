package ejerciciouno;

import java.time.LocalDate;
import java.time.Period;
import java.lang.IllegalArgumentException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Trabajador {

    //Atributos de la clase.
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private CategoriaEmpleado categoria;
    public static final double SUELDO_BASE = 1707;

    //Constructor parametrizado
    public Trabajador(String nombre, String apellidos, LocalDate fechaNacimiento, CategoriaEmpleado categoria) {
        //LocalDate y Period para controlar la fecha de nacimiento y la fecha actual del sistema.
        LocalDate hoy = LocalDate.now();
        Period diferenciaEntreFechas = Period.between(fechaNacimiento, hoy);
        if (diferenciaEntreFechas.getYears() < 16) {
            this.fechaNacimiento = fechaNacimiento;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.categoria = categoria;
        } else {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    public Trabajador() {
    }

    public Trabajador trabajadorCopia() {
        Trabajador copia = new Trabajador();
        copia.nombre = getNombre();
        copia.apellidos = getApellidos();
        copia.fechaNacimiento = getFechaNacimiento();
        copia.categoria = getCategoria();

        return copia;
    }

    //Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpleado categoria) {
        this.categoria = categoria;
    }

    //Métodos:
    public double calcularSueldo() {
        double sueldoFinal = 0;
        switch (categoria) {
            case INICIAL:
                sueldoFinal = SUELDO_BASE + CategoriaEmpleado.INICIAL.getComplemento();
                break;
            case MEDIA:
                sueldoFinal = SUELDO_BASE + CategoriaEmpleado.MEDIA.getComplemento();
                break;
            case AVANZADA:
                sueldoFinal = SUELDO_BASE + CategoriaEmpleado.AVANZADA.getComplemento();
                break;
        }
        return sueldoFinal;
    }

    public static LocalDate fechaJubilacion(Trabajador trabajador) {
        LocalDate fechaJubilacion = trabajador.fechaNacimiento.plus(66, ChronoUnit.YEARS);
        return fechaJubilacion;
    }

    @Override
    public String toString() {
        return "\t" + getApellidos() + ", " + getNombre() + "\t F.Nac: " + getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd MM yyyy")) + "\n"
                + "Categoría: " + getCategoria() + "\n"
                + "Fecha Jubilación: " + fechaJubilacion(this) + "\n"
                + "Sueldo actual: " + this.calcularSueldo();
    }
}
