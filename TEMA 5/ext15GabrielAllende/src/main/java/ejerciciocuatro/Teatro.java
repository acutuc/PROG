package ejerciciocuatro;

/**
 *
 * @author acutuc
 */
//Definición de la clase.
public class Teatro {

    //Atributos de la clase.
    //0 libre, 1 reservado, -1 covid.
    private int filas;
    private int columnas;
    private int[][] asientos;

    //Constructor parametrizado.
    public Teatro(int filas, int columnas) {
        this.asientos = new int[filas][columnas];
        llenarAsientos();
    }

    //Métodos
    private void llenarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (((i + 1) % 2) != 0 && ((j + 1) % 2) != 0) {
                    asientos[i][j] = 0;
                } else {
                    asientos[i][j] = -1;
                }
            }
        }
    }

    private void reservar() {

    }

    private void cancelar() {

    }

}
