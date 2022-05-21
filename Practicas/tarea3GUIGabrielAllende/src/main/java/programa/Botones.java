
package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author acutuc
 */
//Definición de la clase, hereda JPanel e implementa ActionListener
public class Botones extends JPanel implements ActionListener {
	//Atributos de la clase, componentes gráficos.
    private JButton boton1;
    private JButton boton2;
    private JTextArea texto;
    private JButton boton3;
    private JLabel etiqueta;

    //Constructor de la clase Botones
    public Botones() {
        initComponents();
    }

    //Métodos
    private void initComponents() {
        // Tamaño del panel en px.
        this.setPreferredSize(new Dimension(600, 200));

        //Borde del panel, con título (similar a un legend en HTML).
        this.setBorder(new TitledBorder("Nombre, apellidos y Generación aleatorios"));

        //Inicializamos los atributos.
        boton1 = new JButton("Nombre");
        boton2 = new JButton("Apellidos");
        texto = new JTextArea(1, 15);
        boton3 = new JButton("Generar Aleatorio");
        etiqueta = new JLabel("Numero");

        //Posicionamos los componentes con FlowLayout
        this.setLayout(new FlowLayout());

        //Añadimos los componentes al panel
        this.add(boton1);
        this.add(boton2);
        this.add(texto);
        this.add(boton3);
        this.add(etiqueta);

        //Añadimos los servicios de escucha a los botones creados
        boton1.addActionListener(this);
        boton2.addActionListener(this);

        //Le cambiamos el color de fondo por defecto del textArea
        texto.setBackground(Color.GRAY);

        //Añadimos los servicios de escucha al botón y creamos un objeto
        //actionListener para agregar su mètodo abstracto y así usar clases
        //anónimas
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Random rd = new Random();

                //si el evento detecta que el click es en el boton que es Generar 
                //Aleatorio muestra el numero aleatorio generado por rd 
                //en String por el valueof
                if (e.getSource() == boton3) {

                	//Generamos un número entre 0 y 10.
                    int numero = rd.nextInt(11);
                    etiqueta.setText(String.valueOf(numero));
                }
            }
        });

        //Añadimos los servicios de escucha al botón y creamos un objeto
        //MouseListener para agregar su mètodo abstracto y así usar clases
        //anónimas
        boton3.addMouseListener(new MouseListener() {
            //Solo usaremos mouseEntered y mouseEntered
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            //Al poner el ratón encima este cambia a cyan
            @Override
            public void mouseEntered(MouseEvent e) {
                boton3.setBackground(Color.CYAN);
            }

            //Cuando el ratón sale del área del botón, vuelve a su color original (lo ponemos a null)
            @Override
            public void mouseExited(MouseEvent e) {
                //volver al color por defecto
                boton3.setBackground(null);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//Si clicamos en boton1 (nombre), muestra el nombre y cambia el color de fondo 
    	//del textarea a blanco.
        if (e.getSource() == boton1) {

            texto.setText("Gabriel");
            texto.setBackground(Color.WHITE);

            //Si le damos al boton2 (apellido, else) muestra el apellido y cambia el color de fondo
            //del textarea a rojo
        } else {

            texto.setText("Allende");
            texto.setBackground(Color.RED);
        }
    }
}
