/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculoAbstractFinal;

import java.util.Comparator;

/**
 *
 * @author carlos
 */
public class ComparadorColor implements Comparator<Vehiculo>{

    @Override
    public int compare(Vehiculo t, Vehiculo t1) {
       return t.getColor().compareTo(t1.getColor());
    }

}
