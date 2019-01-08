/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.models;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author JuanDavid
 */
public class Model {
    JsonObject jarr = new JsonObject();
    JsonObject jarr2 = new JsonObject();
    JsonArray arr = new JsonArray();
    JsonArray arr2 = new JsonArray();
    
    public String obtenerArchivotxt(File fichero) {
        String cadena = "";
        char letra;
        String fila = "";
        String vect[];
        boolean formato1 = true;
        
        try (FileReader fr = new FileReader(fichero)) {
            int valor = fr.read();
            while (valor != -1) {
                letra = (char) valor;
                if (letra == '\n') {
                    //codigo de interpretacion de fila
                    if (fila.equals("F1\n") || fila.equals("F1\r") || fila.equals("F1")) {
                        formato1 = true;
                    } else if (fila.equals("F2\n") || fila.equals("F2\r") || fila.equals("F2")) {
                        formato1 = false;
                    } else if (formato1) {
                        fila = fila.substring(1, fila.length());
                        vect = fila.split(",");
                        insertaRegistro(vect, 1);
                    } else {
                        fila = fila.substring(1, fila.length());
                        vect = fila.split(" ; ");
                        insertaRegistro(vect, 2);
                    }
                    //cadena += fila + letra;
                    fila = "";
                } else {
                    fila = fila + letra;
                }
                
                valor = fr.read();
                
            }
            
            cadena= jarr.toString();
            System.out.println(jarr);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            return cadena;
        }
    }

    /**
     *
     * @param vect es el vector con la informacion que deseas ingresar al Json
     * @param formato es el formato en el que se creo el vector
     */
    private void insertaRegistro(String[] vect, int formato) {
     
        JsonObject obj = new JsonObject();
        
        if (formato == 1) {
            //se agrega al obj. la el nombre y el id
            obj.addProperty(vect[0], vect[2]);

            if(jarr.has(vect[1])){
                jarr.getAsJsonArray(vect[1]).add(obj);
            }else{
                arr.add(obj);
                jarr.add(vect[1], arr);
                arr = new JsonArray();
            }            
        } else {
            //se agrega al obj. la el nombre y el id
            obj.addProperty("City", vect[1]);

            if(jarr.has(vect[2])){
                jarr.getAsJsonArray(vect[2]).add(obj);
            }else{
                arr2.add(obj);
                jarr.add(vect[2], arr2);
                arr2 = new JsonArray();
            }  
        }
  
    }

}
