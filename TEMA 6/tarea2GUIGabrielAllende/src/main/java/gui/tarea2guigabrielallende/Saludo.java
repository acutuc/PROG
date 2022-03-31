package gui.tarea2guigabrielallende;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Se implementa la interfaz
public class Saludo extends JPanel implements ActionListener {

    //Atributos
    private JButton botonSaludar;
    private JTextArea texto;
    private JButton botonDespedir;

    //Constructor
    public Saludo() {
        initComponents();
    }

    //Método
    private void initComponents() {
        botonSaludar = new JButton("Saludar");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        this.add(botonSaludar);
        this.add(texto);

        // Se le indica al objeto boton que escuche eventos tipo click
        // y se pasa como argumento una referencia de tipo ActionListener
        // En este caso se pasa this que es el panel sobre el 
        // que está el botón y que implementa la interfaz ActionListener
        botonSaludar.addActionListener(this);

        // Añadimos el botón al panel
        this.add(botonDespedir);
        // Controlador del evento
        botonDespedir.addActionListener(this);

    }

    @Override
    // Sobrescribimos el método de la interfaz
    public void actionPerformed(ActionEvent ae) {
        // Si el botón pulsado es botonSaludar
        if (ae.getSource() == botonSaludar) {
            texto.setText("Hola amigos!!");
        } else {
            texto.setText("Adios amigos!!");
        }
    }

    // Clase anónima (sin nombre) anidada (dentro de un método)
    botonSaludar.addActionListener ( 
        new ActionListener() {
        	@Override
        public void actionPerformed
        (ActionEvent e
        
        
            ) {
            		texto.setText("Hola Amigos!!");
        }
    }

    );
   

    botonDespedir.addActionListener (
             
        new ActionListener() {
        	@Override
        public void actionPerformed
        (ActionEvent e
        
        
            ) {
            		texto.setText("Adios Amigos!!");
        }
    }


);


}
