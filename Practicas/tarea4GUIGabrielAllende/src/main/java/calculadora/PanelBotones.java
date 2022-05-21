package calculadora;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author acutuc
 */
//Definición de la clase, hereda JPanel
public class PanelBotones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Creamos un grupo de botones
	//10 botones para los números (0-9)
	//4 botones para sumar, restar, multiplicar, dividir
	//1 botón para mostrar resultado.
	//1 botón para borrar.
    JButton[] listaBotones = new JButton[16];

    //Constructor con sus atributos por defecto.
    public PanelBotones() {
    	//Inicializamos los botones mediante el método.
        initComponents();
    }

    //Método que inicializa todos los componentes.
    private void initComponents() {

        // Creación de los botones
        for (int i = 0; i < 10; i++) {
        	listaBotones[i] = new JButton(Integer.toString(i));
        }
        listaBotones[10] = new JButton("+");
        listaBotones[11] = new JButton("-");
        listaBotones[12] = new JButton("*");
        listaBotones[13] = new JButton("/");
        listaBotones[14] = new JButton("=");
        listaBotones[15] = new JButton("C");

        //Inicializamos el Layout de 4x4
        this.setLayout(new GridLayout(4, 4));

        //Recorremos la lista de botones
        for (JButton boton : listaBotones) {
            this.add(boton);
        }
    }

    public JButton[] getgrupoBotones() {
        return listaBotones;
    }
}
