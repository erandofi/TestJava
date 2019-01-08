/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.libraries;

import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author JuanDavid
 */
public class UtilesApp {

    public static Properties cargarPropiedades(String ficheroPrp) {
        // Inicializacomo un objeto propiedades vacio
        Properties prp = new Properties();
        
        //Carga propiedades
        try {
            FileReader fr = new FileReader(ficheroPrp);
            prp.load(fr);
            
        } catch (Exception e) {
            System.out.println("Error al cargar las propiedades del fichero " + ficheroPrp + " mensaje de error : \n" + e.getMessage());
        }
        return prp;
    }
    
}
