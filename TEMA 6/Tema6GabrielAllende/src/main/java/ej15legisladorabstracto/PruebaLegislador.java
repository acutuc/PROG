package ej15legisladorabstracto;

import java.util.ArrayList;

/**
 *
 * @author acutuc
 */
public class PruebaLegislador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creo dos objetos tipo Senador
        Senador senador1 = new Senador(1500, "Málaga", "Partido Inventado", "Josep", "Ortega");
        Senador senador2 = new Senador(4500, "Sevilla", "Partido Inventado", "Cristiano Lionel", "Vico");
        
        //Creo dos objetos tipo Diputado
        Diputado diputado1 = new Diputado(84, "A Coruña", "Partido Oposición Inventado", "Michael", "Ballack");
        Diputado diputado2 = new Diputado(25, "Madrid", "Partido Oposición Inventado", "Tomás", "Dimitrov");
        
        //Creo ArrayList de Legisladores
        ArrayList<Legislador> lista = new ArrayList<>();
        lista.add(new Diputado(45, "Granada", "Partido Raro", "Mamawevo", "Olala"));
        lista.add(senador1);
        lista.add(senador2);
        lista.add(diputado1);
        lista.add(diputado2);
        
        //Recorro la lista e imprimo de cada Objeto su getCamara().
        for (Legislador legislador : lista) {
            if(legislador instanceof Diputado){
                System.out.println(((Diputado) legislador).getNumeroAsiento());
            }
            System.out.println(legislador.getCamara());
        }
        
        for(Legislador legislador : lista){
            System.out.println(legislador.toString());
        }
    }
    
}
