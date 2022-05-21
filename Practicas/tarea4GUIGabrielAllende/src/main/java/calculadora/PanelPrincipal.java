package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author acutuc
 */
//Definición de la clase, hereda JPanel e implementa el interface MouseListener.
public class PanelPrincipal extends JPanel implements MouseListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos de la clase
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private double resultado;
    private String conjuntoNumeros;
    private String subcadena2;

    //Constructor con sus atributos por defecto.
    public PanelPrincipal() {
    	//Inicializo el objeto con el método.
        initComponents();
    }

    //Método que inicializa los componentes.
    private void initComponents() {
        //Creo el panel de botones
        botonera = new PanelBotones();
        
        //Creo el área de texto
        areaTexto = new JTextArea(5, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establezco layout del panel principal
        this.setLayout(new BorderLayout());
        
        //Coloco los botones y textarea
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        //Añado el daemon de escuha para la botonera
        for (int i = 0; i < botonera.listaBotones.length; i++) {

            botonera.listaBotones[i].addMouseListener(this);
        }
    }

    
    //Sobreescibo los métodos abstractos del interface MouseListener.
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == botonera.listaBotones[0]) {

            if (!areaTexto.getText().equals("")) {

                areaTexto.setText(areaTexto.getText() + "0");
            }

        } else if (e.getSource() == botonera.listaBotones[1]) {

            areaTexto.setText(areaTexto.getText() + "1");

        } else if (e.getSource() == botonera.listaBotones[2]) {

            areaTexto.setText(areaTexto.getText() + "2");

        } else if (e.getSource() == botonera.listaBotones[3]) {

            areaTexto.setText(areaTexto.getText() + "3");

        } else if (e.getSource() == botonera.listaBotones[4]) {

            areaTexto.setText(areaTexto.getText() + "4");

        } else if (e.getSource() == botonera.listaBotones[5]) {

            areaTexto.setText(areaTexto.getText() + "5");

        } else if (e.getSource() == botonera.listaBotones[6]) {

            areaTexto.setText(areaTexto.getText() + "6");

        } else if (e.getSource() == botonera.listaBotones[7]) {

            areaTexto.setText(areaTexto.getText() + "7");

        } else if (e.getSource() == botonera.listaBotones[8]) {

            areaTexto.setText(areaTexto.getText() + "8");

        } else if (e.getSource() == botonera.listaBotones[9]) {

            areaTexto.setText(areaTexto.getText() + "9");

        } else if (e.getSource() == botonera.listaBotones[10]) {

            //Guardamos el primer conjunto de numeros como conjuntoNumeros para luego
            //usarla en las operaciones.
            conjuntoNumeros = areaTexto.getText();
            areaTexto.setText(areaTexto.getText() + "+");

        } else if (e.getSource() == botonera.listaBotones[11]) {

        	conjuntoNumeros = areaTexto.getText();
            areaTexto.setText(areaTexto.getText() + "-");

        } else if (e.getSource() == botonera.listaBotones[12]) {

        	conjuntoNumeros = areaTexto.getText();
            areaTexto.setText(areaTexto.getText() + "*");

        } else if (e.getSource() == botonera.listaBotones[13]) {

        	conjuntoNumeros = areaTexto.getText();
            areaTexto.setText(areaTexto.getText() + "/");

        } else if (e.getSource() == botonera.listaBotones[14]) {

            //Para coger la subcadena2, le restamos el conjuntoNumeros + 1 que es el 
            //caracter que indica el operando
            subcadena2 = areaTexto.getText().substring(conjuntoNumeros.length() + 1);
            areaTexto.setText(areaTexto.getText() + "=");
            //IF's que según que operando se eligió, hará la operación pertinente
            if (areaTexto.getText().contains("+")) {

                //Sumamos las subcadenas y mostramos el resutado, haciendo casting
                resultado = (Double.parseDouble(conjuntoNumeros) + Double.parseDouble(subcadena2));
                areaTexto.setText(String.valueOf(resultado));
            } else if (areaTexto.getText().contains("-")) {

                //Restamos las subcadenas y mostramos el resutado, haciendo casting
                resultado = (Double.parseDouble(conjuntoNumeros) - Double.parseDouble(subcadena2));
                areaTexto.setText(String.valueOf(resultado));
            } else if (areaTexto.getText().contains("*")) {

                //Multiplicamos las subcadenas y mostramos el resutado, haciendo casting
                resultado = (Double.parseDouble(conjuntoNumeros) * Double.parseDouble(subcadena2));
                areaTexto.setText(String.valueOf(resultado));
            } else {

                //Algoritmo que no nos permite dividir entre 0.
                if (subcadena2.equals("0")) {

                    JOptionPane.showMessageDialog(null, "No se puede dividir entre 0,");
                } else {

                    //Dividimos las subcadenas y mostramos el resutado, haciendo casting
                    resultado = (Double.parseDouble(conjuntoNumeros) / Double.parseDouble(subcadena2));
                    areaTexto.setText(String.valueOf(resultado));
                }
            }

            //Al darle al botón de borrar, se borrará todo, utilizando un setText de cadena vacía.
        } else if (e.getSource() == botonera.listaBotones[15]) {

            areaTexto.setText("");

        }
    }

    //Métodos del interface al que no le daremos código, por no ser necesario en este ejercicio.
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
