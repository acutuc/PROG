/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarlos.backendjavajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Programa {

    public static void main(String[] args) throws JsonProcessingException {
        
        String url1 = "https://jsonplaceholder.typicode.com/users";
        mostrarClientes(url1);
        System.out.println("-------------------");
    }
    

    public static void mostrarClientes(String url) {       
        String respuesta = "";
        ConexionHTTP conexion = new ConexionHTTP();
        Json mapeador = new Json();

        try {
            respuesta = conexion.peticionHttpGet(url);
            ArrayList<Cliente> lista = mapeador.stringToList(respuesta);
            lista.forEach(c -> System.out.println(c.getId()+ "   " + c.getUsername() + "    " + c.getEmail()));
        } catch (Exception e) {
            // Manejar excepción
            System.out.println("Error durante la conexión HTTP");
            e.printStackTrace();
        }
    }

}
