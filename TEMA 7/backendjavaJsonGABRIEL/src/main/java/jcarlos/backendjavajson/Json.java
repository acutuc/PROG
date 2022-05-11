/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarlos.backendjavajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

public class Json {

    public ArrayList<Cliente> stringToList(String json) throws JsonProcessingException {
        ObjectMapper mapeador = new ObjectMapper();

        ArrayList<Cliente> catalogo = mapeador.readValue(json,
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class));
        
        return catalogo;
    }
    
    public Cliente stringToPojo(String json) throws JsonProcessingException {
        ObjectMapper mapeador = new ObjectMapper();

        Cliente cliente = mapeador.readValue(json,Cliente.class);
        
        return cliente;
    }
}
