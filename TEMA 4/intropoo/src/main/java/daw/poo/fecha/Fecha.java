package daw.poo.fecha;

// Clase para tratar fechas (sólo día, mes y año)
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
// Enumerado para los meses del año (Enero, ...)
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 *
 * @author acutuc
 */

/*15.- Crea una clase Fecha con atributos para el día, el mes y el año. Incluye, al menos, los siguientes métodos:

Constructor predeterminado con el 1-1-2022, como fecha por defecto.

Constructor parametrizado con día, mes y año. Se debe comprobar que los parámetros introducidos proporcionan una fecha válida.
En caso contrario, se lanzará una excepción de tipo IllegalArgument.
comprobarFecha(int dia, int mes, int anio): comprobará si los parámetros son válidos para crear una nueva fecha. 
Ejemplos: 31-2-2010 no es una fecha correcta. Este método se debe usar en el constructor parametrizado.

Métodos get y set. Los métodos set deben tener en cuenta las restricciones lógicas y además que la nueva fecha sea válida.
En caso contrario, el método set no hace nada.

bisiesto(): indicará si el año almacenado en el atributo es bisiesto o no.

diasMes(): devolverá el número de días que tiene el mes de la fecha establecida.

mostrarFechaCorta(): mostrará la fecha en formato corto (02-09-2003).

mostrarFechaLarga(): mostrará la fecha en formato largo, empezando por el día de la semana (martes 2 de septiembre de 2003).

diaSemana(): devolverá el día de la semana de la fecha (7 para domingo, 6 para sábado, etc). El 1-1-1900 fue domingo.

diasEntreFechas(Fecha inicial, Fecha final): devolverá el número de días entre ambas fechas. Este método es de clase.

siguiente(): pasará al día siguiente.

anterior(): pasará al día anterior.

copia(): devolverá un objeto Fecha clonando la fecha almacenada en el objeto.

igualQue(Fecha): indica si la fecha es la misma que la proporcionada.

menorQue(Fecha): indica si la fecha es anterior a la proporcionada.

mayorQue(Fecha): indica si la fecha es posterior a la proporcionada.

	Este ejercicio hay qu public Fecha(int dia, int mes, int anio){
        
    }e realizarlo utilizando las clases necesarias del paquete java.time. Consultar API de Java8.
Ejemplos en https://github.com/jfervic933/fechasHorasJava8

En una clase Utilidades, implementa los siguientes métodos de clase para usarlos en el método main():

leerDia(): leerá un entero por teclado hasta que se encuentre en el rango 1 – 31 y lo devolverá.

leerMes(): leerá un entero por teclado hasta que se encuentre en el rango 1 – 12 y lo devolverá.

leerAnio(): leerá un entero por teclado hasta que se encuentre en el rango 1900 – 2100 y lo devolverá.

En una clase Test, con el método main(), usando los métodos de la clase Utilidades,
lee valores para crear tres objetos con las fechas que tú quieras.
Prueba los métodos de la clase Fecha con los objetos que consideres oportunos.*/
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
    //Constructor predeterminado con la fecha descrita en el enunciado.
    public Fecha(){
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        this.dia = 1;
        this.mes = 1;
        this.anio = 2022;
    }
    
    //Constructor parametrizado. Se debe comprobar que los parámetros introducidos proporcionan una fecha válida.
    //En caso contrario, se lanzará una excepción de tipo IllegalArgument.
    public Fecha(int dia, int mes, int anio) {
        try{
        LocalDate fecha = LocalDate.of(dia, mes, anio);
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;              
        }
        catch(DateTimeException dte){
            System.out.println("DateTime");
        }
        
    }

    //Métodos get y set. Los métodos set deben tener en cuenta las restricciones lógicas y además que la nueva fecha sea válida.
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    //comprobarFecha(int dia, int mes, int anio): comprobará si los parámetros son válidos para crear una nueva fecha.
    //Este método se debe usar en el constructor parametrizado.
    public boolean comprobarFecha(int dia, int mes, int anio){
        boolean diaBien;
        boolean mesBien;
        boolean anioBien;
        
        mesBien = mes >= 1 && mes <= 12;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
             diaBien = dia > 0 && dia <= 31;
        } else{
            System.out.println("Este mes tiene 31 días.");
        }
        
        if (mes == 2){
            diaBien = dia > 0 && dia 
        }
        anioBien = anio >= 0;
    }
    
    public boolean bisiesto(LocalDate bisiesto){
        // return (anio % 4 == 0 || anio % 100 == 0 || anio % 400 == 0);
        return bisiesto.isLeapYear();
    }
    
      
    
}
