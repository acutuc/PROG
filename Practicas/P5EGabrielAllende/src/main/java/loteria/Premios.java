package loteria;

/**
 *
 * @author Gabriel
 */
public enum Premios {
    PRIMER_PREMIO(25000000),
    SEGUNDO_PREMIO(750000),
    TERCER_PREMIO(250000),
    CUARTO_PREMIO(100000),
    QUINTO_PREMIO(25000),
    NORMAL_PREMIO(1000);
    
    private double premio;

    //Constructor parametrizado.
    private Premios(double premio) {
        this.premio = premio;
    }

    //Getter.
    public double getPremio() {
        return premio;
    }
    
}
