package hospital;

/**
 *
 * @author Gabriel
 */
//Definición de la clase Enum
public enum Grupo {
    C(0.175),
    D(0.18),
    E(0.185);
    
    //Atributos de la clase
    private final double irpf;

    //Constructor parametrizado encapsulado.
    private Grupo(double irpf) {
        this.irpf = irpf;
    }
    
    //Getter
    public static Grupo getC() {
        return C;
    }

    public static Grupo getD() {
        return D;
    }

    public static Grupo getE() {
        return E;
    }

    public double getIrpf() {
        return irpf;
    }
}
