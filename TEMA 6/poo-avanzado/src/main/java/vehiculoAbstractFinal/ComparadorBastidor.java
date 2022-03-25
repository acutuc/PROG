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

// Los objetos ComparadorBastidor son también del tipo Comparator
public class ComparadorBastidor implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo t, Vehiculo t1) {
        return t.getBastidor().compareTo(t1.getBastidor());
    }
}
