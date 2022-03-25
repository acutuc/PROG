/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class PruebaLegislador {

    public static void main(String[] args) {
        ArrayList<Empleado> lista = new ArrayList<>();

        lista.add(new Senador(-100, "Málaga", "Vox", "sswe23", 0, "Pepe", "López", new Nif()));
        lista.add(new Senador(-100, "Málaga", "PSOE", "sswe22", 0, "Juana", "López", new Nif()));
        lista.add(new Diputado("1A", "Málaga", "PP", "sswe24", 0, "Luis", "Pérez", new Nif()));
        lista.add(new Diputado("1B", "Málaga", "Ciudadanos", "sswe25", 0, "María", "Pérez", new Nif()));

        lista.forEach(System.out::println);

        for (Empleado empleado : lista) {
            if (empleado instanceof Legislador) {
                System.out.println(((Legislador) empleado).getCamaraTrabaja());

            }

            if (empleado instanceof Diputado) {
                // Los diputados entran también
                ((Diputado) empleado).metodoDiputado();
            }

            if (empleado instanceof Senador) {
                // Senadores
                ((Senador) empleado).metodoSenador();
            }
        }

    }
}
