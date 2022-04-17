package gui.tarea2guigabrielallende;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Se implementa la interfaz
public class Saludo extends JPanel implements ActionListener {

    //Atributos
    private JButton btnNombre;
    private JTextArea texto;
    private JButton btnApellidos;

    //Constructor
    public Saludo() {
        initComponents();
    }

    //Método
    private void initComponents() {
        //Creo los botones.
        btnNombre = new JButton("Nombre");
        btnApellidos = new JButton("Apellidos");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        this.add(btnNombre);
        this.add(texto);

        // Se le indica al objeto boton que escuche eventos tipo click
        // y se pasa como argumento una referencia de tipo ActionListener
        // En este caso se pasa this que es el panel sobre el 
        // que está el botón y que implementa la interfaz ActionListener
        btnNombre.addActionListener(this);

        // Añadimos el botón al panel
        this.add(btnApellidos);
        // Controlador del evento
        btnApellidos.addActionListener(this);

        //Clase sin nombre (anónima):
        btnNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("Gabriel");
                texto.setBackground(Color.WHITE);
            }
        });

        btnApellidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("Allende");
                texto.setBackground(Color.BLUE);
            }
        });
    }
    

    public static void main(String[] args) {
        // Construimos la ventana
    	JFrame frame = new JFrame("App");
	// La ventana no se puede redimensionar
	frame.setResizable(false);
	// Posición de la ventana
    	frame.setLocationRelativeTo(null);
	// Incluimos el panel en la ventana
    	frame.add(new Saludo());
       // Ajusta el frame al contenido
       frame.pack();
	// Hacemos visible la ventana
    	frame.setVisible(true);
	//Acción por defecto al pulsar el botón de cierre de la ventana
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Con éste método, la ventana se ajusta al tamaño de los componentes que contiene.
        frame.pack();
	}

   
    }

