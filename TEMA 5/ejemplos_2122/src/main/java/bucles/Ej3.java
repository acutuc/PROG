/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bucles;

/**
 *
 * @author profesor
 */
public class Ej3 {
    
    public static void main(String[] args) {
        
        // 15, 30, 60 ,...
        
        final int VALOR_INICIAL = 15;
        final int FACTOR_MULTIPLICATIVO = 2;
        final int TOTAL_TERMINOS = 25;
        
        int aux = VALOR_INICIAL;
        
        for (int i = 0; i < TOTAL_TERMINOS; i++) {
            
            System.out.print("Iteración número " + (i+1));
            System.out.println(" Término: " + aux);
            aux*=FACTOR_MULTIPLICATIVO;
        }
        
    }
            
    
}
