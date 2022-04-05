package loteria;

/**
 *
 * @author Gabriel
 */
public class LoteriaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicializo una nueva loteria.
        Loteria loteria = new Loteria();
        
        int contadorPrimero = 1;
        int contadorSegundo = 1;
        int contadorTercero = 1;
        int contadorCuarto = 1;
        int contadorQuinto = 1;
        Premios premio;
        
        for (int i = 0; i < 1000; i++) {
            if (i == 978 && contadorPrimero > 1) {
                premio = Premios.PRIMER_PREMIO;
                contadorPrimero++;
            } else if (i < 100 && i > 50 && contadorSegundo > 2) {
                premio = Premios.SEGUNDO_PREMIO;
                contadorSegundo++;
            } else if (i < 300 && i > 200 && contadorTercero > 3) {
                premio = Premios.TERCER_PREMIO;
                contadorTercero++;
            } else if (i < 600 && i > 400 && contadorTercero > 3) {
                premio = Premios.CUARTO_PREMIO;
                contadorCuarto++;
            } else if (i < 900 && i > 700 && contadorTercero > 3) {
                premio = Premios.QUINTO_PREMIO;
                contadorQuinto++;
            } else {
                premio = Premios.NORMAL_PREMIO;
            }
            loteria.addPremio(new Decimos(), premio);
        }

        Decimos decimoABuscar = new Decimos("354651");
        System.out.println("Premio del decimo 354651: " + loteria.consulta(decimoABuscar));

        
        Decimos decimoExistente = (Decimos) loteria.getLoteria().keySet().toArray()[0];
        

        System.out.println("Premio del " + decimoExistente + ": "
                + loteria.consulta(decimoExistente).getPremio() + "€");
    }
}
