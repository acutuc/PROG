package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author acutuc
 */
//Definición de la clase
public class Calculadora {

    public static void main(String[] args) {

    	//Inicializamos un JFrame, pasamos por parámetro el título del frame.
        JFrame frame = new JFrame("Calculadora");
        
        frame.setBounds(250, 250, 0, 0);
        frame.add(new PanelPrincipal());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

}
