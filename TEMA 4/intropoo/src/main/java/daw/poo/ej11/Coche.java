package daw.poo.ej11;

/**
 *
 * @author acutuc
 */
public class Coche {
    private Motor motor;
    private Rueda ruedaDelIzq;
    private Rueda ruedaDelDer;
    private Rueda ruedaTraIzq;
    private Rueda ruedaTraDer;
    private Puerta puertaPiloto;
    private Puerta puertaCopiloto;

    public Coche(Motor motor, Rueda ruedaDelIzq, Rueda ruedaDelDer, Rueda ruedaTraIzq, Rueda ruedaTraDer, Puerta puertaPiloto, Puerta puertaCopiloto) {
        this.motor = motor;
        this.ruedaDelIzq = ruedaDelIzq;
        this.ruedaDelDer = ruedaDelDer;
        this.ruedaTraIzq = ruedaTraIzq;
        this.ruedaTraDer = ruedaTraDer;
        this.puertaPiloto = puertaPiloto;
        this.puertaCopiloto = puertaCopiloto;
    }
    
    //Constructor por defecto.
    public Coche(){
        
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Rueda getRuedaDelIzq() {
        return ruedaDelIzq;
    }

    public void setRuedaDelIzq(Rueda ruedaDelIzq) {
        this.ruedaDelIzq = ruedaDelIzq;
    }

    public Rueda getRuedaDelDer() {
        return ruedaDelDer;
    }

    public void setRuedaDelDer(Rueda ruedaDelDer) {
        this.ruedaDelDer = ruedaDelDer;
    }

    public Rueda getRuedaTraIzq() {
        return ruedaTraIzq;
    }

    public void setRuedaTraIzq(Rueda ruedaTraIzq) {
        this.ruedaTraIzq = ruedaTraIzq;
    }

    public Rueda getRuedaTraDer() {
        return ruedaTraDer;
    }

    public void setRuedaTraDer(Rueda ruedaTraDer) {
        this.ruedaTraDer = ruedaTraDer;
    }

    public Puerta getPuertaPiloto() {
        return puertaPiloto;
    }

    public void setPuertaPiloto(Puerta puertaPiloto) {
        this.puertaPiloto = puertaPiloto;
    }

    public Puerta getPuertaCopiloto() {
        return puertaCopiloto;
    }

    public void setPuertaCopiloto(Puerta puertaCopiloto) {
        this.puertaCopiloto = puertaCopiloto;
    }

    @Override
    public String toString() {
        return "Coche{" + "motor=" + motor + ", ruedaDelIzq=" + ruedaDelIzq + ", ruedaDelDer=" +
                ruedaDelDer + ", ruedaTraIzq=" + ruedaTraIzq + ", ruedaTraDer=" + ruedaTraDer + ", puertaPiloto=" +
                puertaPiloto + ", puertaCopiloto=" + puertaCopiloto + '}';
    }
    
    
}
