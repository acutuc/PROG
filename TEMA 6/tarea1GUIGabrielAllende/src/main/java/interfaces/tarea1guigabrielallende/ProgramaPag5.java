package interfaces.tarea1guigabrielallende;

import javax.swing.JFrame;

public class ProgramaPag5 {

    public static void main(String[] args) {

        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Gabriel Allende");

        // Establecemos posición y tamaño
        ventanaPrincipal.setBounds(250, 250, 800, 600);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

        //Con éste metodo en false, restringimos que la ventana no sea redimensionable.
        ventanaPrincipal.setResizable(false);
        
        // Acción por defecto al pulsar el botón de cierre
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
