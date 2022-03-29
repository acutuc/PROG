package interfaces.tarea1guigabrielallende;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

public class ProgramaPag9 {

    public static void main(String[] args) {

        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Gabriel Allende");

        // Establecemos tamaño y posición
        ventanaPrincipal.setSize(500, 500);
        ventanaPrincipal.setLocationRelativeTo(null);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);
        
        //Con éste metodo en false, restringimos que la ventana no sea redimensionable.
        ventanaPrincipal.setResizable(false);

        // Acción por defecto al pulsar el botón de cierre de la ventana
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        /*Con el método pack(), la ventana cogerá el tamaño necesario para que se vea todo
//        lo que tiene dentro*/
//        ventanaPrincipal.pack();

        // Establecemos el layout del JFrame
        ventanaPrincipal.setLayout(new BorderLayout());

        // Añadimos los paneles en cada posición del BorderLayout
        // Añadir panel rojo en la posición superior (NORTH)
        ventanaPrincipal.add(new MiPanel(Color.red), BorderLayout.NORTH);

        // Añadir panel amarillo en la posición inferior (SOUTH)
        ventanaPrincipal.add(new MiPanel2(Color.yellow), BorderLayout.SOUTH);
        
        // Añadir panel azul en la posición central (CENTER)
        ventanaPrincipal.add(new MiPanel3(Color.blue), BorderLayout.CENTER);

        // Añadir panel cián en la posición izquierda (WEST)
        ventanaPrincipal.add(new MiPanel4(Color.cyan), BorderLayout.WEST);

        // Añadir panel gris en la posición derecha (EAST)
        ventanaPrincipal.add(new MiPanel5(Color.darkGray), BorderLayout.EAST);
        

    }

}
