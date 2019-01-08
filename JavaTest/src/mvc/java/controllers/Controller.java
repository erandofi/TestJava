/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.controllers;

import java.io.File;
import java.util.Properties;
import mvc.java.libraries.UtilesApp;
import mvc.java.models.Model;
import mvc.java.views.View;

/**
 *
 * @author JuanDavid
 */
public class Controller {
    //Referencias
    private final Model model;
    private Properties prpApp;
    
    public Controller() {
        model = new Model();
        //Cargar propiedades Aplicacion
        prpApp = UtilesApp.cargarPropiedades("app.properties");
        
    }
    
    public String obtenerArchivotxt(File file){
        return model.obtenerArchivotxt(file);        
    }
    
    
}
