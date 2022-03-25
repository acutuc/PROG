package daw.poo.maquinavending.gabrielallendejuanjosebazan;

//Importamos
import java.time.Year;
import java.time.YearMonth;
import org.apache.commons.lang3.RandomStringUtils;
/**
 *
 * @author Gabriel
 */
//Definición de la clase
public class Tarjetas {
    //Atributos de la clase Tarjetas. Seran "final", pues no podrán ser modificados (no habrá setters).
    private final String NUMERO_TARJETA;
    private final YearMonth FECHA_CADUCIDAD;
    private final String CVV;
    private int dineroAcumulado;

    //Constructor con sus atributos con valores predeterminados.
    public Tarjetas() {
        //Generamos el número de tarjeta con 16 digitos.
        this.NUMERO_TARJETA = RandomStringUtils.randomNumeric(16); 
        //Establecemos una fecha fija, dentro de unos parámetros reales.
        this.FECHA_CADUCIDAD = YearMonth.of(2023, 10);
        //Generamos el CVV con 3 dígitos.
        this.CVV = RandomStringUtils.randomNumeric(3);
        this.dineroAcumulado = dineroAcumulado;
    }
   //No ponemos constructor parametrizado, pues entendemos que un usuario no tiene libertad de crear tarjetas.
    
    //Getters
    public String getNUMERO_TARJETA() {
        return NUMERO_TARJETA;
    }

    public YearMonth getFECHA_CADUCIDAD() {
        return FECHA_CADUCIDAD;
    }

    public String getCVV() {
        return CVV;
    }

    public int getDineroAcumulado() {
        return dineroAcumulado;
    }

    public void setDineroAcumulado(int dineroAcumulado) {
        this.dineroAcumulado = dineroAcumulado;
    }
    
    
    
    //toString.
    @Override
    public String toString() {
        return "Tarjetas{" + "NUMERO_TARJETA=" + NUMERO_TARJETA + ", FECHA_CADUCIDAD=" + FECHA_CADUCIDAD + ", CVV=" + CVV + ", dineroAcumulado=" + dineroAcumulado + '}';
    }
    
    public void ventaRealizada(int cantidadIngresada){
        this.dineroAcumulado = dineroAcumulado + cantidadIngresada;
    }
    
    
    
}
