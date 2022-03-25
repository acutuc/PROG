/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author carlos
 */
public abstract class Legislador extends Empleado{
    
    private String provincia;
    private String partidoPolitico;

    // Un método abstract no tiene código
    public abstract String getCamaraTrabaja();
    
    public Legislador(String provincia, String partidoPolitico, String numeroSS, double salario, String nombre, String apellidos, Nif nif) {
        super(numeroSS, salario, nombre, apellidos, nif);
        this.provincia = provincia;
        this.partidoPolitico = partidoPolitico;
    }
    
    public Legislador(){
        super();
        this.partidoPolitico = " Sin partido ";
        this.provincia = "Sin provincia";
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    @Override
    public String toString() {
        return super.toString() + " Legislador{" + "provincia=" + provincia + ", partidoPolitico=" + partidoPolitico + '}';
    }
            
    
    
}
