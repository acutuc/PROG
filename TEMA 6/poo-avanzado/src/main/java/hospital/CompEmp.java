/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.Comparator;

/**
 *
 * @author carlos
 */
public enum CompEmp {

    NOMBRE("NOMBRE", (Empleado e1, Empleado e2) -> e1.getNombre().compareTo(e2.getNombre())),
    APELLIDO("APELLIDO", (Empleado e1, Empleado e2) -> e1.getApellidos().compareTo(e2.getApellidos())),
    SALARIO("SALARIO", (Empleado e1, Empleado e2) -> (int) (e1.getSalario() - e2.getSalario())),
    NUMEROSS("NÚMERO SEGURIDAD SOCIAL",(Empleado e1, Empleado e2) -> e1.getNumeroSS().compareTo(e2.getNumeroSS()) );

    private final String criterio;
    private final Comparator<Empleado> comp;

    private CompEmp(String criterio, Comparator<Empleado> comp) {
        this.criterio = criterio;
        this.comp = comp;
    }

    public String getCriterio() {
        return criterio;
    }

    public Comparator<Empleado> getComp() {
        return comp;
    }

}
