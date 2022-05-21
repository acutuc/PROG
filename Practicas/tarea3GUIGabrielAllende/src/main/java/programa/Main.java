package programa;

import javax.swing.JFrame;

/**
 *
 * @author acutuc
 */
public class Main {

    public static void main(String[] args) {
        // Construimos la ventana
        JFrame ventana = new JFrame("AnexoIITarea3");

        // La ventana no se puede redimensionar
        ventana.setResizable(false);

        // Posición de la ventana
        ventana.setLocationRelativeTo(null);

        // Incluimos el panel en la ventana
        ventana.add(new Botones());

        // Ajusta el ventana al contenido
        ventana.pack();

        // Hacemos visible la ventana
        ventana.setVisible(true);

        //Acción por defecto al pulsar el botón de cierre de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
