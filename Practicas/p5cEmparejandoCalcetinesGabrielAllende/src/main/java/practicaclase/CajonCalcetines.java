package practicaclase;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class CajonCalcetines {

    //Atributos de la clase.
    private ArrayList<Calcetin> cajonCalcetines;

    //Constructor por defecto
    public CajonCalcetines() {
    }

    //Getter y setter.
    public ArrayList<Calcetin> getCajonCalcetines() {
        return cajonCalcetines;
    }

    public void setCajonCalcetines(ArrayList<Calcetin> cajonCalcetines) {
        this.cajonCalcetines = cajonCalcetines;
    }
   

    //toString
    @Override
    public String toString() {
        return "CajonCalcetines{" + "cajonCalcetines=" + cajonCalcetines + '}';
    }

    
}
